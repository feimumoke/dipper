package main

import (
	"github.com/dipper/AlkaidService/service"
	"github.com/dipper/AlkaidService/service/image"
)

func main() {
	go image.ImageHttpServer()
	service.RegisterRpcServer()
}
