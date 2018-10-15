var sample =function(){
    privar_var=20;
    public_var=30;
    private_Fun=function(){
        console.log("hey in private");
        console.log(privar_var);
    }
    public_Fun=function(){
        console.log("Hey in public function");
        private_Fun();
    }

    return{

        var: public_var,
        fun:public_Fun
    }
}();

console.log(sample.fun());

// https://scotch.io/bar-talk/4-javascript-design-patterns-you-should-know



var person =function() {
    this.name='soniya';
    this.age=23

}
person.prototype = {
    job:true,
    myself:function(){
        console.log(this.name + 'is my name!!!!');
    }
}
var pr =new person();
pr.myself();
console.log(pr.job)  