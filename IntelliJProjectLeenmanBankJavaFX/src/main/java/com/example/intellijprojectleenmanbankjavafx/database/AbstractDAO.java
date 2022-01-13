package com.example.intellijprojectleenmanbankjavafx.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Centralizes shared database operations
 * @author remideboer, gerke de boer, Michael Oosterhout
 *
 */
public abstract class AbstractDAO<T> {

    protected DBAccess dBaccess;
    protected PreparedStatement preparedStatement;

    public AbstractDAO() {
        this.dBaccess = dBaccess;
    }

    /**
     * Builds a prepared Statement from the sql string. A DAO should used this to
     * fill the parameters.
     *
     * @param sql, the SQl query
     */
    protected void setupPreparedStatement(String sql) throws SQLException {
        preparedStatement = dBaccess.getConnection().prepareStatement(sql);
    }

    /**
     * Executes a prepared statement without result. Used for insert, update and
     * delete statements.
     *
     *            the prepared statement filled by a DAO
     */
    protected void executeManipulatePreparedStatement() throws SQLException {
        preparedStatement.executeUpdate();
    }

    /**
     * Executes a prepared statement with result. Used for select statements.
     *
     *
     *            the prepared statement filled by a DAO
     */
    protected ResultSet executeSelectPreparedStatement() throws SQLException {
        return preparedStatement.executeQuery();
    }

    /**
     * Executes a prepared statement with result to get a generated key.
     *
     * @param sql, the SQL query
     */
    protected void getStatementWithKey(String sql) throws SQLException {
        preparedStatement = dBaccess.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    protected int executeInsertPreparedStatementWithKey() throws SQLException {
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        int gegenereerdeSleutel = 0;
        while (resultSet.next()) {
            gegenereerdeSleutel = resultSet.getInt(1);
        }
        return gegenereerdeSleutel;
    }
}
