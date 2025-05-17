# Duty Pharmacy API

This project is a Spring Boot-based API that fetches pharmacy data from an external API and uses **Hazelcast caching** to reduce repeated calls. It also saves fetched data to a MySQL database **asynchronously** to ensure high performance.

## 🚀 Features

- Caches external API responses using Hazelcast to minimize requests.
- Asynchronous saving of records to the database.
- Integrated Swagger UI for API testing.

## 🛠️ Technologies Used

- **Spring Boot**
- **MySQL**
- **Hibernate (JPA)**
- **Hazelcast Cache**
- **Swagger / OpenAPI**
- **Asynchronous Task Execution**

## ⚙️ `application.yaml` Configuration

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/duty_pharmacy
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
  application:
    name: duty-pharmacy
  jpa:
    hibernate:
      ddl-auto: update

server:
  servlet:
    context-path: /api/duty
  port: 8081

application:
  external-service:
    url: https://api.collectapi.com/health
    token: apikey 32SW8VFp7VSjuv4WpGIUzX:1mp4YKzlSayIa2ARtNDOwr
  thread-pool:
    core-pool-size: 10
    max-pool-size: 20
    queue-capacity: 200
    thread-name-prefix: async-thread-
  hazelcast:
    instance-name: duty-hazelcast
    port: 5702