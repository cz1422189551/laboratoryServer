package com.lq.laboratory.util;

import com.lq.laboratory.entity.Laboratory;

import java.util.List;

public class DeleteUtil {

    public static void releaseLaboratory(List<Laboratory> laboratoryList) {
        laboratoryList.forEach(laboratory -> deleteLaboratory(laboratory));
    }

    public static void deleteLaboratory(Laboratory laboratory) {
        laboratory.setUser(null);
        laboratory.getAppointmentList().stream().forEach(ap -> {
            ap.setLaboratory(null);
            ap.setUser(null);
        });
        laboratory.getCommentList().stream().forEach(cm -> {
            cm.setLaboratory(null);
            cm.setUser(null);
        });
        laboratory.getAppointmentList().clear();
        laboratory.getCommentList().clear();
    }


    public static void deleteLaboratory2(Laboratory laboratory) {
        laboratory.setUser(null);
        laboratory.getAppointmentList().stream().forEach(ap -> {
            ap.setLaboratory(null);
            ap.setUser(null);
        });
        laboratory.getCommentList().stream().forEach(cm -> {
            cm.setLaboratory(null);
            cm.setUser(null);
        });
        laboratory.getAppointmentList().clear();
        laboratory.getCommentList().clear();
    }
}
