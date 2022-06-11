package library_books;
import java.text.SimpleDateFormat;
import java.util.Date;

// 도서(책) 정보 : InfoBook
public class InfoBook {
	
	// 도서관 필드
	private String id;			// 책 고유 번호
	
	// 책 정보 필드
	private String name;		// 책 이름
	private String author;		// 저자 
	private String genre;		// 장르 
	private String year;		// 출판년도 
	private String image;			// 이미지 -- 태준이가 처리하기
	
	
	
	// 생성자, 초기화 =============================================================================================
	public InfoBook(String id, String name, String author, String genre, String year, String image) {
		// 기존 도서 만들때(불러올때) 사용
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.image =image;
	}
	public InfoBook() {
		// 비어있는 도서 만들때 사용
		this.id = "unknown";
		this.name = "unknown";
		this.author = "unknown";
		this.genre = "unknown";
		this.year = "unknown";
		this.image = null;
	}
	
	//getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	


}
