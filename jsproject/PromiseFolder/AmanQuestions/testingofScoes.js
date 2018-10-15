var multiply = (x) => {
    return (y) => {
        return (z) => {
            console.log(x * y * z)
        }
    }
}

multiply(3)(4)(5);

var createperson={
    first:'Soniya',
    last:'chopra',
    getfullname:function(){
      return ()=>{
          console.log(this.first+"_"+this.last)
      }
    }
}

var person= createperson.getfullname();
person();