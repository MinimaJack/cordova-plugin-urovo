var exec = require("cordova/exec");

module.exports = {

    startScan: function (successCallback, errorCallback) {
        exec(successCallback, errorCallback, "Urovo", "startScan", []);
    },

    stopScan: function (successCallback, errorCallback) {
        exec(successCallback, errorCallback, "Urovo", "stopScan", []);
    }

};
