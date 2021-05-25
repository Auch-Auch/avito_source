package com.google.firebase.crashlytics.internal.report.model;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class SessionReport implements Report {
    public final File a;
    public final File[] b;
    public final Map<String, String> c;

    public SessionReport(File file) {
        this(file, Collections.emptyMap());
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Map<String, String> getCustomHeaders() {
        return Collections.unmodifiableMap(this.c);
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public File getFile() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public String getFileName() {
        return getFile().getName();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public File[] getFiles() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public String getIdentifier() {
        String fileName = getFileName();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Report.Type getType() {
        return Report.Type.JAVA;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public void remove() {
        Logger logger = Logger.getLogger();
        StringBuilder L = a.L("Removing report at ");
        L.append(this.a.getPath());
        logger.d(L.toString());
        this.a.delete();
    }

    public SessionReport(File file, Map<String, String> map) {
        this.a = file;
        this.b = new File[]{file};
        this.c = new HashMap(map);
    }
}
