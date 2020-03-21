from module.base import (toAsync, QLabel, QIcon, QPushButton, QHBoxLayout,
                         QVBoxLayout, QFileDialog,
                         InputLine, QRadioButton, QGridLayout, QTableWidgetItem, PicLabel, ScrollArea, TableWidget,
                         VBoxLayout, HBoxLayout, pyqtSignal)
from service.const.consts import *
import datetime
import os


class UserInfo(ScrollArea):
    def __init__(self, parent=None):
        super(UserInfo, self).__init__(self)
        self.setLabel()
        self.setLayouts()

    def setLabel(self):
        self.avatarLabel = QLabel()
        self.avatarLabel.setText("头像")
        self.avatarImage = PicLabel(width=100, height=100)
        self.avatarImage.setObjectName("avatarImage")
        self.avatarImage.doubleClick.connect(self.avatarClick)

        self.userNameLabel = QLabel()
        self.userNameLabel.setText("用户名")
        self.userNameText = InputLine(self, 300, 32)

        self.passwordLabel = QLabel()
        self.passwordLabel.setText("密码")
        self.passwordText = InputLine(self, 300, 32)

        self.nickNameLabel = QLabel()
        self.nickNameLabel.setText("昵称")
        self.nickNameText = InputLine(self, 300, 32)

        self.genderLabel = QLabel()
        self.genderLabel.setText("性别")
        self.boyRadio = QRadioButton('男')
        self.girlRadio = QRadioButton('女')

        self.emailLabel = QLabel()
        self.emailLabel.setText("邮箱")
        self.emailText = InputLine(self, 300, 32)

        self.phoneLabel = QLabel()
        self.phoneLabel.setText("手机")
        self.phoneText = InputLine(self, 300, 32)

        self.signLabel = QLabel()
        self.signLabel.setText("签名")
        self.signText = InputLine(self, 300, 32)

    def avatarClick(self):
        print('ccc')

    def setLayouts(self):
        middle = 20
        height = 20
        self.mainLayout = VBoxLayout()
        self.mainLayout.addSpacing(20)
        self.infoLayout = HBoxLayout()
        self.infoLayout.addStretch()
        self.labelLayout = VBoxLayout()
        self.labelLayout.addSpacing(42)
        self.labelLayout.addWidget(self.avatarLabel)
        self.labelLayout.addSpacing(52)
        self.labelLayout.addWidget(self.userNameLabel)
        self.labelLayout.addSpacing(height)
        self.labelLayout.addWidget(self.passwordLabel)
        self.labelLayout.addSpacing(height)
        self.labelLayout.addWidget(self.nickNameLabel)
        self.labelLayout.addSpacing(height)
        self.labelLayout.addWidget(self.genderLabel)
        self.labelLayout.addSpacing(height)
        self.labelLayout.addWidget(self.emailLabel)
        self.labelLayout.addSpacing(height)
        self.labelLayout.addWidget(self.phoneLabel)
        self.labelLayout.addSpacing(height)
        self.labelLayout.addWidget(self.signLabel)
        self.labelLayout.addSpacing(height)
        self.textLayout = VBoxLayout()
        self.imageLayout = HBoxLayout()
        self.imageLayout.addStretch()
        self.imageLayout.addWidget(self.avatarImage)
        self.imageLayout.addStretch()
        self.textLayout.addLayout(self.imageLayout)
        self.textLayout.addSpacing(height)
        self.textLayout.addWidget(self.userNameText)
        self.textLayout.addSpacing(height)
        self.textLayout.addWidget(self.passwordText)
        self.textLayout.addSpacing(height)
        self.textLayout.addWidget(self.nickNameText)
        self.textLayout.addSpacing(height)
        self.genderLayout = HBoxLayout()
        self.genderLayout.addWidget(self.boyRadio)
        self.genderLayout.addWidget(self.girlRadio)
        self.textLayout.addLayout(self.genderLayout)
        self.textLayout.addSpacing(height)
        self.textLayout.addWidget(self.emailText)
        self.textLayout.addSpacing(height)
        self.textLayout.addWidget(self.phoneText)
        self.textLayout.addSpacing(height)
        self.textLayout.addWidget(self.signText)
        self.textLayout.addSpacing(height)
        self.infoLayout.addLayout(self.labelLayout)
        self.infoLayout.addSpacing(middle)
        self.infoLayout.addLayout(self.textLayout)
        self.infoLayout.addStretch()
        self.mainLayout.addLayout(self.infoLayout)


class Personal(UserInfo):
    def __init__(self, parent=None):
        super(Personal, self).__init__(self)
        self.parent = parent
        self.user = self.parent.user
        self.userService = self.parent.parent.userService
        self.imageService = self.parent.parent.imageService
        with open('qss/common.qss', 'r', encoding="utf-8") as f:
            self.setStyleSheet(f.read())

        self.initData()

    def initData(self):
        self.avatarImage.setSrc(IMAGE_BASE + self.user.avatar)
        self.userNameText.setText(self.user.user_name)
        self.passwordText.setText(self.user.password)
        self.nickNameText.setText(self.user.nick_name)
        self.signText.setText(self.user.sign)
        self.emailText.setText(self.user.email)
        self.phoneText.setText(self.user.phone)
        if self.user.gender == 1:
            self.girlRadio.setChecked(True)
        elif self.user.gender == 0:
            self.boyRadio.setChecked(True)
        self.mainLayout.addStretch()
        self.setLayout(self.mainLayout)

    def avatarClick(self):
        print('aaa')
        path, _ = QFileDialog.getOpenFileName(self, "选择图片", '.', '图像文件(*.jpg *.png)')
        result = self.imageService.saveImage(path)
        if result is not None:
            self.user.avatar = result
            self.userService.register(self.user)
            self.avatarImage.setSrc(IMAGE_BASE + result)
            self.parent.header.userPix.setSrc(IMAGE_BASE + result)
        print(result)
