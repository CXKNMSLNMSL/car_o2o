package cn.wolfcode.car.base.service.impl;

import cn.wolfcode.car.base.domain.Customer;
import cn.wolfcode.car.base.mapper.CustomerMapper;
import cn.wolfcode.car.base.query.CustomerQuery;
import cn.wolfcode.car.base.service.ICustomerService;
import cn.wolfcode.car.common.base.page.TablePageInfo;
import cn.wolfcode.car.common.util.Convert;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public TablePageInfo<Customer> query(CustomerQuery qo) {
        PageHelper.startPage(qo.getPageNum(), qo.getPageSize());
        return new TablePageInfo<Customer>(customerMapper.selectForList(qo));
    }


    @Override
    public void save(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public Customer get(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }


    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public void deleteBatch(String ids) {
        Long[] dictIds = Convert.toLongArray(ids);
        for (Long dictId : dictIds) {
            customerMapper.deleteByPrimaryKey(dictId);
        }
    }

    @Override
    public List<Customer> list() {
        return customerMapper.selectAll();
    }


}
