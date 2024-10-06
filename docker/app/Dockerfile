FROM alpine/java:21-jdk AS app

WORKDIR /var/www/app

COPY . .

RUN ./mvnw clean package

RUN ./bash/run

EXPOSE 80