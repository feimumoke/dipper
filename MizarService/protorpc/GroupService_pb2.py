# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: GroupService.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='GroupService.proto',
  package='com.dipper.proto.rpc',
  syntax='proto3',
  serialized_options=b'\n\024com.dipper.proto.rpcB\nGroupProtoP\001',
  serialized_pb=b'\n\x12GroupService.proto\x12\x14\x63om.dipper.proto.rpc\"\x92\x01\n\x08GroupPro\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x11\n\tgroup_num\x18\x02 \x01(\x05\x12\x12\n\ngroup_name\x18\x03 \x01(\t\x12\x0e\n\x06\x61vatar\x18\x04 \x01(\t\x12\x0e\n\x06is_del\x18\x05 \x01(\x05\x12\x0f\n\x07is_read\x18\x06 \x01(\x05\x12\x11\n\tsend_time\x18\x07 \x01(\t\x12\x0f\n\x07is_back\x18\x08 \x01(\x05\x32\x0e\n\x0cGroupServiceB$\n\x14\x63om.dipper.proto.rpcB\nGroupProtoP\x01\x62\x06proto3'
)




_GROUPPRO = _descriptor.Descriptor(
  name='GroupPro',
  full_name='com.dipper.proto.rpc.GroupPro',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='com.dipper.proto.rpc.GroupPro.id', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='group_num', full_name='com.dipper.proto.rpc.GroupPro.group_num', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='group_name', full_name='com.dipper.proto.rpc.GroupPro.group_name', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='avatar', full_name='com.dipper.proto.rpc.GroupPro.avatar', index=3,
      number=4, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='is_del', full_name='com.dipper.proto.rpc.GroupPro.is_del', index=4,
      number=5, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='is_read', full_name='com.dipper.proto.rpc.GroupPro.is_read', index=5,
      number=6, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='send_time', full_name='com.dipper.proto.rpc.GroupPro.send_time', index=6,
      number=7, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='is_back', full_name='com.dipper.proto.rpc.GroupPro.is_back', index=7,
      number=8, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=45,
  serialized_end=191,
)

DESCRIPTOR.message_types_by_name['GroupPro'] = _GROUPPRO
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

GroupPro = _reflection.GeneratedProtocolMessageType('GroupPro', (_message.Message,), {
  'DESCRIPTOR' : _GROUPPRO,
  '__module__' : 'GroupService_pb2'
  # @@protoc_insertion_point(class_scope:com.dipper.proto.rpc.GroupPro)
  })
_sym_db.RegisterMessage(GroupPro)


DESCRIPTOR._options = None

_GROUPSERVICE = _descriptor.ServiceDescriptor(
  name='GroupService',
  full_name='com.dipper.proto.rpc.GroupService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=193,
  serialized_end=207,
  methods=[
])
_sym_db.RegisterServiceDescriptor(_GROUPSERVICE)

DESCRIPTOR.services_by_name['GroupService'] = _GROUPSERVICE

# @@protoc_insertion_point(module_scope)