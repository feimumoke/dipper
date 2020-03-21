from module.base import (Qt, QFrame, QMessageBox, QTabWidget, QTextEdit, QLabel, QIcon, QPushButton, QHBoxLayout,
                         QVBoxLayout, QSize, QTextDocument, QUrl, QFileDialog,
                         InputLine, QListWidget, QGridLayout, QListWidgetItem, PicLabel, ScrollArea, TableWidget,
                         VBoxLayout, HBoxLayout, pyqtSignal, QScrollArea, QWidget, QAbstractSlider)
from service.const.consts import *
from protorpc.BlogService_pb2 import *


class ItemWidget(ScrollArea):
    def __init__(self, parent=None, blog=None):
        super(ItemWidget, self).__init__()
        self.parent = parent
        self.blog = blog
        self.init()
        self.setLayouts()
        self.setData()

        with open('qss/common.qss', 'r', encoding="utf-8") as f:
            self.setStyleSheet(f.read())

    def init(self):
        self.headerText = InputLine(self.frame, 600, 32, self.blog.header)
        self.headerText.setAlignment(Qt.AlignCenter)
        self.contentText = QTextEdit(self.frame)
        self.contentText.setMaximumWidth(600)
        self.contentText.setMaximumHeight(100)
        self.contentText.setMinimumHeight(100)
        self.contentText.setText(self.blog.content)
        self.imageFrame = QFrame()
        self.imageLayout = QGridLayout()
        self.imageFrame.setLayout(self.imageLayout)

    def setLayouts(self):
        self.mainLayout = VBoxLayout()
        self.frameLayout = HBoxLayout()
        self.contentLayout = VBoxLayout()
        self.contentLayout.addSpacing(30)
        self.contentLayout.addWidget(self.headerText)
        self.contentLayout.addSpacing(20)
        self.contentLayout.addWidget(self.contentText)
        self.contentLayout.addSpacing(20)
        self.contentLayout.addWidget(self.imageFrame)
        self.frameLayout.addSpacing(10)
        self.frameLayout.addLayout(self.contentLayout)
        self.frameLayout.addSpacing(10)
        self.mainLayout.addLayout(self.frameLayout)
        self.mainLayout.addStretch()
        self.setLayout(self.mainLayout)

    def setData(self):
        if self.blog.image is None or self.blog.image == "":
            return
        images = self.blog.image.split(":")
        count = 0
        for image in images:
            row = int(count / 3)
            col = int(count % 3)
            pic_label = PicLabel(src=IMAGE_BASE + image, width=180, height=120)
            self.imageFrame.setFixedHeight(120 * (row + 1) + 10)
            self.imageLayout.addWidget(pic_label, row, col)
            count = count + 1

    def sizeHint(self):
        # 每个item控件的大小
        return QSize(self.width(), self.height())


class BlogList(QListWidget):
    def __init__(self, parent, userId=None):
        super(BlogList, self).__init__()
        self.setFlow(self.LeftToRight)  # 从左到右
        self.setWrapping(True)  # 这三个组合可以达到和FlowLayout一样的效果
        self.setResizeMode(self.Adjust)
        self.parent = parent
        self.userId = userId
        self.user = self.parent.user
        self.blogService = self.parent.parent.blogService
        self.imageService = self.parent.parent.imageService
        self.init()

    def init(self):
        blogs = []
        if self.userId is None:
            blogs = self.blogService.selectAll()
        else:
            blogs = self.blogService.getById(self.userId)

        self.mainLayout = VBoxLayout()
        self.mainLayout.addSpacing(20)
        for blog in blogs:
            item_widget = ItemWidget(self, blog)
            item = QListWidgetItem(self)
            item.setSizeHint(item_widget.sizeHint())
            self.setItemWidget(item, item_widget)

        self.setLayout(self.mainLayout)
