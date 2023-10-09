FROM amazoncorretto:17-al2023
ENV BINARYBLUFF_PORT=8761
RUN mkdir /app
WORKDIR /app
COPY . .
# ----
# Install Maven
RUN dnf install -y maven
EXPOSE ${BINARYBLUFF_PORT}
ENTRYPOINT [ "bash", "entrypoint.sh" ]