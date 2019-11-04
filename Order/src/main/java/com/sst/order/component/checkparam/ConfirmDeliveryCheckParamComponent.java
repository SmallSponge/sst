package com.sst.order.component.checkparam;

import com.sst.context.OrderProcessContext;
import com.sst.exception.ExpCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/10 下午5:30
 * @description
 */
@Component
public class ConfirmDeliveryCheckParamComponent extends BaseCheckParamComponent {
    @Override
    protected void privateParamCheck(OrderProcessContext orderProcessContext) {
        // 物流单号不能为空
        checkParam(orderProcessContext.getOrderProcessReq().getReqData()+"", ExpCodeEnum.EXPRESS_NO_NULL);
    }
}
