function removeDuplicateChar(str){
    var len = str.length,
        char, 
        charCount = {}, 
        newStr = [];
    for(var i =0; i<len; i++){
      char = str[i];
      if(charCount[char]){
        //newStr.push(char);
        charCount[char]++;
      }
      else
        charCount[char] = 1;
    }
    console.log(JSON.stringify(charCount));
     for (var j in charCount){
          newStr.push(j);
     }
    return newStr.join('');
  }

  console.log(removeDuplicateChar("SSSONIYYYYYA"));
  