FROM openjdk:11
EXPOSE 8090
COPY target/IT-Hackathon-0.0.1-SNAPSHOT.jar it-hackathon-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dockerembbed,oauth-security", "-jar","/it-hackathon-0.0.1-SNAPSHOT.jar"]