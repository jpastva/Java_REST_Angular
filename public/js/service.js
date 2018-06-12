app.service('appService', ["$http", function ($http) {

    this.getPlanets = function () {
        return $http.get("planets");
    };

    this.getVisits = function () {
        return $http.get("visits");
    };

}]);