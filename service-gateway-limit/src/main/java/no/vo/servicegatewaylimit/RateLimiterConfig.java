package no.vo.servicegatewaylimit;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 路由限流配置
 * @author huanghanxin
 * @date 2019/1/15
 */
@Configuration
public class RateLimiterConfig {

    /**
     * IP限流
     *
     * @return
     */
    @Bean(value = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
/**
 * 接口限流   获取请求地址的uri作为限流key
 * @return
 */
    /*@Bean
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }*/
    /*@Bean
    public KeyResolver addressKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }*/


/**
 * 用户限流   使用这种方式限流，请求路径中必须携带userId参数
 * @return
 */
    /*@Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }*/

}

