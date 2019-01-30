package com.lq.laboratory.config;

import com.lq.laboratory.task.StartAppointmentCheckTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 启动时候 ： 检查状态
 */
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        StartAppointmentCheckTask task = applicationContext.getBean(StartAppointmentCheckTask.class);
        if (event.getApplicationContext().getParent() == null) {
            //只有root application context 没有父容器。
            new Thread(task).start();
        }
    }
}
