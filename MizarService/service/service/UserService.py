from MerakService import MerakService
import BaseService_pb2
import UserService_pb2


class UserService:
    def __init__(self):
        self.stub = MerakService(type=BaseService_pb2.MessageType.USER)

    def login(self, username, password):
        user_pro = UserService_pb2.UserPro(user_name=username, password=password)
        one = self.stub.selectOne(user_pro)
        print(one)
        return one

    def selectAll(self):
        all = self.stub.selectAll()
        print(all)
        return all

    def register(self, user):
        save = self.stub.save(user)
        return save


if __name__ == '__main__':
    us = UserService()
    us.login('jk', 'j2k')
