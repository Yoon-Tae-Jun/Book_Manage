package library_books;
import java.text.SimpleDateFormat;
import java.util.Date;

// 도서(책) 정보 : InfoBook
public class InfoBook {
	
	// 도서관 필드
	private String id;			// 책 고유 번호
	private Date addedDate;		// 책이 도서관에 추가된 날짜
	
	// 책 정보 필드
	private String name;		// 책 이름
	private String author;		// 저자 
	private String genre;		// 장르 
	private String year;		// 출판년도 
	// private ? image;			// 이미지 -- 태준이가 처리하기
	
	
	
	// 생성자, 초기화 =============================================================================================
	public InfoBook(String id, Date addedDate, String name, String author, String genre, String year) {
		// 기존 도서 만들때(불러올때) 사용
		this.id = id;
		this.addedDate = addedDate;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.year = year;
	}
	public InfoBook() {
		// 비어있는 도서 만들때 사용
		this.id = "unknown";
		this.addedDate = new Date();	// 현재시간 저장
		this.name = "unknown";
		this.author = "unknown";
		this.genre = "unknown";
		this.year = "unknown";
	}
	public InfoBook(InfoBook ib) {
		// 기존 객체로 책 정보 초기화
		this.id = ib.id;
		this.addedDate = ib.addedDate;
		this.name = ib.name;
		this.author = ib.author;
		this.genre = ib.genre;
		this.year = ib.year;
	}
	
	// 도서 정보 반환 =============================================================================================
	public String 	getId() 		{return id;}
	public String 	getAddedDate() 	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(addedDate);
	}
	public String 	getName() 		{return name;}
	public String 	getAuthor() 	{return author;}
	public String 	getGenre() 		{return genre;}
	public String 		getYear() 		{return year;}
	
	// 도서 정보 수정 =============================================================================================
	public void updateId(String id)					{this.id = id;}
	public void updateName(String name)				{this.name = name;}
	public void updateAuthor(String author)			{this.author = author;}
	public void updateGenre(String genre)			{this.genre = genre;}
	public void udpateYear(String year)				{this.year = year;}
}
