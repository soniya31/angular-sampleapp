function LS(arr,item){

    for(let i in arr){
        if(arr[i] === item){
        return i;
        }

    }
    return -1;
}

let arr =[45,67,89,23,67,09];
let result = LS(arr,90);
if(result >-1){
    console.log('Item found at the '+ result + ' position');
}
else{
    console.log('Item is not in the List');
}