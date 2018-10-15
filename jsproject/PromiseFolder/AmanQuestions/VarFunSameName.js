var a = 1; 
function b() { 
    //a = 10; 
    console.log(a)
    return ;
    function a() {} 
} 
b(); 
console.log(a);     //will display 1


var a ; 
function b() { 
     a=10 ; 
    return function a() {} 
   // console.log("after returm")
} 
b(); 
console.log(a);     //will display 10


var a=10; // placed

function a(x) {
  return x * 2;
};
console.log(a);
var a = 4; // removed
a = 4 // added

console.log(a); // a is now 4



var a; // placed

function a(x) {
  return x * 2;
};

var a ; // removed

console.log(a); // a is now function body