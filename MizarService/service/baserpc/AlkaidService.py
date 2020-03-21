from AbsBaseService import AbsBaseService
import grpc
import BaseService_pb2
import BaseService_pb2_grpc
from service.const import consts
from BlogService_pb2 import *

channel = grpc.insecure_channel(consts.BLOG_ADDRESS)
baseStub = BaseService_pb2_grpc.BaseServiceStub(channel)


class AlkaidService(AbsBaseService):
    def __init__(self, type):
        super(AlkaidService, self).__init__(type, baseStub)


if __name__ == '__main__':
    stub = AlkaidService(type=BaseService_pb2.MessageType.BLOG)
    select_all = stub.selectAll()
    for item in select_all:
        print(item.id, item.user_id, item.header, item.content, item.image)

    print()
    by_id = stub.getById(1)
    for item in by_id:
        print(item.id, item.user_id, item.header, item.content)
