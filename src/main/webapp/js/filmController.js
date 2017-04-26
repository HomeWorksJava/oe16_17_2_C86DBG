angular.module('project').controller('FilmController', function ($scope, $location, $routeParams, $http) {

    $scope.listData = [];
    $scope.formData = {};
    $scope.page = "";

    $scope.loadData = function () {

        $http({
            method: 'GET',
            url: 'rest/read/filmek'
        }).then(function successCallback(response) {
            console.log(response);
            $scope.listData = response.data;
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.loadMufajData = function () {

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

    $scope.loadOneData = function () {

        var id = $routeParams.id;

        $http({
            method: 'GET',
            url: 'rest/read/film/' + id
        }).then(function successCallback(response) {
            console.log(response);
            $scope.formData = response.data;
            $scope.formData.mufajId = $scope.formData.mufajId.toString();
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.checkLocation = function () {

        if ($location.path() === '/filmek') {
            $scope.loadData();
        } else if ($location.path() === '/film/uj') {
            $scope.loadMufajData();
            $scope.page = "Új film";
        } else if ($location.path().indexOf('/film/modosit/') > -1) {
            $scope.loadMufajData();
            $scope.loadOneData();
            $scope.page = "Film módosítása";
        }

    };

    $scope.submitForm = function () {

        var url, message;

        if ($location.path().indexOf('/film/modosit/') > -1) {
            url = 'rest/update/film';
            message = 'Sikeres módosítás';
        } else if ($location.path() === '/film/uj') {
            url = 'rest/create/film';
            message = 'Sikeres hozzáadás';
        }

        $http({
            method: 'POST',
            url: url,
            data: $scope.formData
        }).then(function successCallback(response) {
            console.log(response);
            if (response.data.id > 0) {
                $location.path('/filmek');
                Materialize.toast(message + ': ' + response.data.cim + '!', 4000);
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
                url: 'rest/read/film/' + id
            }).then(function successCallback(response) {
                console.log(response);
                $scope.formData = response.data;

                $http({
                    method: 'POST',
                    url: 'rest/delete/film',
                    data: $scope.formData
                }).then(function successCallback(response) {
                    console.log(response);
                    if (response.data.id > 0) {
                        Materialize.toast('Sikeres törlés: ' + response.data.cim + '!', 4000);
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