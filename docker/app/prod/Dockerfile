FROM alpine/java:21-jdk AS builder
WORKDIR /var/www/app
COPY . .
RUN ./mvnw clean package

FROM alpine/java:21-jdk AS wrapped-app
WORKDIR /var/www/app
COPY --from=builder /var/www/app/target .
COPY --from=builder /var/www/app/sh .

FROM alpine/java:21-jdk AS app
WORKDIR /var/www/app
COPY --from=wrapped-app /var/www/app .
EXPOSE 80
ENTRYPOINT [ "./sh/run" ]
