package API;

public class APIMethod {
	
	public static String[][] getBooksData(String[] header){
		
		// 0,1,2,3,4 변환
		
		// 여기에 너가 api를 사용하여 데이터를 가공 !
		
		String[][] contents = {
				{"자료구조", "12340000", "Y", "Y", "N", "N"},
				{"이산수학", "12340001", "N" , "Y", "Y", "N"},
				{"자바", "12129999", "N", "N", "N", "Y"}
		};
		
		return contents;
	}
}
