package com.google.android.play.core.appupdate;

import a2.j.b.e.a.a.k;
import android.app.PendingIntent;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
public abstract class AppUpdateInfo {
    public static AppUpdateInfo a(String str, int i, @UpdateAvailability int i2, @InstallStatus int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        return new k(str, i, i2, i3, num, i4, j, j2, j3, j4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
    }

    public abstract long a();

    public abstract int availableVersionCode();

    public final PendingIntent b(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() != 0) {
            if (appUpdateOptions.appUpdateType() == 1) {
                if (e() != null) {
                    return e();
                }
                if (d(appUpdateOptions)) {
                    return g();
                }
            }
            return null;
        } else if (f() != null) {
            return f();
        } else {
            if (d(appUpdateOptions)) {
                return h();
            }
            return null;
        }
    }

    public abstract long bytesDownloaded();

    public abstract long c();

    public abstract Integer clientVersionStalenessDays();

    public final boolean d(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.a() && a() <= c();
    }

    public abstract PendingIntent e();

    public abstract PendingIntent f();

    public abstract PendingIntent g();

    public abstract PendingIntent h();

    @InstallStatus
    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(@AppUpdateType int i) {
        return b(AppUpdateOptions.defaultOptions(i)) != null;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return b(appUpdateOptions) != null;
    }

    public abstract String packageName();

    public abstract long totalBytesToDownload();

    @UpdateAvailability
    public abstract int updateAvailability();

    public abstract int updatePriority();
}
