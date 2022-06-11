package library_books;

public class Book {
	
	private InfoBook ib;			// 책의 기본 정보
	private InfoBookStatement ibs;	// 책의 현황 정보
	
	// 생성자, 초기화 =============================================================================================
	public Book(InfoBook ib, InfoBookStatement ibs) {
		// 기존 책 불러올때 사용
		this.ib = ib;
		this.ibs = ibs;
	}
	public Book() {
		// 비어있는 도서(새로운 도서) 생성
		this.ib = new InfoBook();
		this.ibs = new InfoBookStatement();
	}
	
	public InfoBook getIb() {
		return ib;
	}
	public void setIb(InfoBook ib) {
		this.ib = ib;
	}
	public InfoBookStatement getIbs() {
		return ibs;
	}
	public void setIbs(InfoBookStatement ibs) {
		this.ibs = ibs;
	}
}