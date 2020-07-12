import socket

HOST = "127.0.0.1"
PORT = 5000

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))
s.listen(1)

print('SERVER STARTED RUNNING')

client, address = s.accept()

while True:
    msg = s.recv(4096)

print('Terminou')

print(msg)

client.close()