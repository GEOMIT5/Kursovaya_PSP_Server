package org.work.dao.mapper;

import org.work.dao.core.RowMapper;
import org.work.dao.mapper.builder.impl.SegmentRowMapperBuilder;
import org.work.domen.entity.Segment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SegmentRowMapper implements RowMapper<Segment> {

    private static final int SEGMENT_ID = 1;
    private static final int SEGMENT_NAME = 2;

    @Override
    public Segment mapRow(ResultSet set) throws SQLException {
        return
                new SegmentRowMapperBuilder(SEGMENT_ID, SEGMENT_NAME)
                        .getBuiltEntity(set);
    }
}
