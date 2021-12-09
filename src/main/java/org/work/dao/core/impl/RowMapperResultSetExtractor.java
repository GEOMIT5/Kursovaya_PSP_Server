package org.work.dao.core.impl;



import org.work.dao.core.ResultSetExtractor;
import org.work.dao.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


class RowMapperResultSetExtractor<T> implements ResultSetExtractor<List<T>> {

    private final RowMapper<T> rowMapper;


    RowMapperResultSetExtractor(RowMapper<T> rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public List<T> extractData(ResultSet set) throws SQLException {

        final List<T> results = new ArrayList<>();

        while (set.next()) {
            results.add(this.rowMapper.mapRow(set));
        }

        return results;
    }
}
