



var person = (name) => (gender) =>{
    return "my name is " + name + " & i am a " + gender
}


//currying example

var prefilledPersonNameDynamicProperties = person("Soniya")

console.log("After currying")
console.log(prefilledPersonNameDynamicProperties("female"))



// Practial use-case
// babyAnimals is a curried function; it is designed for the first argument to be ‘prefilled’
//  before the function itself is fully executed. With this pattern, 
// ‘koala’ can be bound to babyAnimals, and my love for animals other than
//  elephants can easily be expressed.

console.log("practical use-case")

var babyAnimal = function (lovy) {
    return function (b) {
        return "i love " + lovy + " & " + b
    }
}

var prefilledFnWithKoala = babyAnimal("koala")

console.log(prefilledFnWithKoala("Elephant"))
console.log(prefilledFnWithKoala("Tiger"))
