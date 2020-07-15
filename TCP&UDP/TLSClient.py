import socket,time,ssl,pprint

times=0
timeRTT=0
timeSum=0
timeTLS=0

while(times<20):
    time1=time.time()
    jh=socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    time2=time.time()
    ssl=ssl.wrap_socket(jh,ca_certs='csr.pem',cert_reqs=ssl.CERT_REQUIRED)

    time3=time.time()
    ssl.connect(('10.5.3.2',25555))

    time4=time.time()
    ssl.send('Hi!!!'.encode())

    time5=time.time()
    content=ssl.recv[4096]

    ssl.close()
    time6=time.time()

    times+=1

    RTT=(time6-time4)*1000
    TLS=(time4-time3)*1000
    sum=(time6-time1)*1000
    timeRTT+=RTT
    timeTLS+=TLS
    timeSum+=sum

averRTT=timeRTT/times
averTLS=timeTLS/times
averSUM=timeSum/times

AverRTT=str(float('%.3f' % averRTT))
AverTLS=str(float('%.3f' % averTLS))
AverSUM=str(float('%.3f' % averSUM))

print(AverRTT)
print(AverTLS)
print(AverSUM)
