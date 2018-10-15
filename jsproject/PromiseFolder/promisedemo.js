var promise = new Promise(function (resolve, reject) {
    resolve({name:"soniya"})
})


promise
.then((data) => console.log(data.age)).catch((e) => {
    console.log("Haye error aa gi" + e)
});



