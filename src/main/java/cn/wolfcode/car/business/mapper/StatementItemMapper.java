package cn.wolfcode.car.business.mapper;

import cn.wolfcode.car.business.domain.StatementItem;

import java.util.List;

public interface StatementItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatementItem record);

    StatementItem selectByPrimaryKey(Long id);

    List<StatementItem> selectAll();

    int updateByPrimaryKey(StatementItem record);


    List<StatementItem> selectByStatementId(Long statementId);

    void deleteByStatementId(Long statementId);
}