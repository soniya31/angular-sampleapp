var printer = function () {
    var printerInstance;

    function create() {
        var me = function () {

        };
        var you = function () { };
        return {
            me: me,
            you: you
        }
    };

    return {
        getInstance: function () {
            if (!printerInstance) {
                printerInstance = create();
            }
            return printerInstance;
        }

    }
}();

console.log(printer.getInstance())
