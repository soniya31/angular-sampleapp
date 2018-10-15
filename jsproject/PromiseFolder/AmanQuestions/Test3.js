// var myObject = {
//     foo: "bar",
//     func: function() {
//         var self = this;
//         console.log("outer func:  this.foo = " + this.foo);
//         console.log("outer func:  self.foo = " + self.foo);
//         (function() {
//             console.log("inner func:  this.foo = " + this.foo);
//             console.log("inner func:  self.foo = " + self.foo);
//         }());
//     }
// };
// myObject.func();

var myObject = {
    foo: "bar",
    func: function () {
        var self = this;
        console.log("outer func:  this.foo = " + this);
        console.log("outer func:  self.foo = " + self.foo);
        //A function declared with the fat arrow is the most appropriate declaration type 
        //in a case when the context needs to be inherited from the outer method 

        ( function(){
            console.log("outer func:  this.foo = " + this.foo);
            console.log("outer func:  self.foo = " + self.foo);
        })()

        // return function(){
        //     console.log("outer func:  this.foo = " + this);
        //     console.log("outer func:  self.foo = " + self.foo);
        // }.bind(this)

        // return ()=>{
        //     console.log("outer func:  this.foo = " + this);
        //     console.log("outer func:  self.foo = " + self.foo);
        // }
      
     //(()=>{
        //     console.log("outer func:  this.foo = " + this);
        //     console.log("outer func:  self.foo = " + self.foo);
        // })();

    }
};
myObject.func();
//var a=myObject.func();
// console.log(a)
// a()
