#!/bin/sh

echo ENV

java -Dspring.data.mongodb.uri=mongodb://mongo:27017/  -Dspring.data.mongodb.database=totvus-clients -jar /app/app.war