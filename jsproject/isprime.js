

// (function(){
//     var textfield=document.createElement("textarea");
//     var button =document.createElement("button");
//     button.appendChild(document.createTextNode("Click me"))
//     document.body.appendChild(textfield)
//     document.body.appendChild(button)
// })();

var isPrime= (num)=>
{
if(typeof num !='number')
{ 
  return false  
}
if(num<2)
{
    return false
}
if(num==2)
{
    return true

}
for(var i=3;i<num;i++)
{
    if(num%i==0)
    {
        return false
    }
    else{
        return true
    }
}
}

console.log(isPrime(5))