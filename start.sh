# 拉取最新的源码
git pull

# 执行打包
mvn clean package -Pprod

java -jar target/lybbs.jar --spring.profiles.active=prod  &

echo "Lybbs部署完毕，Enjoy！"