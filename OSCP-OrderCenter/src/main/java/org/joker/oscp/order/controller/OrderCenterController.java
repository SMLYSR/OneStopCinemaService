package org.joker.oscp.order.controller;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.extern.slf4j.Slf4j;
import org.joker.oscp.common.CommonResult;
import org.joker.oscp.system.api.order.OrderCenterApi;
import org.joker.oscp.system.api.order.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单中心控制器
 * <p>将OrderCenterApi中的接口全部暴露出来</p>
 * <p>并在Gateway集中聚合调用</p>
 * @author JOKER
 */
@Slf4j
@RestController
public class OrderCenterController {

    private OrderCenterApi orderCenterApi;

    @Autowired
    public OrderCenterController(OrderCenterApi orderCenterApi) {
        this.orderCenterApi = orderCenterApi;
    }

    @PostMapping(value = "/isTrueSeats")
    public boolean isTrueSeats(@RequestParam(value = "fieldId") Long fieldId,
                               @RequestParam(value = "seats")String seats) {
        return orderCenterApi.isTrueSeats(fieldId,seats);
    }

    @PostMapping(value = "/isNotSoldSeats")
    public boolean isNotSoldSeats(@RequestParam(value = "fieldId")Long fieldId,
                                  @RequestParam(value = "seats")String seats) {
        return orderCenterApi.isNotSoldSeats(fieldId, seats);
    }

    @PostMapping(value = "/saveOrderInfo")
    public OrderVO saveOrderInfo(@RequestParam(value = "fieldId")Long fieldId,
                                 @RequestParam(value = "soldSeats")String soldSeats,
                                 @RequestParam(value = "seatsName")String seatsName,
                                 @RequestParam(value = "userId")Long userId) {
        return orderCenterApi.saveOrderInfo(fieldId, soldSeats, seatsName, userId);
    }

    @PostMapping(value = "/getOrderByUserId")
    public Page<OrderVO> getOrderByUserId(@RequestParam(value = "userId")Long userId,
                                          @RequestParam(value = "userId")Page<OrderVO> page) {
        return orderCenterApi.getOrderByUserId(userId, page);
    }

}
