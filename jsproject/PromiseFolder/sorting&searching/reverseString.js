let str = "my name is soniya chopra";

let charArr = str.split(" ");

for (let i = charArr.length - 1; i >= 0; i--) {
    console.log(charArr[i]);
}
console.log('Another way')
console.log(charArr.reverse().join(" "));

console.log('Another way is: ')
console.log(charArr.reverse().map(data => 
   data.toLocaleUpperCase()
).join(" "));

