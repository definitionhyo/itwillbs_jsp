/**
 * 
 */

// 구구단 2단을 출력하는 gugudan() 함수 정의
function gugudan() {
	let dan = 2;
	document.write(" < " + dan + "단 ><br>");
	
	for(let i = 1; i <= 9; i++) {
		document.write(dan + " * " + i + " = " + (dan * i) + "<br>");
	}
}
// => 이 함수를 호출하려면 현재 파일(test1.js)을 자신의 파일 내에 포함시켜서 호출해야함