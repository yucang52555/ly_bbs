FROM maven:3
LABEL maintainer="qiaofu"

WORKDIR /app/ly/server/lybbs
ADD target/lybbs/* /app/ly/server/lybbs/

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/ly/server/lybbs/lybbs-latest.jar","--spring.profiles.active=docker"]
