package cn.wolfcode.car.business.mapper;

import cn.wolfcode.car.business.domain.CarPackageAudit;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface CarPackageAuditMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CarPackageAudit record);

    CarPackageAudit selectByPrimaryKey(Long id);

    List<CarPackageAudit> selectAll();

    int updateByPrimaryKey(CarPackageAudit record);

    void updateInstanceId(@Param("id") Long id, @Param("instanceId")String instanceId);


    void changeStatus(@Param("id")Long id, @Param("status")Integer status);
}