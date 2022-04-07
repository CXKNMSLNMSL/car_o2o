package cn.wolfcode.car.base.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private Long id;
    private String name;
    private String phone;
    private Integer age;

}