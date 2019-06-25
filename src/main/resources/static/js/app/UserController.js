'use strict'

var module = angular.module('demo.controllers', []);
module.controller("UserController", [ "$scope", "UserService",
		function($scope, UserService) {

			$scope.employeeDto = {
                id : null,
                firstName : null,
                lastName : null,
                organisation : null,
                email : null

			};

			


			$scope.saveUser = function() {

				UserService.saveUser($scope.employeeDto).then(function() {
					console.log("works");
					UserService.getAllUsers().then(function(value) {
						$scope.allUsers= value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});


					$scope.employeeDto = {
                        id : null,
                        firstName : null,
                        lastName : null,
                        organisation : null,
                        email : null
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}


            $scope.removeEmployee =function (id){
                console.log('About to remove User with id '+id);
                UserService.removeEmployee(id)
                $scope.allUsers=''

                $scope.employeeDto = {
                    id : null,
                    firstName : null,
                    lastName : null,
                    organisation : null,
                    email : null
                };

                UserService.getAllUsers().then(function(value) {
                    console.log('inside getAllusermethod')
                    $scope.allUsers= value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });


            }


            $scope.editEmployee =function (id) {
			    console.log("in editemployee start")
                UserService.getEmployee(id).then(function (value) {
                    console.log(value.data)
                    $scope.employeeDto=value.data

                })

            }


            $scope.getAllEmployee =function (id) {
                console.log("in getAllEmployee start")
                UserService.getAllUsers().then(function(value) {
                    $scope.allUsers= value.data;
                })

            }




        } ]);