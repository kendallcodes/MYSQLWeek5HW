package entity;

public class Recipes {
	
	private int id; 
	private String recipeName; 
	private String recipeType; 
	private String recipeOrigin;
	
	public Recipes (int id, String recipeName, String recipeType, String recipeOrigin) { 
		this.setId(id); 
		this.setRecipeName(recipeName);
		this.setType(recipeType); 
		this.setRecipeOrigin(recipeOrigin); 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getType() {
		return recipeType;
	}

	public void setType(String type) {
		this.recipeType = type;
	}

	public String getRecipeOrigin() {
		return recipeOrigin;
	}

	public void setRecipeOrigin(String recipeOrigin) {
		this.recipeOrigin = recipeOrigin;
	}

}
