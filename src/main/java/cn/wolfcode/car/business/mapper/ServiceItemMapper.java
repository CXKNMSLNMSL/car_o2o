package cn.wolfcode.car.business.mapper;

import cn.wolfcode.car.business.domain.ServiceItem;
import cn.wolfcode.car.business.query.ServiceItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceItem record);

    ServiceItem selectByPrimaryKey(Long id);

    List<ServiceItem> selectAll();

    int updateByPrimaryKey(ServiceItem record);


    void changeSaleStatus(@Param("itemId")Long id, @Param("saleStatus")Integer saleStatus);

    void changeAuditStatus(@Param("itemId")Long id, @Param("auditStatus")Integer auditStatus);

    List<ServiceItem> selectForList(ServiceItemQuery qo);
}