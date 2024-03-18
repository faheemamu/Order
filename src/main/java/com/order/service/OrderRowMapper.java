package com.order.service;
//comment by faheem
import com.order.entity.MonthlyOrder;
import com.order.entity.TodayOrder;
import com.order.entity.TotalOrder;
import com.order.entity.order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<order> {

    @Override
    public order mapRow(ResultSet rs, int rowNum) throws SQLException {

        order orders = new order();
        TodayOrder todayOrder = new TodayOrder();
        todayOrder.setTodayTotal(rs.getLong("today"));
        todayOrder.setTodayPurchase(rs.getLong("today_purchase"));
        todayOrder.setTodayRedemption(rs.getLong("today_redemption"));

        orders.setTodayOrder(todayOrder);

        MonthlyOrder monthlyOrder = new MonthlyOrder();
        monthlyOrder.setMonthlyTotal(rs.getLong("monthly"));
        monthlyOrder.setMonthlyPurchase(rs.getLong("monthly_purchase"));
        monthlyOrder.setMonthlyRedemption(rs.getLong("monthly_redemption"));
        orders.setMonthlyOrder(monthlyOrder);

        TotalOrder totalOrder = new TotalOrder();
        totalOrder.setTotalOrder(rs.getLong("total_orders"));
        totalOrder.setTotalPurchase(rs.getLong("total_purchase"));
        totalOrder.setTotalRedemption(rs.getLong("total_redemption"));

        orders.setTotalOrder(totalOrder);
        return orders;
    }
}
