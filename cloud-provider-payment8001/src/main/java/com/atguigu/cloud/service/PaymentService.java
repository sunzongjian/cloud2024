package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface PaymentService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);
    public Pay getById(Integer id);
    public List<Pay> getAll();

}
