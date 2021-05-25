package com.avito.android.messenger.conversation.analytics;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001QB)\b\u0007\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020C8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u00109R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010R\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010'¨\u0006W"}, d2 = {"Lcom/avito/android/messenger/conversation/analytics/ChannelTrackerImpl;", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "", "attach", "()V", "detach", "destroy", "stopAllSessions", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "", "curItemCount", "startReloadSession", "(I)V", "startLoadMoreSession", "startContextLoading", "startMessagesLoading", "trackContextLoad", "trackMessagesLoad", "trackContextLoadError", "trackMessagesLoadError", "startContextPreparing", "startMessagesPreparing", "trackContextPreparing", "trackMessagesPreparing", "trackContextPreparingError", "trackMessagesPreparingError", "startContextDraw", "startMessagesDraw", "trackContextDraw", "trackMessagesDraw", "trackContextDrawError", "trackMessagesDrawError", "Lcom/avito/android/messenger/conversation/analytics/ChannelTrackerImpl$a;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/analytics/ChannelTrackerImpl$a;", "contextState", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "k", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "contextPreparingTracker", g.a, "messagesPreparingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "messagesLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "j", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "l", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "", "isTrackingLoadMore", "()Z", "c", "I", "pageNo", "d", "contextLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "h", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contextDrawingTracker", "i", "messagesDrawingTracker", AuthSource.SEND_ABUSE, "messagesState", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelTrackerImpl implements ChannelTracker {
    public volatile a a;
    public volatile a b;
    public volatile int c = 1;
    public volatile ContentLoadingTracker d;
    public volatile ContentLoadingTracker e;
    public volatile ViewDataPreparingTracker f;
    public volatile ViewDataPreparingTracker g;
    public volatile ContentDrawingTracker h;
    public volatile ContentDrawingTracker i;
    public final ScreenMemoryMeasureTracker j;
    public final ScreenDiInjectTracker k;
    public final ScreenInitTracker l;
    public final ScreenFlowTrackerProvider m;

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
    public ChannelTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.k = screenDiInjectTracker;
        this.l = screenInitTracker;
        this.m = screenFlowTrackerProvider;
        a aVar = a.INIT;
        this.a = aVar;
        this.b = aVar;
        this.j = screenFlowTrackerProvider.getMemoryMeasureTracker();
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void attach() {
        this.j.resumeTracking();
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void destroy() {
        this.j.reportLeast();
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void detach() {
        this.j.pauseTracking();
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public boolean isTrackingLoadMore() {
        return false;
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startContextDraw() {
        if (this.b == a.PREPARE_COMPLETED) {
            ContentDrawingTracker contentDrawing = this.m.getContentDrawing("context");
            contentDrawing.start();
            this.h = contentDrawing;
            this.b = a.DRAW_STARTED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startContextLoading() {
        if (this.b == a.INIT) {
            ContentLoadingTracker contentLoadingFromRemoteStorage = this.m.getContentLoadingFromRemoteStorage("context");
            contentLoadingFromRemoteStorage.start();
            this.d = contentLoadingFromRemoteStorage;
            this.b = a.LOAD_STARTED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startContextPreparing() {
        if (this.b == a.LOAD_COMPLETED) {
            ViewDataPreparingTracker viewPreparing = this.m.getViewPreparing("context");
            viewPreparing.start();
            this.f = viewPreparing;
            this.b = a.PREPARE_STARTED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startInit() {
        this.j.restart();
        this.l.start();
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startLoadMoreSession(int i2) {
        stopAllSessions();
        int i3 = 1;
        if (i2 > 0) {
            int i4 = (i2 / 100) + 1;
            if (i2 % 100 <= 0) {
                i3 = 0;
            }
            i3 = a2.b.a.a.a.G1(i4, i3, 0, i2 == 101 ? -1 : 0);
        }
        this.c = i3;
        StringBuilder M = a2.b.a.a.a.M("startLoadMoreSession(curItemCount = ", i2, ") => pageNo = ");
        M.append(this.c);
        Logs.verbose$default("ChannelTracker", M.toString(), null, 4, null);
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startMessagesDraw() {
        if (this.a == a.PREPARE_COMPLETED) {
            ContentDrawingTracker contentDrawing = this.m.getContentDrawing("messages");
            contentDrawing.start();
            this.i = contentDrawing;
            this.a = a.DRAW_STARTED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startMessagesLoading() {
        if (this.a == a.INIT) {
            ContentLoadingTracker contentLoadingFromRemoteStorage = this.m.getContentLoadingFromRemoteStorage("messages");
            contentLoadingFromRemoteStorage.start();
            this.e = contentLoadingFromRemoteStorage;
            this.a = a.LOAD_STARTED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startMessagesPreparing() {
        if (this.a == a.LOAD_COMPLETED) {
            ViewDataPreparingTracker viewPreparing = this.m.getViewPreparing("messages");
            viewPreparing.start();
            this.g = viewPreparing;
            this.a = a.PREPARE_STARTED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void startReloadSession(int i2) {
        stopAllSessions();
        int i3 = 1;
        if (i2 > 0) {
            int i4 = (i2 / 100) + 1;
            int i5 = 0;
            if (i2 % 100 <= 0) {
                i3 = 0;
            }
            if (i2 == 101) {
                i5 = -1;
            }
            i3 = a2.b.a.a.a.G1(i4, i3, -1, i5);
        }
        this.c = i3;
        StringBuilder M = a2.b.a.a.a.M("startReloadSession(curItemCount = ", i2, ") => pageNo = ");
        M.append(this.c);
        Logs.verbose$default("ChannelTracker", M.toString(), null, 4, null);
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void stopAllSessions() {
        a aVar = a.INIT;
        this.b = aVar;
        this.a = aVar;
        this.d = null;
        this.f = null;
        this.h = null;
        this.e = null;
        this.g = null;
        this.i = null;
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackContextDraw() {
        if (this.b == a.DRAW_STARTED) {
            ContentDrawingTracker contentDrawingTracker = this.h;
            if (contentDrawingTracker != null) {
                contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(this.c), false);
            }
            this.h = null;
            this.b = a.DRAW_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackContextDrawError() {
        if (this.b == a.DRAW_STARTED) {
            ContentDrawingTracker contentDrawingTracker = this.h;
            if (contentDrawingTracker != null) {
                contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(this.c), true);
            }
            this.h = null;
            this.b = a.DRAW_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackContextLoad() {
        if (this.b == a.LOAD_STARTED) {
            ContentLoadingTracker contentLoadingTracker = this.d;
            if (contentLoadingTracker != null) {
                ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(this.c), "success", 0, 4, null);
            }
            this.d = null;
            this.b = a.LOAD_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackContextLoadError() {
        if (this.b == a.LOAD_STARTED) {
            ContentLoadingTracker contentLoadingTracker = this.d;
            if (contentLoadingTracker != null) {
                ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(this.c), PublicConstantsKt.FAILURE, 0, 4, null);
            }
            this.d = null;
            this.b = a.LOAD_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackContextPreparing() {
        if (this.b == a.PREPARE_STARTED) {
            ViewDataPreparingTracker viewDataPreparingTracker = this.f;
            if (viewDataPreparingTracker != null) {
                viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(this.c), false);
            }
            this.f = null;
            this.b = a.PREPARE_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackContextPreparingError() {
        if (this.b == a.PREPARE_STARTED) {
            ViewDataPreparingTracker viewDataPreparingTracker = this.f;
            if (viewDataPreparingTracker != null) {
                viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(this.c), true);
            }
            this.f = null;
            this.b = a.PREPARE_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackDiInject(long j2) {
        this.k.track(j2);
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.l, 0, 1, null);
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackMessagesDraw() {
        if (this.a == a.DRAW_STARTED) {
            ContentDrawingTracker contentDrawingTracker = this.i;
            if (contentDrawingTracker != null) {
                contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(this.c), false);
            }
            this.i = null;
            this.a = a.DRAW_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackMessagesDrawError() {
        if (this.a == a.DRAW_STARTED) {
            ContentDrawingTracker contentDrawingTracker = this.i;
            if (contentDrawingTracker != null) {
                contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(this.c), true);
            }
            this.i = null;
            this.a = a.DRAW_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackMessagesLoad() {
        if (this.a == a.LOAD_STARTED) {
            ContentLoadingTracker contentLoadingTracker = this.e;
            if (contentLoadingTracker != null) {
                ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(this.c), "success", 0, 4, null);
            }
            this.e = null;
            this.a = a.LOAD_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackMessagesLoadError() {
        if (this.a == a.LOAD_STARTED) {
            ContentLoadingTracker contentLoadingTracker = this.e;
            if (contentLoadingTracker != null) {
                ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(this.c), PublicConstantsKt.FAILURE, 0, 4, null);
            }
            this.e = null;
            this.a = a.LOAD_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackMessagesPreparing() {
        if (this.a == a.PREPARE_STARTED) {
            ViewDataPreparingTracker viewDataPreparingTracker = this.g;
            if (viewDataPreparingTracker != null) {
                viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(this.c), false);
            }
            this.g = null;
            this.a = a.PREPARE_COMPLETED;
        }
    }

    @Override // com.avito.android.messenger.conversation.analytics.ChannelTracker
    public void trackMessagesPreparingError() {
        if (this.a == a.PREPARE_STARTED) {
            ViewDataPreparingTracker viewDataPreparingTracker = this.g;
            if (viewDataPreparingTracker != null) {
                viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(this.c), true);
            }
            this.g = null;
            this.a = a.PREPARE_COMPLETED;
        }
    }
}
