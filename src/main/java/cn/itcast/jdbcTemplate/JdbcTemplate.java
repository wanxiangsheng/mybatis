package cn.itcast.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplate {
    public static void main(String[] args) {


        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql///maven");
        ds.setUsername("root");
        ds.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

    }
}
