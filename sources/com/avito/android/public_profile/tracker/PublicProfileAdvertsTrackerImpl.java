package com.avito.android.public_profile.tracker;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.public_profile.di.ProfileAdvertsModule;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\b\u0001\u00102\u001a\u00020\u001e¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTrackerImpl;", "Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;", "", "stop", "()V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "restartSession", "startProfileAdvertsLocalLoading", "startProfileAdvertsServerLoading", "trackProfileAdvertsLoaded", "trackProfileAdvertsLoadError", "startProfileAdvertsPreparing", "trackProfileAdvertsPreparing", "trackProfileAdvertsErrorPreparing", "startProfileAdvertsDraw", "trackProfileAdvertsDraw", "trackProfileAdvertsErrorDraw", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "contentLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "contentType", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", g.a, "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contentDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "viewDataPreparingTracker", "shortcut", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileAdvertsTrackerImpl implements PublicProfileAdvertsTracker {
    public final String a;
    public ContentLoadingTracker b;
    public ViewDataPreparingTracker c;
    public ContentDrawingTracker d;
    public final ScreenDiInjectTracker e;
    public final ScreenInitTracker f;
    public final ScreenFlowTrackerProvider g;

    @Inject
    public PublicProfileAdvertsTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @ProfileAdvertsModule.Shortcut @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(str, "shortcut");
        this.e = screenDiInjectTracker;
        this.f = screenInitTracker;
        this.g = screenFlowTrackerProvider;
        this.a = a.c3(str, "-advertisements");
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void restartSession() {
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void startInit() {
        this.f.start();
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void startProfileAdvertsDraw() {
        ContentDrawingTracker contentDrawing = this.g.getContentDrawing(this.a);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.d = contentDrawing;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void startProfileAdvertsLocalLoading() {
        ContentLoadingTracker contentLoadingFromLocalStorage = this.g.getContentLoadingFromLocalStorage(this.a);
        contentLoadingFromLocalStorage.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentLoadingFromLocalStorage;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void startProfileAdvertsPreparing() {
        ViewDataPreparingTracker viewPreparing = this.g.getViewPreparing(this.a);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.c = viewPreparing;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void startProfileAdvertsServerLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.g.getContentLoadingFromRemoteStorage(this.a);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void stop() {
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackDiInject(long j) {
        this.e.track(j);
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.f, 0, 1, null);
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackProfileAdvertsDraw() {
        ContentDrawingTracker contentDrawingTracker = this.d;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackProfileAdvertsErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.d;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackProfileAdvertsErrorPreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.c;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, true, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackProfileAdvertsLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackProfileAdvertsLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker
    public void trackProfileAdvertsPreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.c;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, false, 1, null);
        }
        this.c = null;
    }
}
