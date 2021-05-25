package com.avito.android.user_advert.tracker;

import a2.g.r.g;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\bS\u0010TJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010\u0004R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010=R\u0018\u0010B\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u00109R\u0018\u0010D\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010=R\u0018\u0010F\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u00109R\u0018\u0010H\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00109R\u0018\u0010J\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010=R\u0018\u0010L\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u00109R\u0018\u0010N\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010=R\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTrackerImpl;", "Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;", "", "stop", "()V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "startAdvertServerLoading", "trackAdvertLoaded", "trackAdvertLoadError", "startAdvertPreparing", "trackAdvertPreparing", "startAdvertDraw", "trackAdvertDraw", "trackAdvertErrorDraw", "startDeleteAdvertLoading", "trackDeleteAdvertLoading", "trackDeleteAdvertLoadingError", "startDeleteAdvertDraw", "trackDeleteAdvertDraw", "trackDeleteAdvertDrawError", "startActivateAdvertLoading", "trackActivateAdvertLoading", "trackActivateAdvertLoadingError", "startActivateAdvertDraw", "trackActivateAdvertDraw", "trackActivateAdvertDrawError", "startDeactivateAdvertLoading", "trackDeactivateAdvertLoading", "trackDeactivateAdvertLoadingError", "startDeactivateAdvertDraw", "trackDeactivateAdvertDraw", "trackDeactivateAdvertDrawError", "startRestoreAdvertLoading", "trackRestoreAdvertLoading", "trackRestoreAdvertLoadingError", "startRestoreAdvertDraw", "trackRestoreAdvertDraw", "trackRestoreAdvertDrawError", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "l", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "n", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "advertContentDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "restoreContentLoadingTracker", AuthSource.SEND_ABUSE, "advertContentLoadingTracker", "i", "activateContentDrawingTracker", "d", "deactivateContentLoadingTracker", "h", "deleteContentDrawingTracker", "j", "deactivateContentDrawingTracker", "c", "activateContentLoadingTracker", "k", "restoreContentDrawingTracker", AuthSource.BOOKING_ORDER, "deleteContentLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "advertViewDataPreparingTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsTrackerImpl implements MyAdvertDetailsTracker {
    public ContentLoadingTracker a;
    public ContentLoadingTracker b;
    public ContentLoadingTracker c;
    public ContentLoadingTracker d;
    public ContentLoadingTracker e;
    public ViewDataPreparingTracker f;
    public ContentDrawingTracker g;
    public ContentDrawingTracker h;
    public ContentDrawingTracker i;
    public ContentDrawingTracker j;
    public ContentDrawingTracker k;
    public final ScreenDiInjectTracker l;
    public final ScreenInitTracker m;
    public final ScreenFlowTrackerProvider n;

    @Inject
    public MyAdvertDetailsTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.l = screenDiInjectTracker;
        this.m = screenInitTracker;
        this.n = screenFlowTrackerProvider;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startActivateAdvertDraw() {
        ContentDrawingTracker contentDrawing = this.n.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_ACTIVATE_ADVERT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.i = contentDrawing;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startActivateAdvertLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.n.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_ACTIVATE_ADVERT);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startAdvertDraw() {
        ContentDrawingTracker contentDrawing = this.n.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_RELOAD_ADVERT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.g = contentDrawing;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startAdvertPreparing() {
        ViewDataPreparingTracker viewPreparing = this.n.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_RELOAD_ADVERT);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.f = viewPreparing;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startAdvertServerLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.n.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_RELOAD_ADVERT);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startDeactivateAdvertDraw() {
        ContentDrawingTracker contentDrawing = this.n.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_DEACTIVATE_ADVERT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.j = contentDrawing;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startDeactivateAdvertLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.n.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_DEACTIVATE_ADVERT);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.d = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startDeleteAdvertDraw() {
        ContentDrawingTracker contentDrawing = this.n.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_DELETE_ADVERT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.h = contentDrawing;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startDeleteAdvertLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.n.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_DELETE_ADVERT);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startInit() {
        this.m.start();
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startRestoreAdvertDraw() {
        ContentDrawingTracker contentDrawing = this.n.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_RESTORE_ADVERT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.k = contentDrawing;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void startRestoreAdvertLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.n.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_RESTORE_ADVERT);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.e = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void stop() {
        this.a = null;
        this.f = null;
        this.g = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackActivateAdvertDraw() {
        ContentDrawingTracker contentDrawingTracker = this.i;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.i = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackActivateAdvertDrawError() {
        ContentDrawingTracker contentDrawingTracker = this.i;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.i = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackActivateAdvertLoading() {
        ContentLoadingTracker contentLoadingTracker = this.c;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackActivateAdvertLoadingError() {
        ContentLoadingTracker contentLoadingTracker = this.c;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackAdvertDraw() {
        ContentDrawingTracker contentDrawingTracker = this.g;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.g = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackAdvertErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.g;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.g = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackAdvertLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackAdvertLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackAdvertPreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.f;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, false, 1, null);
        }
        this.f = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeactivateAdvertDraw() {
        ContentDrawingTracker contentDrawingTracker = this.j;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.j = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeactivateAdvertDrawError() {
        ContentDrawingTracker contentDrawingTracker = this.j;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.j = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeactivateAdvertLoading() {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeactivateAdvertLoadingError() {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeleteAdvertDraw() {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.h = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeleteAdvertDrawError() {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.h = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeleteAdvertLoading() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDeleteAdvertLoadingError() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackDiInject(long j2) {
        this.l.track(j2);
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.m, 0, 1, null);
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackRestoreAdvertDraw() {
        ContentDrawingTracker contentDrawingTracker = this.k;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.k = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackRestoreAdvertDrawError() {
        ContentDrawingTracker contentDrawingTracker = this.k;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.k = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackRestoreAdvertLoading() {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.user_advert.tracker.MyAdvertDetailsTracker
    public void trackRestoreAdvertLoadingError() {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.e = null;
    }
}
