FROM maven:3
LABEL maintainer="qiaofu"

WORKDIR /app/ly/server/lybbs
ADD . /app/ly/server/tmp

RUN cd /app/ly/server/tmp && mvn clean package -Dmaven.test.skip=true && mv target/* /app/ly/server/lybbs/ && rm -rf /app/ly/server/tmp/*

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/ly/server/lybbs/lybbs.jar","--spring.profiles.active=docker"]
