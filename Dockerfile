FROM maven:3
LABEL maintainer="qiaofu"

WORKDIR /app/ly/server/lybbs
ADD . /tmp

RUN cd /tmp && mvn clean package -Pci && mv target/* /app/ly/server/lybbs/ && rm -rf /tmp/* && rm -rf ~/.m2

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/ly/server/lybbs/lybbs-latest.jar","--spring.profiles.active=docker"]
