package com.lq.laboratory.util;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.LaboratoryType;
import com.lq.laboratory.entity.User;

import java.util.List;
import java.util.function.Consumer;

public class DeleteUtil {

    public static void releaseLaboratory(List<Laboratory> laboratoryList) {
        laboratoryList.forEach(laboratory -> deleteLaboratory(laboratory, null));
    }

    public static void releaseLaboratory(List<Laboratory> laboratoryList, Consumer<Laboratory> consumer) {
        laboratoryList.forEach(laboratory -> deleteLaboratory(laboratory, consumer));
    }

    public static void deleteLaboratoryType(LaboratoryType type) {
        List<Laboratory> laboratoryList = type.getLaboratoryList();
        releaseLaboratory(laboratoryList);
        type.getLaboratoryList().clear();
    }

    //实验室删除，解除Comment , Appointment ， User的关系
    private static void deleteLaboratory(Laboratory laboratory, Consumer<Laboratory> consumer) {
        if (consumer != null) consumer.accept(laboratory);
        laboratory.setUser(null);
        laboratory.getAppointmentList().stream().forEach(ap -> {
            ap.setLaboratory(null);
            ap.setUser(null);
        });
        laboratory.getCommentList().stream().forEach(cm -> {
            User user = cm.getUser();
            user.getCommentList().remove(cm);
            cm.setLaboratory(null);
            cm.setUser(null);
        });
        laboratory.getAppointmentList().clear();
        laboratory.getCommentList().clear();
    }

    //实验室删除，解除Comment , Appointment ， User的关系
    public static void deleteLaboratory(Laboratory laboratory) {
        deleteLaboratory(laboratory, null);
    }

    public static void releaseAppointment(Appointment one) {
        one.getUser().getAppointmentList().remove(one);
        one.setUser(null);
        one.getLaboratory().getAppointmentList().remove(one);
        one.setLaboratory(null);
    }
}
