package com.google.firebase.crashlytics.internal.common;

import a2.j.e.d.d.a.b;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
@AutoValue
public abstract class CrashlyticsReportWithSessionId {
    @NonNull
    public static CrashlyticsReportWithSessionId create(CrashlyticsReport crashlyticsReport, String str) {
        return new b(crashlyticsReport, str);
    }

    public abstract CrashlyticsReport getReport();

    public abstract String getSessionId();
}
