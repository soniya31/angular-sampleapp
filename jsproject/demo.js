

function talk(sound){
    
    this._sound=sound
        console.log("I am doggie ,will do "+ this._sound );
    
}

talk.prototype.dance =function(){
    console.log("I am dancing girl in the dancing world")
}


var doggie=new talk("ek kya bolti tu");
console.log(doggie.dance())


// learn scoping + scoping scoping

var a="Soniya"


function getNames(a)
{
    console.log("non strict mode"+ !this)

}

function getNames(a)
{
    console.log(!this)

}






function demo()
{
   
    a=10
    console.log("ineer"+ a)

}
console.log("outer"+ a)


