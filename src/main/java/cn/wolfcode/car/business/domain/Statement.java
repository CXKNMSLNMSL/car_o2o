package cn.wolfcode.car.business.domain;

import cn.wolfcode.car.base.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 结算单
 */
@Setter
@Getter
public class Statement {

    public static final Integer STATUS_CONSUME = 0;//消费中
    public static final Integer STATUS_PAID = 1;//已支付
    private static final long serialVersionUID = 1L;

    private Long id;

    private String customerName;                    //客户姓名

    private String customerPhone;                   //客户联系方式

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date actualArrivalTime;                 //实际到店时间

    private String licensePlate;                    //车牌号码

    private String carSeries;                       //汽车类型

    private Long serviceType;                       //服务类型【维修/保养】

    private Long appointmentId;                     //预约单ID【通过这个来判断是否预约用户,唯一标识】

    private Integer status = STATUS_CONSUME;        //结算状态【消费中0/已支付1】

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payTime;                           //收款时间

    private Long payeeId;                           //收款人id

    private User payee;                             //收款人对象

    private BigDecimal totalAmount = new BigDecimal("0.00");        //总消费金额

    private BigDecimal totalQuantity= new BigDecimal("0");;         //服务项数量

    private BigDecimal discountAmount = new BigDecimal("0.00");     //折扣金额

    private Date createTime;                        //创建时间

    private String info;                            //备注信息
}