package com.facebook.internal.logging.monitor;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MonitorManager {
    public static MonitorCreator a = new a();

    @VisibleForTesting
    public interface MonitorCreator {
        void enable();
    }

    public static class a implements MonitorCreator {
        @Override // com.facebook.internal.logging.monitor.MonitorManager.MonitorCreator
        public void enable() {
            Monitor.enable();
        }
    }

    public static void start() {
        FetchedAppSettings appSettingsWithoutQuery;
        if (FacebookSdk.getMonitorEnabled() && (appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId())) != null && appSettingsWithoutQuery.getMonitorViaDialogEnabled()) {
            Monitor.enable();
        }
    }
}
