var createPerson = function () {

    this.fn = "Soniya";
    this.ln = "Chopra";
    this.fullname = function () {
        console.log(arguments)
        console.log(this.fn + " " + this.ln + " " + this.age);
    }
}

createPerson.prototype.age = 23;
createPerson.prototype.designation = "SE";
var person =new createPerson();

console.log("Just Kidding");
var sonu = person.fullname.bind({ fn: "dhjjh", ln: "sdffkjjk", age: 28 });
sonu();




var myobj = {
    foo: "fooooo",
    func:function() {
        return ()=>{
            console.log(this.foo);
        }
    }
    

}



var d=myobj.func();
d();