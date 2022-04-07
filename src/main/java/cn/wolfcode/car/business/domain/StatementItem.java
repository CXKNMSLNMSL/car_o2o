package cn.wolfcode.car.business.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 结算单明细
 */
@Setter
@Getter
public class StatementItem {
    private Long id;

    private Long statementId;           //结算单ID

    private Long itemId;                //服务项明细ID

    private String itemName;           //服务项明细名称

    private BigDecimal itemPrice;      //服务项价格

    private Long itemQuantity;          //购买数量
}