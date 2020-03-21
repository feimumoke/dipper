package image

import (
	"context"
	"errors"
	"fmt"
	pb "github.com/dipper/AlkaidService/protorpc"
	"github.com/dipper/AlkaidService/service/utils"
	"io/ioutil"
	"os"
	"path/filepath"
)

type RpcImageService struct {
}

var config = utils.Config


func (ims *RpcImageService) Save(ctx context.Context, im *pb.ImageData) (resp *pb.ImageSaveResult, err error) {
	name := im.Name
	fmt.Printf("%v", im)
	path := config.ImagePath + name
	dir, _ := filepath.Split(path)
	err = os.MkdirAll(dir, os.ModePerm)
	file, err := os.Create(path)
	if err != nil {
		fmt.Printf("create file error: %v", err)
		return nil, err
	}
	n, err := file.Write(im.Photo)
	if err != nil {
		fmt.Printf("write file error: %v", err)
		return nil, err
	}
	if n <= 0 {
		fmt.Printf("write a empty file")
		return nil, errors.New("empty file")
	}
	return &pb.ImageSaveResult{
		RpcCode: 200,
		Message: "success",
		Url:     name,
	}, nil
}

func (ims *RpcImageService) Download(ctx context.Context, im *pb.ImagePath) (resp *pb.ImageLoadResult, err error) {
	url := im.Url
	path := config.ImagePath + url
	photo, err := ioutil.ReadFile(path)
	if err != nil {
		fmt.Printf("no request file")
		return nil, err
	}
	return &pb.ImageLoadResult{
		RpcCode: 200,
		Message: "success",
		Photo:   photo,
	}, nil
}
