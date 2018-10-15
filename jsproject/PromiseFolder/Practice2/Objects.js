function Hero(name,level){
    this.name=name;
    this.level=level;
}


Hero.prototype.getDetails=function(){

    console.log(`My name is ${this.name} and I am on level ${this.level}`);
}

Warrior.prototype=Object.create(Hero.prototype);
function Warrior(name,level,gender){

    Hero.call(this,name,level);
    this.gender=gender;
    console.log(`${gender}`);

}
Warrior.prototype.imwarrior=function(){
    console.log("I am a warrior");
}

var warrior1=new Warrior("ashoka","Senior","Male");
warrior1.imwarrior();
warrior1.getDetails();
