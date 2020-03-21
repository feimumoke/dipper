package blog

import (
	"context"
	"fmt"
	pb "github.com/dipper/AlkaidService/protorpc"
	"github.com/dipper/AlkaidService/service/dao"
	"github.com/dipper/AlkaidService/service/utils"
	"github.com/golang/protobuf/ptypes"
	"github.com/golang/protobuf/ptypes/any"
)

var config = utils.Config

type RpcBlogService struct{}

func (rbs RpcBlogService) Save(ctx context.Context, et *pb.Entry) (*pb.RpcResult, error) {
	msgType := et.Type
	data := et.Entry
	switch msgType {
	case pb.MessageType_BLOG:
		blog := new(pb.BlogPro)
		err := ptypes.UnmarshalAny(data, blog)
		if err != nil {
			return nil, err
		}
		tBlog := dao.TBlog{
			UserId:  blog.UserId,
			Header:  blog.Header,
			Content: blog.Content,
			Image:   blog.Image,
		}
		err = dao.SaveBlog(&tBlog)
		if err != nil {
			return nil, err
		}
		return &pb.RpcResult{
			RpcCode: 200,
			Message: "SUCCESS",
		}, nil

	default:
		return nil, nil
	}
}

func (rbs RpcBlogService) DeleteById(ctx context.Context, kid *pb.KeyId) (*pb.RpcResult, error) {
	panic("implement me")
}

func (rbs RpcBlogService) DeleteByPropertyList(context.Context, *pb.Entry) (*pb.RpcResult, error) {
	panic("implement me")
}

func (rbs RpcBlogService) Update(context.Context, *pb.Entry) (*pb.RpcResult, error) {
	panic("implement me")
}

func (rbs RpcBlogService) SelectById(ctx context.Context, ki *pb.KeyId) (*pb.RpcResult, error) {
	msgType := ki.Type
	id := ki.KeyId
	switch msgType {
	case pb.MessageType_BLOG:
		data, err := dao.GetBlogById(id)
		if err != nil {
			return nil, err
		}
		return packBlogList(data)
	default:
		return nil, nil
	}
}

func (rbs RpcBlogService) SelectAll(ctx context.Context, et *pb.Empty) (*pb.RpcResult, error) {
	msgType := et.Type
	switch msgType {
	case pb.MessageType_BLOG:
		data, err := dao.GetAllBlog()
		if err != nil {
			return nil, err
		}
		return packBlogList(data)
	default:
		return nil, nil
	}
}

func (rbs RpcBlogService) SelectByProperty(context.Context, *pb.Entry) (*pb.RpcResult, error) {
	panic("implement me")
}

func (rbs RpcBlogService) SelectListByProperty(context.Context, *pb.Entry) (*pb.RpcResult, error) {
	panic("implement me")
}

func (rbs RpcBlogService) SelectPageList(context.Context, *pb.PageInfo) (*pb.RpcResult, error) {
	panic("implement me")
}

func packBlogList(data []dao.TBlog) (*pb.RpcResult, error) {
	var anys []*any.Any
	for i := 0; i < len(data); i++ {
		any, err := ptypes.MarshalAny(&pb.BlogPro{
			Id:      data[i].Id,
			UserId:  data[i].UserId,
			Header:  data[i].Header,
			Content: data[i].Content,
			Image:   data[i].Image,
		})
		if err != nil {
			fmt.Println("error in marshal any")
		}
		anys = append(anys, any)
	}
	list := pb.DataList{
		Data: anys,
	}
	dataList, err := ptypes.MarshalAny(&list)
	if err != nil {
		fmt.Println("error in marshal resultList")
		return nil, err
	}
	result := pb.RpcResult{
		RpcCode: 200,
		Message: "SUCCESS",
		Data:    dataList,
	}
	return &result, nil
}
