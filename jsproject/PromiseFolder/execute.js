function function1(callback) {
    setTimeout(() => {
        console.log("Done with function 1. looking for function2")
        callback();
    }, 8000)


}

function function2() {

    console.log("Gotcha ,now i'm gonna execute you !!!!hu hah ha aha")


}

function1(function2);
