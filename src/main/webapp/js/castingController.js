angular.module('project').controller('CastingController', function ($scope, $location, $routeParams, $http) {

    $scope.listData = [];
    $scope.formData = {};
    $scope.page = "";

    $scope.loadData = function () {

        $http({
            method: 'GET',
            url: 'rest/read/castingok'
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

    $scope.loadOneData = function () {

        var id = $routeParams.id;

        $http({
            method: 'GET',
            url: 'rest/read/casting/' + id
        }).then(function successCallback(response) {
            console.log(response);
            $scope.formData = response.data;
            $scope.formData.filmId = $scope.formData.filmId.toString();
        }, function errorCallback(response) {
            console.log(response);
        });

    };

    $scope.checkLocation = function () {

        if ($location.path() === '/castingok') {
            $scope.loadData();
        } else if ($location.path() === '/casting/uj') {
            $scope.loadFilmData();
            $scope.page = "Új casting";
        } else if ($location.path().indexOf('/casting/modosit/') > -1) {
            $scope.loadFilmData();
            $scope.loadOneData();
            $scope.page = "Casting módosítása";
        }

    };

    $scope.submitForm = function () {

        var url, message;

        if ($location.path().indexOf('/casting/modosit/') > -1) {
            url = 'rest/update/casting';
            message = 'Sikeres módosítás';
        } else if ($location.path() === '/casting/uj') {
            url = 'rest/create/casting';
            message = 'Sikeres hozzáadás';
        }

        $http({
            method: 'POST',
            url: url,
            data: $scope.formData
        }).then(function successCallback(response) {
            console.log(response);
            if (response.data.id > 0) {
                $location.path('/castingok');
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
                url: 'rest/read/casting/' + id
            }).then(function successCallback(response) {
                console.log(response);
                $scope.formData = response.data;

                $http({
                    method: 'POST',
                    url: 'rest/delete/casting',
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

    $scope.currentTime = new Date();
    $scope.idopont_start = $scope.currentTime;
    $scope.idopont_veg = $scope.currentTime;
    $scope.month = ['Január', 'Február', 'Március', 'Április', 'Május', 'Június', 'Július', 'Augusztus', 'Szeptember', 'Október', 'November', 'December'];
    $scope.monthShort = ['Jan', 'Feb', 'Már', 'Ápr', 'Máj', 'Jún', 'Júl', 'Aug', 'Szep', 'Okt', 'Nov', 'Dec'];
    $scope.weekdaysFull = ['Vasárnap', 'Hétfő', 'Kedd', 'Szerda', 'Csütörtök', 'Péntek', 'Szombat'];
    $scope.weekdaysLetter = ['Vas', 'Hé', 'Ke', 'Sze', 'Csü', 'Pé', 'Szo'];
    $scope.today = 'Ma';
    $scope.clear = 'Törlés';
    $scope.close = 'Mégse';
    $scope.minDate = (new Date($scope.currentTime.getTime())).toISOString();
    $scope.maxDate = (new Date($scope.currentTime.getTime() + (1000 * 60 * 60 * 24 * 365))).toISOString();

});