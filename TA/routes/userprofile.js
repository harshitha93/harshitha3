var rec    = require('../app/models/user2');
 var express = require('express')
var router1 = express.Router();



 router1.route('/save').post(function saveUser(req, res) {

          var user = new rec({
            
            name: req.body.name,
            designation: req.body.designation,
            email: req.body.email,
            pastemployment: [{
                        company:req.body.company,
                        timeperiod:req.body.timeperiod,
                        designation:req.body.designation,
                        loc:req.body.loc
    }],
    skills:req.body.skills,
    postgraduation: [{
                        postcollegename: req.body.postcollegename,
                        postdegree: req.body.postdegree,
                       postyearofpassing: req.body.postyearofpassing
    }],
    graduation: [{
                       gradcollegename: req.body.gradcollegename,
                       graddegree: req.body.graddegree,
                       gradyearofpassing: req.body.gradyearofpassing
    }],
    highschool: [{
                      schoolname: req.body.schoolname,
                      board: req.body.board,
                      schoolyearofpassingschool: req.body.schoolyearofpassing
    }]
              
        
});

          user.save(function(err,rec) {
            if (err)  res.json(err);
             res.json({
              success: 'true'
              
            });

          });

        });


router1.route('/userupdate/:id').put(function(req, res) {
  
  rec.findById(req.params.id, function(err, rec) {
    if (err)
      res.json(err);
  
    
    
    if( req.body.name!==undefined)
            rec.name = req.body.name
    if(req.body.designation!==undefined){
          
            rec.designation=req.body.designation

          }
    if(req.body.email!==undefined)
            rec.email=req.body.email;

    if(req.body.company!==undefined)
            rec.pastemployment[0].company=req.body.company;

    if(req.body.timeperiod!==undefined)
            rec.pastemployment[1].timeperiod=req.body.timeperiod;

      if(req.body.designation!==undefined)
            rec.pastemployment[2].designation=req.body.designation;

      if(req.body.loc!==undefined)
            rec.pastemployment[3].loc=req.body.loc;

      if(req.body.skills!==undefined)
            rec.skills=req.body.skills;
      
      if(req.body.postcollegename!==undefined)
            rec.postgraduation[0].postcollegename=req.body.postcollegename;
      if(req.body.postdegree!==undefined)
            rec.postgraduation[1].postdegree=req.body.postdegree;
      if(req.body.postyearofpassing!==undefined)
            rec.postgraduation[2].postyearofpassing=req.body.postyearofpassing;
          

      if(req.body.gradcollegename!==undefined)
            rec.graduation[0].gradcollegename=req.body.gradcollegename;
      if(req.body.graddegree!==undefined)
            rec.graduation[1].graddegree=req.body.graddegree;
      if(req.body.gradyearofpassing!==undefined)
            rec.graduation[2].gradyearofpassing=req.body.gradyearofpassing;


      if(req.body.schoolname!==undefined)
            rec.highschool[0].schoolname=req.body.schoolname;
      if(req.body.board!==undefined)
            rec.highschool[1].board=req.body.board;
      if(req.body.schoolyearofpassing!==undefined)
            rec.highschool[2].schoolyearofpassing=req.body.schoolyearofpassing;




    rec.save(function(err) {
      if (err)
        res.json(err);

      res.json({
        sucess:"true"
      });
    });
  });

});



router1.route('/userupdate/:id').delete(function(req, res) {
  // Use the Beer model to find a specific beer
  rec.findById(req.params.id, function(err, rec) {
    if (err)
      res.json(err);
  
    rec.remove(function(err) {
      if (err)
        res.json(err);

      res.json({
        sucess:"true"
      });
    });
  });

});

module.exports = router1;



// var saveUser = function(req, res, next) {

          
//           rec.findOne({name:req.body.name},function(err,user){
//             console.log(user)
//             if(user){
//               return res.json('user already exists')
//             }
//             else{
//                var user = new rec();
//                user.name = req.body.name;
//               user.save(function(err,rec) {
//             if (err)  res.json(err);
//              res.json({
//               success: 'true'
              
//             });

//           });

//             }
//           });
//         }
      
        // router.post('/save', saveUser);
        // module.exports = router;