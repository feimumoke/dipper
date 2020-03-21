from module.base import QWidget, QTabWidget, Qt, QIcon, QStackedWidget, QApplication, QFrame, QVBoxLayout, QHBoxLayout, \
    SystemTray
from view.Header import Header
from view.MainContent import MainContent
from view.Navigation import Navigation
from room.personal import Personal
from room.userAdd import UserAdd
from room.userList import UserList
from room.blogAdd import BlogAdd
from room.blogList import BlogList


class MainWindow(QWidget):
    def __init__(self, parent=None):
        super(MainWindow, self).__init__()
        self.parent = parent
        self.user = self.parent.user
        self.setObjectName("MainWindow")
        self.setWindowFlags(Qt.FramelessWindowHint)
        self.setWindowIcon(QIcon('resource/header.PNG'))
        self.setWindowTitle("酌酒援北斗")
        self.resize(1022, 670)

        self.header = Header(self)
        self.navigation = Navigation(self)

        self.personalContent = Personal(self)
        self.userAdd = UserAdd(self)
        self.userList = UserList(self)
        self.blogAdd = BlogAdd(self)
        self.ownBlog=BlogList(self,self.user.id)
        self.blogList = BlogList(self)

        self.mainContents = QStackedWidget()
        self.mainContents.addWidget(self.personalContent)
        self.mainContents.addWidget(self.userAdd)
        self.mainContents.addWidget(self.userList)
        self.mainContents.addWidget(self.blogList)
        self.mainContents.addWidget(self.ownBlog)
        self.mainContents.addWidget(self.blogAdd)

        self.mainContents.setCurrentIndex(0)

        # 设置布局小细线。
        self.setLines()
        # 设置布局。
        self.setLayouts()

        with open('qss/window.qss', 'r') as f:
            self.setStyleSheet(f.read())

    def setLines(self):
        """设置布局小细线。"""
        self.line1 = QFrame(self)
        self.line1.setObjectName("line1")
        self.line1.setFrameShape(QFrame.HLine)
        self.line1.setFrameShadow(QFrame.Plain)
        self.line1.setLineWidth(2)

    def setLayouts(self):
        self.mainLayout = QVBoxLayout()
        self.mainLayout.addWidget(self.header)
        self.mainLayout.addWidget(self.line1)
        self.contentLayout = QHBoxLayout()
        self.contentLayout.setStretch(0, 70)
        self.contentLayout.setStretch(1, 570)

        self.contentLayout.addWidget(self.navigation)
        self.contentLayout.addWidget(self.mainContents)

        self.contentLayout.setSpacing(0)
        self.contentLayout.setContentsMargins(0, 0, 0, 0)

        self.mainLayout.addLayout(self.contentLayout)
        #  self.mainLayout.addWidget(self.playWidgets)

        self.mainLayout.setStretch(0, 43)
        self.mainLayout.setStretch(1, 0)
        self.mainLayout.setStretch(2, 576)
        self.mainLayout.setStretch(3, 50)

        self.mainLayout.setSpacing(0)
        self.mainLayout.setContentsMargins(0, 0, 0, 0)
        self.setLayout(self.mainLayout)
