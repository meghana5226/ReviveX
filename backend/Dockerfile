FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
RUN mvn -q -DskipTests package
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/revivex-backend-2.0.0.jar"]
