"use strict";

(function timer() {
  var _loop = function (i) {
    setTimeout(function clog() {
      console.log(i);
    }, i * 1000);
  };

  for (var i = 0; i <= 5; i++) {
    _loop(i);
    console.log("fdd"+i)
  }
})();