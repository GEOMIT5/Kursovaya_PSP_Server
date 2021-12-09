package org.work.dao.impl.project;

final class ProjectSqlUtil {

    private ProjectSqlUtil() {

    }


    static final String ADD_NEW_PROJECT =
            "INSERT INTO projects (project_id, segment_id, mark_status_id, name, head, human_amount, " +
                    " average_salary, profit, term, profitability) " +
                    " VALUES (uuid(), ? ,  ?,  ?,  ?,  ?, ?, ?, ?, ?);";

    static final String UPDATE_PROJECT =
            "update projects set segment_id=? ,mark_status_id=?, " +
                    " name =? , head =?, human_amount=?, " +
                    " average_salary=?, profit=?, term=?, profitability= ? " +
                    " where project_id=?";

    static final String REMOVE_PROJECT_BY_ID =
            "delete from projects where project_id=?";

    static final String GET_ALL_PROJECT =
            " select p.project_id, " +
                    "s.segment_id, s.segment_name, " +
                    " p.mark_status_id, " +
                    " p.name, p.head, p.human_amount, p.average_salary, " +
                    " p.profit, p.term, p.profitability " +
                    " from projects p " +
                    " inner join segments s " +
                    " on s.segment_id = p.segment_id ";

    static final String GET_PROJECT_BY_ID =
            " select p.project_id, " +
                    "s.segment_id, s.segment_name, " +
                    " p.mark_status_id, " +
                    " p.name, p.head, p.human_amount, p.average_salary, " +
                    " p.profit, p.term, p.profitability " +
                    " from projects p " +
                    " inner join segments s " +
                    " on s.segment_id = p.segment_id " +
                    " where p.project_id = ? ";


    static final String GET_ALL_MARKED_PROJECT =
            " select p.project_id, " +
                    "s.segment_id, s.segment_name, " +
                    " p.mark_status_id, " +
                    " p.name, p.head, p.human_amount, p.average_salary, " +
                    " p.profit, p.term, p.profitability " +
                    " from projects p " +
                    " inner join segments s " +
                    " on s.segment_id = p.segment_id " +
                    " WHERE p.mark_status_id != 4";

    static final String GET_ALL_NOT_MARKED_PROJECT =
            " select p.project_id, " +
                    "s.segment_id, s.segment_name, " +
                    " p.mark_status_id, " +
                    " p.name, p.head, p.human_amount, p.average_salary, " +
                    " p.profit, p.term, p.profitability " +
                    " from projects p " +
                    " inner join segments s " +
                    " on s.segment_id = p.segment_id " +
                    " WHERE p.mark_status_id = 4";
}
