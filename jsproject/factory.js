// class LivingBeing
// {

//     constructor(sound)
//     {
//         this.sound=sound
//     }
//     talk(){
//         console.log("I am making "+this.sound)
//     }
// }

// var cat=new LivingBeing("meow")
// cat.talk()

//above code will work well here but get into an issue when set on click event like on click call talk fns that timeit will confuse abt this. as will refer to  dom elements

//below code will curb up this issue

const factory = (sound) => {
    const voice = sound
    return {
        talk:function () {
            console.log("hey i am " + voice)
        }
    }
}

const cat = factory("meow");
cat.talk()

const dog = factory("woof");
dog.talk()