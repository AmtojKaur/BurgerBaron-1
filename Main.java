package assignment1;

/**
 * TCSS342: Assignment 1
 * Instructor: Paulo Barretto
 * Assignment 1 - Main.java
 */

import java.io.*;
import java.util.*;

/**
 * Main.java is the driver class of the assignment
 * @author Angelynna Pyeatt and Amtoj Kaur
 * @version 10 April 2022
 */

public class Main {
    private static int orderCount;

    /**
     * driver
     * @param args File input
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

    	FileReader inputStream = null;
		try {
			for (final String arg : args) {
				inputStream = new FileReader(arg);	//to read through 
													//command line arg
				
				Scanner sc = new Scanner(inputStream);
				
				String line = sc.nextLine();	   //first line of scanner
				
				while (!line.equals("Empty")) {
					parseLine(line);
					System.out.println();
					if(sc.hasNextLine()) {
						line = sc.nextLine();
					} else {
						line = "Empty";
					}
				}
					sc.close();
			}
		} finally {}
	        // testMyStack();
	        // testBurger();
	}

    /**
     * parse input string from customer order.
     *
     * @throws IOException
     */
    public static void parseLine(String line) throws IOException {
        if (line.equals(""))
            return;
            
        int pCount = 1;             //patty count
        String pType = "Beef";
        boolean works = false;      //default for works
        Burger burger = null;
        String[] st = line.split(" ");
        
        for (String str : st) {
            if (str.equals("Baron")) {
                works = true;
            }
            if (str.equals("Veggie") || str.equals("Chicken")) {
                pType = str;
            }
            if (str.equals("Double")) {
                pCount = 2;
            }
            if (str.equals("Triple")) {
                pCount = 3;
            }
        }
        
        burger = new Burger(works);
        for (int i = 1; i < pCount; i++) {      //adds patties
            burger.addPatty();
        }
        burger.changePatties(pType);
        for (int i = 0; i < st.length; i++) {
        
            if (st[i].equals("with")) {
            
                if (st[i + 1].equals("no")) {
                
                    for (int j = i + 2; j < st.length; j++) {
                    
                        if (st[j].equals("but")) {
                        
                            for (int k = j + 1; k < st.length; k++) {
                                burger.addIngredient(st[k].toString());
                            }
                            
                            break;
                        }
                        burger.removeCategory(st[j]);
                        burger.removeIngredient(st[j]);
                    }
                    
                } else {
                
                    for (int j = i + 1; j < st.length; j++) {
                    
                        if (st[j].equals("but")) {
                        
                            for (int k = j + 2; k < st.length; k++) {
                                burger.removeIngredient(st[k].toString());
                            }
                            
                            break;
                        }
                        
                        if (st[j].equals("Sauce") || st[j].equals("Cheese") 
                        		|| st[j].equals("Veggies")) {
                            burger.addCategory(st[j]);
                        
                        } else {
                            burger.addIngredient(st[j].toString());
                        }
                    }
                }
            }
        }
        System.out.println("Processing Order " + orderCount++ + ": " + line);
        System.out.println(burger.toString());
        System.out.println();
    }

    /*
     * test method for MyStack.
     */
    public void testMyStack() {
        // test burger with different data type
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(3);
        stack.push(9);
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop(); // should throw EmptyStackException
    }

    /*
     * test method for the burger class
     */
    public void testBurger() {
        System.out.println("Baron Burger Test:");
        System.out.println("Processing Order test: "
        					+ "Baron Burger with no Sauce "
        					+ "Pickles but Baron-Sauce");
        Burger bTest1 = new Burger(true);
        bTest1.removeCategory("Sauce");
        bTest1.removeIngredient("Pickles");
        bTest1.addIngredient("Baron-Sauce");
        System.out.println(bTest1.toString());
        System.out.println();
        System.out.println("Non-Baron Burger Test:");
        System.out.println("Processing Order test: Triple Chicken" +
        					"Burger with Sauce Cheese Veggies but " +
        					"no Lettuce Mozarella Mayonnaise");
        Burger bTest2 = new Burger(false);
        bTest2.addPatty();
        bTest2.addPatty();
        bTest2.changePatties("Chicken");
        bTest2.addCategory("Sauce");
        bTest2.addCategory("Cheese");
        bTest2.addCategory("Veggies");
        bTest2.removeIngredient("Lettuce");
        bTest2.removeIngredient("Mozarella");
        System.out.println(bTest2.toString());
    }

}
