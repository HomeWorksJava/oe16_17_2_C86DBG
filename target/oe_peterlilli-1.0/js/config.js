angular.module('project', ['ngRoute', 'ui.materialize']).config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

        $routeProvider
                .when('/', {
                    templateUrl: 'template/welcome.html',
                })
                .when('/fooldal', {
                    templateUrl: 'template/welcome.html',
                })
                
                
                
                .when('/filmek', {
                    controller: 'FilmController',
                    templateUrl: 'template/filmek.html',
                })
                .when('/film/uj', {
                    controller: 'FilmController',
                    templateUrl: 'template/film.html',
                })
                .when('/film/modosit/:id', {
                    controller: 'FilmController',
                    templateUrl: 'template/film.html',
                })
                
                
                
                .when('/szereplok', {
                    controller: 'SzereploController',
                    templateUrl: 'template/szereplok.html',
                })
                .when('/szereplo/uj', {
                    controller: 'SzereploController',
                    templateUrl: 'template/szereplo.html',
                })
                .when('/szereplo/modosit/:id', {
                    controller: 'SzereploController',
                    templateUrl: 'template/szereplo.html',
                })
                
                
                
                .when('/castingok', {
                    controller: 'CastingController',
                    templateUrl: 'template/castingok.html',
                })
                .when('/casting/uj', {
                    controller: 'CastingController',
                    templateUrl: 'template/casting.html',
                })
                .when('/casting/modosit/:id', {
                    controller: 'CastingController',
                    templateUrl: 'template/casting.html',
                })
                
                
                
                .when('/mufajok', {
                    controller: 'MufajController',
                    templateUrl: 'template/mufajok.html',
                })
                .when('/mufaj/uj', {
                    controller: 'MufajController',
                    templateUrl: 'template/mufaj.html',
                })
                .when('/mufaj/modosit/:id', {
                    controller: 'MufajController',
                    templateUrl: 'template/mufaj.html',
                })
                
                
                
                .otherwise({
                    redirectTo: '/fooldal'
                });

        $locationProvider.html5Mode(true);

    }]);        