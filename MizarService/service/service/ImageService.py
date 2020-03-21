import grpc
import BaseService_pb2
import BaseService_pb2_grpc
from service.const import consts
from BlogService_pb2 import *
import ImageService_pb2
import ImageService_pb2_grpc
import datetime
import os

channel = grpc.insecure_channel(consts.BLOG_ADDRESS)
baseStub = ImageService_pb2_grpc.ImageServiceStub(channel)


class ImageService:
    def __init__(self):
        self.stub = baseStub

    def saveImage(self, path):
        filename = os.path.basename(path)
        today = datetime.date.today()
        microsecond = datetime.datetime.now().microsecond
        filename = str(today) + "/" + str(microsecond) + "/" + filename
        with open(path, 'rb') as f:
            content = f.read()
            img_data = ImageService_pb2.ImageData(name=filename, photo=content)
            result = self.stub.save(img_data)
            if result.rpc_code == 200:
                return result.url
            else:
                return None
