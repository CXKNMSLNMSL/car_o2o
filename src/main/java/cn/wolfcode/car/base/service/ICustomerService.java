package cn.wolfcode.car.base.service;

import cn.wolfcode.car.base.domain.Customer;
import cn.wolfcode.car.base.query.CustomerQuery;
import cn.wolfcode.car.common.base.page.TablePageInfo;

import java.util.List;

/**
 * 客户服务接口
 */
public interface ICustomerService {

    /**
     * 分页
     * @param qo
     * @return
     */
    TablePageInfo<Customer> query(CustomerQuery qo);


    /**
     * 查单个
     * @param id
     * @return
     */
    Customer get(Long id);


    /**
     * 保存
     * @param customer
     */
    void save(Customer customer);

  
    /**
     * 更新
     * @param customer
     */
    void update(Customer customer);

    /**
     *  批量删除
     * @param ids
     */
    void deleteBatch(String ids);

    /**
     * 查询全部
     * @return
     */
    List<Customer> list();


}
