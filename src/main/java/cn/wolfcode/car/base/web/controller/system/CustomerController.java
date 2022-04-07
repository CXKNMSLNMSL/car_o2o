package cn.wolfcode.car.base.web.controller.system;


import cn.wolfcode.car.base.domain.Customer;
import cn.wolfcode.car.base.query.CustomerQuery;
import cn.wolfcode.car.base.service.ICustomerService;
import cn.wolfcode.car.common.base.page.TablePageInfo;
import cn.wolfcode.car.common.web.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户控制器
 */
@Controller
@RequestMapping("system/customer")
public class CustomerController {
    //模板前缀
    private static final String prefix = "base/system/customer/";

    @Autowired
    private ICustomerService customerService;

    //页面------------------------------------------------------------
    //列表
    @RequiresPermissions("system:customer:view")
    @RequestMapping("/listPage")
    public String listPage(){
        return prefix + "list";
    }

    @RequiresPermissions("system:customer:add")
    @RequestMapping("/addPage")
    public String addPage(){
        return prefix + "add";
    }


    @RequiresPermissions("system:customer:edit")
    @RequestMapping("/editPage")
    public String editPage(Long id, Model model){
        model.addAttribute("customer", customerService.get(id));
        return prefix + "edit";
    }

    //数据-----------------------------------------------------------
    //列表
    @RequiresPermissions("system:customer:list")
    @RequestMapping("/query")
    @ResponseBody
    public TablePageInfo<Customer> query(CustomerQuery qo){
        return customerService.query(qo);
    }

    //新增
    @RequiresPermissions("system:customer:add")
    @RequestMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Customer customer){
        customerService.save(customer);
        return AjaxResult.success();
    }

    //编辑
    @RequiresPermissions("system:customer:edit")
    @RequestMapping("/edit")
    @ResponseBody
    public AjaxResult edit(Customer customer){
        customerService.update(customer);
        return AjaxResult.success();
    }

    //删除
    @RequiresPermissions("system:customer:remove")
    @RequestMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids){
        customerService.deleteBatch(ids);
        return AjaxResult.success();
    }

}
