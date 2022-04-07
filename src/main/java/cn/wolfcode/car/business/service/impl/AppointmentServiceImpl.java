package cn.wolfcode.car.business.service.impl;


import cn.wolfcode.car.business.domain.Appointment;
import cn.wolfcode.car.business.mapper.AppointmentMapper;
import cn.wolfcode.car.business.query.AppointmentQuery;
import cn.wolfcode.car.business.service.IAppointmentService;
import cn.wolfcode.car.common.base.page.TablePageInfo;
import cn.wolfcode.car.common.exception.BusinessException;
import cn.wolfcode.car.common.util.Convert;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;


    @Override
    public TablePageInfo<Appointment> query(AppointmentQuery qo) {
        PageHelper.startPage(qo.getPageNum(), qo.getPageSize());
        return new TablePageInfo<Appointment>(appointmentMapper.selectForList(qo));
    }


    @Override
    public void save(Appointment appointment) {
        //创建时间
        appointment.setCreateTime(new Date());
        //默认状态
        appointment.setStatus(Appointment.STATUS_APPOINTMENT);
        appointmentMapper.insert(appointment);
    }



    @Override
    public Appointment get(Long id) {
        return appointmentMapper.selectByPrimaryKey(id);
    }


    @Override
    public void update(Appointment appointment) {
        //更新时考虑参数是否丢失问题
        //使用修改sql语句， 不添加可丢失那个列
        //考虑是否允许更新
        //只有在状态只有在预约中才允许修改
        Appointment temp = this.get(appointment.getId());
        if(!Appointment.STATUS_APPOINTMENT.equals(temp.getStatus())){
            throw new BusinessException("预约单只有预约中状态时才允许修改");
        }
        appointmentMapper.updateByPrimaryKey(appointment);
    }

    @Override
    public void deleteBatch(String ids) {
        Long[] dictIds = Convert.toLongArray(ids);
        for (Long dictId : dictIds) {
            appointmentMapper.deleteByPrimaryKey(dictId);

            //如果使用是硬删除操作， 注意需要将后续的结算单中预约单id改为null
            //所以最佳操作， 建议使用软删除
        }
    }

    @Override
    public List<Appointment> list() {
        return appointmentMapper.selectAll();
    }

    @Override
    public void cancel(Long id) {
        //1:取消操作需要当前状态为预约中
        Appointment appointment = this.get(id);
        if(!Appointment.STATUS_APPOINTMENT.equals(appointment.getStatus())){
            throw new BusinessException("预约单只有预约中状态时才允许取消");
        }
        //2：结合需要发现只需要改动状态：用户取消
        appointmentMapper.changeStatus(id, Appointment.STATUS_CANCEL);
    }

    @Override
    public void arrival(Long id) {
        //1:预约单位预约状态才允许操作
        Appointment appointment = this.get(id);
        if(!Appointment.STATUS_APPOINTMENT.equals(appointment.getStatus())){
            throw new BusinessException("预约单只有预约中状态时才允许设置到店操作");
        }
        //2：将预约单状态该为到店操作
        //3:设置到店时间
        appointmentMapper.updateArrical(id, Appointment.STATUS_ARRIVAL, new Date());
    }

    @Override
    public void renewal() {
        Date date = new Date();

        appointmentMapper.renewal(date,Appointment.STATUS_APPOINTMENT,Appointment.STATUS_OVERTIME);
    }

    @Override
    public void changeStatus(Long appointmentId, Integer statusSettle) {
        appointmentMapper.changeStatus(appointmentId, statusSettle);
    }
}
