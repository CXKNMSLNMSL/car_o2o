package cn.wolfcode.car.business.mapper;

import cn.wolfcode.car.business.domain.Appointment;
import cn.wolfcode.car.business.query.AppointmentQuery;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AppointmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Appointment record);

    Appointment selectByPrimaryKey(Long id);

    List<Appointment> selectAll();

    int updateByPrimaryKey(Appointment record);

    List<Appointment> selectForList(AppointmentQuery qo);

    void changeStatus(@Param("aId")Long id, @Param("status")Integer status);

    void updateArrical(@Param("aId")Long id, @Param("status")Integer status,
                       @Param("time")Date date);

    void renewal(@Param("date")Date date,
                 @Param("statusAppointment")Integer statusAppointment,
                         @Param("statusOvertime")Integer statusOvertime);
}