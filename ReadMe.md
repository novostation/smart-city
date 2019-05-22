

##  consul 控制台
d;>.\consul.exe agent -dev
consul agent -dev -http-port 8500
d;>.\consul.exe agent -server -ui -bootstrap-expect=1 -data-dir=d:/tmp/consul -node=agent-one -advertise=192.168.1.61 -bind=0.0.0.0 -client=0.0.0.0



##  Sentinel 控制台
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.6.0.jar