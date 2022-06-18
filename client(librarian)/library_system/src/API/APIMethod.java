package API;

import java.awt.Color;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import library_books.Book;
import library_books.InfoBook;
import library_books.InfoBookStatement;
import library_system.layout.GuiLibraryDesk;
import library_users.Users;

public class APIMethod {
	

	public static Book[] getBooksData(String s, int sel){
		
        // 입력 : s = 검색 키워드,  sel = 라디오 버튼
        // 입력에 부합하는 조건을을 API로 검색하고, 해당 값들을 Book[]으로 만들어 리턴
        // 만약 검색결과가 없을시 비어있는 null 반환
		Book[] books = null;
		String column = Integer.toString(sel);
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("value", s);
		try {
			obj = api.POST("/book/search/"+column, option);
			
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			
			if(statusCode == 200) {
				
				JSONArray jsonAry = (JSONArray)obj.get("data");
				books = new Book[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					books[i] = new Book(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					InfoBook infobook = new InfoBook();
					InfoBookStatement statement = new InfoBookStatement();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					//statement 받아오기
					statement.setBorrowed((Boolean)data.get("borrowed"));
					
					String date = (String)data.get("borrowedDate");
					if( date != null) statement.setBorrowedDate(format.parse(date));
					else statement.setBorrowedDate(null);
					statement.setBorrowedUser((String)data.get("borrowedUser"));
					String buf = String.valueOf(data.get("cntExtension"));
					statement.setExternDateCount(Integer.parseInt(buf));
					statement.setReserved((Boolean)data.get("reserved"));
					statement.setReservedUser((String)data.get("reservedUser"));
					date = (String)data.get("returnDate");
					if( date != null) statement.setReturnDate(format.parse(date));
					else statement.setReturnDate(null);
					
					//infoBook 받아오기
					infobook.setAuthor((String)data.get("bookAuthor"));
					infobook.setGenre(String.valueOf(data.get("bookGenre")));
					infobook.setId((String)data.get("bookId"));
					infobook.setImage((String)data.get("imageURL"));
					infobook.setName((String)data.get("bookName"));
					infobook.setYear((String)data.get("publicationYear"));
					
					books[i].setIb(infobook);
					books[i].setIbs(statement);
					
				}
				
			}
			else {
				System.out.println("fail found book");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return books;

	}
	
	public static Book getBookData(int bookID){
		Book book = new Book();
		String id = Integer.toString(bookID);
		Call_API api = new API.Call_API();
		JSONObject obj;
		try {
			obj = api.GET("/book/"+id);
			
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			if(statusCode == 200) {
				
				JSONObject data = (JSONObject) obj.get("data");
				InfoBook infobook = new InfoBook();
				InfoBookStatement statement = new InfoBookStatement();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				//statement 받아오기
				statement.setBorrowed((Boolean)data.get("borrowed"));
				String date = (String)data.get("borrowedDate");
				if( date != null) statement.setBorrowedDate(format.parse(date));
				else statement.setBorrowedDate(null);
				statement.setBorrowedUser((String)data.get("borrowedUser"));
				String buf = String.valueOf(data.get("cntExtension"));
				statement.setExternDateCount(Integer.parseInt(buf));
				statement.setReserved((Boolean)data.get("reserved"));
				statement.setReservedUser((String)data.get("reservedUser"));
				date = (String)data.get("returnDate");
				if( date != null) statement.setReturnDate(format.parse(date));
				else statement.setReturnDate(null);
				
				//infoBook 받아오기
				infobook.setAuthor((String)data.get("bookAuthor"));
				infobook.setGenre(String.valueOf("bookGenre"));
				infobook.setId((String)data.get("bookId"));
				infobook.setImage((String)data.get("imageURL"));
				infobook.setName((String)data.get("bookName"));
				infobook.setYear((String)data.get("publicationYear"));
				
				book.setIb(infobook);
				book.setIbs(statement);	
			}
			else {
				System.out.println("login fail");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return book;
	}
	
	public static Book[] getBorrowedBook(int UserID){
		Book[] books = null;
		String id = Integer.toString(UserID);
		Call_API api = new API.Call_API();
		JSONObject obj;
		try {
			obj = api.GET("/user/borrowedBook/"+id);
			
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			if(statusCode == 200) {
				
				JSONArray jsonAry = (JSONArray)obj.get("data");
				books = new Book[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					books[i] = new Book(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					InfoBook infobook = new InfoBook();
					InfoBookStatement statement = new InfoBookStatement();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					//statement 받아오기
					statement.setBorrowed((Boolean)data.get("borrowed"));
					
					String date = (String)data.get("borrowedDate");
					if( date != null) statement.setBorrowedDate(format.parse(date));
					else statement.setBorrowedDate(null);
					statement.setBorrowedUser((String)data.get("borrowedUser"));
					String buf = String.valueOf(data.get("cntExtension"));
					statement.setExternDateCount(Integer.parseInt(buf));
					statement.setReserved((Boolean)data.get("reserved"));
					statement.setReservedUser((String)data.get("reservedUser"));
					date = (String)data.get("returnDate");
					if( date != null) statement.setReturnDate(format.parse(date));
					else statement.setReturnDate(null);
					//infoBook 받아오기
					infobook.setAuthor((String)data.get("bookAuthor"));
					infobook.setGenre(String.valueOf("bookGenre"));
					infobook.setId((String)data.get("bookId"));
					infobook.setImage((String)data.get("imageURL"));
					infobook.setName((String)data.get("bookName"));
					infobook.setYear((String)data.get("publicationYear"));
					
					books[i].setIb(infobook);
					books[i].setIbs(statement);
					
				}
				
			}
			else {
				System.out.println("예약된 책이 없음");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return books;
	}
	
	public static Book[] getReservedBook(int UserID) {
		Book[] books = null;
		String id = Integer.toString(UserID);
		Call_API api = new API.Call_API();
		JSONObject obj;
		try {
			obj = api.GET("/user/reservedBook/"+id);
			
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			if(statusCode == 200) {
				
				JSONArray jsonAry = (JSONArray)obj.get("data");
				books = new Book[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					books[i] = new Book(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					InfoBook infobook = new InfoBook();
					InfoBookStatement statement = new InfoBookStatement();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					//statement 받아오기
					statement.setBorrowed((Boolean)data.get("borrowed"));
					String date = (String)data.get("borrowedDate");
					if( date != null) statement.setBorrowedDate(format.parse(date));
					else statement.setBorrowedDate(null);
					statement.setBorrowedUser((String)data.get("borrowedUser"));
					String buf = String.valueOf(data.get("cntExtension"));
					statement.setExternDateCount(Integer.parseInt(buf));
					statement.setReserved((Boolean)data.get("reserved"));
					statement.setReservedUser((String)data.get("reservedUser"));
					date = (String)data.get("returnDate");
					if( date != null) statement.setReturnDate(format.parse(date));
					else statement.setReturnDate(null);
					
					//infoBook 받아오기
					infobook.setAuthor((String)data.get("bookAuthor"));
					infobook.setGenre(String.valueOf("bookGenre"));
					infobook.setId((String)data.get("bookId"));
					infobook.setImage((String)data.get("imageURL"));
					infobook.setName((String)data.get("bookName"));
					infobook.setYear((String)data.get("publicationYear"));
					
					books[i].setIb(infobook);
					books[i].setIbs(statement);
					
				}
				
			}
			else {
				System.out.println("fail load reserve data");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return books;
	}
	
	public static int postBorrowedBook(int BookID, int UserID) {
		String bookid = Integer.toString(BookID);
		String userid = Integer.toString(UserID);
		Users user = getUserDataID(userid);
		int statusCode = 500;
		int cnt =user.getMAX_borrowedCount();
		if(cnt != 0) {
			Call_API api = new API.Call_API();
			JSONObject obj;
			HashMap<String, String> option = new HashMap<String, String>();
			option.put("userID", userid);
			try {
				obj = api.POST("/book/borrowed/"+bookid, option);
				
				statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
				if(statusCode == 200) {
					user.setMAX_borrowedCount(--cnt);
				}
			}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return statusCode;
	}
	
	public static int postReservedBook(int BookID, int UserID) {
		String bookid = Integer.toString(BookID);
		String userid = Integer.toString(UserID);
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("userID", userid);
		try {
			obj = api.POST("/book/reserved/"+bookid, option);
			
			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}
	
	public static int postcancelReservedBook(int BookID, int UserID) {
		String bookid = Integer.toString(BookID);
		String userid = Integer.toString(UserID);
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("userID", userid);
		try {
			obj = api.POST("/book/reserved/cancel/"+bookid, option);
			
			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}
	
	public static int postExtensioncount(int BookID, int cnt) {
		String bookid = Integer.toString(BookID);
		String extension = Integer.toString(cnt);
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("cnt", extension);
		try {
			obj = api.POST("/book/extension/"+bookid, option);
			
			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}
	
	public static int postReturnBook(int BookID, int UserID, int overdueDay) {
		String bookid = Integer.toString(BookID);
		String userid = Integer.toString(UserID);
		String day = Integer.toString(overdueDay);
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("userID", userid);
		option.put("day", day);
		try {
			System.out.println(option.get("day"));
			obj = api.POST("/book/return/"+bookid, option);
			
			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}
	
	public static int deleteBook(int BookID) {
		String bookid = Integer.toString(BookID);
		int statusCode = 404;
		Call_API api = new API.Call_API();
		int statuscode = 0;
		try {
			statusCode = api.DELETE("/book/"+bookid);
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return statusCode;
	}
	
	public static int postUpdateBook(int BookID, String name, String author, String genre, String year) {
		String bookid = Integer.toString(BookID);
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("name", name);
		option.put("author", author);
		option.put("genre", genre);
		option.put("year", year);
		try {
			obj = api.POST("/book/update/"+bookid, option);
			
			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}
	
	public static int putBook(String name, String author, String genre, String year, String url) {
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("author", author);
		option.put("genre", genre);
		option.put("year", year);
		option.put("url", url);
		try {
			name = URLEncoder.encode(name, "UTF-8");
			obj = api.POST("/book/put/"+name, option);

			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}
	
	//user
    public static Users[] getUsersData(String s, int sel) {
    	Users[] users = null;
		String column = Integer.toString(sel);
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("value", s);
		try {
			obj = api.POST("/user/search/"+column, option);
			
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			if(statusCode == 200) {
				JSONArray jsonAry = (JSONArray)obj.get("data");
				users = new Users[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					users[i] = new Users(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					System.out.println((String)data.get("userID"));
					users[i].setId((String)data.get("userID"));
					users[i].setPw((String)data.get("password"));
					users[i].setEmail((String)data.get("userEmail"));
					users[i].setName((String)data.get("userName"));
					users[i].setUserType((String)data.get("userType"));
					String buf = String.valueOf(data.get("maxBorrowedCount"));
					users[i].setMAX_borrowedCount(Integer.parseInt(buf));
					buf = String.valueOf(data.get("maxReservedCount"));
					users[i].setMAX_reservedCount(Integer.parseInt(buf));
					Book[] books =getBorrowedBook(Integer.parseInt(users[i].getId()));
					ArrayList<Book> arrayList = new ArrayList<>(Arrays.asList(books));
					users[i].setBorrowedBook(arrayList);
					books = getReservedBook(Integer.parseInt(users[i].getId()));
					arrayList = new ArrayList<>(Arrays.asList(books));
					users[i].setReservedBook(arrayList);
				}

			}
			else {
				System.out.println("fail load user list");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return users;

    }
    
    public static Users getUserData(String id, String pw) {
    	Users user = new Users();
    	Call_API api = new API.Call_API();
		JSONObject obj;
		
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("userEmail", id);
		option.put("password", pw);
		try {
			obj = api.POST("/login", option);
		
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			if(statusCode == 200) {
				JSONObject data = (JSONObject) obj.get("data");
				user.setId((String)data.get("userID"));
				user.setPw((String)data.get("password"));
				user.setEmail((String)data.get("userEmail"));
				user.setName((String)data.get("userName"));
				user.setUserType((String)data.get("userType"));
				String buf = String.valueOf(data.get("maxBorrowedCount"));
				user.setMAX_borrowedCount(Integer.parseInt(buf));
				buf = String.valueOf(data.get("maxReservedCount"));
				user.setMAX_reservedCount(Integer.parseInt(buf));
				Book[] br_books =getBorrowedBook(Integer.parseInt(user.getId()));
				
				if(br_books != null) {
					user.setBorrowedBook(new ArrayList<>(Arrays.asList(br_books)));
					user.setMAX_borrowedCount(3 -user.getBorrowedBook().size());
				}
				
				System.out.println(user.getId());
				Book[] rr_books = getReservedBook(Integer.parseInt(user.getId()));
				if(rr_books != null) {
					user.setReservedBook(new ArrayList<>(Arrays.asList(rr_books)));
					user.setMAX_reservedCount(3 -user.getReservedBook().size());
				}
				
			}
			else {
				System.out.println("fail load user");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
		
		
    }
    
    public static Users getUserDataID(String id) {
    	Users user = new Users();
    	Call_API api = new API.Call_API();
		JSONObject obj;
		
		try {
			obj = api.GET("/user/"+id);
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			if(statusCode == 200) {
				JSONObject data = (JSONObject) obj.get("data");
				user.setId((String)data.get("userID"));
				user.setPw((String)data.get("password"));
				user.setEmail((String)data.get("userEmail"));
				user.setName((String)data.get("userName"));
				user.setUserType((String)data.get("userType"));
				String buf = String.valueOf(data.get("maxBorrowedCount"));
				user.setMAX_borrowedCount(Integer.parseInt(buf));
				buf = String.valueOf(data.get("maxReservedCount"));
				user.setMAX_reservedCount(Integer.parseInt(buf));
				Book[] books =getBorrowedBook(Integer.parseInt(user.getId()));
				ArrayList<Book> arrayList = null;
				if (books == null) {
					arrayList = new ArrayList<>();
				}
				else {
					arrayList = new ArrayList<>(Arrays.asList(books));					
				}
				user.setBorrowedBook(arrayList);
				books = getReservedBook(Integer.parseInt(user.getId()));
				arrayList = new ArrayList<>(Arrays.asList(books));
				user.setReservedBook(arrayList);
			}
			else {
				System.out.println("login fail");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
    }

    public static int deleteUser(int UserID) {
    	String userid = Integer.toString(UserID);
		int statusCode = 404;
		Call_API api = new API.Call_API();
		int statuscode = 0;
		try {
			statusCode = api.DELETE("/user/"+userid);
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return statusCode;
    }

    public static int postUpdateUser(int UserID, String email, String password, String name) {
		String userid = Integer.toString(UserID);
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("email", email);
		option.put("password", password);
		option.put("name", name);
		try {
			obj = api.POST("/user/update/"+userid, option);
			
			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}

    public static int putUser(String name, String email, String password, String type) {
		int statusCode = 500;
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("email", email);
		option.put("password", password);
		option.put("type", type);
		try {
			name = URLEncoder.encode(name, "UTF-8");
			obj = api.POST("/user/put/"+name, option);

			statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return statusCode;
	}
}
