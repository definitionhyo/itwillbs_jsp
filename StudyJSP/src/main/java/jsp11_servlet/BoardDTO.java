package jsp11_servlet;

/*
 CREATE TABLE jsp10_board (
 	board_name VARCHAR(20) NOT NULL,
 	board_pass VARCHAR(20) NOT NULL,
 	board_subject VARCHAR(50) NOT NULL,
 	board_content VARCHAR(2000) NOT NULL
 );
 */
public class BoardDTO {
	private String board_name;
	private String board_pass;
	private String board_subject;
	private String board_content;
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_pass() {
		return board_pass;
	}
	public void setBoard_pass(String board_pass) {
		this.board_pass = board_pass;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [board_name=" + board_name + ", board_pass=" + board_pass + ", board_subject=" + board_subject
				+ ", board_content=" + board_content + "]";
	}
	
}













