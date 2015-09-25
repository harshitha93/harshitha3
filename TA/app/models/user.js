
var mongoose = require('mongoose');
var Schema = mongoose.Schema;


module.exports = mongoose.model('db2', new Schema({
    designation: String,
    location: String,
    experience: String,
    description: String,
    salary: String
}));



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
    }]

}//,
  //{ collection: 'recs' }
  )
);