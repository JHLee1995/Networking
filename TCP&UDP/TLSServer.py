import socket,time,ssl
times=0
jh=socket.socket()

context=ssl.SSLContext(ssl.PROTOCOL_TLSv1)
context.load_cert_chain(certfile='csr.pem',keyfile='private.pem')

jh=socket.socket()
jh.bind('10.5.3.2',25555)
jh.listen(5)

while True:
    accpt,address =jh.accept()
    content=context.wrap_socket(accpt,server_side=True)

    data=content.recv[4096]
    content.send('Hi!!!'.encode())
    times+=1

    content.close()
