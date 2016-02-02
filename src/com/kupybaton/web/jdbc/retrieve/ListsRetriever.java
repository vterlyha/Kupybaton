package com.kupybaton.web.jdbc.retrieve;

import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListsRetriever extends DatabaseConnect {

	private static ListsRetriever listsRetriever;

	private ListsRetriever() {
	}

	public static ListsRetriever getListsRetriever() {
		if (listsRetriever == null) {
			listsRetriever = new ListsRetriever();
		}

		return listsRetriever;
	}

    public List<ProductList> getOnlyActiveLists() {
        String sql = "SELECT * FROM list WHERE date_del IS NULL";

        List<ProductList> list = new ArrayList<>();

        try {
            ResultSet listValues = getResultSet(sql);

            list = prepareListOfProductList(list, listValues, false);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return list;
    }

    public List<ProductList> getOnlyInactiveLists() {
        String sql = "SELECT * FROM list WHERE date_del IS NOT NULL";

        List<ProductList> list = new ArrayList<>();

        try {
            ResultSet listValues = getResultSet(sql);

            list = prepareListOfProductList(list, listValues, true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return list;
    }

    public ProductList getProductListById(Integer listId) {
        String sql = "SELECT * FROM list WHERE id = ?";

        try {
            ResultSet listValues = getResultSetPreparedStatementById(sql, listId);
            listValues.next();

            return retrieveProductList(listValues, true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return null;
    }

    private List<ProductList> prepareListOfProductList(List<ProductList> productLists, ResultSet resultSet, Boolean isInactiveIncluded) throws SQLException {
        while (resultSet.next()) {
            productLists.add(retrieveProductList(resultSet, isInactiveIncluded));
        }

        return productLists;
    }

    private ProductList retrieveProductList(ResultSet resultSet, Boolean isInactiveIncluded) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Date dateCreated = resultSet.getDate("date_cr");

        if (isInactiveIncluded) {
            Date dateDeleted = resultSet.getDate("date_del");
            return new ProductList(id, name, dateCreated, dateDeleted);
        }

        return new ProductList(id, name, dateCreated);
    }
}
