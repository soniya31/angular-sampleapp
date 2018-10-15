(function () {
    try {
        throw new Error();
    } catch (x) {
        var x = 1
        var y = 2
        console.log("catcher"+x); //1 error wals x
    }
    console.log(x);//undefined
    console.log(y);//2
})();