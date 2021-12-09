package org.work.dao.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public interface PreparedStatementSetter {
    void setValues(PreparedStatement statement) throws SQLException;
}

