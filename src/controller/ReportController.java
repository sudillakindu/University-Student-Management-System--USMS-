package controller;

import model.ReportModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportController {
    private ReportModel reportModel;

    public ReportController() {
        this.reportModel = new ReportModel();
    }

    public List<Map<String, ?>> getAttendanceSummaryReport() {
        List<Map<String, ?>> dataSource = new ArrayList<>();
        for (ReportModel.AttendanceRecord record : reportModel.findAttendanceRecords()) {
            Map<String, Object> m = new HashMap<>();
            m.put("studentID", record.getStudentID());
            m.put("studentName", record.getStudentName());
            m.put("attendanceDate", record.getAttendanceDate());
            m.put("status", record.getStatus());
            dataSource.add(m);
        }
        return dataSource;
    }
}

