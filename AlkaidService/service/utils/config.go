package utils

import (
	"encoding/json"
	"io/ioutil"
)

type AlkaidConfig struct {
	ImagePath string
	GrpcPort  string
	HttpPort  string
	HttpPath  string
	Mysql     MysqlConfig
}

type MysqlConfig struct {
	Host     string
	Port     string
	DataBase string
	UserName string
	Password string
}

const path = "./config.json"

var Config AlkaidConfig

func init() {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err)
	}
	err = json.Unmarshal(data, &Config)
	if err != nil {
		panic(err)
	}
}
