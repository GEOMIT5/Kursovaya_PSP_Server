package org.work.dao.mapper.builder.impl;

import org.work.dao.mapper.builder.RowMapperBuilder;
import org.work.domen.entity.Project;
import org.work.domen.entity.Segment;
import org.work.domen.entity.ProjectMarkStatus;
import org.work.domen.utilit.builder.impl.ProjectBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapperBuilder implements RowMapperBuilder<Project> {

    private final int COMPANY_ID;
    private final int SEGMENT_ID;
    private final int SEGMENT_NAME;
    private final int PROJECT_MARK_STATUS;
    private final int PROJECT_NAME;
    private final int PROJECT_HEAD;
    private final int PROJECT_HUMAN_AMOUNT;
    private final int PROJECT_AVERAGE_SALARY;
    private final int PROJECT_PROFIT;
    private final int PROJECT_TERM;
    private final int PROJECT_PROFITABILITY;


    public ProjectRowMapperBuilder(int COMPANY_ID, int SEGMENT_ID, int SEGMENT_NAME, int PROJECT_MARK_STATUS,
                                   int PROJECT_NAME, int PROJECT_HEAD, int PROJECT_HUMAN_AMOUNT,
                                   int PROJECT_AVERAGE_SALARY,
                                   int PROJECT_PROFIT, int PROJECT_TERM, int PROJECT_PROFITABILITY) {
        this.COMPANY_ID = COMPANY_ID;
        this.SEGMENT_ID = SEGMENT_ID;
        this.SEGMENT_NAME = SEGMENT_NAME;
        this.PROJECT_MARK_STATUS = PROJECT_MARK_STATUS;
        this.PROJECT_NAME = PROJECT_NAME;
        this.PROJECT_HEAD = PROJECT_HEAD;
        this.PROJECT_HUMAN_AMOUNT = PROJECT_HUMAN_AMOUNT;
        this.PROJECT_AVERAGE_SALARY = PROJECT_AVERAGE_SALARY;
        this.PROJECT_PROFIT = PROJECT_PROFIT;
        this.PROJECT_TERM = PROJECT_TERM;
        this.PROJECT_PROFITABILITY = PROJECT_PROFITABILITY;
    }

    @Override
    public Project getBuiltEntity(ResultSet set) throws SQLException {
        return doBuildProduct(set);
    }


    private Project doBuildProduct(ResultSet set) throws SQLException {
        //
        Segment segment = new SegmentRowMapperBuilder(SEGMENT_ID, SEGMENT_NAME)
                .getBuiltEntity(set);
        //
        return getProduct(segment, set);
    }

    private Project getProduct(Segment segment, ResultSet set) throws SQLException {
        final int statusId = set.getInt(PROJECT_MARK_STATUS) - 1; // because arrays start from 0
        final ProjectMarkStatus status = ProjectMarkStatus.values()[statusId];
        //
        return
                new ProjectBuilderImpl(set.getString(COMPANY_ID))
                        .withSegment(segment)
                        .withProjectStatus(status)
                        .withName(set.getString(PROJECT_NAME))
                        .withHead(set.getString(PROJECT_HEAD))
                        .withHumanAmount(set.getDouble(PROJECT_HUMAN_AMOUNT))
                        .withProfit(set.getDouble(PROJECT_PROFIT))
                        .withAverageSalary(set.getDouble(PROJECT_AVERAGE_SALARY))
                        .withTerm(set.getDouble(PROJECT_TERM))
                        .withProfitability(set.getDouble(PROJECT_PROFITABILITY))
                        .build();
    }
}
