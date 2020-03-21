import os
import subprocess

proto_path = './proto'

for file in os.listdir(proto_path):
    print(file)
    args = "--proto_path=./proto --python_out=./protorpc --grpc_python_out=./protorpc {0}".format("proto/" + file)
    result = subprocess.call("python -m grpc_tools.protoc " + args, shell=True)
    print("grpc generation result for '{0}': code {1}".format(file, result))
