from module.base import QFrame, QPushButton, QHBoxLayout, Qt, PicLabel, QLabel
from service.const.consts import *


# 标题栏，包括logo，搜索，登陆，最小化/关闭。
class Header(QFrame):

    def __init__(self, parent=None):
        """头部区域，包括图标/搜索/设置/登陆/最大/小化/关闭。"""

        super(Header, self).__init__()
        self.setObjectName('Header')

        self.parent = parent
        # 用于确定是否最大化.
        self.isMax = False

        with open('qss/header.qss', 'r', encoding='utf-8') as f:
            self.setStyleSheet(f.read())

        # 加载按钮设置。
        self.setButtons()
        # 加载小细线装饰。
        self.setLines()
        # 加载布局设置。
        self.setLayouts()
        self.bindConnect()

    # 布局。
    def setButtons(self):
        """创建所有的按钮。"""
        self.logoLabel = PicLabel(r'resource/header.png', 32, 32)
        self.descriptionLabel = QLabel(self)
        self.descriptionLabel.setText("<b>酌酒援北斗</b>")

        self.userName = QLabel(self)
        self.userName.setText("<b>" + self.parent.parent.user.user_name + "</b>")

        self.userPix = PicLabel(IMAGE_BASE + self.parent.parent.user.avatar, 32, 32)
        self.userPix.setMinimumSize(22, 22)
        self.userPix.setObjectName("userPix")

        self.closeButton = QPushButton('×', self)
        self.closeButton.setObjectName("closeButton")
        self.closeButton.setMinimumSize(21, 17)

        self.showminButton = QPushButton('－', self)
        self.showminButton.setObjectName("minButton")
        self.showminButton.setMinimumSize(21, 17)

        self.showmaxButton = QPushButton('□')
        self.showmaxButton.setObjectName("maxButton")
        self.showmaxButton.setMaximumSize(16, 16)

        self.loginButton = QPushButton("未登录 ▼", self)
        self.loginButton.setObjectName("loginButton")

        self.prevButton = QPushButton("<")
        self.prevButton.setObjectName("prevButton")
        self.prevButton.setMaximumSize(28, 22)
        self.prevButton.setMinimumSize(28, 22)

        self.nextButton = QPushButton(">")
        self.nextButton.setObjectName("nextButton")
        self.nextButton.setMaximumSize(28, 22)
        self.nextButton.setMinimumSize(28, 22)

    def setLines(self):
        """设置装饰用小细线。"""
        self.line1 = QFrame(self)
        self.line1.setObjectName("line1")
        self.line1.setFrameShape(QFrame.VLine)
        self.line1.setFrameShadow(QFrame.Plain)
        self.line1.setMaximumSize(1, 25)

    def setLayouts(self):
        """设置布局。"""
        self.mainLayout = QHBoxLayout()
        self.mainLayout.setSpacing(0)
        self.mainLayout.addWidget(self.logoLabel)
        self.mainLayout.addWidget(self.descriptionLabel)
        self.mainLayout.addSpacing(30)
        self.mainLayout.addWidget(self.prevButton)
        self.mainLayout.addWidget(self.nextButton)
        self.mainLayout.addStretch(1)
        self.mainLayout.addWidget(self.userPix)
        self.mainLayout.addSpacing(10)
        self.mainLayout.addWidget(self.userName)
        self.mainLayout.addSpacing(18)
        self.mainLayout.addWidget(self.loginButton)
        self.mainLayout.addSpacing(7)
        self.mainLayout.addWidget(self.line1)
        self.mainLayout.addSpacing(30)
        self.mainLayout.addWidget(self.showminButton)
        self.mainLayout.addSpacing(8)
        self.mainLayout.addWidget(self.showmaxButton)
        self.mainLayout.addSpacing(8)
        self.mainLayout.addWidget(self.closeButton)
        self.setLayout(self.mainLayout)

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

    def bindConnect(self):
        self.closeButton.clicked.connect(self.parent.close)
        self.showminButton.clicked.connect(self.parent.showMinimized)
        self.showmaxButton.clicked.connect(self.showMaxiOrRevert)

    def showMaxiOrRevert(self):
        if self.isMax:
            self.parent.showNormal()
            self.isMax = False
        else:
            self.parent.showMaximized()
            self.isMax = True
