FROM maven:3
LABEL maintainer="qiaofu"

WORKDIR /app/ly/server/lyblog
ADD . /tmp

RUN cd /tmp && mvn package -Pci && mv target/dist/lyblog/* /app/ly/server/lyblog/ && rm -rf /tmp/* && rm -rf ~/.m2

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/ly/server/lyblog/ly_bbs.jar","--spring.profiles.active=docker"]
