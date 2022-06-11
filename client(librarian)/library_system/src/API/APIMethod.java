package API;

import java.awt.Color;
import java.util.HashMap;

import org.json.simple.JSONObject;

import library_books.Book;
import library_system.LibraryDesk;
import library_users.Users;

public class APIMethod {
	

	public static Book[] getBooksData(String s, int sel){
		
        // 입력 : s = 검색 키워드,  sel = 라디오 버튼
        // 입력에 부합하는 조건을을 API로 검색하고, 해당 값들을 Book[]으로 만들어 리턴
        // 만약 검색결과가 없을시 비어있는 null 반환
		Call_API api = new API.Call_API();
		JSONObject obj;
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("value", s);
		try {
			obj = api.POST("/book/search/"+sel, option);

		
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			System.out.println(statusCode);
			if(statusCode == 200) {
				JSONObject data = (JSONObject) obj.get("data");
				user.setPw((String)data.get("password"));
				user.setId((String)data.get("userEmail"));
				user.setName((String)data.get("UserName"));
				user.setUserType((String)data.get("userType"));
				mine.setVisible(false);
				LibraryDesk ld = new LibraryDesk(user, mine.getLibraryName());
				ld.run();
			}
			else {
				System.out.println("login fail");
				mine.getError_Text().setText("아이디나 비밀번호가 틀렸습니다.");
				mine.getError_Text().setForeground(Color.RED);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;

	}
	

    public static Users[] getUsersData(String s, int sel) {
        // 입력 : s = 검색 키워드,  sel = 라디오 버튼
        // 입력에 부합하는 조건을을 API로 검색하고, 해당 값들을 Users[]으로 만들어 리턴
        // 만약 검색결과가 없을시 비어있는 null 반환

        return null;
    }
}
