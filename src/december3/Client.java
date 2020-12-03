package december3;

import java.util.HashSet;

public class Client {

	public static void main(String[] args) {
		HashMap<String,Integer> hmap = new HashMap<String, Integer>();
		hmap.put("India", 1000);
		hmap.put("Aus", 100);
		hmap.put("Pak", 10);
		hmap.put("Uk", 8000);
		hmap.display();
		hmap.put("India", 1200);
		hmap.display();
		hmap.remove("Pak");
		hmap.display();
		hmap.put("Armenia", 80);
		hmap.put("Russia", 800);
		hmap.put("Afganistan", 1200);
		hmap.put("Sri Lanka", 199);
		hmap.put("Austria", 200);
		hmap.put("Bangladesh", 90);
		hmap.put("Nepal", 8);
		hmap.display();
	}

}
