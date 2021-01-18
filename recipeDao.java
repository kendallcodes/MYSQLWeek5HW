package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Recipes;

public class recipeDao {
	
	private Connection connection; 
	private final String GET_RECIPES_QUERY = "SELECT * FROM recipes";
	private final String CREATE_NEW_RECIPE_QUERY = "INSERT INTO recipes(recipe_name, recipe_type, recipe_origin) VALUES(?, ?, ?)";
	private final String DELETE_RECIPES_BY_ID_QUERY = "DELETE FROM recipes WHERE id = ?";
	private final String UPDATE_RECIPES_BY_ID_QUERY = "UPDATE recipes SET recipe_name = ? WHERE id = ?";
	
	public recipeDao() { 
		connection = DBConnection.getConnection(); 
		}
	
	public List<Recipes> getRecipes() throws SQLException { 
		ResultSet rs = connection.prepareStatement(GET_RECIPES_QUERY).executeQuery();
		List<Recipes> recipes = new ArrayList<Recipes>(); 
		
		while (rs.next()) { 
			recipes.add(populateRecipes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		return recipes; 
	}	
	
	public void createNewRecipe (String recipeName, String recipeType, String recipeOrigin) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_RECIPE_QUERY); 
		ps.setString(1, recipeName);
		ps.setString(2, recipeType);
		ps.setString(3, recipeOrigin);
		ps.executeUpdate();
	}
	public void deleteRecipe (int id) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement(DELETE_RECIPES_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateRecipe (int id, String recipeName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RECIPES_BY_ID_QUERY);
		ps.setInt(1, id); 
		ps.setString(2, recipeName);
		ps.executeUpdate();
	}
	
	
	private Recipes populateRecipes(int id, String recipeName, String recipeType, String recipeOrigin) {
		return new Recipes(id, recipeName, recipeType, recipeOrigin);	
	}
	
	
}
