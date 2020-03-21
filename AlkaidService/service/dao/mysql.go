package dao

import (
	"errors"
	"fmt"
	"github.com/dipper/AlkaidService/service/utils"
	_ "github.com/go-sql-driver/mysql"
	"github.com/go-xorm/xorm"
	"time"
)

var mysql *xorm.Engine

var config = utils.Config.Mysql

func InitMysql() (*xorm.Engine, error) {
	fmt.Printf("%+v", config)
	dataSourceName := fmt.Sprintf("%s:%s@tcp(%s:%s)/%s?charset=utf8",
		config.UserName, config.Password, config.Host, config.Port, config.DataBase)
	engine, err := xorm.NewEngine("mysql", dataSourceName)
	if err != nil {
		return nil, errors.New("init db failed")
	}
	engine.SetMaxIdleConns(3)
	engine.SetMaxOpenConns(20)
	engine.SetConnMaxLifetime(0)
	engine.ShowExecTime(true)
	engine.ShowSQL(true)
	mysql = engine
	timer := time.NewTicker(time.Minute * 10)
	go func(conn *xorm.Engine) {
		for _ = range timer.C {
			if err = mysql.Ping(); err != nil {
				MySQLAutoConnect()
			}
		}
	}(mysql)
	return mysql, nil
}

func autoConnectMySQL(tryTimes int, maxTryTimes int) int {
	tryTimes++
	if tryTimes <= maxTryTimes {
		if mysql.Ping() != nil {
			fmt.Printf("数据库连接失败,已重连%d次", tryTimes)
		}
		tryTimes = autoConnectMySQL(tryTimes, maxTryTimes)
	}
	return tryTimes
}

func MySQLAutoConnect() {
	autoConnectMySQL(0, 5)
}
