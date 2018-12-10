FROM maven:3
LABEL maintainer="qiaofu"

WORKDIR /app/ly/server/lybbs
ADD target/lybbs-latest.jar /app/ly/server/lybbs/lybbs-latest.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/ly/server/lybbs/lybbs-latest.jar","--spring.profiles.active=docker"]
