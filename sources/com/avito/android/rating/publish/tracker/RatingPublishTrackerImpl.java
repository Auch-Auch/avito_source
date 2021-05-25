package com.avito.android.rating.publish.tracker;

import a2.g.r.g;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.RatingPublishScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\fR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010\u001e¨\u0006<"}, d2 = {"Lcom/avito/android/rating/publish/tracker/RatingPublishTrackerImpl;", "Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startDraw", "trackDraw", "startNextStepLoading", "trackNextStepLoadingSuccess", "trackNextStepLoadingFail", "startNextStepDraw", "trackNextStepDrawFail", "trackNextStepDrawSuccess", "startSendRatingLoading", "trackSendRatingLoadingSuccess", "trackSendRatingLoadingFail", "startSendRatingDraw", "trackSendRatingDrawSuccess", "trackSendRatingDrawFail", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contentDrawingTracker", AuthSource.BOOKING_ORDER, "nextStepDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "i", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "recovery", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "nextStepLoadingTracker", "e", "sendRatingLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "h", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "c", "sendRatingDrawingTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Lcom/avito/android/analytics/screens/ScreenTransferRecovery;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishTrackerImpl implements RatingPublishTracker {
    public ContentDrawingTracker a;
    public ContentDrawingTracker b;
    public ContentDrawingTracker c;
    public ContentLoadingTracker d;
    public ContentLoadingTracker e;
    public final ScreenDiInjectTracker f;
    public final ScreenInitTracker g;
    public final ScreenFlowTrackerProvider h;
    public final ScreenTransferRecovery i;

    @Inject
    public RatingPublishTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @NotNull ScreenTransferRecovery screenTransferRecovery) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(screenTransferRecovery, "recovery");
        this.f = screenDiInjectTracker;
        this.g = screenInitTracker;
        this.h = screenFlowTrackerProvider;
        this.i = screenTransferRecovery;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void recover(@NotNull ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(screenTransfer, "transfer");
        this.i.recover(screenTransfer, RatingPublishScreen.INSTANCE, ScreenPublicConstsKt.CONTENT_TYPE_PRELOAD);
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void startDraw() {
        ContentDrawingTracker contentDrawing = this.h.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_PRELOAD);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentDrawing;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void startInit() {
        this.g.start();
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void startNextStepDraw() {
        ContentDrawingTracker contentDrawing = this.h.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_NEXT_STEP);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentDrawing;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void startNextStepLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.h.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_NEXT_STEP);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.d = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void startSendRatingDraw() {
        ContentDrawingTracker contentDrawing = this.h.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_SEND_RATING);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentDrawing;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void startSendRatingLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.h.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_SEND_RATING);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.e = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackDiInject(long j) {
        this.f.track(j);
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackDraw() {
        ContentDrawingTracker contentDrawingTracker = this.a;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.g, 0, 1, null);
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackNextStepDrawFail() {
        ContentDrawingTracker contentDrawingTracker = this.b;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackNextStepDrawSuccess() {
        ContentDrawingTracker contentDrawingTracker = this.b;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackNextStepLoadingFail() {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackNextStepLoadingSuccess() {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackSendRatingDrawFail() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackSendRatingDrawSuccess() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackSendRatingLoadingFail() {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.rating.publish.tracker.RatingPublishTracker
    public void trackSendRatingLoadingSuccess() {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.e = null;
    }
}
