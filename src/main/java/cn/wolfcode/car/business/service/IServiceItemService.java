package cn.wolfcode.car.business.service;

import cn.wolfcode.car.business.domain.ServiceItem;
import cn.wolfcode.car.business.query.ServiceItemQuery;
import cn.wolfcode.car.common.base.page.TablePageInfo;

import java.util.List;

/**
 * 预约单项服务接口
 */
public interface IServiceItemService {

    /**
     * 分页
     * @param qo
     * @return
     */
    TablePageInfo<ServiceItem> query(ServiceItemQuery qo);


    /**
     * 查单个
     * @param id
     * @return
     */
    ServiceItem get(Long id);


    /**
     * 保存
     * @param ServiceItem
     */
    void save(ServiceItem ServiceItem);

  
    /**
     * 更新
     * @param ServiceItem
     */
    void update(ServiceItem ServiceItem);

    /**
     *  批量删除
     * @param ids
     */
    void deleteBatch(String ids);

    /**
     * 查询全部
     * @return
     */
    List<ServiceItem> list();

    /**
     * 取消预约单
     * @param id
     */
    void cancel(Long id);

    /**
     * 到店
     * @param id
     */
    void arrival(Long id);

    /**
     * 修改状态
     * @param ServiceItemId
     * @param statusSettle
     */
    void changeStatus(Long ServiceItemId, Integer statusSettle);

    void renewal();

}
