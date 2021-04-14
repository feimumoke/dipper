## dipper为单机版，分布式版本请移步[skynet](https://github.com/feimumoke/skynet)项目
---
## 总体基于google提供的GRPC框架实现不同语言之间的交互。  
### Grpc-Java(the-big-dipper)：   
  后台：基于springboot、mybatis，grpc，netty，redis等实现用户和qq消息的管理  
  前台：目前实现登录和QQ单聊，聊天基于layim。  
### Grpc-Python(MizarService)：  
  基于pyqt5,实现了登录，注册，博客发表和浏览功能  
### Grpc-Golang(AlkaidService)：  
  提供后台服务：提供博客相关功能，提供图片服务器功能。  

## 启动顺序：  
  先启动 MerakService和AlkaidService提供服务，再启动MizarService或者PhecdaService
## 效果图如下：
  
![效果图]( /views/1.PNG)

![效果图]( /views/2.PNG)

![效果图]( /views/3.PNG)

![效果图]( /views/4.PNG)

![效果图]( /views/5.PNG)

![效果图]( /views/6.PNG)

# TODO
  群聊  
  网页版博客功能  
  客户端聊天功能  
  服务自治  
