package assignment1;

/**
 * Burger.java
 * @author Angelynna Pyeatt and Amtoj Kaur
 * @version 10 April 2022
 */

public class Burger {
    /** holds patty count*/
    private int pattyCount;
    
    /** holds patty type*/
    private String pattyType;
    
    /** holds stack for burger order*/
    private MyStack<String> burger;
    
    /** holds stack for recipe of the burger*/
    private MyStack<String> recipe;
    
    /** holds stack for ingredients*/
    private MyStack<String> ingredients;
    
    /** holds a temporary stack for burger*/
    private MyStack<String> tempBurger;

    /*
     * constructor that initializes a Burger with only a bun and patty if
     * theWorks is false and a Baron Burger if theWorks is true.
     *
     * @param boolean theWorks
     */
    public Burger(boolean theWorks) {
        burger = new MyStack<String>();
        recipe = new MyStack<String>();
        ingredients = new MyStack<String>();
        tempBurger = new MyStack<String>();
        
        pattyCount = 1;
        pattyType = "Beef";
        ingredients.push("Bun");          //bottom
        ingredients.push(pattyType);
        ingredients.push("Bun");          //top
        
        if (theWorks) {
            addCategory("Sauce");
            addCategory("Cheese");
            addCategory("Veggies");
        }
        
        //fill recipe stack:
        recipe.push("Pickles");
        recipe.push("Bun");
        recipe.push("Mayonnaise");
        recipe.push("Baron-Sauce");
        recipe.push("Lettuce");
        recipe.push("Tomato");
        recipe.push("Onions");
        if (pattyCount > 1) {
            for (int i = 1; i < pattyCount; i++) {
                recipe.push(pattyType);
            }
        }
        recipe.push("Pepperjack");
        recipe.push("Mozzarella");
        recipe.push("Cheddar");
        recipe.push(pattyType);
        recipe.push("Mushrooms");
        recipe.push("Mustard");
        recipe.push("Ketchup");
        recipe.push("Bun");
        
        stackBurger();
    }

    
    /*
     * changes all patties in the Burger to the pattyType
     */
    public void changePatties(String pattyType) {
        if (pattyType.equals(pattyType)) {
            return;
        }
        
        while (!burger.isEmpty()) {
            if (burger.peek().equals(pattyType)) {
                burger.pop();
                burger.push(pattyType);
                
            } else {
                tempBurger.push(burger.pop());
            }
        }
        
        while (!tempBurger.isEmpty()) {
            burger.push(tempBurger.pop());
        }
        
        pattyType = pattyType;
        changeRecipe();
    }

    /*
     * adds one patty to the Burger: max of 3.
     */
    public void addPatty() {
        pattyCount++;
        changeRecipe();
        addIngredient(pattyType);
    }

    /*
     * removes one patty from the Burger: min of 1.
     */
    public void removePatty() {
        if (pattyCount > 1) {
            pattyCount--;
            changeRecipe();
            removeIngredient(pattyType);
            
        } else {
            System.out.println("cannot proceed: patty count must be 1");
        }
    }

    /*
     * adds all items of the type to the Burger in the proper locations.
     *
     * @param String type: ingredient
     */
    public void addCategory(String type) {
        if (type.equals("Sauce")) {
            ingredients.push("Mayonnaise");
            ingredients.push("Baron-Sauce");
            ingredients.push("Mustard");
            ingredients.push("Ketchup");
            
        } else if (type.equals("Cheese")) {
            ingredients.push("Cheddar");
            ingredients.push("Mozzarella");
            ingredients.push("Pepperjack");
            
        } else if (type.equals("Veggies")) {
            ingredients.push("Mushrooms");
            ingredients.push("Onions");
            ingredients.push("Tomato");
            ingredients.push("Lettuce");
            ingredients.push("Pickles");
        }
        
        swap();
        stackBurger();
    }

    /*
     * removes all items of the ingredient type from the Burger
     *
     * @param String type: ingredient
     */
    public void removeCategory(String type) {
        if (type.equals("Sauce")) {
            removeIngredient("Mayonnaise");
            removeIngredient("Baron-Sauce");
            removeIngredient("Mustard");
            removeIngredient("Ketchup");
            
        } else if (type.equals("Cheese")) {
            removeIngredient("Cheddar");
            removeIngredient("Mozzarella");
            removeIngredient("Pepperjack");
            
        } else if (type.equals("Veggies")) {
            removeIngredient("Mushrooms");
            removeIngredient("Onions");
            removeIngredient("Tomato");
            removeIngredient("Lettuce");
            removeIngredient("Pickles");
        }
    }

    /*
     * adds ingredient types to the Burger in the proper location.
     *
     * @param String type: ingredient type
     */
    public void addIngredient(String type) {
        ingredients.push(type);
        swap();
        stackBurger();
    }

    /*
     * returns string representation of burger stack
     *
     * @return String: burgerString.toString()
     */
    @Override
    public String toString() {
        StringBuilder burgerString = new StringBuilder();
        burgerString.append("[");
        while (!burger.isEmpty()) {
            burgerString.append(burger.pop());
            if (!burger.isEmpty()) {
                burgerString.append(", ");
            } else {
                burgerString.append("]");
            }
        }
        return burgerString.toString();
    }
    
    // private helper methods
    
    /**
      * initializes burger stack
      */
    private void stackBurger() {
        while (!recipe.isEmpty()) {
            if (hasIngredient(recipe.peek())) {
                burger.push(recipe.pop());
            } else {
                recipe.pop();
            }
        }
        
        //restack recipe
        recipe.push("Pickles");
        recipe.push("Bun");
        recipe.push("Mayonnaise");
        recipe.push("Baron-Sauce");
        recipe.push("Lettuce");
        recipe.push("Tomato");
        recipe.push("Onions");
        
        if (pattyCount > 1) {
            for (int i = 1; i < pattyCount; i++) {
                recipe.push(pattyType);
            }
        }
        
        recipe.push("Pepperjack");
        recipe.push("Mozzarella");
        recipe.push("Cheddar");
        recipe.push(pattyType);
        recipe.push("Mushrooms");
        recipe.push("Mustard");
        recipe.push("Ketchup");
        recipe.push("Bun");
    }
    
    
    /**
      * method changes the recipe order of the burger
      */
    private void changeRecipe() {
        while (!recipe.isEmpty()) {
            recipe.pop();
        }
        
        recipe.push("Pickles");
        recipe.push("Bun");
        recipe.push("Mayonnaise");
        recipe.push("Baron-Sauce");
        recipe.push("Lettuce");
        recipe.push("Tomato");
        recipe.push("Onions");
        if (pattyCount > 1) {
            for (int i = 1; i < pattyCount; i++) {
                recipe.push(pattyType);
            }
        }
        recipe.push("Pepperjack");
        recipe.push("Mozzarella");
        recipe.push("Cheddar");
        recipe.push(pattyType);
        recipe.push("Mushrooms");
        recipe.push("Mustard");
        recipe.push("Ketchup");
        recipe.push("Bun");
    }

    /**
      * method swaps ingredients from burger
      */
    private void swap() {
        while (!burger.isEmpty()) {
            ingredients.push(burger.pop());
        }
    }
    
     /**
       * adds an ingredient type to the Burger
       * 
       * @return: boolean: hasIngredient
       */
    private boolean hasIngredient(String type) {
        boolean hasIngredient = false;
        while (!ingredients.isEmpty()) {
            if (type.equals(ingredients.peek())) {
                ingredients.pop();
                hasIngredient = true;
                break;
            }
            tempBurger.push(ingredients.pop());
        }
        while (!tempBurger.isEmpty()) {
            ingredients.push(tempBurger.pop());
        }
        return hasIngredient;
    }
    
    /**
      * removes an ingredient type from the Burger
      */
    public void removeIngredient(String type) {
        while (!burger.isEmpty()) {
            if (type.equals(burger.peek())) {
                burger.pop();
                break;
            } else {
                tempBurger.push(burger.pop());
            }
        }
        
        //restack burger
        while (!tempBurger.isEmpty()) {
            burger.push(tempBurger.pop());
        }
    }

}
