package API;

public class APIMethod {
	
	public static String[][] getBooksData(String s, String sel){
		
		// 입력 : s = 검색 키워드,  sel = 라디오 버튼 이름
		// 입력에 부합하는 조건을을 API로 검색하고, 해당 값들을 string[][]으로 만들어 리턴
		// 만약 검색결과가 없을시 비어있는 new String[][] 반환
		
		
		
		
		// String[][] 예시
		String[][] contents = {
				{"자료구조", "12340000", "Y", "Y", "N", "N"},
				{"이산수학", "12340001", "N" , "Y", "Y", "N"},
				{"자바", "12129999", "N", "N", "N", "Y"}
		};
		
		return contents;
	}
}
