app.controller('visitController', ["$scope", "$log", "appService",
    function($scope, $log, appService) {
        $scope.starshipId = "";
        $scope.planetId = "";
        $scope.arrivalStarDate = "";
        $scope.departureStarDate = "";

        $scope.visits = appService.getVisits();

        $scope.loadVisits = function () {
            var promiseGet = appService.getVisits();
            promiseGet.then(function (result) {
                if (result && result.data) {
                    $scope.visits = result.data;
                }
            }, function (reason) {
                $log.error("Failure loading database information", reason);
            });
        };

        $scope.loadVisits();

}]);