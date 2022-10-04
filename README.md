# BurgerBaron

Assignment:
The Burger Baron will make custom burgers including any of the toppings on his famous Baron Burger. The Baron Burger is made on the special Baron Bun and has on it:
• Patties: Beef, Chicken, or Veggie
• Cheese: Cheddar, Mozzarella, and Pepperjack
• Veggies: Lettuce, Tomato, Onions, Pickle, and Mushrooms
• Sauces: Ketchup, Mustard, Mayonnaise, and Baron Sauce
The Burger Baron’s official recipe constructs the Baron Burger in this order (top to bottom):
• Pickle: Skewered to the burger with the Baron’s Blade.
• Top Bun
• Mayonnaise
• Baron Sauce
• Lettuce
• Tomato
• Onions
• Pepperjack
• Mozzarella
• Cheddar
• Patty: If there is more than one patty then the cheese goes on the bottom patty.
• Mushrooms
• Mustard
• Ketchup
• Bottom Bun
The Burger Baron has customers that will order in different ways and he wants his menus to automatically construct the burger ingredients in the proper order so he can display it to his gourmet burger chef’s. Here are some sample orders:
• Single Veggie Baron Burger.
• Double Baron Burger with no Cheese but Mozzarella.
• Single Burger with Veggies but no Lettuce.
• Double Chicken Burger with Ketchup Cheddar Onions Mushrooms.
That is, most customers use one of two styles to order.
• <Patty Count> <Patty Type> Baron Burger with no <omissions> but <exceptions>
• <Patty Count> <Patty Type> Burger with <additions> but no <exceptions>
The <omissions> and <additions> may include ingredients or categories of ingredients:
• Categories Cheese, Sauce, Veggies
• Ingredients Cheddar, Mozzarella, Pepperjack, Lettuce, Tomato, Onions, Pickle,
Mushrooms, Ketchup, Mustard, Mayonnaise, and Baron Sauce
The <exceptions> are always ingredients only and are exceptions to the categories listed in the <omissions> or <additions>.
if an order contains invalid <omissions>, <additions>, or <exceptions> (including <exceptions> that are categories instead of ingredients), those invalid items may be ignored (an error message may be displayed as well).
Each of the components can be omitted when ordering with the following defaults.
• <Patty Count> defaults to Single.
• <Patty Type> defaults to Beef
• <omissions>, <additions>, <exceptions> default to empty.
The Burger Baron takes orders one at a time and gives them a number 0 to 99. The input to your program will be a file with one line per burger. The file name is to be passed to your program as a command line argument (so that it is available as the first component of the String[] argument to the main() method).
• Your program should assign each order a number starting with 0.
• Each line will be a string in the format above.
• Your output (to System.out) will be the ingredients of the ordered burger listed from top to
bottom.

Formal Specifications:
Your assignment is to create a program that can take text orders in the format described and construct a custom burger with all ingredients in the proper order.
Your program will implement the MyStack class as a linked structure that must function according to the following interface:
• class MyStack <Type> () – generic class declaration.
• MyStack() – a constructor that initializes an empty MyStack.
• boolean isEmpty() – returns true if the MyStack is empty.
• void push(Type item) – this method adds the item to the top of the MyStack .
• Type pop() – this method removes and returns the item on the top of the MyStack .
• Type peek() – this method returns the item on the top of the MyStack.
• int size() – this method returns the number of items in the MyStack.
• String toString() – this method converts the contents of the MyStack to a String for display.
The MyStack class must not use or extend any List type in Java or arrays. It must be built from scratch.
Your program will implement the Burger class using only the MyStack class that must function according to the following interface:
• class Burger – plain class declaration.
• Burger(boolean theWorks) – a constructor that initializes a Burger with only a bun and
patty if theWorks is false and a Baron Burger if theWorks is true.
• void changePatties(String pattyType) – this method changes all patties in the Burger to
the pattyType.
• void addPatty() – this method adds one patty to the Burger up to the maximum of 3.
• void addCategory(String type) – this method adds all items of the type to the Burger in the
proper locations.
• void removeCategory(String type) – this method removes all items of the type from the
Burger.
• void addIngredient(String type) – this method adds the ingredient type to the Burger in the
proper location (unless it is already there, in which case this method does nothing).
• void removeIngredient(String type) – this method removes the ingredient type from the
Burger.
• String toString() – this method converts the Burger to a String for display.
The Burger class must not use any List type in Java or arrays. It must only use the MyStack class to store ingredients. Hint: You may use a “recipe” stack in your program that has the complete burger according to the recipe.
Finally, your program will also provide a Main class that is used to read in the input file and test and run the Burger class.
• class Main – plain class declaration.
• void main(String[] args) – static main method used to run the program and test the
program elements. The input file containing the list of burger orders is to be passed as a
command line argument, so that the file name is available to your program as args[0].
• void parseLine(String line) – parses a line of input from the file and outputs the burger.
• void testMyStack() – test method for MyStack.
• void testBurger() – test method for Burger.
You may use List types in the main and you may create any other (private or public) classes that you expect will be useful in your simulation. However, your solution must use the Burger class and the MyStack class as described.
Also, none of those classes may be in a named package (just define them without a Java package clause).


[Assignment1-BurgerBaron.pdf](https://github.com/angielynna/BurgerBaron/files/8605599/Assignment1-BurgerBaron.pdf)
