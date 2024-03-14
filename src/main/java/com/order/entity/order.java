package com.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class order {

    private TodayOrder todayOrder;

    private MonthlyOrder monthlyOrder;

    private TotalOrder totalOrder;
}
