package cn.wolfcode.car.business.web.controller;


import cn.wolfcode.car.business.domain.ServiceItem;
import cn.wolfcode.car.business.query.ServiceItemQuery;
import cn.wolfcode.car.business.service.IServiceItemService;
import cn.wolfcode.car.common.base.page.TablePageInfo;
import cn.wolfcode.car.common.web.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 预约控制器
 */
@Controller
@RequestMapping("business/serviceItem")
public class ServiceItemController {
    //模板前缀
    private static final String prefix = "business/serviceItem/";

    @Autowired
    private IServiceItemService serviceItemService;
    @Autowired

    //页面------------------------------------------------------------
    //列表
    @RequiresPermissions("system:serviceItem:view")
    @RequestMapping("/listPage")
    public String listPage(){
        return prefix + "list";
    }

    @RequiresPermissions("system:serviceItem:add")
    @RequestMapping("/addPage")
    public String addPage(){
        return prefix + "add";
    }


    @RequiresPermissions("system:serviceItem:edit")
    @RequestMapping("/editPage")
    public String editPage(Long id, Model model){
        model.addAttribute("serviceItem", serviceItemService.get(id));
        return prefix + "edit";
    }

    //数据-----------------------------------------------------------
    //列表
    @RequiresPermissions("system:serviceItem:list")
    @RequestMapping("/query")
    @ResponseBody
    public TablePageInfo<ServiceItem> query(ServiceItemQuery qo){
        serviceItemService.renewal();
        return serviceItemService.query(qo);
    }

    //新增
    @RequiresPermissions("system:serviceItem:add")
    @RequestMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ServiceItem serviceItem){
        serviceItemService.save(serviceItem);
        return AjaxResult.success();
    }

    //编辑
    @RequiresPermissions("system:serviceItem:edit")
    @RequestMapping("/edit")
    @ResponseBody
    public AjaxResult edit(ServiceItem serviceItem){
        serviceItemService.update(serviceItem);
        return AjaxResult.success();
    }

    //删除
    @RequiresPermissions("system:serviceItem:remove")
    @RequestMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids){
        serviceItemService.deleteBatch(ids);
        return AjaxResult.success();
    }


    //取消-cancel
    @RequiresPermissions("system:serviceItem:cancel")
    @RequestMapping("/cancel")
    @ResponseBody
    public AjaxResult cancel(Long id){
        serviceItemService.cancel(id);
        return AjaxResult.success();
    }

    //到店-arrival
    @RequiresPermissions("system:serviceItem:arrival")
    @RequestMapping("/arrival")
    @ResponseBody
    public AjaxResult  arrival(Long id){
        serviceItemService.arrival(id);
        return AjaxResult.success();
    }

    //预约单转结算单
    @RequiresPermissions("system:serviceItem:generateStatement")
    @RequestMapping("/generateStatement")
    @ResponseBody
    public AjaxResult  generateStatement(Long serviceItemId){
        return null;
    }



}
