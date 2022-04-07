package cn.wolfcode.car.base.query;

import cn.wolfcode.car.common.base.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerQuery extends QueryObject {

    private String name;
    private String phone;

}
