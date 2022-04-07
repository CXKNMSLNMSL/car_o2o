package cn.wolfcode.car.business.mapper;

import cn.wolfcode.car.business.domain.BpmnInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BpmnInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BpmnInfo record);

    BpmnInfo selectByPrimaryKey(Long id);

    List<BpmnInfo> selectAll();

    int updateByPrimaryKey(BpmnInfo record);


    void updateInfo(@Param("id") Long id, @Param("info")String info);

    BpmnInfo selectByType(String type);
}