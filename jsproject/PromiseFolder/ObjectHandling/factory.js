const dog=()=>{
 const sound='woof';
 return {
     talk:function(){
         console.log(sound);
     }
 }

}
const dogObj=dog();
dogObj.talk();

//Array.from(arguments)
//Array.prototype.slice.apply(arguments);

const cat=()=>{
    breed="fluffins"
    return function(){
        console.log(breed);
    }
}

var catty=cat();
catty();