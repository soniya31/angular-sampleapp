var obj={
    id: 094545,
    fullName: "Not Set",
    // setUserName is a method on the clientData object​
    setUserName: function (firstName, lastName)  {
        // this refers to the fullName property in this object​
      this.fullName = firstName + " " + lastName;
      
      console.log(this.fullName)
    },
    getUserName: function ()  {
        // this refers to the fullName property in this object​
     console.log( this.fullName )
    }
}


function getUserInput(firstName, lastName, callback)  {
  
   
    if(typeof callback =='function'){
        console.log(typeof callback)
    callback(firstName, lastName);
    }

}

getUserInput("Soniya","Chopra",obj.setUserName)