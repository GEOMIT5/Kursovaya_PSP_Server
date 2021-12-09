package org.work.dao.mapper;

import org.work.dao.core.RowMapper;
import org.work.dao.mapper.builder.impl.ProjectRowMapperBuilder;
import org.work.domen.entity.Project;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {

    private final int COMPANY_ID = 1;

    private final int SEGMENT_ID = 2;
    private final int SEGMENT_NAME = 3;

    private final int PROJECT_MARK_STATUS = 4;

    private final int PROJECT_NAME = 5;
    private final int PROJECT_HEAD = 6;
    private final int PROJECT_HUMAN_AMOUNT = 7;
    private final int PROJECT_AVERAGE_SALARY = 8;
    private final int PROJECT_PROFIT = 9;
    private final int PROJECT_TERM = 10;
    private final int PROJECT_PROFITABILITY = 11;

    @Override
    public Project mapRow(ResultSet set) throws SQLException {
        return
                new ProjectRowMapperBuilder(COMPANY_ID, SEGMENT_ID, SEGMENT_NAME,
                        PROJECT_MARK_STATUS, PROJECT_NAME, PROJECT_HEAD,PROJECT_HUMAN_AMOUNT,
                        PROJECT_AVERAGE_SALARY, PROJECT_PROFIT, PROJECT_TERM, PROJECT_PROFITABILITY)
                        .getBuiltEntity(set);
    }
}
