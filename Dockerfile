FROM maven:3
LABEL maintainer="qiaofu"

WORKDIR /app/ly/server/lyblog
ADD . /app/ly/server/tmp

RUN cd /app/ly/server/tmp && mvn package && mv target/dist/lyblog/* /app/ly/server/lyblog/ && rm -rf /app/ly/server/tmp/*

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/ly/server/lyblog/ly_bbs.jar","--spring.profiles.active=docker"]
