import abc
import BaseService_pb2
from service.const import consts


class AbsBaseService(metaclass=abc.ABCMeta):
    def __init__(self, type, stub):
        self._type = type
        self.baseStub = stub

    @staticmethod
    def get_class(path):
        print(path)
        clazz = path.split('.')[-1]
        module = clazz.replace('Pro', 'Service_pb2')
        try:
            m = __import__(module)
        except Exception:
            m = __import__("BaseService_pb2")
        cls = getattr(m, clazz)()
        return cls

    def save(self, data):
        base_entry = BaseService_pb2.Entry(type=self._type)
        base_entry.entry.Pack(data)
        result = self.baseStub.save(base_entry)
        if result.rpc_code == consts.RESULT_OK:
            return "SUCCESS"
        else:
            return None

    def getById(self, id):
        all = []
        base_entry = BaseService_pb2.KeyId(type=self._type, key_id=id)
        result = self.baseStub.selectById(base_entry)
        if result.rpc_code == consts.RESULT_OK:
            data_list = BaseService_pb2.DataList()
            result.data.Unpack(data_list)
            for data in data_list.data:
                url = data.type_url
                clazz = self.get_class(url)
                data.Unpack(clazz)
                all.append(clazz)
        return all

    def update(self, data):
        return self.save(data)

    def selectAll(self):
        all = []
        base_entry = BaseService_pb2.Empty(type=self._type)
        result = self.baseStub.selectAll(base_entry)
        if result.rpc_code == consts.RESULT_OK:
            data_list = BaseService_pb2.DataList()
            result.data.Unpack(data_list)
            for data in data_list.data:
                url = data.type_url
                clazz = self.get_class(url)
                data.Unpack(clazz)
                all.append(clazz)
        return all

    def selectOne(self, data):
        base_entry = BaseService_pb2.Entry(type=self._type)
        base_entry.entry.Pack(data)
        result = self.baseStub.selectByProperty(base_entry)
        if result.rpc_code == consts.RESULT_OK:
            url = result.data.type_url
            clazz = self.get_class(url)
            result.data.Unpack(clazz)
            return clazz
        else:
            return None

    def selectList(self, data):
        all = []
        base_entry = BaseService_pb2.Entry(type=self._type)
        base_entry.entry.Pack(data)
        result = self.baseStub.selectListByProperty(base_entry)
        if result.rpc_code == consts.RESULT_OK:
            data_list = BaseService_pb2.DataList()
            result.data.Unpack(data_list)
            for one in data_list:
                url = one.type_url
                clazz = self.get_class(url)
                one.Unpack(clazz)
                all.append(clazz)
        return all

    def selectAndPaging(self, pageNum, pageSize):
        all = []
        base_entry = BaseService_pb2.PageInfo(type=self._type, page_num=pageNum, page_size=pageSize)
        result = self.baseStub.selectPageList(base_entry)
        if result.rpc_code == consts.RESULT_OK:
            data_list = BaseService_pb2.DataList()
            result.data.Unpack(data_list)
            for one in data_list:
                url = one.type_url
                clazz = self.get_class(url)
                one.Unpack(clazz)
                all.append(clazz)
        return all
