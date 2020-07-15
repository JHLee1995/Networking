import socket,time,requests
#import http.client
from http.client import *

jh=http.client.HTTPConnection('10.5.3.2',25555)

times=0
timeRTT=0
timeSum=0

while(times<50):

    time1=time.time()

    jh.connect()

    time2=time.time()
    jh.request('GET','/')

    i=jh.getresponse()
    time3=time.time()
    jh.close()

    time4=time.time()
    print(i.status,i.reason)

    value=i.read()
    RTT=(time2-time1)*1000
    sum=(time4-time2)*1000
    times+=1

    timeRTT+=RTT
    timeSum+=sum

averageTime=tiemRTT/times
wholeTime=sum/times

averTime=str(float('%.3f' % averageTime))
whoTime=str(float('%.3f' % wholeTime))

print(averTime)
print(whoTime)
