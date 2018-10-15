//Closure is a locally declared variable related to a function which stays in memory when the function has returned

var a = 10
function outerFn(inc) {
    a=a + inc
    var b = 20 + inc
    var innerFn = function () {// here the function object will hold a referenceto a and b ,
        // no matter where it will execute it will always remember these values
        console.log(a)
        console.log(b)

    }
    console.log("Inside call")
  
    return innerFn
    

}
var innerVar1 = outerFn(30)
console.log("call with 30")
innerVar1()

var innerVar2 = outerFn(20)
console.log("call with 20")
innerVar2()

//closure always remenber the scope information 
//they have the snapshot of scope chain no matter when you invoke them
//when ever function is invoke it create separte copy of variable








