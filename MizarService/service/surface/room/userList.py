from module.base import (QAbstractItemView, QFrame, Qt, QTabWidget, QTextEdit, QLabel, QIcon, QPushButton, QHBoxLayout,
                         QVBoxLayout,
                         InputLine, QTableWidget, QGridLayout, QTableWidgetItem, PicLabel, ScrollArea, TableWidget,
                         VBoxLayout, HBoxLayout, pyqtSignal)


class UserList(ScrollArea):
    def __init__(self, parent=None):
        super().__init__()
        self.parent = parent
        self.setObjectName('userList')
        self.userService = self.parent.parent.userService
        self.drawPanel()
        self.setLayouts()
        with open('qss/userList.qss', 'r', encoding="utf-8") as f:
            self.setStyleSheet(f.read())
        self.echoUserList()

    def drawPanel(self):
        self.spaceLine = QFrame(self)
        self.spaceLine.setObjectName("spaceLine")
        self.spaceLine.setFrameShape(QFrame.HLine)
        self.spaceLine.setFrameShadow(QFrame.Plain)
        self.spaceLine.setLineWidth(2)

        self.userTable = QTableWidget()
        self.userTable.setObjectName('userTable')
        self.userTable.setMinimumWidth(self.width())
        self.userTable.setColumnCount(6)
        self.userTable.setHorizontalHeaderLabels(['用户名', '昵称', '邮箱', '联系方式', '签名', '添加好友'])

        self.userTable.setColumnWidth(0, self.width() / 6 * 0.9)
        self.userTable.setColumnWidth(1, self.width() / 6 * 0.9)
        self.userTable.setColumnWidth(2, self.width() / 6 * 1.1)
        self.userTable.setColumnWidth(3, self.width() / 6 * 1.1)
        self.userTable.setColumnWidth(4, self.width() / 6 * 1.5)
        self.userTable.setColumnWidth(5, self.width() / 6 * 0.5)
        self.userTable.horizontalHeader().setStretchLastSection(True)
        self.userTable.verticalHeader().setVisible(False)
        self.userTable.setShowGrid(False)
        self.userTable.setAlternatingRowColors(True)
        self.userTable.setEditTriggers(QAbstractItemView.NoEditTriggers)
        self.userTable.setSelectionBehavior(QAbstractItemView.SelectRows)

    def setLayouts(self):
        self.mainLayout = VBoxLayout()

        self.mainLayout.addSpacing(10)
        self.contentLayout = HBoxLayout()

        self.mainLayout.addWidget(self.spaceLine)
        self.mainLayout.addSpacing(10)
        self.contentLayout.addSpacing(30)
        self.contentLayout.addWidget(self.userTable)
        self.contentLayout.addSpacing(30)
        self.mainLayout.addLayout(self.contentLayout)
        self.mainLayout.addSpacing(30)
        self.setLayout(self.mainLayout)

    def echoUserList(self):
        allUser = self.userService.selectAll()
        for user in allUser:
            rowCount = self.userTable.rowCount()
            self.userTable.setRowCount(rowCount + 1)
            userInfo = [user.user_name, user.nick_name, user.email, user.phone, user.sign]
            for i in range(5):
                self.userTable.setItem(rowCount, i, QTableWidgetItem(userInfo[i]))
