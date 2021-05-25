package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/publish/details/analytics/ProfileLoadTrackerImpl;", "Lcom/avito/android/publish/details/analytics/ProfileLoadTracker;", "", "startProfileLoading", "()V", "trackProfileLoaded", "trackProfileLoadError", "", "result", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "profileLoadTracker", "<init>", "(Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileLoadTrackerImpl implements ProfileLoadTracker {
    public ContentLoadingTracker a;
    public final ScreenFlowTrackerProvider b;

    @Inject
    public ProfileLoadTrackerImpl(@NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.b = screenFlowTrackerProvider;
    }

    public final void a(String str) {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, str, 0, 4, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.publish.details.analytics.ProfileLoadTracker
    public void startProfileLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.b.getContentLoadingFromRemoteStorage("profile");
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.publish.details.analytics.ProfileLoadTracker
    public void trackProfileLoadError() {
        a(PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.publish.details.analytics.ProfileLoadTracker
    public void trackProfileLoaded() {
        a("success");
    }
}
