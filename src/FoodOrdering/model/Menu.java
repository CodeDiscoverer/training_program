package FoodOrdering.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	public static List<Dish> menuList = new ArrayList<>();
	
	public static class Dish{
		
		private String dishId;
		private String dishName;
		private double dishPrice;
		
		public Dish(String dishId, String dishName, double dishPrice){
			this.dishId = dishId;		
			this.dishName = dishName;
			this.dishPrice = dishPrice;
		}
		
		public String getDishId() {
			return dishId;
		}
		public String getDishName() {
			return dishName;
		}
		public double getDishPrice() {
			return dishPrice;
		}
		public String toString() {
			return "Food Id: " + dishId +
					" | Food Name: " + dishName +
					" | Price: " + dishPrice;
		}
	}
}
