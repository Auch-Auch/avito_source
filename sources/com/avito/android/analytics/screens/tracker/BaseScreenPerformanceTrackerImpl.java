package com.avito.android.analytics.screens.tracker;

import a2.g.r.g;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startLoading", "trackLoaded", "trackLoadingError", "startPreparing", "trackPrepared", "startDrawing", "trackDrawn", "trackDrawnError", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "f", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "contentLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "drawingTracker", "", g.a, "Ljava/lang/String;", "contentType", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "prepareTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Ljava/lang/String;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class BaseScreenPerformanceTrackerImpl implements BaseScreenPerformanceTracker {
    public ContentLoadingTracker a;
    public ViewDataPreparingTracker b;
    public ContentDrawingTracker c;
    public final ScreenDiInjectTracker d;
    public final ScreenInitTracker e;
    public final ScreenFlowTrackerProvider f;
    public final String g;

    @Inject
    public BaseScreenPerformanceTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(str, "contentType");
        this.d = screenDiInjectTracker;
        this.e = screenInitTracker;
        this.f = screenFlowTrackerProvider;
        this.g = str;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void startDrawing() {
        ContentDrawingTracker contentDrawing = this.f.getContentDrawing(this.g);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentDrawing;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void startInit() {
        this.e.start();
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void startLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.f.getContentLoadingFromRemoteStorage(this.g);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void startPreparing() {
        ViewDataPreparingTracker viewPreparing = this.f.getViewPreparing(this.g);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.b = viewPreparing;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void trackDiInject(long j) {
        this.d.track(j);
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void trackDrawn() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, false);
        }
        this.c = null;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void trackDrawnError() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, true);
        }
        this.c = null;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.e, 0, 1, null);
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void trackLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void trackLoadingError() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 4, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker
    public void trackPrepared() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.b;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, false);
        }
        this.b = null;
    }
}
