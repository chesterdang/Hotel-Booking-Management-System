/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.GenericDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import mapping.IRowMapping;
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.impli.ContractMapping;
import util.JDBCUtill;

/**
 *
 * @author Nguyen Quang Hau
 */
public class AbstractModel implements GenericDAO {

    @Override
    public <T> List<T> query(String sql, IRowMapping mapper, Object... parameters) {
        List<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtill.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                mapParameter(statement, parameters);
                rs = statement.executeQuery();

                while (rs.next()) {
                    list.add((T) mapper.mapRow(rs));
                }
                return list;
            } else {
                list = null;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(connection, statement, rs);
        }

        return list;
    }

    @Override
    public boolean update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtill.getConnection();
            if (connection != null) {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql);
                mapParameter(statement, parameters);
                statement.executeUpdate();
                connection.commit();
                return true;
            } else {
                throw new SQLException("Connection is null");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
            return false;

        } finally {
            closeConnection(connection, statement, rs);
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Long id = null;
        try {
            connection = JDBCUtill.getConnection();
            if (connection != null) {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                mapParameter(statement, parameters);
                statement.executeUpdate();
                rs = statement.getGeneratedKeys();

                if (rs.next()) {
                    id = rs.getLong(1);
                }

                connection.commit();
            } else {
                throw new SQLException("Connection is null");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        } finally {
            closeConnection(connection, statement, rs);
        }

        return id;
    }

    @Override
    public int countRows(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int count = 0;
        try {
            connection = JDBCUtill.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                mapParameter(statement, parameters);
                rs = statement.executeQuery();

                if (rs.next()) {
                    count = rs.getInt(1);
                }

            } else {
                throw new SQLException("Connection is null");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection, statement, rs);
        }
        
        return count;
    }

    private void mapParameter(PreparedStatement statement, Object... parameters) throws SQLException {
        int index = 1;

        for (Object parameter : parameters) {
            if (parameter instanceof Long) {
                statement.setLong(index, (Long) parameter);
            } else if (parameter instanceof String) {
                statement.setString(index, (String) parameter);
            } else if (parameter instanceof Date) {
                statement.setDate(index, (Date) parameter);
            } else if (parameter instanceof Boolean) {
                statement.setBoolean(index, (Boolean) parameter);
            } else if (parameter instanceof Integer) {
                statement.setInt(index, (int) parameter);
            } else if (parameter instanceof BigDecimal) {
                statement.setBigDecimal(index, (BigDecimal) parameter);
            }else if (parameter instanceof Timestamp) {
                statement.setTimestamp(index, (Timestamp) parameter);
            }else if (parameter instanceof Short) {
                statement.setShort(index, (short) parameter);
            }else if (parameter == null) {
                statement.setNull(index, Types.NULL);
            }else if(parameter instanceof Double){
               statement.setDouble(index, (double) parameter);
            }
            index++;
        }
    }

    private void closeConnection(Connection con, PreparedStatement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public HashMap<Integer, Integer> numberHashMap(String sql) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int count = 0;

        try {
            connection = JDBCUtill.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                mapParameter(statement);
                rs = statement.executeQuery();
                while (rs.next()) {
                    hashMap.put(rs.getInt(1), rs.getInt(2));
                }
            } else {
                hashMap = null;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection, statement, rs);
        }

     return hashMap ;
    }

}
