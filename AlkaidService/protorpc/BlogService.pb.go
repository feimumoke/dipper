// Code generated by protoc-gen-go. DO NOT EDIT.
// source: BlogService.proto

package com_dipper_proto_rpc

import (
	fmt "fmt"
	proto "github.com/golang/protobuf/proto"
	math "math"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion3 // please upgrade the proto package

type BlogPro struct {
	Id                   int32    `protobuf:"varint,1,opt,name=id,proto3" json:"id,omitempty"`
	UserId               int32    `protobuf:"varint,2,opt,name=user_id,json=userId,proto3" json:"user_id,omitempty"`
	Header               string   `protobuf:"bytes,3,opt,name=header,proto3" json:"header,omitempty"`
	Content              string   `protobuf:"bytes,4,opt,name=content,proto3" json:"content,omitempty"`
	Image                string   `protobuf:"bytes,5,opt,name=image,proto3" json:"image,omitempty"`
	BuildTime            string   `protobuf:"bytes,6,opt,name=build_time,json=buildTime,proto3" json:"build_time,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *BlogPro) Reset()         { *m = BlogPro{} }
func (m *BlogPro) String() string { return proto.CompactTextString(m) }
func (*BlogPro) ProtoMessage()    {}
func (*BlogPro) Descriptor() ([]byte, []int) {
	return fileDescriptor_c71e800f31ff5594, []int{0}
}

func (m *BlogPro) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_BlogPro.Unmarshal(m, b)
}
func (m *BlogPro) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_BlogPro.Marshal(b, m, deterministic)
}
func (m *BlogPro) XXX_Merge(src proto.Message) {
	xxx_messageInfo_BlogPro.Merge(m, src)
}
func (m *BlogPro) XXX_Size() int {
	return xxx_messageInfo_BlogPro.Size(m)
}
func (m *BlogPro) XXX_DiscardUnknown() {
	xxx_messageInfo_BlogPro.DiscardUnknown(m)
}

var xxx_messageInfo_BlogPro proto.InternalMessageInfo

func (m *BlogPro) GetId() int32 {
	if m != nil {
		return m.Id
	}
	return 0
}

func (m *BlogPro) GetUserId() int32 {
	if m != nil {
		return m.UserId
	}
	return 0
}

func (m *BlogPro) GetHeader() string {
	if m != nil {
		return m.Header
	}
	return ""
}

func (m *BlogPro) GetContent() string {
	if m != nil {
		return m.Content
	}
	return ""
}

func (m *BlogPro) GetImage() string {
	if m != nil {
		return m.Image
	}
	return ""
}

func (m *BlogPro) GetBuildTime() string {
	if m != nil {
		return m.BuildTime
	}
	return ""
}

func init() {
	proto.RegisterType((*BlogPro)(nil), "com.dipper.proto.rpc.BlogPro")
}

func init() {
	proto.RegisterFile("BlogService.proto", fileDescriptor_c71e800f31ff5594)
}

var fileDescriptor_c71e800f31ff5594 = []byte{
	// 194 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0x6c, 0xce, 0xb1, 0x6e, 0x83, 0x30,
	0x10, 0xc6, 0x71, 0x99, 0x16, 0x23, 0x6e, 0xa8, 0x54, 0x0b, 0xb5, 0x5e, 0x2a, 0xa1, 0x76, 0x61,
	0x62, 0xe9, 0x1b, 0xb0, 0x75, 0x43, 0x34, 0x3b, 0x02, 0xfb, 0x44, 0x4e, 0xc2, 0xd8, 0x72, 0x4c,
	0xde, 0x25, 0x6f, 0x1b, 0x61, 0xc8, 0x96, 0xf1, 0xff, 0xbb, 0x1b, 0x3e, 0x78, 0x6f, 0x66, 0x3b,
	0xfd, 0xa3, 0xbf, 0x92, 0xc2, 0xda, 0x79, 0x1b, 0xac, 0x28, 0x94, 0x35, 0xb5, 0x26, 0xe7, 0xd0,
	0xef, 0x52, 0x7b, 0xa7, 0xbe, 0x6f, 0x0c, 0xb2, 0xed, 0xb7, 0xf5, 0x56, 0xbc, 0x41, 0x42, 0x5a,
	0xb2, 0x92, 0x55, 0x69, 0x97, 0x90, 0x16, 0x9f, 0x90, 0xad, 0x17, 0xf4, 0x3d, 0x69, 0x99, 0x44,
	0xe4, 0x5b, 0xfe, 0x69, 0xf1, 0x01, 0xfc, 0x8c, 0x83, 0x46, 0x2f, 0x5f, 0x4a, 0x56, 0xe5, 0xdd,
	0x51, 0x42, 0x42, 0xa6, 0xec, 0x12, 0x70, 0x09, 0xf2, 0x35, 0x1e, 0x1e, 0x29, 0x0a, 0x48, 0xc9,
	0x0c, 0x13, 0xca, 0x34, 0xfa, 0x1e, 0xe2, 0x0b, 0x60, 0x5c, 0x69, 0xd6, 0x7d, 0x20, 0x83, 0x92,
	0xc7, 0x53, 0x1e, 0xe5, 0x44, 0x06, 0x9b, 0x1f, 0x78, 0xba, 0xb9, 0xc9, 0x8f, 0xc1, 0xc1, 0xb6,
	0x6c, 0xe4, 0xd1, 0x7f, 0xef, 0x01, 0x00, 0x00, 0xff, 0xff, 0xa3, 0xaf, 0x54, 0x8d, 0xf2, 0x00,
	0x00, 0x00,
}
