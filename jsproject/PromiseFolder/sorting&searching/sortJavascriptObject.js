var homes = [
    {
        "h_id": "3",
        "city": "Dallas",
        "state": "TX",
        "zip": "75201",
        "price": "999162500"
    }, {
        "h_id": "4",
        "city": "Bevery Hills",
        "state": "CA",
        "zip": "90210",
        "price": "319250"
    }, {
        "h_id": "5",
        "city": "New York",
        "state": "NY",
        "zip": "00010",
        "price": "962500"
    }
];

// console.log(homes.sort((a,b)=> {
// return a.city.localeCompare(b.city);

// })
// );

// console.log(homes.sort((a,b) => {
//     return a.price-b.price;

// }));
// Sort by price high to low
homes.sort(sort_by('price', true, parseInt));