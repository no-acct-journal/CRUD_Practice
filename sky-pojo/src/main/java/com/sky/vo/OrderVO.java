package com.sky.vo;

import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO extends Orders {

    //订单菜品信息
    private String orderDishes;

    //菜品/套餐总份数
    private Integer totalItems;

    //订单详情
    private List<OrderDetail> orderDetailList;

}
