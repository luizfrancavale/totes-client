FROM --platform=linux/amd64/v8 amazoncorretto:17-alpine-jdk

WORKDIR /app/
COPY . /app/

COPY /build/libs/*SNAPSHOT.war /app/app.war

EXPOSE 8080

ENTRYPOINT [ "/bin/sh", "/app/entrypoint.sh", "dev" ]