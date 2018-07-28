##项目结构
- **destiny-service** 服务注册中心（eureka-server）
- **destiny-canal** 数据变化监控包（独立的数据抽取工程）
- **destiny-common** 公共依赖包 
- **destiny-entity** 实体类包
- **destiny-lottery** 抽奖服务提供（eureka-client）
- **destiny-prize** 奖品服务提供（eureka-client）
- **destiny-api** 所有服务的接口定义包 （为服务提供和消费包共同依赖）
- **destiny-business**  统一对外提供服务的工程，外部项目通过它来调用内部的服务提供（eureka-client）（feign）
- **destiny-gateway** 网关服务 （zuul）
