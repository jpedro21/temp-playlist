FROM java:8
EXPOSE 9090
ADD /temp-playlist-config-server/target/*.jar config-server.jar
ENTRYPOINT ["java","-jar", "config-server.jar"]