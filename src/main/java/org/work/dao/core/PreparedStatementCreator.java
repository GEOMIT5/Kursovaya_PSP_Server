package org.work.dao.core;




import org.work.dao.core.pool.connection.ConnectionWrapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementCreator {

    PreparedStatement createPreparedStatement(ConnectionWrapper connectionWrapper) throws SQLException;

}
