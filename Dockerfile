FROM openjdk:19

ENV ENVIRONMENT=prod

MAINTAINER Roh Kazimi <rohula-kazimi@hotmail.com>

EXPOSE 8080

ADD ./backend/target/app.jar app.jar

CMD ["sh", "-c", "java -jar /app.jar"]