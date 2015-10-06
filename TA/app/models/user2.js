var mongoose = require('mongoose');
var Schema = mongoose.Schema;


module.exports = mongoose.model('rec', new Schema({
    name: String,
    designation: String,
    email: String,
    phone: String,
    pastemployment: [{
    	                company:String,
    	                timeperiod:String,
    	                designation:String,
    	                loc:String
    }],
    skills:[{
        
    }],
    postgraduation: [{
                        postcollegename: String,
                        postdegree: String,
                       postyearofpassing: String
    }],
    graduation: [{
                       gradcollegename: String,
                       graddegree: String,
                       gradyearofpassing: String
    }],
    highschool: [{
                      schoolname: String,
                      board: String,
                      schoolyearofpassingschool: String
    }]

}//,
  //{ collection: 'recs' }
  )
);