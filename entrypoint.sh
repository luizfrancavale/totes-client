#!/bin/sh


java -Dspring.data.mongodb.uri=mongodb://mongo:27017/  -Dspring.data.mongodb.database=totvus-clients -Dspring.servlet.context-path=/totvs-api -jar /app/app.war