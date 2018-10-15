function permutations(str){
var myset = new Set();
if(str === null){
    return;

}
else if(str.length===0){
  myset.add("");
  return myset;
}
else{
var index= str.charAt(0);
var rest =str.substring(1);
var words = permutations(rest);
words.forEach(function(w){
    for(let i=0;i<=w.length;i++){
        myset.add(charInsert(w,index,i));
    }
});

return myset;
}
} 

function charInsert(st, c, j) {
    var begin = st.substring(0, j);
    var end = st.substring(j);
    return begin + c + end;
}
 
var perm =permutations("ABCD");
console.log(perm);