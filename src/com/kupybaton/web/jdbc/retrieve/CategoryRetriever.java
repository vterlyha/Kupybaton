package com.kupybaton.web.jdbc.retrieve;

import com.kupybaton.model.Category;
import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRetriever extends DatabaseConnect {

	private static CategoryRetriever productRetriever;

	private CategoryRetriever() {
	}

	public static CategoryRetriever getListsRetriever() {
		if (productRetriever == null) {
			productRetriever = new CategoryRetriever();
		}

		return productRetriever;
	}

    public List <Category> getAllCategories() {
        String sql = "SELECT * FROM category";

        try {
            ResultSet categoryValues = getResultSet(sql);
            List<Category> listOfAllCategories = prepareListOfCategories(categoryValues);
            return listOfAllCategories;
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return null;
    }
    
    public Category getUnitById(Integer productId) {
        String sql = "SELECT * FROM product WHERE id = ?";

        try {
            ResultSet categoryValues = getResultSetPreparedStatementById(sql, productId);
            categoryValues.next();

            return retrieveCategory(categoryValues);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return null;
    }

    private List<Category> prepareListOfCategories(ResultSet resultSet) throws SQLException {
    	List<Category> categoryList = new ArrayList<Category>();
    	while (resultSet.next()) {
    		categoryList.add(retrieveCategory(resultSet));
        }

        return categoryList;
    }

    private Category retrieveCategory(ResultSet resultSet) throws SQLException {
    	Integer id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        
        return new Category(id, name);
    }
}
