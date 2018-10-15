// function Person(firstName, lastName) {
//     this.firstName = firstName;
//     this.lastName = lastName;

//     this.getFullName = function() {
//         console.log(this.firstName)
//         return function() {
//             return this.firstName + " " + this.lastName }.bind(this)
//     };
// }

// var jeremy = new Person("Jeremy", "McPeak")
// var fun = jeremy.getFullName()
// console.log(fun())


// function Person(firstName, lastName) {
//     fullname = function () {
//         return function() {
//              console.log(firstName + " " + lastName)
//              firstName + " " + lastName }
//     };
//     return fullname();
// }

// var soniya = Person("Soniya", "Chopra");
// soniya();

function Person1(firstName, lastName) {
    return (function () {
        return function() {
             console.log(firstName + " " + lastName)
             firstName + " " + lastName }
    }())();
}

var soniya1 = Person1("Soniya", "Chopra");
soniya1;
    
function Foo(paramOne) {
    this._thisIsPrivate = paramOne;
}
function Person1(firstName, lastName) {
    return (function () {
        return function() {
             console.log(firstName + " " + lastName)
             firstName + " " + lastName }
    })();
}

var soniya1 = Person1("Soniya", "Chopra");
soniya1();
Foo.prototype.bar = function() {
    return this._thisIsPrivate;
};
 
var foo = new Foo("Hello, Convention to Denote Privacy!");
console.log(foo.bar()); // alerts "Hello, Convention to Denote Privacy!"


