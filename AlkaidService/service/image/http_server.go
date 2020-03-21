package image

import (
	"fmt"
	"github.com/julienschmidt/httprouter"
	"io/ioutil"
	"log"
	"net/http"
	"os"
)

func handler(w http.ResponseWriter, r *http.Request, ps httprouter.Params) {
	file := ps.ByName("path")
	fmt.Println(file)
	path := config.ImagePath + file
	if !isFile(path) {
		photo, _ := ioutil.ReadFile(config.ImagePath + "/default.jpg")
		_, err := w.Write(photo)
		if err != nil {
			fmt.Println("write default image error")
		}
		return
	}
	photo, err := ioutil.ReadFile(path)
	if err != nil {
		fmt.Println("read image error")
		return
	}
	_, err = w.Write(photo)
	if err != nil {
		fmt.Println("write default image error")
	}
}

func isFile(path string) bool {
	info, err := os.Stat(path)
	if err != nil {
		return false
	}
	fmt.Println(info)
	return !info.IsDir()
}

func ImageHttpServer() {
	router := httprouter.New()
	router.GET(config.HttpPath+"*path", handler)
	log.Fatal(http.ListenAndServe(":"+config.HttpPort, router))
}
