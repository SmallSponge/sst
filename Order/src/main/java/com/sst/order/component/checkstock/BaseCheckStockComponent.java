package com.sst.order.component.checkstock;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sst.context.OrderProcessContext;
import com.sst.entity.product.ProductEntity;
import com.sst.exception.CommonBizException;
import com.sst.exception.ExpCodeEnum;
import com.sst.facade.product.ProductService;
import com.sst.order.component.BaseComponent;
import com.sst.req.order.OrderInsertReq;

import java.util.Map;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/7 下午1:17
 * @description 库存校验组件
 */
public class BaseCheckStockComponent extends BaseComponent {

    @Reference(version = "1.0.0")
    private ProductService productService;

    @Override
    public void handle(OrderProcessContext orderProcessContext) {
        preHandle(orderProcessContext);

        // 获取产品Entity的Map
        OrderInsertReq orderInsertReq = (OrderInsertReq) orderProcessContext.getOrderProcessReq().getReqData();
        Map<ProductEntity ,Integer> prodEntityCountMap = orderInsertReq.getProdEntityCountMap();

        // 检查库存
        checkStock(prodEntityCountMap);

        afterHandle(orderProcessContext);
    }

    /**
     * 校验库存是否足够
     * @param prodEntityCountMap 产品-购买数量 集合
     */
    private void checkStock(Map<ProductEntity, Integer> prodEntityCountMap) {
        // 校验库存
        for (ProductEntity productEntity : prodEntityCountMap.keySet()) {
            // 获取购买量
            Integer count = prodEntityCountMap.get(productEntity);
            // 校验
            if (productEntity.getStock() < count) {
                throw new CommonBizException(ExpCodeEnum.STOCK_LOW);
            }
        }
    }

}
