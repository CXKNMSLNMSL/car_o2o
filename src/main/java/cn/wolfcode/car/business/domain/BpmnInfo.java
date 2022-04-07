package cn.wolfcode.car.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/**
 * 流程定义
 */
@Setter
@Getter
public class BpmnInfo {
    private Long id;

    private String bpmnName;            //流程(图)名称

    private String bpmnType;             //流程(图)类型

    private String deploymentId;         //流程部署id

    private String actProcessId;         //activity流程定义生成的主键

    private String actProcessKey;        //activity流程定义生成的key

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date deployTime;             //部署时间

    private String info;                 //描述信息

}