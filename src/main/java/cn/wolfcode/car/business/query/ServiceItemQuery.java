package cn.wolfcode.car.business.query;

import cn.wolfcode.car.common.base.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceItemQuery  extends QueryObject {


    private  String customerName;
    private String customerPhone;

    private Integer status;

}
