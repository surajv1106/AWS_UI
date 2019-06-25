'use strict'

angular.module('demo.services', []).factory('UserService',
		[ "$http", "CONSTANTS",  function($http, CONSTANTS) {
			var service = {};

			service.getAllUsers = function() {
				return $http.get(CONSTANTS.getAllUsers);
			}
			service.saveUser = function(employeeDto) {
				return $http.post(CONSTANTS.saveUser, employeeDto);
			}

            service.removeEmployee =function(id) {
                console.log('Removing User with id '+id);

                $http.delete(CONSTANTS.deleteEmployee + id)

                //return deferred.promise;
            }

            service.getEmployee =function(id) {
                console.log('Get employee with id '+id);

                return $http.get(CONSTANTS.getEmployee + id)

                //return deferred.promise;
            }

            service.updateEmployee=function(EmployeeDTO,id) {
                console.log('Updating Employee with id '+id);
				$http.put(CONSTANTS.editEmployee + id, EmployeeDTO)

            }








			return service;
		} ]);