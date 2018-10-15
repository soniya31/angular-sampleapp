function createPerson(f,s) {

    var firstName = f;   //prototype this will work only if this.firstname is ther not var 
    var lastName = s;

    var personObj = {

        getFirstName: function () {
            return firstName;
        },
        getLastName: function () {
            return lastName
        }
    }
   // return personObj;

}
createPerson.prototype.talk = function () {
    console.log("I am " + this.firstName + "I can talk endlessly");
}


var person = new createPerson("Soniya","Chopra")
person.talk()
//console.log(person.getFirstName())

////////////////////////////////////////////////////////////////////

function constructor1(name) {
    this.name = name

}
constructor1.prototype.talk = function () {
    console.log("My name is " + this.name)
}

var myname = new constructor1("Soniya")
myname.talk();