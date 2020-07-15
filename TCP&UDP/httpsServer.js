var httpsServer=require('https');
var jh=require('fs');
var nm={
  key: jh.readFileSync('private.pem'),
  cert: jh.readFileSync('ca.cer')
}
httpsServer.Server(nm,function(request, response){
  response.write("aloha");
  response.end();
}).listen(25555);
