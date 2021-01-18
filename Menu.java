package RecipeApp;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.recipeDao;
import entity.Recipes;


public class Menu {

		private recipeDao RecipeDao = new recipeDao();
		private Scanner scanner = new Scanner(System.in);
		private List<String> menuOptions = Arrays.asList(
				"Display Recipes",
				"Create New Recipe",
				"Update A Recipe", 
				"Delete A Recipe");
		
		public void start() {
			String selection = ""; 
			
			do {
				printMenu();
				selection = scanner.nextLine();
			try {
				if (selection.equals("1")) { 
					displayRecipes(); 
				} else if (selection.equals("2")) {
					createNewRecipe(); 
				} else if (selection.equals("3")) { 
					updateRecipe(); 
				} else if (selection.equals("4")) { 
					deleteRecipe(); 
				} 
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
				System.out.println("Press enter... ");	
				scanner.nextLine(); 
			} while (selection.equals("-1"));
			
		}
	 private void printMenu() { 
		 System.out.println("Select an Option");
		 for (int i = 0; i < menuOptions.size(); i++) {
			 System.out.println(i + 1 + ") " + menuOptions.get(i));
		 }
	 }
	private void displayRecipes() throws SQLException {
		List<Recipes> recipes = RecipeDao.getRecipes();
			for (Recipes recipe : recipes) {
			System.out.println(recipe.getId() + " " + recipe.getRecipeName() + " " + recipe.getType() + " " + recipe.getRecipeOrigin()); 
				}
	}
	private void createNewRecipe() throws SQLException {
		System.out.println("Enter New Recipe..");
		String recipeName = scanner.nextLine(); 
		System.out.println("Enter Recipe Type..");
		String recipeType = scanner.nextLine(); 
		System.out.println("Enter Recipe Origin..");
		String recipeOrigin = scanner.nextLine(); 
		RecipeDao.createNewRecipe(recipeName, recipeType, recipeOrigin);
	}
	private void deleteRecipe() throws SQLException {
		System.out.println("Enter Recipe ID to delete....");
		int id = Integer.parseInt(scanner.nextLine());
		RecipeDao.deleteRecipe(id);
		}
	private void updateRecipe() throws SQLException { 
		System.out.println("Enter Recipe ID to update...");
		int id = scanner.nextInt();
		System.out.println("Enter New Recipe Name...");
		String recipeName = scanner.nextLine();
		RecipeDao.updateRecipe(id, recipeName);
	}
}
