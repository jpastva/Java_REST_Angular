app.service('appService', ["$http", function ($http) {

    this.getPlanets = function () {
        return $http.get("planets");
    };

}]);