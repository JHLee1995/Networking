import time,socket
from socket import *

times=0
while True:

    jh=socket(AF_INET,SOCK_GRAM)
    jh.bind(('10.5.3.2',25555))

    accpt,address = jh.recvfrom(4096)


    jh.sendto('hi!!!'.encode(),address)
    times+=1
    jh.close()
