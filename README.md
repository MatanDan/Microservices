# Microservices example
This project contains microservices using the following technologies:
* Eureka for services discovery.
* Zuul for gateway and proxying.
* Spring Cloud Streaming with RabbitMQ binder, for events and messages between services.
* Spring Cloud Config Server for dynamic and encrypted configuration.
* Zipking and Spring Cloud Sleuth for HTTP requests tracing.

## Microservices modules:
### eureka-discovery
Configured Eureka server, with 2 peers.

### gateway
Zuul server that connects to Eureka as client, and proxy requests to other microservices.

### config-server
Spring Cloud Config Server which take its configuration from this repository at /properties URI.

Some of the properties, like the RabbitMQ AMQP's URL are encrypted.

### users
A super-simple microservice which exposes a single endpoint that sends data from git's property file.

Publishes events using RabbitMQ.

### mailing
A super-simple microservice which exposes data from user's microservice, uses Spring Cloud's and Eureka's client side load balancing.

Listens for events using RabbitMQ.

### zipkin
It is recommended to run Zipkin Server, using one of the following options: https://zipkin.io/pages/quickstart.
