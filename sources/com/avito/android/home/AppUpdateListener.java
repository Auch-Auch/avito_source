package com.avito.android.home;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/home/AppUpdateListener;", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "Lcom/google/android/play/core/install/InstallState;", "state", "", "onStateUpdate", "(Lcom/google/android/play/core/install/InstallState;)V", "Ljava/lang/ref/WeakReference;", "Lcom/avito/android/home/HomeActivity;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "weakActivity", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", AuthSource.BOOKING_ORDER, "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "updateManager", "activity", "<init>", "(Lcom/avito/android/home/HomeActivity;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class AppUpdateListener implements InstallStateUpdatedListener {
    public final WeakReference<HomeActivity> a;
    public final AppUpdateManager b;

    public AppUpdateListener(@NotNull HomeActivity homeActivity) {
        Intrinsics.checkNotNullParameter(homeActivity, "activity");
        this.a = new WeakReference<>(homeActivity);
        this.b = AppUpdateManagerFactory.create(homeActivity.getApplicationContext());
    }

    public void onStateUpdate(@Nullable InstallState installState) {
        AppUpdateManager appUpdateManager;
        if (installState != null && installState.installStatus() == 11) {
            HomeActivity homeActivity = this.a.get();
            if (homeActivity != null) {
                homeActivity.popupSnackbarForCompleteUpdate();
            }
        } else if (installState != null && installState.installStatus() == 4 && (appUpdateManager = this.b) != null) {
            appUpdateManager.unregisterListener(this);
        }
    }
}
