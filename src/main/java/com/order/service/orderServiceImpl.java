package com.order.service;

import com.order.entity.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class orderServiceImpl implements orderServiceI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public order getCount() {

        String sqlQuery = "SELECT COUNT(*) AS total_orders, " +
                "SUM(CASE WHEN transaction_type = 'P' THEN 1 ELSE 0 END) AS total_purchase, " +
                "SUM(CASE WHEN transaction_type = 'R' THEN 1 ELSE 0 END) AS total_redemption, " +
                "SUM(CASE WHEN DATE_FORMAT(order_date, '%Y-%m') = DATE_FORMAT(NOW(), '%Y-%m') THEN 1 ELSE 0 END) AS monthly, " +
                "SUM(CASE WHEN DATE_FORMAT(order_date, '%Y-%m') = DATE_FORMAT(NOW(), '%Y-%m') AND transaction_type = 'P' THEN 1 ELSE 0 END) AS monthly_purchase, " +
                "SUM(CASE WHEN DATE_FORMAT(order_date, '%Y-%m') = DATE_FORMAT(NOW(), '%Y-%m') AND transaction_type = 'R' THEN 1 ELSE 0 END) AS monthly_redemption, " +
                "SUM(CASE WHEN DATE(order_date) = CURDATE() THEN 1 ELSE 0 END) AS today, " +
                "SUM(CASE WHEN DATE(order_date) = CURDATE() AND transaction_type = 'P' THEN 1 ELSE 0 END) AS today_purchase, " +
                "SUM(CASE WHEN DATE(order_date) = CURDATE() AND transaction_type = 'R' THEN 1 ELSE 0 END) AS today_redemption " +
                "FROM order_dtl";

        order order = jdbcTemplate.queryForObject(sqlQuery, new OrderRowMapper());

        return order;
    }
}
