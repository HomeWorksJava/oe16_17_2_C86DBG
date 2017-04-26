angular.module('project').controller('SzereploController', function ($scope, $location, $routeParams, $http) {

    $scope.listData = [];
    $scope.formData = {};
    $scope.page = "";

    $scope.loadData = function () {

        $http({
            method: 'GET',
            url: 'rest/read/szereplok'
        }).then(function successCallback(response) {
            console.log(response);
            $scope.listData = response.data;
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.loadFilmData = function () {

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

    $scope.loadOneData = function (id) {

        $http({
            method: 'GET',
            url: 'rest/read/szereplo/' + id
        }).then(function successCallback(response) {
            console.log(response);
            $scope.formData = response.data;
            $scope.formData.filmId = $scope.formData.filmId.toString();
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.checkLocation = function () {

        if ($location.path() === '/szereplok') {
            $scope.loadData();
        } else if ($location.path() === '/szereplo/uj') {
            $scope.loadFilmData();
            $scope.page = "Új szereplő";
        } else if ($location.path().indexOf('/szereplo/modosit/') > -1) {
            $scope.loadFilmData();
            $scope.loadOneData($routeParams.id);
            $scope.page = "Szereplő módosítása";
        }

    };

    $scope.submitForm = function () {

        var url, message;

        if ($location.path().indexOf('/szereplo/modosit/') > -1) {
            url = 'rest/update/szereplo';
            message = 'Sikeres módosítás';
        } else if ($location.path() === '/szereplo/uj') {
            url = 'rest/create/szereplo';
            message = 'Sikeres hozzáadás';
        }

        $http({
            method: 'POST',
            url: url,
            data: $scope.formData
        }).then(function successCallback(response) {
            console.log(response);
            if (response.data.id > 0) {
                $location.path('/szereplok');
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
                url: 'rest/read/szereplo/' + id
            }).then(function successCallback(response) {
                console.log(response);
                $scope.formData = response.data;

                $http({
                    method: 'POST',
                    url: 'rest/delete/szereplo',
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