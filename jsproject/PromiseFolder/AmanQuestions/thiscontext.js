class Names {  
    constructor (names) {
      this.names = names;
    }
    contains(actualNames) {
      return actualNames.every((name) => this.names.indexOf(name) !== -1);
    }
  }
 var countries = new Names(['UK', 'Italy', 'Germany', 'France']);  
 console.log( countries.contains(['UK', 'Germany']) )// => true  
 console.log(countries.contains(['USA', 'Italy'])) // => false  