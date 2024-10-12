FROM alpine/java:21-jdk AS builder
WORKDIR /var/www/app
COPY . .
RUN ./mvnw clean package
EXPOSE 80
ENTRYPOINT [ "./sh/run" ]
