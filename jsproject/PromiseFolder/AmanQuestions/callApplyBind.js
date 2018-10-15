//Use .bind() when you want that function to later be called with a certain context, useful in events.
// Use .call() or .apply() when you want to invoke the function immediately, and modify the context.
//Call/apply call the function immediately, whereas bind returns a function that, when later executed, will have the correct context set for calling the 
//original function. This way you can maintain context in async callbacks and events.

//The function .call() and .apply() are very similar in their usage except a little difference. .call() is used when the number of the function’s arguments are known to the programmer, as they have to be mentioned as arguments in the call statement. On the other hand
//, .apply() is used when the number is not known. The function .apply() expects the argument to be an array.


var person={
     firstName:"Soniya",
     lastName:"Chopra",
    fullname:function(prefix,postfix){
      console.log(prefix + this.firstName+"-"+this.lastName+ postfix)
    }
}

var prem={
    firstName:"Sh.Prem",
    lastName:"Chopra"
}


var ft=person.fullname.bind(prem,"m","m");
ft("u","u");

person.fullname.call({firstName:'teena',lastName:'bhalla'},"x","x")
person.fullname();
var fns=person.fullname.bind(prem,"z","z")
fns();

person.fullname.apply(prem,["<",">"])




// var someObject = {
 
//     myProperty : 'Foo',
     
//     myMethod : function(prefix, postfix) {
     
//     alert(prefix + this.myProperty + postfix);
     
//     }
     
//     };
     
//     someObject.myMethod('<', '>'); // alerts '<Foo>'
     
//     var someOtherObject  = {
     
//     myProperty : 'Bar'
     
//     };
     
//     someObject.myMethod.call(someOtherObject, '<', '>'); // alerts '<Bar>'
     
//     someObject.myMethod.apply(someOtherObject, ['<', '>']); // alerts '<Bar>'