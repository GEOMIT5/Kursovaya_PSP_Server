package org.work.dao.core;


import org.work.dao.core.impl.JdbcTemplate;


public class InitializerRepository {

    protected JdbcOperations jdbcTemplate;

    public InitializerRepository() {
        this.jdbcTemplate = new JdbcTemplate();
    }
}
