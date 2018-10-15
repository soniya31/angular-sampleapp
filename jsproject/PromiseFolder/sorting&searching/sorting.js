function insertionSort(arr) {
    for (let i = 0; i < arr.length; i++) {
        let index = i
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[index]) {
                index = j;
            }
        }
        let temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }
    console.log(arr);
}

function bubbleSort(arr) {
    for (let i = 0; i < arr.length - 1; i++) {

        for (let j = 0; j < arr.length - i; j++) {
            if (arr[j] > arr[j + 1]) {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    console.log(arr);

}
function selectionSort(arr) {
    for (let i = 1; i <= arr.length - 1; i++) {
        for (let j = i - 1; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }

        }
    }
    console.log(arr);
}

function quickSort(inarr, beg, end) {
    if (beg < end) {



        let p = partition(inarr, beg, end);
        quickSort(inarr, beg, p - 1);
        quickSort(inarr, p + 1, end);
       
    }
   
}

function partition(a, beg, end) {
    pivot = a[end];
    j = beg - 1;
    for (var i = beg; i <= end; i++) {
        if (a[i] < pivot) {
            j++;
            let temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

    }
    j++;
    a[end] = a[j];
    a[j] = pivot;
    return j;
}

var arr = [34, 66, 23, 56, 76, 34, 54, 100, 8];
// bubbleSort(arr);
// insertionSort(arr);
// selectionSort(arr);
quickSort(arr, 0, arr.length - 1);
console.log(arr);



