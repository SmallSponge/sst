package com.sst.order.component.changestate;

import com.sst.enumeration.order.OrderStateEnum;
import org.springframework.stereotype.Component;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/13 上午8:55
 * @description
 */
@Component
public class FinishedChangeStateComponent extends BaseChangeStateComponent {
    @Override
    public void setTargetOrderState() {
        this.targetOrderState = OrderStateEnum.FINISHED;
    }
}