package com.example.demo.mapper;

import com.example.demo.po.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


@Mapper
public interface ProductMapper {

    //获取所有商品
    ArrayList<ProductPo> selectProductAll();

    //根据id修改商品数量
    int updateProduct(@Param("id") int id, @Param("quantity") String quantity);

    //根据id查询商品对象
    ProductPo selectProduct(int id);

}
