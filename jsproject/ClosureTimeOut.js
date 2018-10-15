

var fn = function () {
    console.log(i)
}


for (var i = 0; i < 10; i++) {
    ;(function (i) {
        setTimeout(function () {
            console.log(i)
        }, 500)
    })(i);
    console.log("outside Timeout function" + i)
}

console.log("Done ,my job is done and i am leaving")


//////////////////////////////////////////////

var j
for (j = 0; j < 10; j++) {
    (function (j) {

        setTimeout(function () {
            console.log(j)
        }, 5000)
    }
    )(j);


}

//Copy paste on scratch pad to see the execution

for (var i = 0; i < 10; i++)
{
  var btnElement = document.createElement('button')
  btnElement.appendChild(document.createTextNode('Button' + i))
  ;(function (i){
    btnElement.addEventListener('click', function () {
      alert('Value of i' + i)
    })
  }) (i)
  document.body.appendChild(btnElement);
}

