var obj = {a: 1 ,b: 2}
var objclone = Object.assign({},obj);
console.log('objclone: ', objclone);

let obj1 = {
    a: 1,
    b: 2,
    c: {
        age: 30
    }
};

var objclone = Object.assign({},obj1);
console.log('objclone: ', objclone);


obj1.c.age = 45;
obj1.a=12;
console.log('After Change - obj: ', obj1);           // 45 - This also changes
console.log('After Change - objclone: ', objclone); // 45

//Note the potential pitfall, though: Object.clone() will just do a shallow copy,
// not a deep copy. This means that nested objects aren’t copied. They still refer to the same nested objects as the original:

function deepClone(object){
	var newObject = {};
	for(var key in object){
        console.log(key)
		if(typeof object[key] === 'object'){
		 newObject[key] = deepClone(object[key]);
		}else{
		 newObject[key] = object[key];
		}
	}
    return newObject}
    
    var deep=deepClone(obj1)
    console.log(deep)


      // Deep Clone
  obj1 = { a: 0 , b: { c: 0}};
  let obj3 = JSON.parse(JSON.stringify(obj1));
  obj1.a = 4;
  obj1.b.c = 4;
  console.log(JSON.stringify(obj3)); // { a: 0, b: { c: 0}}