FROM openjdk:11-jre-slim

WORKDIR /var/opt
RUN useradd appuser --gid=100 --uid=1337 -m
COPY build/libs/*.jar app.jar
USER appuser
ENTRYPOINT ["java","-jar","app.jar"]