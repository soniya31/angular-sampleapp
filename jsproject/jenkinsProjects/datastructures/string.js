function findLongestWordLength(str) {

    const arr=str.split(" ");
    arr.sort((a,b) => b.length-a.length)
     return arr[0];
  }
  
  findLongestWordLength("The quick brown fox jumped over the lazy dog");

  function largestOfFour(arr) {
    let newArr=[];
    arr.forEach(element => {
       element.sort((a,b)=>b-a)
       newArr.push(element[0])
    });
    console.log(newArr)
   return newArr
}

largestOfFour([[4, 5, 1, 3], [13, 27, 18, 26], [32, 35, 37, 39], [1000, 1001, 857, 1]]);


function confirmEnding(str, target) {
    let len =target.length;
    console.log(len)
    let suspect=str.substring(str.length-len)
    console.log(suspect)
 return suspect === target
}

confirmEnding("Bastian", "n");