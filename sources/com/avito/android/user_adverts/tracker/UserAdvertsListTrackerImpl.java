package com.avito.android.user_adverts.tracker;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/user_adverts/tracker/UserAdvertsListTrackerImpl;", "Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "startAdvertsLoading", "trackInit", "startDraw", "trackAdvertsLoadingSuccess", "trackAdvertsDrawSuccess", "trackAdvertsLoadingError", "trackAdvertsDrawError", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "contentLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contentDrawingTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "e", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsListTrackerImpl implements UserAdvertsListTracker {
    public ContentDrawingTracker a;
    public ContentLoadingTracker b;
    public final ScreenDiInjectTracker c;
    public final ScreenInitTracker d;
    public final ScreenFlowTrackerProvider e;

    @Inject
    public UserAdvertsListTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.c = screenDiInjectTracker;
        this.d = screenInitTracker;
        this.e = screenFlowTrackerProvider;
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void startAdvertsLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.e.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void startDraw() {
        ContentDrawingTracker contentDrawing = this.e.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentDrawing;
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void startInit() {
        this.d.start();
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void trackAdvertsDrawError() {
        ContentDrawingTracker contentDrawingTracker = this.a;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void trackAdvertsDrawSuccess() {
        ContentDrawingTracker contentDrawingTracker = this.a;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void trackAdvertsLoadingError() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void trackAdvertsLoadingSuccess() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void trackDiInject(long j) {
        this.c.track(j);
    }

    @Override // com.avito.android.user_adverts.tracker.UserAdvertsListTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.d, 0, 1, null);
    }
}
