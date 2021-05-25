package a2.j.e.d.d.a;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
public class q0 {
    public final CrashlyticsReportDataCapture a;
    public final CrashlyticsReportPersistence b;
    public final DataTransportCrashlyticsReportSender c;
    public final LogFileManager d;
    public final UserMetadata e;
    @Nullable
    public String f;

    public q0(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.a = crashlyticsReportDataCapture;
        this.b = crashlyticsReportPersistence;
        this.c = dataTransportCrashlyticsReportSender;
        this.d = logFileManager;
        this.e = userMetadata;
    }

    public final void a(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j, boolean z) {
        String str2 = this.f;
        if (str2 == null) {
            Logger.getLogger().d("Cannot persist event, no currently open session");
            return;
        }
        boolean equals = str.equals("crash");
        CrashlyticsReport.Session.Event captureEventData = this.a.captureEventData(th, thread, str, j, 4, 8, z);
        CrashlyticsReport.Session.Event.Builder builder = captureEventData.toBuilder();
        String logString = this.d.getLogString();
        if (logString != null) {
            builder.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(logString).build());
        } else {
            Logger.getLogger().d("No log data to include with this event.");
        }
        Map<String, String> customKeys = this.e.getCustomKeys();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(customKeys.size());
        for (Map.Entry<String, String> entry : customKeys.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        Collections.sort(arrayList, p0.a);
        if (!arrayList.isEmpty()) {
            builder.setApp(captureEventData.getApp().toBuilder().setCustomAttributes(ImmutableList.from(arrayList)).build());
        }
        this.b.persistEvent(builder.build(), str2, equals);
    }

    public Task<Void> b(@NonNull Executor executor, @NonNull DataTransportState dataTransportState) {
        if (dataTransportState == DataTransportState.NONE) {
            Logger.getLogger().d("Send via DataTransport disabled. Removing DataTransport reports.");
            this.b.deleteAllReports();
            return Tasks.forResult(null);
        }
        List<CrashlyticsReportWithSessionId> loadFinalizedReports = this.b.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : loadFinalizedReports) {
            if (crashlyticsReportWithSessionId.getReport().getType() != CrashlyticsReport.Type.NATIVE || dataTransportState == DataTransportState.ALL) {
                arrayList.add(this.c.sendReport(crashlyticsReportWithSessionId).continueWith(executor, new Continuation(this) { // from class: a2.j.e.d.d.a.o0
                    public final q0 a;

                    {
                        this.a = r1;
                    }

                    @Override // com.google.android.gms.tasks.Continuation
                    public Object then(Task task) {
                        boolean z;
                        q0 q0Var = this.a;
                        Objects.requireNonNull(q0Var);
                        if (task.isSuccessful()) {
                            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId2 = (CrashlyticsReportWithSessionId) task.getResult();
                            Logger logger = Logger.getLogger();
                            StringBuilder L = a.L("Crashlytics report successfully enqueued to DataTransport: ");
                            L.append(crashlyticsReportWithSessionId2.getSessionId());
                            logger.d(L.toString());
                            q0Var.b.deleteFinalizedReport(crashlyticsReportWithSessionId2.getSessionId());
                            z = true;
                        } else {
                            Logger.getLogger().d("Crashlytics report could not be enqueued to DataTransport", task.getException());
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }));
            } else {
                Logger.getLogger().d("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.b.deleteFinalizedReport(crashlyticsReportWithSessionId.getSessionId());
            }
        }
        return Tasks.whenAll(arrayList);
    }
}
