package org.work.dao.core.impl;


import org.work.dao.core.pool.connection.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


final class JdbcUtils {

    //private static final Logger logger = LogManager.getLogger(JdbcUtils.class);


    private JdbcUtils() {

    }


    static void closeConnection(ProxyConnection proxyConnection) {
        if (proxyConnection != null) {
            proxyConnection.close();
        }
    }

    static void closePreparedStatement(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException var2) {
               // logger.error("Could not close JDBC Statement", var2);
            }
        }

    }

    static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var2) {
             //   logger.error("Could not close JDBC ResultSet", var2);
            }
        }
    }


}