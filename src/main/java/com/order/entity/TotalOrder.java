package com.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalOrder {
    private long totalOrder;

    private long totalPurchase;

    private long totalRedemption;
}
