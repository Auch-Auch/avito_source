package com.google.android.play.core.splitinstall;

import a2.j.b.e.a.i.a;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import java.util.ArrayList;
import java.util.List;
public abstract class SplitInstallSessionState {
    public static SplitInstallSessionState a(Bundle bundle) {
        return new a(bundle.getInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public static SplitInstallSessionState create(int i, @SplitInstallSessionStatus int i2, @SplitInstallErrorCode int i3, long j, long j2, List<String> list, List<String> list2) {
        if (i2 != 8) {
            return new a(i, i2, i3, j, j2, list, list2, null, null);
        }
        throw new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
    }

    public abstract List<String> b();

    public abstract long bytesDownloaded();

    public abstract List<String> c();

    public abstract List<Intent> d();

    @SplitInstallErrorCode
    public abstract int errorCode();

    public boolean hasTerminalStatus() {
        int status = status();
        return status == 0 || status == 5 || status == 6 || status == 7;
    }

    public List<String> languages() {
        return c() != null ? new ArrayList(c()) : new ArrayList();
    }

    public List<String> moduleNames() {
        return b() != null ? new ArrayList(b()) : new ArrayList();
    }

    @Deprecated
    public abstract PendingIntent resolutionIntent();

    public abstract int sessionId();

    @SplitInstallSessionStatus
    public abstract int status();

    public abstract long totalBytesToDownload();
}
