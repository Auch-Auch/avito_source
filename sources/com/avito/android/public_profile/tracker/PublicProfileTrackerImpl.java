package com.avito.android.public_profile.tracker;

import a2.g.r.g;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.public_profile.di.ScreenAnalytics;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0001\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/public_profile/tracker/PublicProfileTrackerImpl;", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "", "stop", "()V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "restartSession", "startProfileLocalLoading", "startProfileServerLoading", "trackProfileLoaded", "trackProfileLoadError", "startProfilePreparing", "trackProfilePreparing", "trackProfileErrorPreparing", "startProfileDraw", "trackProfileDraw", "trackProfileErrorDraw", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "f", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contentDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/Screen;", g.a, "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "h", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "recovery", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "viewDataPreparingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "contentLoadingTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/ScreenTransferRecovery;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileTrackerImpl implements PublicProfileTracker {
    public ContentLoadingTracker a;
    public ViewDataPreparingTracker b;
    public ContentDrawingTracker c;
    public final ScreenDiInjectTracker d;
    public final ScreenInitTracker e;
    public final ScreenFlowTrackerProvider f;
    public final Screen g;
    public final ScreenTransferRecovery h;

    @Inject
    public PublicProfileTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @ScreenAnalytics @NotNull Screen screen, @NotNull ScreenTransferRecovery screenTransferRecovery) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(screenTransferRecovery, "recovery");
        this.d = screenDiInjectTracker;
        this.e = screenInitTracker;
        this.f = screenFlowTrackerProvider;
        this.g = screen;
        this.h = screenTransferRecovery;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void recover(@NotNull ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(screenTransfer, "transfer");
        this.h.recover(screenTransfer, this.g, ScreenPublicConstsKt.CONTENT_TYPE_PRELOAD);
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void restartSession() {
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void startInit() {
        this.e.start();
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void startProfileDraw() {
        ContentDrawingTracker contentDrawing = this.f.getContentDrawing("profile");
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentDrawing;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void startProfileLocalLoading() {
        ContentLoadingTracker contentLoadingFromLocalStorage = this.f.getContentLoadingFromLocalStorage("profile");
        contentLoadingFromLocalStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromLocalStorage;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void startProfilePreparing() {
        ViewDataPreparingTracker viewPreparing = this.f.getViewPreparing("profile");
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.b = viewPreparing;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void startProfileServerLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.f.getContentLoadingFromRemoteStorage("profile");
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void stop() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackDiInject(long j) {
        this.d.track(j);
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.e, 0, 1, null);
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackProfileDraw() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackProfileErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackProfileErrorPreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.b;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, true, 1, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackProfileLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackProfileLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileTracker
    public void trackProfilePreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.b;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, false, 1, null);
        }
        this.b = null;
    }
}
