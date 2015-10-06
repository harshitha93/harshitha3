
var mongoose = require('mongoose');
var Schema = mongoose.Schema;


module.exports = mongoose.model('db2', new Schema({
    designation: String,
    location: String,
    experience: String,
    description: String,
    salary: String
}));


