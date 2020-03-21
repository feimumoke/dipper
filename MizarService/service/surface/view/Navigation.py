from module.base import (QApplication, cacheFolder, QDialog, QFrame, QHBoxLayout, HBoxLayout, QIcon, QLabel,
                         QListWidget, QListWidgetItem,
                         QPushButton, PicLabel, QScrollArea, ScrollArea, Qt, QTabWidget, TableWidget, QVBoxLayout,
                         VBoxLayout,
                         QWidget)


# 左侧的导航栏
class Navigation(QScrollArea):
    def __init__(self, parent=None):
        """包括博客、用户申请"""
        super(Navigation, self).__init__(parent)
        self.parent = parent
        self.frame = QFrame()
        self.setMaximumWidth(200)

        self.setWidget(self.frame)
        self.setWidgetResizable(True)
        self.frame.setMinimumWidth(200)

        # 定义3个事件函数，方便扩展。
        self.navigationListFunction = self.none
        self.nativeListFunction = self.none
        self.singsFunction = self.none

        with open('QSS/navigation.qss', 'r') as f:
            style = f.read()
            self.setStyleSheet(style)
            self.frame.setStyleSheet(style)

        # 包括显示信息： 推荐 我的音乐 歌单。
        self.setLabels()
        # 包括详细的内容：发现音乐，FM，MV等。
        self.setListViews()

        self.setLayouts()
        self.bindConnect()

    # 布局。
    def setLabels(self):
        """定义所有的标签。"""
        self.userLabel = QLabel(" 用户管理")
        self.userLabel.setObjectName("userManagement")
        self.userLabel.setMaximumHeight(27)

        self.blogLabel = QLabel(" 博客管理")
        self.blogLabel.setObjectName("blogManagement")
        self.blogLabel.setMaximumHeight(27)
        # self.myMusic.setMaximumHeight(54)

        self.otherLabel = QLabel(" 其他...")
        self.otherLabel.setObjectName("otherLabel")
        self.otherLabel.setMaximumHeight(27)

    def setListViews(self):
        """定义承载功能的ListView"""
        self.userItemList = QListWidget()
        self.userItemList.setMaximumHeight(110)
        self.userItemList.setObjectName("userItemList")
        self.userItemList.addItem(QListWidgetItem("♠ 个人信息"))
        self.userItemList.addItem(QListWidgetItem("❧ 新增用户"))
        self.userItemList.addItem(QListWidgetItem("ღ 用户查找"))
        self.userItemList.setCurrentRow(0)

        self.blogItemList = QListWidget()
        self.blogItemList.setObjectName("blogItemList")
        self.blogItemList.setMaximumHeight(100)
        # self.blogItemList.addItem(QListWidgetItem(QIcon('resource/notes.png'), "☯ 博客浏览"))
        self.blogItemList.addItem(QListWidgetItem("☯ 博客浏览"))
        self.blogItemList.addItem(QListWidgetItem("☪ 我的博客"))
        self.blogItemList.addItem(QListWidgetItem("✯ 博客发表"))

    def setLayouts(self):
        """定义布局。"""
        self.mainLayout = VBoxLayout(self.frame)
        self.mainLayout.addSpacing(10)

        self.mainLayout.addWidget(self.blogLabel)
        self.mainLayout.addSpacing(10)
        self.mainLayout.addWidget(self.blogItemList)
        self.mainLayout.addSpacing(10)

        self.mainLayout.addWidget(self.userLabel)
        self.mainLayout.addSpacing(10)
        self.mainLayout.addWidget(self.userItemList)
        self.mainLayout.addSpacing(1)

        self.mainLayout.addWidget(self.otherLabel)
        self.mainLayout.addSpacing(1)

        self.mainLayout.addStretch(1)

        self.setContentsMargins(0, 0, 0, 0)

    def bindConnect(self):
        self.blogItemList.itemPressed.connect(self.blogItemListClickEvent)
        self.userItemList.itemPressed.connect(self.userItemListClickEvent)

    def userItemListClickEvent(self):
        print(self.userItemList.currentRow())
        self.blogItemList.setCurrentRow(-1)
        row = self.userItemList.currentRow()
        if 0 <= row < 3:
            self.parent.mainContents.setCurrentIndex(row)

    def blogItemListClickEvent(self):
        self.userItemList.setCurrentRow(-1)
        if self.blogItemList.currentRow() == 0:
            self.parent.mainContents.setCurrentIndex(3)
        elif self.blogItemList.currentRow() == 1:
            self.parent.mainContents.setCurrentIndex(4)
        elif self.blogItemList.currentRow() == 2:
            self.parent.mainContents.setCurrentIndex(5)

    # just a test.
    def setSingsList(self):

        pass

    # 功能。
    def none(self):
        # 没有用的空函数。
        pass
