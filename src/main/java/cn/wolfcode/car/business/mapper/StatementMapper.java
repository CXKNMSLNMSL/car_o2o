package cn.wolfcode.car.business.mapper;

import cn.wolfcode.car.business.domain.Statement;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface StatementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Statement record);

    Statement selectByPrimaryKey(Long id);

    List<Statement> selectAll();

    int updateByPrimaryKey(Statement record);


    Statement selectByAppointmentId(Long appointmentId);

    void updateAmount(@Param("statementId") Long statementId,
                      @Param("totalAmount")BigDecimal totalAmount,
                      @Param("totalQuantity")BigDecimal totalQuantity,
                      @Param("price") BigDecimal price);

    void updatePay(Statement statement);
}