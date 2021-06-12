package Project_DSA2;

import java.util.*;

import javax.lang.model.util.ElementScanner6;

class Rest { // restaurant menu class
	String name; // menu name
	String cost; // cost of menu
	Rest left, right; // pointers

	Rest() {

	}

	public Rest(String n, String c) {// parameterized constructor

		name = n;
		cost = c;
	}
}

class Order {
	int start, end;
}

class Bill // class for displaying bill
{
	String name;
	int quantity;

	Bill(String n, int q) {// parameterized constructor
		name = n;
		quantity = q;
	}
}

public class Tree {

	Rest hotel1; // object of Rest class
	int final_grand_total = 0;
	String cat, cat1; // for taking input from user for categories of food items
	static ArrayList<ArrayList<Rest>> new_a = new ArrayList<ArrayList<Rest>>(15);
	static ArrayList<ArrayList<Rest>> new_b = new ArrayList<ArrayList<Rest>>(15);
	public int flag_rest_id_not_correct = 0;

	int flag_wrong_qty = 0;

	Tree() {
		hotel1 = null; // initialize hotel1 to null
	}

	void create1() { // creation of restaurant 1 statically
		System.out.print("***  ");
		hotel1 = new Rest("MENU", "***");
		hotel1.left = new Rest("Starters", "------");
		hotel1.right = new Rest("Rice", "------");
		hotel1.left.left = new Rest("Veg Manchurian", "200");
		hotel1.left.right = new Rest("Paneer Chili", "210");
		hotel1.left.left.left = new Rest("Gobi65", "150");
		hotel1.left.left.right = new Rest("Veg Crispy", "220");
		hotel1.left.right.left = new Rest("Kashmiri Rolls", "250");
		hotel1.right.left = new Rest("Veg Biryani", "250");
		hotel1.right.right = new Rest("Fried Rice", "250");
		hotel1.right.left.left = new Rest("Tamarind Rice", "150");
		hotel1.right.left.right = new Rest("Chicken Biryani", "300");
		hotel1.right.right.left = new Rest("Egg Biryani", "280");

	}

	void create2() { // creation of restaurant 2 statically
		System.out.print("***  ");
		hotel1 = new Rest("MENU", "***");
		hotel1.left = new Rest("Soups", "------");
		hotel1.right = new Rest("Chinese", "------");
		hotel1.left.left = new Rest("Tomato Soup", "80");
		hotel1.left.right = new Rest("Baby Corn Soup", "90");
		hotel1.left.left.left = new Rest("Manchow Soup", "100");
		hotel1.left.left.right = new Rest("Thai Soup", "120");
		hotel1.left.right.left = new Rest("Mushroom Soup", "140");
		hotel1.right.left = new Rest("Hakka Noodles", "240");
		hotel1.right.right = new Rest("Schezwan Noodles", "280");
		hotel1.right.left.left = new Rest("Chinese Bhel", "100");
		hotel1.right.left.right = new Rest("Triple Schezwan Rice", "250");
		hotel1.right.right.left = new Rest("Schezwan momos", "180");
	}

	void create3() { // creation of restaurant 3 statically
		System.out.print("***  ");
		hotel1 = new Rest("MENU", "***");
		hotel1.left = new Rest("Pizza", "------");
		hotel1.right = new Rest("Pasta", "------");
		hotel1.left.left = new Rest("Margerita", "150");
		hotel1.left.right = new Rest("Corn Capsicum", "180");
		hotel1.left.left.left = new Rest("Double Cheese Pizza", "240");
		hotel1.left.left.right = new Rest("Chicken Pizza", "250");
		hotel1.left.right.left = new Rest("Peppy Paneer", "200");
		hotel1.right.left = new Rest("White Pasta", "200");
		hotel1.right.right = new Rest("Red Pasta", "220");
		hotel1.right.left.left = new Rest("Spaghetti", "250");
		hotel1.right.left.right = new Rest("Pink sauce Pasta", "280");
		hotel1.right.right.left = new Rest("Pesto Pasta", "290");
	}

	void create4() { // creation of restaurant 4 statically
		System.out.print("***  ");
		hotel1 = new Rest("MENU", "***");
		hotel1.left = new Rest("Roti", "------");
		hotel1.right = new Rest("Mains", "------");
		hotel1.left.left = new Rest("Butter Roti", "20");
		hotel1.left.right = new Rest("Naan", "30");
		hotel1.left.left.left = new Rest("Tandoori roti", "35");
		hotel1.left.left.right = new Rest("Roomali roti", "50");
		hotel1.left.right.left = new Rest("Lachha Paratha", "55");
		hotel1.right.left = new Rest("Paneer Tikka Masala", "250");
		hotel1.right.right = new Rest("Kaju masala", "230");
		hotel1.right.left.left = new Rest("Mushroom Masala", "280");
		hotel1.right.left.right = new Rest("Lassoni Methi", "190");
		hotel1.right.right.left = new Rest("Thai Curry", "290");
	}

	void display(Rest root) { // display function for displaying menu items
		if (root == null)
			return;
		else {
			if (root.name == "Rice" || root.name == "Starters" || root.name == "Chinese" || root.name == "Soups"
					|| root.name == "Pizza" || root.name == "Pasta" || root.name == "Mains"
					|| root.name == "Roti") {
				System.out.println("\n"); // for printing line after menu and categories
			}
			System.out.println(root.name + "  Rs. " + root.cost);
			display(root.left);
			display(root.right); // preorder traversal
		}

	}

	int search_item(String n) { // this function search food item and return it's cost
		Queue<Rest> queue = new LinkedList<Rest>();
		queue.add(hotel1); // add hotel1 in queue
		if (hotel1 == null) {
			return 0;
		}
		while (!queue.isEmpty()) { // while queue is not empty remove item
			Rest temp = queue.remove();
			if (n.toUpperCase().compareTo(temp.name.toUpperCase())==0) { // if key is matched convert string cost to int cost and return
				int c = Integer.parseInt(temp.cost);
				return c;
			}
			if (temp.left != null) { // if left node is present add that to queue
				queue.add(temp.left);
			}
			if (temp.right != null) { // if right node is present add that to queue
				queue.add(temp.right);
			}
		}
		return 0; // if key is not matched return 0

	}

	void cal_bill() { // function for calculating bill
		Bill b;
		Scanner sc = new Scanner(System.in);
		float grand_total = 0;
		int opt;
		int q; // quantity
		float gst = 0;
		String n; // name
		ArrayList<Bill> a = new ArrayList<>();
		do {
			System.out.println("\nEnter the food item name: ");
			n = sc.nextLine();
			System.out.println("Enter the quantity");
			q = Integer.parseInt(sc.nextLine());
				b = new Bill(n, q); // add name and quantity to constructor
				if (search_item(n) != 0)
					a.add(b); // add into the array list
				if (search_item(n) == 0) // if item is not present
				{
					System.out.println("\n Enter valid food item name \n");
				}
				grand_total = grand_total + (search_item(n) * q);// calculating total amount
			
			System.out.println("Do you want to add more food items into the basket?(0/1)");
			opt = Integer.parseInt(sc.nextLine());
		} while (opt == 1);
		gst = (.20f * grand_total); // calculating gst
		float k = grand_total + gst;

		System.out.println("-------------Your Order Details-------------");
		System.out.println();
		System.out.println("Food Item" + "                  " + "Quantity");
		System.out.println();
		for (int i = 0; i < a.size(); i++) {
			System.out.println(String.format("%-30s", a.get(i).name) + a.get(i).quantity);
		}
		System.out.println();
		System.out.println("--------------BIILING DETAILS--------------");
		System.out.println("Your Total is                   =   " + "Rs. " + grand_total);
		System.out.println("The GST amount is               =   " + "Rs. " + gst);
		System.out.println("                                  ________________");
		System.out.println("YOUR FINAL BILLING AMOUNT IS    =   " + "Rs. " + k);
		System.out.println();
		System.out.println("*********");
		System.out.println("\n!!THANK YOU FOR CHOOSING SPYG FOR YOUR FOOD DELIVERY SERVICE!! \n");
		System.out.println("*********");
		final_grand_total += grand_total + gst;
	}

	void showmenu(int i) {
		Tree t = new Tree();
		Scanner sc = new Scanner(System.in);
		int rest_temp_id = 0;
		int rest_id = 0;
		int ch = 0, flag = 0;
		do {
			if (i == -1) {
				try {
					System.out.println(
							"Enter location code of restaurant to view menu. if you don't enter -1");
					rest_temp_id = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Error!");
					flag = 1;
					sc.next();

				}
				if (flag == 0) {
					int temp_calc = 0;
					if (rest_temp_id >= 1 && rest_temp_id <= 4) {
						temp_calc = rest_temp_id - 1;
					} else
						temp_calc = rest_temp_id;
					if ((rest_temp_id < 0 || !dynamic_list.rest_city.contains(temp_calc))) {
						try {
							System.out.println("Enter Valid restaurant location code");
							rest_temp_id = sc.nextInt();
						} catch (Exception e) {
							System.out.println("Error!");
							flag_rest_id_not_correct = 1;
							break;
							// sc.next();

						}
					}

					if (rest_temp_id >= 5) {
						create_new(rest_temp_id, 1);
						System.out.println("******");
					}
					if (rest_temp_id >= 1 && rest_temp_id <= 4) {
						rest_id = rest_temp_id - 1;
						show(rest_id);
					}
				}
			} else {
				rest_id = i;
				if (rest_id < 4 && rest_id >= 0) {
					switch (rest_id) { // for restaurant id taken from user
						case 0:
							t.create1(); // call create fun of restaurant 1
							t.display(t.hotel1); // display menu of restaurant 1
							System.out.println("*****");

							break;
						case 1:
							t.create2(); // call create fun of restaurant 2
							t.display(t.hotel1); // display menu of restaurant 2
							System.out.println("*****");

							break;
						case 2:
							t.create3(); // call create fun of restaurant 3
							t.display(t.hotel1); // display menu of restaurant 3
							System.out.println("*****");

							break;
						case 3:
							t.create4(); // call create fun of restaurant 4
							t.display(t.hotel1); // display menu of restaurant 4
							System.out.println("*****");
							break;
					}

				} else {
					create_new(rest_id, 1);
				}
			}

			try {
				System.out.println("Do you want to continue to view menu? Press 1 else 0 ");
				ch = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Enter 1 or 0");
				sc.next();
				ch=sc.nextInt();
			}
			flag = 0;
		} while (ch == 1); // while you want to continue viewing restaurant
	}

	void show(int rest_id) {
		Tree t = new Tree();
		switch (rest_id) { // for restaurant id taken from user
			case 0:
				t.create1(); // call create fun of restaurant 1
				t.display(t.hotel1); // display menu of restaurant 1
				System.out.println("*****");

				break;
			case 1:
				t.create2(); // call create fun of restaurant 2
				t.display(t.hotel1); // display menu of restaurant 2
				System.out.println("*****");

				break;
			case 2:
				t.create3(); // call create fun of restaurant 3
				t.display(t.hotel1); // display menu of restaurant 3
				System.out.println("*****");

				break;
			case 3:
				t.create4(); // call create fun of restaurant 4
				t.display(t.hotel1); // display menu of restaurant 4
				System.out.println("*****");
				break;
		}
	}

	int search_item_new(String Name, int idx) {
		for (int i = 0; i < new_a.get(idx).size(); i++) {
			if (Name.toUpperCase().equals(new_a.get(idx).get(i).name.toUpperCase())) {
				int c = Integer.parseInt(new_a.get(idx).get(i).cost);
				return c;
			} // category
		}
		for (int i = 0; i < new_b.get(idx).size(); i++) {
			if (Name.equals(new_b.get(idx).get(i).name)) {
				int c = Integer.parseInt(new_b.get(idx).get(i).cost);
				return c;
			} // category
		}

		return 0;
	}

	public void bill_it(int rest_id_final) {
		if (rest_id_final >= 0 && rest_id_final <= 3) {
			switch (rest_id_final) {
				case 0:
					create1();
					cal_bill();

					break;
				case 1:
					create2();
					cal_bill();
					break;
				case 2:
					create3();
					cal_bill();
					break;
				case 3:
					create4();
					cal_bill();

					break;
			}
		} else {
			Bill b;
			Scanner sc = new Scanner(System.in);
			float grand_total = 0;
			int opt, flag_wrong_qty = 0;
			int q = 0; // quantity
			float gst = 0;
			String n; // name
			ArrayList<Bill> a = new ArrayList<>();
			do {
				System.out.println("\nEnter the food item name: ");
				sc.nextLine();
				n = sc.nextLine();
				try {
					System.out.println("Enter the quantity");
					q = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Enter Valid quantity");
					flag_wrong_qty = 1;
					sc.next();
				}
				if (flag_wrong_qty != 1) {
					b = new Bill(n, q); // add name and quantity to constructor
					if (search_item_new(n, rest_id_final) != 0)
						a.add(b); // add into the array list
					if (search_item_new(n, rest_id_final) == 0) // if item is not present
					{
						System.out.println("\n Enter valid food item name \n");
					}
					grand_total = grand_total + (search_item_new(n, rest_id_final) * q);
				} // calculating total amount
				System.out.println("Do you want to add more food items into the basket?(0/1)");
				opt = sc.nextInt();
			} while (opt == 1);
			gst = (.20f * grand_total); // calculating gst
			float k = grand_total + gst;

			System.out.println("-------------Your Order Details-------------");
			System.out.println();
			System.out.println("Food Item" + "                  " + "Quantity");
			System.out.println();
			for (int i = 0; i < a.size(); i++) {
				System.out.println(String.format("%-30s", a.get(i).name) + a.get(i).quantity);
			}
			System.out.println();
			System.out.println("--------------BIILING DETAILS--------------");
			System.out.println("Your Total is                   =   " + "Rs. " + grand_total);
			System.out.println("The GST amount is               =   " + "Rs. " + gst);
			System.out.println("                                  ________________");
			System.out.println("YOUR FINAL BILLING AMOUNT IS    =   " + "Rs. " + k);
			System.out.println();
			System.out.println("*********");
			System.out.println("\n!!THANK YOU FOR CHOOSING SPYG FOR YOUR FOOD DELIVERY SERVICE!! \n");
			System.out.println("*********");
			final_grand_total += grand_total + gst;
		}
	}

	void initial() {
		ArrayList<Rest> temp_a = new ArrayList<Rest>();
		for (int i = 0; i < 15; i++) {
			new_a.add(temp_a);
			new_b.add(temp_a);
		}

	}

	void create_new(int new_rest_loc, int disp_only) { // function for creating new restaurant dynamically
		if (disp_only == 0) {
			int opt;
			ArrayList<Rest> temp_a = new ArrayList<Rest>();
			ArrayList<Rest> temp_b = new ArrayList<Rest>();
			String name, cost;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter category of menu:"); // taking 1st category of food
			cat = sc.nextLine();
			do { // do this till you want to add more items
				System.out.println("Enter Food item:");
				name = sc.nextLine();
				System.out.println("Enter cost:");
				cost = sc.nextLine();
				Rest r = new Rest(name, cost);
				temp_a.add(r); // add to arraylist
				System.out.println("Do you want to add more items(1/0)");
				opt = Integer.parseInt(sc.nextLine());
			} while (opt != 0);
			new_a.set(new_rest_loc, temp_a);
			System.out.println("Enter second category"); // taking second category of food
			cat1 = sc.nextLine();
			do {
				System.out.println("Enter Food item:");
				name = sc.nextLine();
				System.out.println("Enter cost:");
				cost = sc.nextLine();
				Rest r = new Rest(name, cost);
				temp_b.add(r); // add to array list
				System.out.println("Do you want to add more items(1/0)");
				opt = Integer.parseInt(sc.nextLine());
			} while (opt != 0);
			new_b.set(new_rest_loc, temp_b);
			display_new(new_rest_loc);
		} else if (disp_only == 1)
			display_new(new_rest_loc);

	}

	void display_new(int new_rest_loc) { // displaying newly created restaurant

		System.out.println("---------MENU-------");
		if (cat != null)
			System.out.println("----" + cat + "----");
		System.out.println();
		for (int i = 0; i < new_a.get(new_rest_loc).size(); i++) {
			System.out.println(
					new_a.get(new_rest_loc).get(i).name + "      Rs. " + new_a.get(new_rest_loc).get(i).cost);// for
																				// 1st
																				// category
		}
		System.out.println("\n");
		if (cat != null)
			System.out.println("----" + cat1 + "---");
		for (int i = 0; i < new_b.get(new_rest_loc).size(); i++) {
			System.out.println(
					new_b.get(new_rest_loc).get(i).name + "      Rs. " + new_b.get(new_rest_loc).get(i).cost);// for
																				// 2nd
																				// category
		}
	}
}
// syso