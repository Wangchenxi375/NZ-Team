package com.qf.service;

import com.qf.dto.ResultBean;

public interface IcartService {
    ResultBean addProduct(String uuid, Long productId, int count);

    ResultBean clean(String uuid);

    ResultBean update(String uuid, Long productId, int count);

    ResultBean showCart(String uuid);

    ResultBean merge(String uuid, String userId);
}
