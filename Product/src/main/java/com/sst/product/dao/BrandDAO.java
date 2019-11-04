package com.sst.product.dao;

import com.sst.entity.product.BrandEntity;
import com.sst.req.product.BrandInsertReq;
import com.sst.req.product.BrandQueryReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by lihang on 2017/11/5.
 */
@Mapper
public interface BrandDAO {
    /**
     * 新增品牌
     * @param brandInsertReq
     * @return
     */
    int createBrand(BrandInsertReq brandInsertReq);

    /**
     * 增量更新品牌
     * @param brandInsertReq
     */
    int updateBrand(BrandInsertReq brandInsertReq);


    /**
     * 查询所有品牌（支持分页）
     * @param brandQueryReq
     * @return
     */
    List<BrandEntity> findBrands(BrandQueryReq brandQueryReq);
}
