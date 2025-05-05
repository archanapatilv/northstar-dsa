var http = require('http');
var dt = require('./date');


http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  //res.write('<script> var val = document.cookie; alert(val); </script>');
  //res.write('<img src="1" onmouseover=alert(document.cookie);/> ');
  //res.write('Date Time: ' + dt.myDateTime());
  //res.write('<b onmouseover=alert(\'Wufff!\')>click me!</b>');
  // res.write('<b onmouseover=alert(document.cookie)>click me to Search!</b>');
  res.write('<input type=text id=text1 name=text1>');
  res.write('<b onmouseover=alert(document.getElementById(\'text1\').value)>click me to Search!</b>');
  res.end()}).listen(8080);