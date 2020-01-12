var a = "hello, ";
var b = "logesh";
a.concat(b);		//hello, logesh

//------------------------------------------

[18, 21, 25, 30, 60].every(age => age >= 18); 	// true
[18, 21, 12, 30, 60].every(age => age >= 18); 	// false

//------------------------------------------

[18, 21, 12, 5, 60].filter(age => age >= 18);	// [18, 21, 60]

//------------------------------------------

[18, 21, 12, 5, 60].forEach((value, index) => console.log(index + ' -> ' + value));

/* Output:

0 -> 18
1 -> 21
2 -> 12
3 -> 5
4 -> 60

------------------------------------------*/

['a', 'b', 'c', 'd', 'b'].indexOf('b');		// 1
['a', 'b', 'c', 'd', 'b'].indexOf('b', 2);	// 4
['a', 'b', 'c', 'd', 'b'].indexOf('e');		// -1

//------------------------------------------

['a', 'b', 'c', 'd', 'b'].lastIndexOf('b');		// 4
['a', 'b', 'c', 'd', 'b'].lastIndexOf('b', 3);	// 1
['a', 'b', 'c', 'd', 'b'].lastIndexOf('e');		// -1

//------------------------------------------

['a', 'b', 'c', 'd', 'e'].join('-');	// "a-b-c-d-e"

//------------------------------------------

var a = [1,2,3,4,5];
var b = a.map(value => value*value);

console.log(a);	// [1, 2, 3, 4, 5]
console.log(b); // [1, 4, 9, 16, 25]

//------------------------------------------

var a = [1,2,2,3,3,3];

var size = a.push(4,4,4,4);		// 10
console.log(a);		// [1,2,2,3,3,3,4,4,4,4]

//------------------------------------------

var a = [1,2,2,3,3,3];

var value = a.pop();	// 3
console.log(a);			// [1,2,2,3,3]

//------------------------------------------

[1,2,3,4,5].reduce((acc, value) => acc + value);		// 15
[1,2,3,4,5].reduce(((acc, value) => acc + value), 5);   // 20
['1', '2', '3', '4', '5'].reduce((acc, value) => acc + value);			// "12345"

//------------------------------------------

[1,2,3,4,5].reduceRight((acc, value) => acc + value);		// 15
[1,2,3,4,5].reduceRight(((acc, value) => acc + value), 5);   // 20
['1', '2', '3', '4', '5'].reduceRight((acc, value) => acc + value);		// "54321"

//------------------------------------------

[1,2,3,4,5].reverse();	// [5, 4, 3, 2, 1]

//------------------------------------------

var a= [1,2,3,4,5];
var value = a.shift();	// 1

console.log(a);		// [2, 3, 4, 5]

//------------------------------------------

var a= [2,3,4,5];
var size = a.unshift(0, 1);	// 6

console.log(a);		// [0, 1, 2, 3, 4, 5]

//------------------------------------------

var a= [1,2,3,4,5];
a.slice(2);		// [3, 4, 5]
a.slice(1,3);	// [2, 3]

console.log(a);		// [1, 2, 3, 4, 5]

//------------------------------------------

var a = [-1, 0, 1, 3, 4, 6];
a = a.splice(2);		// [1, 3, 4, 6]
a.splice(1, 0, 2);		// [1, 2, 3, 4, 6]
a.splice(4, 1, 5);		// [1, 2, 3, 4, 5]

console.log(a);			// [1, 2, 3, 4, 5]

//------------------------------------------

[1,2,3,4,5].toString();		// "1,2,3,4,5"

//------------------------------------------

[5, 4, 3, 2, 1].sort();		// [1, 2, 3, 4, 5]
[5, 1, 100, 2, 33].sort();	// [1, 100, 2, 33, 5]
[5, 1, 100, 2, 33].sort((a,b) => a - b);	// [1, 2, 5, 33, 100]

//------------------------------------------

[1,2,3].some(value => value % 2 == 0);	// true
[1,5,3].some(value => value % 2 == 0);	// false

//------------------------------------------

function Person(name) {
  this.name = name;
}

Person.prototype.toSource = function(){
	return 'name: ' + (this.name);
};

var p = new Person('logesh');

p.toSource();		// "name: logesh"

//------------------------------------------

Difference between '\n' & '\r' :

'\n' -> move the cursor to the next line.
'\r' -> move the cursor in front of the same line.

Example:
echo -en "Lokesh";		// Lokesh D

echo -en "\rRa"			// Rakesh D

echo -en "\nRahul P"	// Rakesh D
						// Rahul P

//------------------------------------------