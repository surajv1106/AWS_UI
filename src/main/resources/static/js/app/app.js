'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {


	saveUser : "/addEmployee",
    editEmployee: "/employee/",
    getEmployeeList: "/findall",
    deleteEmployee: "/employee/",
    getEmployee: "/employee/"
});