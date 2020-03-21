from .personal import UserInfo
import os
import datetime
from module.base import QPushButton, HBoxLayout, QMessageBox, QFileDialog
from protorpc.UserService_pb2 import *
from service.const.consts import *


class UserAdd(UserInfo):
    def __init__(self, parent=None):
        super(UserAdd, self).__init__(self)
        self.parent = parent
        self.userService = self.parent.parent.userService
        self.imageService = self.parent.parent.imageService
        self.avatar = None
        self.addRegisterBtn()
        with open('qss/common.qss', 'r', encoding="utf-8") as f:
            self.setStyleSheet(f.read())

    def addRegisterBtn(self):
        style = """QPushButton{
                height: 30px;
                width: 130px;
                color: #FFFFFF;
                font: 100 12pt "黑体";
                background-color:#A9A9A9;
         }"""
        self.btn_add = QPushButton()
        self.btn_add.setObjectName("but_add")
        self.btn_add.setText("注册账号")
        self.btn_add.setStyleSheet(style)
        self.btn_add.clicked.connect(self.registerUser)
        self.btnLayout = HBoxLayout()
        self.btnLayout.addStretch()
        self.btnLayout.addWidget(self.btn_add)
        self.btnLayout.addStretch()
        self.mainLayout.addLayout(self.btnLayout)
        self.mainLayout.addStretch()
        self.setLayout(self.mainLayout)

    def registerUser(self):
        username = self.userNameText.text()
        password = self.passwordText.text()
        if self.isEmpty(username) or self.isEmpty(password):
            QMessageBox.information(self, "提示", "用户名或密码不能为空！", QMessageBox.Yes)
            return
        userPro = UserPro(user_name=username, password=password)
        email = self.emailText.text()
        if not self.isEmpty(email):
            userPro.email = email
        sign = self.signText.text()
        if not self.isEmpty(sign):
            userPro.sign = sign
        phone = self.phoneText.text()
        if not self.isEmpty(phone):
            userPro.phone = phone
        nick_name = self.nickNameText.text()
        if not self.isEmpty(nick_name):
            userPro.nick_name = nick_name
        if self.boyRadio.isChecked():
            userPro.gender = 0
        elif self.girlRadio.isChecked():
            userPro.gender = 1
        if not self.isEmpty(self.avatar):
            userPro.avatar = self.avatar
        result = self.userService.register(userPro)

        if result is None:
            QMessageBox.information(self, "提示", "添加用户失败！", QMessageBox.Yes)
        else:
            QMessageBox.information(self, "提示", "添加用户成功！", QMessageBox.Yes)

    def avatarClick(self):
        path, _ = QFileDialog.getOpenFileName(self, "选择图片", '.', '图像文件(*.jpg *.png)')
        result = self.imageService.saveImage(path)
        if result is not None:
            self.avatarImage.setSrc(IMAGE_BASE + result)
            self.avatar = result
        print(result)

    @staticmethod
    def isEmpty(text):
        return text is None or text.strip() == ""
