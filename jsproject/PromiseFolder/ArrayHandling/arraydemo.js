var fruits = ["Banana", "Orange", "Apple", "Mango"];
console.log(fruits.join("&"))
console.log(fruits.toString()) //join is the new tostring with joining capabilities
console.log(fruits.pop().toString())
console.log(fruits.push("WaterMelon"))//push the element at the end + return the new array length
console.log(fruits.shift())
console.log(fruits.toString())
console.log(fruits.unshift("Kiwi"))//add it at the beginning  unshift add at the beginning of the list
console.log(fruits.toString())


fruits[fruits.length] = "pears";
console.log(fruits.toString())


fruits.splice(2, 0, "anar")
console.log(fruits.toString())

var arr1 = ["Cecilie", "Lone"];
var arr2 = ["Emil", "Tobias", "Linus"];
var arr3 = ["Robin", "Morgan"];
var myChildren = arr1.concat(arr2, arr3);
console.log(myChildren.toString())
//splice can remove and add array like modify existing array
//The slice() method creates a new array. It does not remove any elements from the source array.

//In JavaScript, arrays use numbered indexes.  
//Difference between object and array objet
//In JavaScript, objects use named indexes.


//how to identify an array
console.log(Array.isArray(fruits));

//null + array + every thing is object in javascript ,except undefined ,be careful while checking their types

//Array.isArray() is not supported
console.log(fruits.constructor.toString().indexOf("Array"))

function isArray(x) {
    return x.constructor.toString().indexOf("Array") > -1;
}
fruits instanceof Array  //returns true


//sorting 

console.log(fruits.sort())
console.log(fruits.reverse())

var num = [45, 54, 100]
console.log(num.sort()) //100 45 54 as 1 comes before  4 & 5  the sort() function sorts values as strings.


//You can fix this by providing a compare function:

num.sort(function (a, b) { return a - b });
console.log(num)


function myArrayMin(arr) {
    return Math.min.apply(null, arr);
}

function myArrayMax(arr) {
    var len = arr.length
    var max = -Infinity;  //min =Infinity
    while (len--) {
        if (arr[len] > max) {
            max = arr[len];
        }
    }
    return max;
}

//Sorting Objects
var cars = [
    { type: "Volvo", year: 2016 },
    { type: "Saab", year: 2001 },
    { type: "BMW", year: 2010 }];

cars.sort(function (a, b) {
    return a.year - b.year


})

cars.forEach((x) => console.log(x.year))


cars.sort(function (a, b) {

    var x = a.type.toLowerCase()
    var y = b.type.toLowerCase()
    if (x > y) { return 1 }
    if (x < y) { return -1 }
    return 0

})
cars.forEach((x) => console.log(x.type))

console.log(cars.constructor)
console.log(cars instanceof String)
console.log(typeof cars)




