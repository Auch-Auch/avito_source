package com.avito.android.messenger.channels.analytics;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00014B)\b\u0007\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/avito/android/messenger/channels/analytics/ChannelsTrackerImpl;", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "", "attach", "()V", "detach", "destroy", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "", "curItemCount", "startReloadSession", "(I)V", "startLoadMoreSession", "startChannelsLoading", "trackChannelsLoad", "trackChannelsLoadError", "startChannelsViewPreparing", "trackChannelsPreparing", "trackChannelsPreparingError", "startChannelsViewDraw", "trackChannelsDraw", "trackChannelsDrawError", "stopAllSessions", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "h", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", AuthSource.BOOKING_ORDER, "I", "pageNo", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "viewDataPreparingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contentDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/messenger/channels/analytics/ChannelsTrackerImpl$a;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/channels/analytics/ChannelsTrackerImpl$a;", "state", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "contentLoadingTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "i", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsTrackerImpl implements ChannelsTracker {
    public a a = a.INIT;
    public int b = 1;
    public ContentLoadingTracker c;
    public ViewDataPreparingTracker d;
    public ContentDrawingTracker e;
    public final ScreenMemoryMeasureTracker f;
    public final ScreenDiInjectTracker g;
    public final ScreenInitTracker h;
    public final ScreenFlowTrackerProvider i;

    public enum a {
        INIT,
        LOAD_STARTED,
        LOAD_COMPLETED,
        PREPARE_STARTED,
        PREPARE_COMPLETED,
        DRAW_STARTED,
        DRAW_COMPLETED
    }

    @Inject
    public ChannelsTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.g = screenDiInjectTracker;
        this.h = screenInitTracker;
        this.i = screenFlowTrackerProvider;
        this.f = screenFlowTrackerProvider.getMemoryMeasureTracker();
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void attach() {
        this.f.resumeTracking();
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void destroy() {
        this.f.reportLeast();
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void detach() {
        this.f.pauseTracking();
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void startChannelsLoading() {
        if (this.a == a.INIT) {
            ContentLoadingTracker contentLoadingFromRemoteStorage = this.i.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
            contentLoadingFromRemoteStorage.start();
            this.c = contentLoadingFromRemoteStorage;
            this.a = a.LOAD_STARTED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void startChannelsViewDraw() {
        if (this.a == a.PREPARE_COMPLETED) {
            ContentDrawingTracker contentDrawing = this.i.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
            contentDrawing.start();
            this.e = contentDrawing;
            this.a = a.DRAW_STARTED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void startChannelsViewPreparing() {
        if (this.a == a.LOAD_COMPLETED) {
            ViewDataPreparingTracker viewPreparing = this.i.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
            viewPreparing.start();
            this.d = viewPreparing;
            this.a = a.PREPARE_STARTED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void startInit() {
        this.f.restart();
        this.h.start();
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void startLoadMoreSession(int i2) {
        stopAllSessions();
        int i3 = 1;
        if (i2 > 0) {
            int i4 = (i2 / 10) + 1;
            if (i2 % 10 <= 0) {
                i3 = 0;
            }
            i3 = i4 + i3 + 0;
        }
        this.b = i3;
        StringBuilder M = a2.b.a.a.a.M("startLoadMoreSession(curItemCount = ", i2, ") => pageNo = ");
        M.append(this.b);
        Logs.verbose$default("ChannelsTracker", M.toString(), null, 4, null);
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void startReloadSession(int i2) {
        stopAllSessions();
        int i3 = 1;
        if (i2 > 0) {
            int i4 = (i2 / 10) + 1;
            if (i2 % 10 <= 0) {
                i3 = 0;
            }
            i3 = (i4 + i3) - 1;
        }
        this.b = i3;
        StringBuilder M = a2.b.a.a.a.M("startReloadSession(curItemCount = ", i2, ") => pageNo = ");
        M.append(this.b);
        Logs.verbose$default("ChannelsTracker", M.toString(), null, 4, null);
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void stopAllSessions() {
        this.a = a.INIT;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackChannelsDraw() {
        if (this.a == a.DRAW_STARTED) {
            ContentDrawingTracker contentDrawingTracker = this.e;
            if (contentDrawingTracker != null) {
                contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(this.b), false);
            }
            this.e = null;
            this.a = a.DRAW_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackChannelsDrawError() {
        if (this.a == a.DRAW_STARTED) {
            ContentDrawingTracker contentDrawingTracker = this.e;
            if (contentDrawingTracker != null) {
                contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(this.b), true);
            }
            this.e = null;
            this.a = a.DRAW_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackChannelsLoad() {
        if (this.a == a.LOAD_STARTED) {
            ContentLoadingTracker contentLoadingTracker = this.c;
            if (contentLoadingTracker != null) {
                ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(this.b), "success", 0, 4, null);
            }
            this.c = null;
            this.a = a.LOAD_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackChannelsLoadError() {
        if (this.a == a.LOAD_STARTED) {
            ContentLoadingTracker contentLoadingTracker = this.c;
            if (contentLoadingTracker != null) {
                ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(this.b), PublicConstantsKt.FAILURE, 0, 4, null);
            }
            this.c = null;
            this.a = a.LOAD_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackChannelsPreparing() {
        if (this.a == a.PREPARE_STARTED) {
            ViewDataPreparingTracker viewDataPreparingTracker = this.d;
            if (viewDataPreparingTracker != null) {
                viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(this.b), false);
            }
            this.d = null;
            this.a = a.PREPARE_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackChannelsPreparingError() {
        if (this.a == a.PREPARE_STARTED) {
            ViewDataPreparingTracker viewDataPreparingTracker = this.d;
            if (viewDataPreparingTracker != null) {
                viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(this.b), true);
            }
            this.d = null;
            this.a = a.PREPARE_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackDiInject(long j) {
        this.g.track(j);
    }

    @Override // com.avito.android.messenger.channels.analytics.ChannelsTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.h, 0, 1, null);
    }
}
