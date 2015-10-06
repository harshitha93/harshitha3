var db2    = require('../app/models/user');
//var rec = require('../app/models/user');
 var express = require('express')
var nodemailer = require("nodemailer");
var fs = require('fs');
 var router = express.Router();


router.route('/dbs')
.get(function(req, res) {
db2.find({},{_id:0,salary:0},function(err, dbs) {
   if (err)
     res.send(err);
 
   res.json(dbs);
});
});

router.route('/dbs/:id').post(function(req, res) {
    //console.log(req);
	db2.find({designation:req.params.id},{_id:0},function(err,dbs){
      console.log(req.params.id);
		 // for(i in dbs)
		 // {
		 // 	dbs[i]={description:dbs[i].description}
		 // 	//dbs[i]={location:dbs[i].location}

		 // }

            
			res.json(dbs)
	})

	
});

router.route('/send/:id').post(function handlemail(req, res) {


    //console.log(req.body.mailId)
     var transporter = nodemailer.createTransport({
         service: 'Gmail',
         auth: {
             user: 'spoorthin26@gmail.com ', 
             pass: '#[spoo]{sid}' 
         }
     });


    db2.findOne({designation:req.params.id},{_id:0},function(err,docs){
    text= "Hi greetings from incture technologies\n\nYour friend has suggested a job for you\n\nDesignation: "+docs.designation+",\n\nDescription:"+ docs.description+",\n\nExperience:"+ docs.experience+",\n\nLocation:"+ docs.location+",\n\nSalary:"+ docs.salary+"\n\nClick here to Apply www.incture.com"
     
    mailOptions = {
    from: 'spoorthin26@gmail.com ', // sender address
    to: req.body.mailId, // list of receivers
    subject: 'A job for you ', // Subject line
    text: text
    // attachments: [
    //   {   
    //        path:"/home/spoorthi/Downloads/jobdescription.html", type:"html", name:"job.html"
    //     }
    // ]
        };
        transporter.sendMail(mailOptions, function(error, info){
    if(error){
        console.log(error);
        res.json({unsuccessful: 'error'});
    }else{
        console.log('Message sent: ' + info.response);
        res.json({Successful: info.response});
        };
    })
    })
     
});


module.exports = router;