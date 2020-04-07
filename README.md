# Microservices example
This project contains microservices using the following technologies:
* Eureka for services discovery.
* Zuul for gateway and proxying.
* Spring Cloud Config Server for dynamic configuration.

## Microservices modules:
### eureka-discovery
Configured Eureka server, with 2 peers.

### gateway
Zuul server that connects to Eureka as client, and proxy requests to other microservices.

### config-server
Spring Cloud Config Server which take its configuration from this repository at /properties URI.

### users
A super-simple microservice which exposes a single endpoint that sends data from git's property file.

### mailing
A super-simple microservice which exposes data from user's microservice, uses Spring Cloud's and Eureka's client side load balancing.
