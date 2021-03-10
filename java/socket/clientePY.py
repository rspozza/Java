import socket

conexao = socket.socket()
servidor = socket.gethostname()
porta = 5000

conexao.connect((servidor, porta))
while True:
    recebido = str(conexao.recv(5000).decode())
    print(recebido)
    conexao.send(bytes("Mensagem recebida pelo cliente Python " + "\r\n", 'UTF-8'))

conexao.close