FROM maven:3.9.5-amazoncorretto-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-al2023
ENV BINARYBLUFF_PORT=8761
RUN mkdir /app
WORKDIR /app
COPY --from=build /target/binarybluff-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE ${BINARYBLUFF_PORT}
ENTRYPOINT [ "java", "-jar", "app.jar" ]