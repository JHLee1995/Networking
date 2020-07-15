import time,socketserver
import http.server
from socketserver import *

jh=http.server.SimpleHTTPRequestHandler
with socketserver.TCPServer(('10.5.3.2',25555),jh) as httpServer:
    httpServer.serve_forever()
