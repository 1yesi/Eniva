FROM openjdk:17
COPY "./Envia/target/Envia-1.jar" "app.jar"
EXPOSE 8050
ENTRYPOINT ["java", "-jar", "app.jar"]
