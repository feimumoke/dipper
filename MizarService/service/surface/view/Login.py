# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Login.ui'
#
# Created by: PyQt5 UI code generator 5.11.2
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5.QtGui import *

from module.base import QDialog, QFrame, ScrollArea, HBoxLayout, HStretchBox, QLabel, QLineEdit, QPushButton, Qt, \
    VBoxLayout, RequestThread, InputLine

from module.items import LoginLineEdit

from service.service.UserService import UserService


class Header(QFrame):
    myStyle = """
    QFrame {background: #C0C0C0;}

    QLabel {
        margin-left: 8px; 
        color: white; 
        font-weight: bold;
        font-size: 15px;
    }

    QPushButton {
        border: none;
        font: bold;
        font-size: 13px;
        color: #7C7C7C;
        margin-right: 8px;
    }

    QPushButton:hover{
        color: #DCDDE4;
    }
    """

    def __init__(self, title: str, parent=None):
        super(Header, self).__init__()
        self.parent = parent

        self.setStyleSheet(self.myStyle)

        self.mainLayout = HBoxLayout(self)

        self.title = QLabel(title)
        self.mainLayout.addWidget(self.title)

        self.mainLayout.addStretch(1)

        self.closeButton = QPushButton('×')
        self.closeButton.clicked.connect(self.parent.close)
        self.mainLayout.addWidget(self.closeButton)

    # 事件。
    """重写鼠标事件，实现窗口拖动。"""

    def mousePressEvent(self, event):
        if event.buttons() == Qt.LeftButton:
            self.parent.m_drag = True
            self.parent.m_DragPosition = event.globalPos() - self.parent.pos()
            event.accept()

    def mouseMoveEvent(self, event):
        try:
            if event.buttons() and Qt.LeftButton:
                self.parent.move(event.globalPos() - self.parent.m_DragPosition)
                event.accept()
        except AttributeError:
            pass

    def mouseReleaseEvent(self, event):
        if event.buttons() == Qt.LeftButton:
            self.m_drag = False


class LoginWindow(ScrollArea):
    def __init__(self, parent=None):
        super(LoginWindow, self).__init__()
        self.setWindowFlags(Qt.FramelessWindowHint)
        self.parent = parent
        self.userService = self.parent.userService
        self.resize(600, 360)
        self.setObjectName("LoginWindow")
        self.mainLayout = VBoxLayout(self)
        self.header = Header("登录", self)
        self.header.setMinimumHeight(30)
        self.user_label = QLabel("用户名")
        self.user_label.setObjectName("UserName")

        self.user_label.setMaximumHeight(27)
        self.txt_user = InputLine(self, 220, 32, "请输入用户名")
        self.txt_user.setObjectName("txt_user")
        self.txt_user.setText("生命练习生")
        self.pwd_label = QLabel("密码")
        self.pwd_label.setObjectName("Password")
        self.pwd_label.setMaximumHeight(27)
        self.txt_pwd = InputLine(self, 220, 32, "请输入密码")
        self.txt_pwd.resize(280, 40)
        self.txt_pwd.setObjectName("txt_pwd")
        self.txt_pwd.setEchoMode(QLineEdit.Password)
        self.txt_pwd.setText("123")
        self.btn_login = QPushButton()
        self.btn_login.setObjectName("btn_login")
        self.btn_login.setText("登录")
        self.btn_login.clicked.connect(self.login)
        self.btn_register = QPushButton()
        self.btn_register.setObjectName("btn_register")
        self.btn_register.setText("注册账号")
        self.setLayouts()
        with open('qss/Login_style.qss', 'r', encoding='utf-8') as f:
            self.setStyleSheet(f.read())

    def setLayouts(self):
        self.mainLayout = VBoxLayout()
        self.mainLayout.addWidget(self.header)
        self.mainLayout.addStretch()

        self.infoLayout = HBoxLayout()
        self.infoLayout.addStretch()
        self.labelLayout = VBoxLayout()
        self.labelLayout.addWidget(self.user_label)
        self.labelLayout.addSpacing(10)
        self.labelLayout.addWidget(self.pwd_label)
        self.infoLayout.addLayout(self.labelLayout)
        self.infoLayout.addSpacing(40)
        self.msgLayout = VBoxLayout()
        self.msgLayout.addWidget(self.txt_user)
        self.msgLayout.addSpacing(10)
        self.msgLayout.addWidget(self.txt_pwd)
        self.infoLayout.addLayout(self.msgLayout)
        self.infoLayout.addStretch()
        self.mainLayout.addLayout(self.infoLayout)
        self.mainLayout.addSpacing(15)

        self.mainLayout.addSpacing(40)

        self.loginLayout = HBoxLayout()
        self.loginLayout.addSpacing(150)
        self.loginLayout.addWidget(self.btn_login)
        self.loginLayout.addSpacing(150)

        self.registerLayout = HBoxLayout()
        self.registerLayout.addSpacing(150)
        self.registerLayout.addWidget(self.btn_register)
        self.registerLayout.addSpacing(150)
        self.mainLayout.addLayout(self.loginLayout)
        self.mainLayout.addSpacing(10)
        self.mainLayout.addLayout(self.registerLayout)
        self.mainLayout.addStretch()
        self.frame.setLayout(self.mainLayout)

    def login(self):
        username = self.txt_user.text()
        password = self.txt_pwd.text()
        print(username, password)
        user = self.userService.login(username, password)
        if user is not None:
            self.parent.user = user
            self.parent.loginSuccess()
        else:
            QMessageBox.information(self, "提示", "用户名或密码错误！", QMessageBox.Yes)
