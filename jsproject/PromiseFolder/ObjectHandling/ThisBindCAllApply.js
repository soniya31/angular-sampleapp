function Person(firstName,lastName){
this.firstName=firstName;
this.lastName=lastName;
this.age=function(age)
{
console.log(`My age is ${age}`);
}
}

Person.prototype.designation="Software Engineer";
Person.prototype.summary=function(){
    return function(){
    console.log(`My Name is ${this.firstName} ${this.lastName}.I am a ${this.designation}`);
    }.bind(this);
}

var sonu=new Person("Soniya","Chopra");
sonu.age(28);
var mystory=sonu.summary();
mystory();



var obj={
firstName:"soniya",
talk:function(){
console.log("Me Talking Talking"+this.firstName);
}
}
obj.talk();
console.log(obj.firstName);


var obj1=
{
    firstName:"Teens",
    talk:obj.talk
}

obj1.talk()
obj.talk()

 var talk=function()
{
    console.log(this.firstName)
}
obj1.speak=talk;
obj1.speak();
