var datahandler=function(j,sound) {

return ()=>console.log(j+sound)

}


function caller() {
   var sound="meow"
    for (var i = 0; i < 10; i++) {

        setTimeout(datahandler(i,sound),5000);
        console.log("in caller fns" + i)
    }
}
caller();