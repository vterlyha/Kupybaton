package com.kupybaton.web.jdbc.retrieve;

import com.kupybaton.model.Unit;
import com.kupybaton.web.jdbc.DatabaseConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitRetriever extends DatabaseConnect {

	private static UnitRetriever unitRetriever;

	private UnitRetriever() {
	}

	public static UnitRetriever getListsRetriever() {
		if (unitRetriever == null) {
			unitRetriever = new UnitRetriever();
		}

		return unitRetriever;
	}

    public List <Unit> getAllUnits() {
        String sql = "SELECT * FROM unit";

        try {
            ResultSet unitValues = getResultSet(sql);
            List<Unit> listOfAllUnits = prepareListOfUnits(unitValues);
            return listOfAllUnits;
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return null;
    }
    
    public Unit getUnitById(Integer productId) {
        String sql = "SELECT * FROM product WHERE id = ?";

        try {
            ResultSet unitValues = getResultSetPreparedStatementById(sql, productId);
            unitValues.next();

            return retrieveUnit(unitValues);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllDBConnections();
        }

        return null;
    }

    private List<Unit> prepareListOfUnits(ResultSet resultSet) throws SQLException {
    	List<Unit> unitList = new ArrayList<Unit>();
    	while (resultSet.next()) {
    		unitList.add(retrieveUnit(resultSet));
        }

        return unitList;
    }

    private Unit retrieveUnit(ResultSet resultSet) throws SQLException {
    	Integer id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        
        return new Unit(id, name);
    }
}
