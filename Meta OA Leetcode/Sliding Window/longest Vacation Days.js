/* longest Vacation Days Leetcode 1004的变形

longest Vacation Days，给一个由'H','W'组成的数组，H代表holiday，W代表workday，给n个PTO days，请问最长连续的假期是多少天？

*/

let str = "HHHWWHHWHHHH"
let pto = 1;

const fn = (str, pto) => {
	let res = 0;
	let l = 0;
	let n = str.length;
	let countW = 0;

	for(let r = 1; r < str.length; r++){
		if(str[r] == 'W'){
			countW++;
		}

		while(countW > pto){
			if(str[l] == 'W'){
				countW--;
			}
			l++;
		}

		res = Math.max(res, r - l + 1);
	}

	return res;
}

console.log(fn(str, pto));
