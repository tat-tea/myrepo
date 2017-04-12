var app = angular.module('app',['ngResourse'])

app.controller('MainCtrl', function($scope, $resource, $window){
	var Student = $resourse('student.php', {id: '$id'}


}