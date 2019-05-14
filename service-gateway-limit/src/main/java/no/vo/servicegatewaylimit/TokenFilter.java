package no.vo.servicegatewaylimit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * gateway全局过滤器
 * https://blog.csdn.net/forezp/article/details/85057268
 */
public class TokenFilter implements GlobalFilter, Ordered {
    private static final String AUTHORIZE_TOKEN = "token";
    Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //String token = exchange.getRequest().getQueryParams().getFirst("token");
        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);
        if (token == null || token.isEmpty()) {
            logger.info("token is empty...");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            ServerHttpResponse response = exchange.getResponse();
            DataBuffer bodyDataBuffer = responseErrorInfo(response, HttpStatus.UNAUTHORIZED.toString(), "token is empty...");
            return exchange.getResponse().writeWith(Mono.just(bodyDataBuffer));
            //return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }

    /**
     * 自定义返回错误信息
     *
     * @param response
     * @param status
     * @param message
     * @return
     */
    public DataBuffer responseErrorInfo(ServerHttpResponse response, String status, String message) {
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        Map<String, String> map = new HashMap<>();
        map.put("status", status);
        map.put("message", message);
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(map.toString().getBytes());
        return bodyDataBuffer;
    }

}