FROM java:8
EXPOSE 9090
ADD /target/*.jar eureka-server.jar
ENTRYPOINT ["java","-jar", "eureka-server.jar"]