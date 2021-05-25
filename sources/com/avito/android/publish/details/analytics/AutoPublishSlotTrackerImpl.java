package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/publish/details/analytics/AutoPublishSlotTrackerImpl;", "Lcom/avito/android/publish/details/analytics/AutoPublishSlotTracker;", "", "startAutoPublishSlotLoading", "()V", "trackAutoPublishSlotLoaded", "trackAutoPublishSlotLoadError", "startAutoPublishSlotPrepare", "trackAutoPublishSlotPrepare", "startAutoPublishSlotDraw", "trackAutoPublishSlotDraw", "", "result", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "d", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "autoPublishSlotLoadTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "autoPublishSlotPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "autoPublishSlotDrawingTracker", "<init>", "(Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AutoPublishSlotTrackerImpl implements AutoPublishSlotTracker {
    public ContentLoadingTracker a;
    public ViewDataPreparingTracker b;
    public ContentDrawingTracker c;
    public final ScreenFlowTrackerProvider d;

    @Inject
    public AutoPublishSlotTrackerImpl(@NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.d = screenFlowTrackerProvider;
    }

    public final void a(String str) {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, str, 0, 4, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void startAutoPublishSlotDraw() {
        ContentDrawingTracker contentDrawing = this.d.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_AUTO_PUBLISH_SLOT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentDrawing;
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void startAutoPublishSlotLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.d.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_AUTO_PUBLISH_SLOT);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void startAutoPublishSlotPrepare() {
        ViewDataPreparingTracker viewPreparing = this.d.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_AUTO_PUBLISH_SLOT);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.b = viewPreparing;
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotDraw() {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotLoadError() {
        a(PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotLoaded() {
        a("success");
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotPrepare() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.b;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, false);
        }
        this.b = null;
    }
}
