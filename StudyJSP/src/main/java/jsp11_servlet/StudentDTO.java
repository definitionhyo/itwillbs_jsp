package jsp11_servlet;

// DTO(Data Transfer Object, 데이터 전송 객체) 역할을 수행할 StudentDTO 클래스 정의
// => insertForm.jsp 페이지에서 입력받은 폼 파라미터 데이터를 저장하고
//    StudentDAO 객체에 전달하는 용도로 사용하거나
//    StudentDAO 객체에서 조회된 데이터를 저장하여 외부로 리턴할 때 사용하는 역할
// => 이 객체에 데이터를 담아 JSP(View)페이지와 Servlet 클래스와 DAO 객체 사이에서 
//    데이터를 주고 받는 용도로 사용
public class StudentDTO {
	// 1. 데이터를 저장하는데 사용할 인스턴스 멤버변수 선언
	// => jsp08_student 테이블의 각 컬럼과 1:1로 대응하는 멤버변수 선언
	// => 멤버변수는 외부로부터 직접 접근을 차단하기 위해 접근제한자 private 선언
	private int idx;
	private String name;
	
	// ---------------------------------------------
	// 필요에 따라 생성자도 정의 가능(선택사항)
	// 단, 반드시 기본 생성자는 포함되도록 정의
	public StudentDTO() {}
	
	// 파라미터 생성자 정의
	// => 생성자를 정의할 경우 컴파일러는 기본 생성자를 자동으로 생성하지 않는다!
	// => 따라서, 기본 생성자가 필요할 경우 수동으로 반드시 정의해야한다!
	public StudentDTO(int idx, String name) {
		super();
		this.idx = idx;
		this.name = name;
	}
	// ---------------------------------------------
	
	// 2. 멤버변수에 접근하기 위한 Getter/Setter 메서드 정의
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// toString() 메서드 오버라이딩을 통해 멤버변수 값 전체를 문자열로 리턴
	// => Alt + Shift + S -> S
	@Override
	public String toString() {
		return "StudentDTO [idx=" + idx + ", name=" + name + "]";
	}
	
	
}

























