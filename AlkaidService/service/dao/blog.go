package dao

import (
	"fmt"
	"github.com/go-xorm/xorm"
	"log"
)

type TBlog struct {
	Id        int32
	UserId    int32
	Header    string
	Content   string
	Image     string
	BuildTime string `xorm:"created"`
}

var engine *xorm.Engine

func init() {
	mysql, err := InitMysql()
	if err != nil {
		fmt.Println("init db fail")
	}
	engine = mysql

	if err = engine.Sync2(new(TBlog)); err != nil {
		log.Fatalf("Fail to sync database: %v\n", err)
	}
}

func GetBlogById(userId int32) (bs []TBlog, err error) {
	err = engine.Where("user_id = ?", userId).Find(&bs)
	return bs, err
}

func GetAllBlog() (bs []TBlog, err error) {
	err = engine.Find(&bs)
	return bs, err
}

func SaveBlog(blog *TBlog) error {
	_, err := engine.Insert(blog)
	return err
}

func DeleteBlog(blog *TBlog) error {
	_, err := engine.Delete(blog)
	return err
}
