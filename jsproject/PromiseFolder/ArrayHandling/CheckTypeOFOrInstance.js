console.log(typeof typeof 15)// String
console.log(typeof undefined==typeof NULL) //True
console.log(typeof undefined==typeof null) //false JAva script case sensitive



//a) It will not crash. The JavaScript engine will make array slots 3 through 9 be “empty slots.”

//b) Here, a[6] will output undefined, but the slot still remains empty rather than filled with undefined. This may be an important nuance in some cases. For example, when using map(), empty slots
// will remain empty in map()’s output, but undefined slots will be remapped using the function passed to it:

var a = [1, 2, 3];
a[10] = 99;
console.log(a[10])
console.log(a[6]);   //undefines -->javascript create void /empty slots

var b = [undefined];
b[2] = 1;
console.log(b);             //[ undefined, <1 empty item>, 1 ]
                                                             //[ 7, <1 empty item>, 7 ]
console.log(b.map(e => 7)); //  




console.log(1 < 2 < 3); //true<3 --> 1<3 true
console.log(3 > 2 > 1);//false