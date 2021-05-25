package com.google.firebase.crashlytics.internal.report.model;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Map;
public class NativeSessionReport implements Report {
    public final File a;

    public NativeSessionReport(File file) {
        this.a = file;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Map<String, String> getCustomHeaders() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public File getFile() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public String getFileName() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public File[] getFiles() {
        return this.a.listFiles();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public String getIdentifier() {
        return this.a.getName();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Report.Type getType() {
        return Report.Type.NATIVE;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public void remove() {
        File[] files = getFiles();
        for (File file : files) {
            Logger logger = Logger.getLogger();
            StringBuilder L = a.L("Removing native report file at ");
            L.append(file.getPath());
            logger.d(L.toString());
            file.delete();
        }
        Logger logger2 = Logger.getLogger();
        StringBuilder L2 = a.L("Removing native report directory at ");
        L2.append(this.a);
        logger2.d(L2.toString());
        this.a.delete();
    }
}
