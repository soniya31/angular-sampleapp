
let counter = (i) => {
    if (i < 0) {
        return;
    }
    else {
        console.log(i)
        counter(--i);
    }
}
counter(10)


let categories = [
    { 'id': 'animal', 'parents': null },
    { 'id': 'mammals', 'parents': 'animal' },
    { 'id': 'dogs', 'parents': 'mammals' },
    { 'id': 'cats', 'parents': 'mammals' },
    { 'id': 'bulldogs', 'parents': 'dogs' },
    { 'id': 'pomeranin', 'parents': 'dogs' }

]

var makeTree = function (category, parent) {
    var node = {};
    category.filter(x=>x.parents===parent).forEach(x => {
        console.log(x.id)
        node[x.id]=makeTree(category,x.id)  
    });
return node

}

console.log(JSON.stringify(makeTree(categories, null),null,4))
JSON.stringify