from module.base import ScrollArea,QTabWidget,QVBoxLayout

# 主要内容区，包括最新的歌单。
class MainContent(ScrollArea):
    # 定义一个滑到了最低部的信号。
    # 方便子控件得知已经滑到了最底部，要做些加载的动作。

    def __init__(self, parent=None,auto_type=None):
        """主内容区，包括推荐歌单等。"""
        super(MainContent, self).__init__()
        self.parent = parent
        self.auto_tpye=auto_type
        self.setObjectName("MainContent")

        # 连接导航栏的按钮。
        # self.parent.navigation.navigationListFunction = self.navigationListFunction
        with open("QSS/mainContent.qss", 'r', encoding='utf-8') as f:
            self.style = f.read()
            self.setStyleSheet(self.style)

        self.tab = QTabWidget()
        self.tab.setObjectName("contentsTab")

        self.mainLayout = QVBoxLayout()
        self.mainLayout.setSpacing(0)
        self.mainLayout.setContentsMargins(0, 0, 0, 0)
        self.mainLayout.addWidget(self.tab)

        self.frame.setLayout(self.mainLayout)

    def addTab(self, widget, name=''):
        self.tab.addTab(widget, name)