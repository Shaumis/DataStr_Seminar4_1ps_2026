package service;

import datastr.MyGraph;
import model.City;

public class MainService {

	public static void main(String[] args) {
		MyGraph<City> map = new MyGraph<City>();
		try {
			City c1 = new City("Ventspils", 55.4f, "LV-3601");
			City c2 = new City("Tukums", 13.35f, "LV-4001");
			City c3 = new City("Limbaži", 50.2f, "LV-4031");
			City c4 = new City("Tukums", 13.35f, "LV-4020");
			
			map.addVertice(c1);
			map.addVertice(c2);
			map.addVertice(c3);
			map.addVertice(c4);
			
			map.addEdge(c1,c2,190);
			map.addEdge(c1,c3,200);
			map.addEdge(c1,c4,30);

			map.print();
		
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
