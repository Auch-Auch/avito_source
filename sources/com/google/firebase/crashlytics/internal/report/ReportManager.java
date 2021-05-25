package com.google.firebase.crashlytics.internal.report;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.NativeSessionReport;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
public class ReportManager {
    public final ReportUploader.ReportFilesProvider a;

    public ReportManager(ReportUploader.ReportFilesProvider reportFilesProvider) {
        this.a = reportFilesProvider;
    }

    public boolean areReportsAvailable() {
        File[] completeSessionFiles = this.a.getCompleteSessionFiles();
        File[] nativeReportFiles = this.a.getNativeReportFiles();
        if (completeSessionFiles != null && completeSessionFiles.length > 0) {
            return true;
        }
        if (nativeReportFiles == null || nativeReportFiles.length <= 0) {
            return false;
        }
        return true;
    }

    public void deleteReport(Report report) {
        report.remove();
    }

    public void deleteReports(List<Report> list) {
        for (Report report : list) {
            deleteReport(report);
        }
    }

    public List<Report> findReports() {
        Logger.getLogger().d("Checking for crash reports...");
        File[] completeSessionFiles = this.a.getCompleteSessionFiles();
        File[] nativeReportFiles = this.a.getNativeReportFiles();
        LinkedList linkedList = new LinkedList();
        if (completeSessionFiles != null) {
            for (File file : completeSessionFiles) {
                Logger logger = Logger.getLogger();
                StringBuilder L = a.L("Found crash report ");
                L.append(file.getPath());
                logger.d(L.toString());
                linkedList.add(new SessionReport(file));
            }
        }
        if (nativeReportFiles != null) {
            for (File file2 : nativeReportFiles) {
                linkedList.add(new NativeSessionReport(file2));
            }
        }
        if (linkedList.isEmpty()) {
            Logger.getLogger().d("No reports found.");
        }
        return linkedList;
    }
}
