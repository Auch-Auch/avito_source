package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
public enum DataTransportState {
    NONE,
    JAVA_ONLY,
    ALL;

    @NonNull
    public static DataTransportState a(@NonNull AppSettingsData appSettingsData) {
        boolean z = false;
        boolean z2 = appSettingsData.reportUploadVariant == 2;
        if (appSettingsData.nativeReportUploadVariant == 2) {
            z = true;
        }
        if (!z2) {
            return NONE;
        }
        if (!z) {
            return JAVA_ONLY;
        }
        return ALL;
    }
}
