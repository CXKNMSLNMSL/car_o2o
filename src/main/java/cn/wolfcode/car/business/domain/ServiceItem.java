package cn.wolfcode.car.business.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 服务单项
 */
@Setter
@Getter
public class ServiceItem {
    private static final long serialVersionUID = 1L;
    public static final Integer CARPACKAGE_NO = 0;//不是套餐
    public static final Integer CARPACKAGE_YES = 1;//是套餐

    public static final Integer AUDITSTATUS_INIT = 0;//初始化
    public static final Integer AUDITSTATUS_AUDITING = 1;//审核中
    public static final Integer AUDITSTATUS_APPROVED = 2;//审核通过
    public static final Integer AUDITSTATUS_REPLY = 3;//重新调整
    public static final Integer AUDITSTATUS_NO_REQUIRED = 4;//无需审核
    public static final Integer SALESTATUS_OFF = 0;//下架
    public static final Integer SALESTATUS_ON = 1;//上架
    private Long id;

    private String name;                //服务项名称

    private BigDecimal originalPrice;    //服务项原价

    private BigDecimal discountPrice;    //服务项折扣价

    private int carPackage;          //是否套餐【是/否】

    private String info;                 //备注信息

    private Date createTime;             //创建时间

    private Integer serviceCatalog;      //服务分类【维修/保养/其他】

    private Integer auditStatus = AUDITSTATUS_NO_REQUIRED;       //审核状态【初始化/审核中/审核通过/审核拒绝/无需审核】

    private Integer saleStatus = SALESTATUS_OFF;                 //上架状态【已上架/未上架】

    private Long version = 0L;           //版本号
}