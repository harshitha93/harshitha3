
$(document).ready(function(){
 $("#menuicon").click(function(){
 $(".dropmenu").slideToggle(300,function(){
  
    $(".dropmenu").addClass("active");
 });
});


$(".sidelist li a").click(function(event) {
 $(".dropmenu").slideUp(300);
});
});





var mainApp = angular.module("myapp", ['ngRoute']);
         mainApp.config(['$routeProvider', function($routeProvider) {
            $routeProvider.
            
            when('/profile', {
               templateUrl: '/partials/profile.html',
               controller: 'profilecontroller'
            }).
            
            when('/history', {
               templateUrl: '/partials/history.html',
               controller: 'historycontroller'
            }).

              when('/alljobs', {
               templateUrl: '/partials/alljobs.html',
               controller: 'alljobscontroller'   
            }).
               when('/alljobs/:jobtitle', {
               templateUrl: '/partials/jobdes.html',
               controller: 'jobdescontroller'   
            }).



               when('/recruiter', {
               templateUrl: '/partials/recruiter.html',
               controller: 'recruitercontroller'   
            }).
                when('/manager', {
               templateUrl: '/partials/manager.html',
               controller: 'managercontroller'   
            }).



            
            otherwise({
               redirectTo: '/profile'
            });
         }]);
   
  mainApp.controller('alljobscontroller',['$scope','$http', function($scope, $http) {
   

      $http.get("http://172.31.98.119:8080/api/dbs/")
    .success(function(response) {
   
    $scope.jobsdata = response;
   }) 
}]);

  function fun(rec)
  {
   var desid=rec.text; 
   
    localStorage.setItem("desigid", desid);

  }
mainApp.controller('jobdescontroller',['$scope','$http', function($scope, $http) {
   $(".divall").css({"display":"none"});
   var desid1= localStorage.getItem("desigid");
  /* alert(desid1);*/
   desid1 = desid1.trim();
    
    $http.post("http://172.31.98.119:8080/api/dbs/" + desid1)
    .success(function(response) {
    $scope.k = response[0];
    var k1 = $scope.k.description;
    $scope.k2= k1.split("^");
    
   
    /*var k2=k1.split("^")[0];
    /*console.log(k2);*/
    $(".divall").css({"display":"block"});
   });
  }]);


      
         
        



