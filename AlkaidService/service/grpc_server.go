package service

import (
	pb "github.com/dipper/AlkaidService/protorpc"
	"github.com/dipper/AlkaidService/service/blog"
	"github.com/dipper/AlkaidService/service/image"
	"github.com/dipper/AlkaidService/service/utils"
	"google.golang.org/grpc"
	"net"
)

var config = utils.Config
var ims = image.RpcImageService{}
var rbs = blog.RpcBlogService{}

func RegisterRpcServer() {
	addr := ":" + config.GrpcPort
	listener, err := net.Listen("tcp", addr)
	if err != nil {
		panic(err)
	}
	server := grpc.NewServer()
	pb.RegisterImageServiceServer(server, &ims)
	pb.RegisterBaseServiceServer(server, &rbs)
	server.Serve(listener)
}
