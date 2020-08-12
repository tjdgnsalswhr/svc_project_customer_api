FROM openjdk:8-jdk-alpine
ADD target/svc_project_customer_api-2.0.1-SNAPSHOT.jar svc-project-customer-api.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/svc-project-customer-api.jar"]