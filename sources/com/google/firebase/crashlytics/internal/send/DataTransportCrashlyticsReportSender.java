package com.google.firebase.crashlytics.internal.send;

import a2.j.e.d.d.g.b;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
public class DataTransportCrashlyticsReportSender {
    public static final CrashlyticsReportJsonTransform c = new CrashlyticsReportJsonTransform();
    public static final String d = a("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    public static final String e = a("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    public static final Transformer<CrashlyticsReport, byte[]> f = b.a;
    public final Transport<CrashlyticsReport> a;
    public final Transformer<CrashlyticsReport, byte[]> b;

    public DataTransportCrashlyticsReportSender(Transport<CrashlyticsReport> transport, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.a = transport;
        this.b = transformer;
    }

    public static String a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static DataTransportCrashlyticsReportSender create(Context context) {
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory(new CCTDestination(d, e));
        Encoding of = Encoding.of("json");
        Transformer<CrashlyticsReport, byte[]> transformer = f;
        return new DataTransportCrashlyticsReportSender(newFactory.getTransport("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, of, transformer), transformer);
    }

    @NonNull
    public Task<CrashlyticsReportWithSessionId> sendReport(@NonNull CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        CrashlyticsReport report = crashlyticsReportWithSessionId.getReport();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.a.schedule(Event.ofUrgent(report), new TransportScheduleCallback(taskCompletionSource, crashlyticsReportWithSessionId) { // from class: a2.j.e.d.d.g.a
            public final TaskCompletionSource a;
            public final CrashlyticsReportWithSessionId b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.google.android.datatransport.TransportScheduleCallback
            public void onSchedule(Exception exc) {
                TaskCompletionSource taskCompletionSource2 = this.a;
                CrashlyticsReportWithSessionId crashlyticsReportWithSessionId2 = this.b;
                CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = DataTransportCrashlyticsReportSender.c;
                if (exc != null) {
                    taskCompletionSource2.trySetException(exc);
                } else {
                    taskCompletionSource2.trySetResult(crashlyticsReportWithSessionId2);
                }
            }
        });
        return taskCompletionSource.getTask();
    }
}
