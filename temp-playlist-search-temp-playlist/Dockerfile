FROM java:8
EXPOSE 9090
ADD /temp-playlist-search-temp-playlist/target/*.jar temp-playlist.jar
ENTRYPOINT ["java","-jar", "temp-playlist.jar"]