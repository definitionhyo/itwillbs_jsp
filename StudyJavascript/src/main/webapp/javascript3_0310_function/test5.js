/**
 * 외부로부터 아이디(id), 패스워드(pass) 전달받아 판별 후 결과를 리턴하는 login() 함수 정의
 * => 파라미터(매개변수) : 2개(아이디, 패스워드)
 * => 아이디와 패스워드가 일치하면 true 값을 리턴하고, 아니면 false 값을 리턴
 */
function login(id, pass) {
//	if(id == "admin" && pass == "1234") { // 로그인 성공
//		return true;
//	} else { // 로그인 실패
//		return false;
//	}
//	
//	// if 문과 else 문 조합으로 return 문을 모든 경우의 수에 사용한 경우
//	// 무조건 하나의 return 문이 실행되므로 함수를 호출한 곳으로 되돌아간다!
//	// 따라서, return 문 다음에 있는 문장들은 절대 실행될 수 없다!
//	alert("코드 실행되나?"); // Unreachable code detected(도달 불가능한 코드 감지됨)
	
	// if~else 문에서 직접 return 문을 기술하지 않고 리턴할 데이터만 생성한 후
	// if문 종료한 다음 return 문에 생성된 데이터를 리턴할 수도 있다!
	let isLoginSuccess = false;
	
	if(id == "admin" && pass == "1234") { // 로그인 성공
		isLoginSuccess = true;
	} else { // 로그인 실패
		isLoginSuccess = false;
	}
	
	// 리턴문이 현재 실행문보다 아래쪽에 있으므로 if 문 종료후에도 alert() 함수 코드 실행됨!
//	alert("코드 실행되나?");
	
	return isLoginSuccess; // true 또는 false 값이 저장된 변수를 리턴
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 