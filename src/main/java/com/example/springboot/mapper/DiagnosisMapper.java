package com.example.springboot.mapper;

import com.example.springboot.entity.Diagnosis;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2023-04-24
 */
public interface DiagnosisMapper extends BaseMapper<Diagnosis> {

    @Select("select * from diagnosis where appointment_id = #{appointmentId}")
    Diagnosis findByAppointment(@Param("appointmentId") String appointmentId);
}
