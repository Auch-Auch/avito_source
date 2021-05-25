package com.google.firebase.crashlytics.internal.report;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class ReportUploader {
    public static final short[] h = {10, 20, 30, 60, 120, 300};
    public final CreateReportSpiCall a;
    @Nullable
    public final String b;
    public final String c;
    public final DataTransportState d;
    public final ReportManager e;
    public final HandlingExceptionCheck f;
    public Thread g;

    public interface HandlingExceptionCheck {
        boolean isHandlingException();
    }

    public interface Provider {
        ReportUploader createReportUploader(@NonNull AppSettingsData appSettingsData);
    }

    public interface ReportFilesProvider {
        File[] getCompleteSessionFiles();

        File[] getNativeReportFiles();
    }

    public class a extends BackgroundPriorityRunnable {
        public final List<Report> a;
        public final boolean b;
        public final float c;

        public a(List<Report> list, boolean z, float f) {
            this.a = list;
            this.b = z;
            this.c = f;
        }

        public final void a(List<Report> list, boolean z) {
            Logger logger = Logger.getLogger();
            StringBuilder L = a2.b.a.a.a.L("Starting report processing in ");
            L.append(this.c);
            L.append(" second(s)...");
            logger.d(L.toString());
            float f = this.c;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (!ReportUploader.this.f.isHandlingException()) {
                int i = 0;
                while (list.size() > 0 && !ReportUploader.this.f.isHandlingException()) {
                    Logger logger2 = Logger.getLogger();
                    StringBuilder L2 = a2.b.a.a.a.L("Attempting to send ");
                    L2.append(list.size());
                    L2.append(" report(s)");
                    logger2.d(L2.toString());
                    ArrayList arrayList = new ArrayList();
                    for (Report report : list) {
                        if (!ReportUploader.this.uploadReport(report, z)) {
                            arrayList.add(report);
                        }
                    }
                    if (arrayList.size() > 0) {
                        short[] sArr = ReportUploader.h;
                        int i2 = i + 1;
                        long j = (long) sArr[Math.min(i, sArr.length - 1)];
                        Logger logger3 = Logger.getLogger();
                        logger3.d("Report submission: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    list = arrayList;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
        public void onRun() {
            try {
                a(this.a, this.b);
            } catch (Exception e) {
                Logger.getLogger().e("An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.g = null;
        }
    }

    public ReportUploader(@Nullable String str, String str2, DataTransportState dataTransportState, ReportManager reportManager, CreateReportSpiCall createReportSpiCall, HandlingExceptionCheck handlingExceptionCheck) {
        if (createReportSpiCall != null) {
            this.a = createReportSpiCall;
            this.b = str;
            this.c = str2;
            this.d = dataTransportState;
            this.e = reportManager;
            this.f = handlingExceptionCheck;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[Catch:{ Exception -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean uploadReport(com.google.firebase.crashlytics.internal.report.model.Report r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            com.google.firebase.crashlytics.internal.report.model.CreateReportRequest r1 = new com.google.firebase.crashlytics.internal.report.model.CreateReportRequest     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = r5.b     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = r5.c     // Catch:{ Exception -> 0x0067 }
            r1.<init>(r2, r3, r6)     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.common.DataTransportState r2 = r5.d     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.common.DataTransportState r3 = com.google.firebase.crashlytics.internal.common.DataTransportState.ALL     // Catch:{ Exception -> 0x0067 }
            r4 = 1
            if (r2 != r3) goto L_0x001b
            com.google.firebase.crashlytics.internal.Logger r7 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "Send to Reports Endpoint disabled. Removing Reports Endpoint report."
            r7.d(r1)     // Catch:{ Exception -> 0x0067 }
            goto L_0x0030
        L_0x001b:
            com.google.firebase.crashlytics.internal.common.DataTransportState r3 = com.google.firebase.crashlytics.internal.common.DataTransportState.JAVA_ONLY     // Catch:{ Exception -> 0x0067 }
            if (r2 != r3) goto L_0x0032
            com.google.firebase.crashlytics.internal.report.model.Report$Type r2 = r6.getType()     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.report.model.Report$Type r3 = com.google.firebase.crashlytics.internal.report.model.Report.Type.JAVA     // Catch:{ Exception -> 0x0067 }
            if (r2 != r3) goto L_0x0032
            com.google.firebase.crashlytics.internal.Logger r7 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "Send to Reports Endpoint for non-native reports disabled. Removing Reports Uploader report."
            r7.d(r1)     // Catch:{ Exception -> 0x0067 }
        L_0x0030:
            r7 = 1
            goto L_0x005e
        L_0x0032:
            com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall r2 = r5.a     // Catch:{ Exception -> 0x0067 }
            boolean r7 = r2.invoke(r1, r7)     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r2.<init>()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = "Crashlytics Reports Endpoint upload "
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            if (r7 == 0) goto L_0x004b
            java.lang.String r3 = "complete: "
            goto L_0x004d
        L_0x004b:
            java.lang.String r3 = "FAILED: "
        L_0x004d:
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = r6.getIdentifier()     // Catch:{ Exception -> 0x0067 }
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0067 }
            r1.i(r2)     // Catch:{ Exception -> 0x0067 }
        L_0x005e:
            if (r7 == 0) goto L_0x0080
            com.google.firebase.crashlytics.internal.report.ReportManager r7 = r5.e     // Catch:{ Exception -> 0x0067 }
            r7.deleteReport(r6)     // Catch:{ Exception -> 0x0067 }
            r0 = 1
            goto L_0x0080
        L_0x0067:
            r7 = move-exception
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error occurred sending report "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r1.e(r6, r7)
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.ReportUploader.uploadReport(com.google.firebase.crashlytics.internal.report.model.Report, boolean):boolean");
    }

    public synchronized void uploadReportsAsync(List<Report> list, boolean z, float f2) {
        if (this.g != null) {
            Logger.getLogger().d("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new a(list, z, f2), "Crashlytics Report Uploader");
        this.g = thread;
        thread.start();
    }
}
