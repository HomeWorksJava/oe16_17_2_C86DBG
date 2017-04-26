angular.module('project').controller('MufajController', function ($scope, $location, $routeParams, $http) {

    $scope.listData = [];
    $scope.formData = {};
    $scope.page = "";

    $scope.loadData = function () {

        $http({
            method: 'GET',
            url: 'rest/read/mufajok'
        }).then(function successCallback(response) {
            console.log(response);
            $scope.listData = response.data;
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.loadOneData = function (id) {

        $http({
            method: 'GET',
            url: 'rest/read/mufaj/' + id
        }).then(function successCallback(response) {
            console.log(response);
            $scope.formData = response.data;
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.checkLocation = function () {

        if ($location.path() === '/mufajok') {
            $scope.loadData();
        } else if ($location.path() === '/mufaj/uj') {
            $scope.page = "Új műfaj";
        } else if ($location.path().indexOf('/mufaj/modosit/') > -1) {
            $scope.loadOneData($routeParams.id);
            $scope.page = "Műfaj módosítása";
        }

    };

    $scope.submitForm = function () {

        var url, message;

        if ($location.path().indexOf('/mufaj/modosit/') > -1) {
            url = 'rest/update/mufaj';
            message = 'Sikeres módosítás';
        } else if ($location.path() === '/mufaj/uj') {
            url = 'rest/create/mufaj';
            message = 'Sikeres hozzáadás';
        }

        $http({
            method: 'POST',
            url: url,
            data: $scope.formData
        }).then(function successCallback(response) {
            console.log(response);
            if (response.data.id > 0) {
                $location.path('/mufajok');
                Materialize.toast(message + ': ' + response.data.nev + '!', 4000);
            }
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.deleteObject = function (id) {

        var alert = confirm("A kiválasztott objektum törlődni fog!\nBiztonsan folytatja?");

        if (alert) {

            $http({
                method: 'GET',
                url: 'rest/read/mufaj/' + id
            }).then(function successCallback(response) {
                console.log(response);
                $scope.formData = response.data;

                $http({
                    method: 'POST',
                    url: 'rest/delete/mufaj',
                    data: $scope.formData
                }).then(function successCallback(response) {
                    console.log(response);
                    if (response.data.id > 0) {
                        Materialize.toast('Sikeres törlés: ' + response.data.nev + '!', 4000);
                        $scope.loadData();
                    }
                }, function errorCallback(response) {
                    console.log(response);
                });

            }, function errorCallback(response) {
                console.log(response);
            });

        }

    };

    $scope.checkLocation();

});