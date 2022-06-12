package API;

import java.awt.Color;
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
			System.out.println(statusCode);
			if(statusCode == 200) {
				
				JSONArray jsonAry = (JSONArray)obj.get("data");
				books = new Book[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					books[i] = new Book(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					InfoBook infobook = new InfoBook();
					InfoBookStatement statement = new InfoBookStatement();
					
					//statement 받아오기
					statement.setBorrowed((Boolean)data.get("borrowed"));
					statement.setBorrowedDate((Date)data.get("borrowedDate"));
					statement.setBorrowedUser((String)data.get("borrowedUser"));
					String buf = String.valueOf(data.get("cntExtension"));
					statement.setExternDateCount(Integer.parseInt(buf));
					statement.setReserved((Boolean)data.get("reserved"));
					statement.setReservedUser((String)data.get("reservedUser"));
					statement.setReturnDate((Date)data.get("returnDate"));
					
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
				System.out.println("login fail");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return books;

	}
	
	public static Book getBookData(int bookID){
		Book book = null;
		String id = Integer.toString(bookID);
		Call_API api = new API.Call_API();
		JSONObject obj;
		try {
			obj = api.GET("/book/"+id);
			
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			System.out.println(statusCode);
			if(statusCode == 200) {
				
				JSONObject data = (JSONObject) obj.get("data");
				InfoBook infobook = new InfoBook();
				InfoBookStatement statement = new InfoBookStatement();
				//statement 받아오기
				statement.setBorrowed((Boolean)data.get("borrowed"));
				statement.setBorrowedDate((Date)data.get("borrowedDate"));
				statement.setBorrowedUser((String)data.get("borrowedUser"));
				String buf = String.valueOf(data.get("cntExtension"));
				statement.setExternDateCount(Integer.parseInt(buf));
				statement.setReserved((Boolean)data.get("reserved"));
				statement.setReservedUser((String)data.get("reservedUser"));
				statement.setReturnDate((Date)data.get("returnDate"));
				
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
			System.out.println(statusCode);
			if(statusCode == 200) {
				
				JSONArray jsonAry = (JSONArray)obj.get("data");
				books = new Book[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					books[i] = new Book(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					InfoBook infobook = new InfoBook();
					InfoBookStatement statement = new InfoBookStatement();
					
					//statement 받아오기
					statement.setBorrowed((Boolean)data.get("borrowed"));
					statement.setBorrowedDate((Date)data.get("borrowedDate"));
					statement.setBorrowedUser((String)data.get("borrowedUser"));
					String buf = String.valueOf(data.get("cntExtension"));
					statement.setExternDateCount(Integer.parseInt(buf));
					statement.setReserved((Boolean)data.get("reserved"));
					statement.setReservedUser((String)data.get("reservedUser"));
					statement.setReturnDate((Date)data.get("returnDate"));
					
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
				System.out.println("login fail");
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
			System.out.println(statusCode);
			if(statusCode == 200) {
				
				JSONArray jsonAry = (JSONArray)obj.get("data");
				books = new Book[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					books[i] = new Book(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					InfoBook infobook = new InfoBook();
					InfoBookStatement statement = new InfoBookStatement();
					
					//statement 받아오기
					statement.setBorrowed((Boolean)data.get("borrowed"));
					statement.setBorrowedDate((Date)data.get("borrowedDate"));
					statement.setBorrowedUser((String)data.get("borrowedUser"));
					String buf = String.valueOf(data.get("cntExtension"));
					statement.setExternDateCount(Integer.parseInt(buf));
					statement.setReserved((Boolean)data.get("reserved"));
					statement.setReservedUser((String)data.get("reservedUser"));
					statement.setReturnDate((Date)data.get("returnDate"));
					
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
				System.out.println("login fail");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return books;
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
			System.out.println(statusCode);
			if(statusCode == 200) {
				JSONArray jsonAry = (JSONArray)obj.get("data");
				users = new Users[jsonAry.size()];
				for(int i=0; i<jsonAry.size(); i++) {
					users[i] = new Users(); //북 객체 생성
					JSONObject data = (JSONObject)jsonAry.get(i);
					Users user = new Users();
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
					ArrayList<Book> arrayList = new ArrayList<>(Arrays.asList(books));
					user.setBorrowedBook(arrayList);
					books = getReservedBook(Integer.parseInt(user.getId()));
					arrayList = new ArrayList<>(Arrays.asList(books));
					user.setReservedBook(arrayList);
				}
				
			}
			else {
				System.out.println("login fail");
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
			System.out.println(statusCode);
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
				ArrayList<Book> arrayList = new ArrayList<>(Arrays.asList(books));
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
    
    public static Users getUserDataID(String id) {
    	Users user = new Users();
    	Call_API api = new API.Call_API();
		JSONObject obj;
		
		try {
			obj = api.GET("/user/"+id);
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			System.out.println(statusCode);
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
				ArrayList<Book> arrayList = new ArrayList<>(Arrays.asList(books));
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
}
