// Binary Search works on sorted array.
let arr = [76, 876, 34, 56, 98, 09, 23, 56]
let newarr = arr.sort((a, b) => a - b);


function BS(arr, beg, end, item) {

    if (beg > end) {
        return -1;
    }
    let mid = Math.floor((beg + end) / 2);



    if (item === arr[mid]) {
        console.log("Item found at " + mid);
        return -1;
    }
    if (item < arr[mid]) {

        BS(arr, 0, mid - 1, item)
    }
    if (item > arr[mid]) {

        BS(arr, mid + 1, end, item)
    }

}

BS(newarr, 0, arr.length - 1, 56);