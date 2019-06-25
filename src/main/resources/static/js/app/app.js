'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getUserByIdUrl : "/user/getUser/",
	getAllUsers : "http://localhost:8080/findall",
	saveUser : "http://localhost:8080/addEmployee",
    editEmployee: "http://localhost:8080/employee/",
    getEmployeeList: "http://localhost:8080/findall",
    deleteEmployee: "http://localhost:8080/employee/",
    getEmployee: "http://localhost:8080/employee/"
});