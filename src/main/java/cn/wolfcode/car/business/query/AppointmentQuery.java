package cn.wolfcode.car.business.query;

import cn.wolfcode.car.common.base.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppointmentQuery extends QueryObject {
    //客户名称
    private String customerName;
    //客户手机
    private String customerPhone;
    //状态
    private Integer status;

}
