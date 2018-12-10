FROM maven:3
LABEL maintainer="qiaofu"

WORKDIR /app/ly/server/lyblog
ADD . /app/ly/server/tmp

RUN cd /app/ly/server/tmp && mvn clean && mvn package && mv target/* /app/ly/server/lyblog/ && rm -rf /app/ly/server/tmp/*

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/ly/server/lyblog/ly_bbs-1.0.jar","--spring.profiles.active=docker"]
