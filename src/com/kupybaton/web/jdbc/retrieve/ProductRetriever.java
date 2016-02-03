package com.kupybaton.web.jdbc.retrieve;

import com.kupybaton.model.Category;
import com.kupybaton.model.Product;
import com.kupybaton.model.Unit;
import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRetriever extends DatabaseConnect {

	private static ProductRetriever productRetriever;

	private ProductRetriever() {
	}

	public static ProductRetriever getListsRetriever() {
		if (productRetriever == null) {
			productRetriever = new ProductRetriever();
		}

		return productRetriever;
	}

    public List <Product> getAllProducts() {
        String sql = "select pr.*, u.name, c.name" + 
        		"FROM product AS pr" +
        		"JOIN unit AS u ON pr.unit_id = u.id" +
        		"JOIN category AS c ON pr.category_id = c.id";

        try {
            ResultSet productValues = getResultSet(sql);
            List<Product> listOfAllProducts = prepareListOfProducts(productValues);
            return listOfAllProducts;
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return null;
    }
    
    public Product getProductById(Integer productId) {
        String sql = "SELECT * FROM product WHERE id = ?";

        try {
            ResultSet productValues = getResultSetPreparedStatementById(sql, productId);
            productValues.next();

            return retrieveProduct(productValues);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return null;
    }

    private List<Product> prepareListOfProducts(ResultSet resultSet) throws SQLException {
    	List<Product> productList = new ArrayList<Product>();
    	while (resultSet.next()) {
            productList.add(retrieveProduct(resultSet));
        }

        return productList;
    }

    private Product retrieveProduct(ResultSet resultSet) throws SQLException {
    	Integer id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        
        Integer categoryId = resultSet.getInt(3);
        String categoryName = resultSet.getString(6);
        Category category = new Category(categoryId, categoryName);
        
        Integer unitId = resultSet.getInt(4);
        String unitName = resultSet.getString(5);
        Unit unit = new Unit(unitId, unitName);

        return new Product(id, name, unit, category);
    }
}
