powershell 连接 oracle vm virtualbox 中的docker 命令
docker-machine env default | Invoke-Expression
docker image ls //查看docker中的所有镜像
docker exec -it mysql /bin/bash //进入mysql容器
docker exec -it mongo /bin/bash //进入mongo容器 mongo -u admin -p admin
docker exec -it redis redis-cli //通过redis-cli进入redis容器