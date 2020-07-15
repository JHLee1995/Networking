import time,socket
from socket import *

times=0
timeRTT=0
timeSum=0

while(times<50):
    jh=socket(AF_INET,SOCK_DGRAM)
    jh=socket
    time1=time.time()

    time2=time.time()

    jh.sendto('hi!!!'.encode(),address)

    fin=jh.recvform(4096)
    time3=time.time()

    RTT=(time3-time2)*1000
    sum=(time3-time1)*1000
    times+=1

    timeRTT+=RTT
    timeSum+=sum

    print(timeRTT/times)
    print(timeSum/times)

    jh.close()
