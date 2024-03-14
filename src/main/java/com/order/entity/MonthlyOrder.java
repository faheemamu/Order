package com.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyOrder {

    private long monthlyTotal;

    private long monthlyPurchase;

    private long monthlyRedemption;
}
