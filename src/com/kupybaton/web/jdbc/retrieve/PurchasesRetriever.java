package com.kupybaton.web.jdbc.retrieve;

import com.kupybaton.model.*;
import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchasesRetriever extends DatabaseConnect {
    private static PurchasesRetriever purchasesRetriever;

    private PurchasesRetriever() {
    }

    public static PurchasesRetriever getListsRetriever() {
        if (purchasesRetriever == null) {
            purchasesRetriever = new PurchasesRetriever();
        }

        return purchasesRetriever;
    }

    public List<Purchase> getPurchasesByListId(Integer listId) {
        String sql = "SELECT p.id, l.*, pr.id, pr.name, c.id, c.name, u.id, u.name, p.quantity, p.flag "
                     + "FROM purchase p "
                     + "JOIN LIST l ON p.list_id = ? AND p.list_id = l.id "
                     + "JOIN product pr ON p.product_id = pr.id "
                     + "JOIN category c ON pr.category_id = c.id "
                     + "JOIN unit u ON pr.unit_id = u.id";

        List<Purchase> purchaseList = new ArrayList<>();

        try {
            ResultSet resultSet = getResultSetPreparedStatementById(sql, listId);

            while (resultSet.next()) {
                int i = 0;
                Purchase purchase = new Purchase();
                purchase.setId(resultSet.getInt(++i));

                ProductList productList = new ProductList();
                productList.setId(resultSet.getInt(++i));
                productList.setName(resultSet.getString(++i));
                productList.setDateCreated(resultSet.getDate(++i));
                productList.setDateDeleted(resultSet.getDate(++i));

                purchase.setProductlist(productList);

                Product product = new Product();
                product.setId(resultSet.getInt(++i));
                product.setName(resultSet.getString(++i));

                Category category = new Category(resultSet.getInt(++i), resultSet.getString(++i));
                product.setCategory(category);

                Unit unit = new Unit(resultSet.getInt(++i), resultSet.getString(++i));
                product.setUnit(unit);

                purchase.setProduct(product);
                purchase.setQuantity(resultSet.getDouble(++i));
                purchase.setFlag(resultSet.getBoolean(++i));

                purchaseList.add(purchase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return purchaseList;
    }
}
