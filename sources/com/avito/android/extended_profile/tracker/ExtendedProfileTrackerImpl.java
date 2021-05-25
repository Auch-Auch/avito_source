package com.avito.android.extended_profile.tracker;

import a2.g.r.g;
import com.avito.android.analytics.screens.ExtendedProfileScreen;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010*R\u0018\u0010?\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010\"R\u0018\u0010A\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u00106¨\u0006D"}, d2 = {"Lcom/avito/android/extended_profile/tracker/ExtendedProfileTrackerImpl;", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startProfileLoading", "trackProfileLoaded", "trackProfileLoadError", "startProfilePreparing", "trackProfilePreparing", "startProfileDraw", "trackProfileDraw", "trackProfileErrorDraw", "startExtendedProfileLoading", "trackExtendedProfileLoaded", "trackExtendedProfileLoadError", "startExtendedProfilePreparing", "trackExtendedProfilePreparing", "trackExtendedProfileErrorPreparing", "startExtendedProfileDraw", "trackExtendedProfileDraw", "trackExtendedProfileErrorDraw", "stopTracking", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "profileLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "extendedProfileDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "h", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "j", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "recovery", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "extendedProfilePrepareTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "i", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "c", "profileDrawingTracker", "d", "extendedProfileLoadingTracker", AuthSource.BOOKING_ORDER, "profilePrepareTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Lcom/avito/android/analytics/screens/ScreenTransferRecovery;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileTrackerImpl implements ExtendedProfileTracker {
    public ContentLoadingTracker a;
    public ViewDataPreparingTracker b;
    public ContentDrawingTracker c;
    public ContentLoadingTracker d;
    public ViewDataPreparingTracker e;
    public ContentDrawingTracker f;
    public final ScreenDiInjectTracker g;
    public final ScreenInitTracker h;
    public final ScreenFlowTrackerProvider i;
    public final ScreenTransferRecovery j;

    @Inject
    public ExtendedProfileTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @NotNull ScreenTransferRecovery screenTransferRecovery) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(screenTransferRecovery, "recovery");
        this.g = screenDiInjectTracker;
        this.h = screenInitTracker;
        this.i = screenFlowTrackerProvider;
        this.j = screenTransferRecovery;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void recover(@NotNull ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(screenTransfer, "transfer");
        this.j.recover(screenTransfer, ExtendedProfileScreen.INSTANCE, ScreenPublicConstsKt.CONTENT_TYPE_PRELOAD);
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startExtendedProfileDraw() {
        ContentDrawingTracker contentDrawing = this.i.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_EXTENDED_PROFILE_DATA);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.f = contentDrawing;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startExtendedProfileLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.i.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_EXTENDED_PROFILE_DATA);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.d = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startExtendedProfilePreparing() {
        ViewDataPreparingTracker viewPreparing = this.i.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_EXTENDED_PROFILE_DATA);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.e = viewPreparing;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startInit() {
        this.h.start();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startProfileDraw() {
        ContentDrawingTracker contentDrawing = this.i.getContentDrawing("profile");
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentDrawing;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startProfileLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.i.getContentLoadingFromRemoteStorage("profile");
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startProfilePreparing() {
        ViewDataPreparingTracker viewPreparing = this.i.getViewPreparing("profile");
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.b = viewPreparing;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void stopTracking() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackDiInject(long j2) {
        this.g.track(j2);
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileDraw() {
        ContentDrawingTracker contentDrawingTracker = this.f;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.f = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.f;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.f = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileErrorPreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.e;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, true, 1, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfilePreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.e;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, false, 1, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.h, 0, 1, null);
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileDraw() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfilePreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.b;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, false, 1, null);
        }
        this.b = null;
    }
}
