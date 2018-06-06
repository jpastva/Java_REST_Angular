app.controller('appController', ["$scope", "$log", "appService",
    function($scope, $log, appService) {
        $scope.id = "";
        $scope.name = "";
        $scope.radius = "";
        $scope.atmosphere = "";
        $scope.planets= appService.getPlanets();

        $scope.loadPlanets = function () {
            var promiseGet = appService.getPlanets();
            promiseGet.then(function (result) {
                if (result && result.data) {
                    $scope.planets = result.data;
                }
            }, function (reason) {
                $log.error("failure loading database information", reason);
            });
        };

        $scope.loadPlanets();

}]);