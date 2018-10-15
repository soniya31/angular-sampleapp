



var person = (name,gender) =>{
    return "my name is " + name + " & i am a " + gender
}

person=_.curry(person)
console.log(person("dd")("jhd"))
