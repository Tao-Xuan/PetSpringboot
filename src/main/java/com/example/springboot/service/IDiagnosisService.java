package com.example.springboot.service;

import com.example.springboot.entity.Diagnosis;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-04-24
 */
@Component
public interface IDiagnosisService extends IService<Diagnosis> {

    /**
     * 根据预约号查找诊断记录
     * @param appointmentId
     * @return
     */
    public Diagnosis findByAppointment(String appointmentId);
}
