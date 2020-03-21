from module.base import (Qt, QFrame, QMessageBox, QTabWidget, QTextEdit, QLabel, QIcon, QPushButton, QHBoxLayout,
                         QVBoxLayout, QTextDocumentFragment, QTextDocument, QUrl, QFileDialog,
                         InputLine, QRadioButton, QGridLayout, QTableWidgetItem, PicLabel, ScrollArea, TableWidget,
                         VBoxLayout, HBoxLayout, pyqtSignal)
from service.const.consts import *
from protorpc.BlogService_pb2 import *
import sip


class BlogAdd(ScrollArea):
    def __init__(self, parent=None):
        super(BlogAdd, self).__init__(self)
        self.parent = parent
        self.user = self.parent.user
        self.blogService = self.parent.parent.blogService
        self.imageService = self.parent.parent.imageService
        self.title = None
        self.contents = None
        self.images = []
        self.image_pic = []
        self.draw()
        self.setLayouts()
        with open('qss/common.qss', 'r', encoding="utf-8") as f:
            self.setStyleSheet(f.read())

    def draw(self):
        self.headerText = InputLine(self.frame, 600, 32, "» 标题 «")
        self.headerText.setAlignment(Qt.AlignCenter)
        self.contentText = QTextEdit(self.frame)
        self.contentText.setMaximumWidth(600)
        self.contentText.setMaximumHeight(100)
        self.contentText.setMinimumHeight(100)
        self.imageFrame = QFrame()
        self.imageFrame.setToolTip("添加图片")
        self.imageFrame.setFixedHeight(20)
        self.addImageButton = QPushButton('☞ ❒')
        self.addImageButton.clicked.connect(self.addImage)
        self.addButton = QPushButton("发布")
        self.addButton.clicked.connect(self.publish)

    def setLayouts(self):
        self.mainLayout = VBoxLayout()
        self.frameLayout = HBoxLayout()
        self.contentLayout = VBoxLayout()
        self.imageLayout = QGridLayout()
        self.imageFrame.setLayout(self.imageLayout)
        self.contentLayout.addSpacing(30)
        self.contentLayout.addWidget(self.headerText)
        self.contentLayout.addSpacing(20)
        self.contentLayout.addWidget(self.contentText)
        self.contentLayout.addSpacing(20)
        self.contentLayout.addWidget(self.addImageButton)
        self.contentLayout.addSpacing(20)
        self.contentLayout.addWidget(self.imageFrame)
        self.contentLayout.addSpacing(20)
        self.contentLayout.addWidget(self.addButton)
        self.frameLayout.addSpacing(10)
        self.frameLayout.addLayout(self.contentLayout)
        self.frameLayout.addSpacing(10)
        self.mainLayout.addLayout(self.frameLayout)
        self.mainLayout.addStretch()
        self.setLayout(self.mainLayout)

    def addImage(self):
        paths, _ = QFileDialog.getOpenFileNames(self, "选择图片", '.', '图像文件(*.jpg *.png)')
        print(paths)
        for path in paths:
            image = self.imageService.saveImage(path)
            if image is not None:
                count = len(self.images)
                row = count / 3
                col = count % 3
                pic_label = PicLabel(src=IMAGE_BASE + image, width=180, height=120)
                self.imageFrame.setFixedHeight(120 * (row + 1) + 10)
                self.imageLayout.addWidget(pic_label, row, col)
                self.images.append(image)
                self.image_pic.append(pic_label)

    def publish(self):
        header = self.headerText.text()
        if self.isEmpty(header):
            QMessageBox.information(self, "提示", "标题不能为空！", QMessageBox.Yes)
            return
        blog = BlogPro(user_id=self.user.id)
        blog.header = header
        blog.content = self.contentText.toPlainText()
        if len(self.images) > 0:
            blog.image = ":".join(self.images)
        result = self.blogService.save(blog)
        if result is None:
            QMessageBox.information(self, "提示", "添加成功！", QMessageBox.Yes)
        else:
            QMessageBox.information(self, "提示", "添加成功！", QMessageBox.Yes)
            self.headerText.setText("")
            self.contentText.setText("")
            for pic in self.image_pic:
                self.imageLayout.removeWidget(pic)
                sip.delete(pic)
            self.images = []
            self.image_pic = []
            self.imageFrame.setFixedHeight(20)

    @staticmethod
    def isEmpty(text):
        return text is None or text.strip() == ""
