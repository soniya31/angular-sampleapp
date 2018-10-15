var name="Please Locate where 'Locate' occurs!";
console.log(typeof name)
console.log(name.length)
console.log(name.indexOf("locate"))
console.log(name.lastIndexOf("'locate'"))
console.log(name.search("locate"))

console.log("Afrer slicing "+name.slice(7,14))
var str="Hello";
var arr=str.split("!")
arr.forEach((x,index)=>console.log(index + x))

console.log(name.replace(/locate/g, "here"))

var str1 = "ghkTestlllltest09-sdds" 

console.log(str1.replace(/test/g,"")) //replace globally 

console.log(str1.replace(/test09|Test/g,""))//replace globally nad check for case too

var e='This iS IIS'.replace(/is/ig, 'as')
console.log(e)


console.log("soniya".includes("on"))
//console.log("soniya".match([a-z]))

//slice is a new substring which can accepts negative value

//substr it will take first argument + no of character to be fetch()

var str2 = "Apple, Banana, Kiwi"
console.log(str2.substring(7, 13))
console.log(str2.slice(7, 13))
console.log(str2.substr(7, 6))


