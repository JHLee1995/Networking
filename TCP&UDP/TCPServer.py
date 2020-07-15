import socket,time

jh=socket.socket()


jh.bind(('10.5.1.2',25555))
jh.listen(1)


while True:
    accpt,address=jh.accept()

    data1=accpt.recv(4096)
    print(data1.decode())

    data2='hi!'
    accpt.send(data2.encode())

    accpt.close()
