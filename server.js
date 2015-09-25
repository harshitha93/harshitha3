
var express   = require('express');

var mongoose   = require('mongoose');
mongoose.connect('mongodb://localhost:27017/db2');
var app       = express();
 
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
 var port     = process.env.PORT || 8080;

var conn = mongoose.connection;

 var router    = require('./routes/r1');
 app.use(function(req,res,next){
  res.setHeader('Access-Control-Allow-Origin','*')
  next()
  })
	router.use(function(req, res, next) {
	console.log('An action was performed by the server.');
	next();
});
 

app.use('/',router);


app.use('/api', router);
app.listen(port);
console.log('listening to port' + port);