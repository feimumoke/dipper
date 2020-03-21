from AbsBaseService import AbsBaseService
import grpc
import BaseService_pb2_grpc
from service.const import consts

channel = grpc.insecure_channel(consts.USER_ADDRESS)
baseStub = BaseService_pb2_grpc.BaseServiceStub(channel)


class MerakService(AbsBaseService):
    def __init__(self, type):
        super(MerakService, self).__init__(type, baseStub)
