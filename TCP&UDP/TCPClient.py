import socket, time


timeRTT=0
timeSum=0


times=0
while(times<50):
    jh=socket.socket()

    time1=time.time()
    jh.connect(('10.5.1.2',25555))

    time2=time.time()
    jh.send('helo'.encode())

    fin=jh.recv(4096)
    time3=time.time()

    RTT=(time3-time2)*1000
    sum=(time3-time1)*1000

    times+=1

    timeRTT+=RTT
    timeSum+=sum

    print(timeRTT/times)
    print(timeSum/times)

    jh.close()
