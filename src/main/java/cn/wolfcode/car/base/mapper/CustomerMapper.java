package cn.wolfcode.car.base.mapper;

import cn.wolfcode.car.base.domain.Customer;
import cn.wolfcode.car.base.query.CustomerQuery;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    Customer selectByPrimaryKey(Long id);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);

    List<Customer> selectForList(CustomerQuery qo);
}