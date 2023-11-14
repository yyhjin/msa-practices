## Spring Cloud Discovery Server: Neflix Eureka


#### 1. Spring Cloud Dependency

```XML
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```


#### 2. Eureka Server Annotation
```java
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryServer {
	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryServer.class, args);
	}
}
```


#### 3. Configuration

1. Tomcat Server

```yml
server:
   port: 8761
```


2. Eureka
	
```yml
eureka:
   instance:
      hostname: localhost
   server:
      enableSelfPreservation: false
      waitTimeInMsWhenSyncEmpty: 5        
   client:
      fetchRegistry: false
      registerWithEureka: false
      serviceUrl:
         defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka
```

- eureka.server.enableSelfPreservation<br>
  네트워크 장애시 정상적인 서비스가 등록 해제되는 상황을 막을 수 있는 자기보존 옵션이다. 서비스 변경이 빈번히 일어나는 개발시에는 false로 설정하는 것이 좋다.
  
- eureka.server.waitTimeInMsWhenSyncEmpty<br>
  모든 서비스가 등록되고 서비스 레지스트리를 모든 서비스에 내리는 시간(기본 5분)으로 개발시에는 짧게 설정하는 것이 편하다.

- eureka.client.fetchRegistry<br>
  서비스 레지스트리를 캐시한다. 한 개만 운용할 경우 다른 Eureka서버로 부터 내릴 수 없기 때문에 false로 설정한다. 

- eureka.client.registerWithEureka<br>
  자기 자신을 서비스로 등록한다. 여러 Euraka를 운용할 경우 필요하지만 한 개만 운용할 경우는 false로 설정한다.

- eureka.client.serviceUrl.defaultZone<br>
  Zone의 의미는 한 개 서비스 레지스트에 등록된 서비스들의 모임이다.	


#### 3. Dashboard

1.	서비스 등록 상태를 확인 할 수 있다.
2.	접근<br>
	http://server:8761

	