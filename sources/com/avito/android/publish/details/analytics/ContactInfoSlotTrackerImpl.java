package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/details/analytics/ContactInfoSlotTrackerImpl;", "Lcom/avito/android/publish/details/analytics/ContactInfoSlotTracker;", "", "startContactInfoSlotPrepare", "()V", "trackContactInfoSlotPrepare", "startContactInfoSlotDraw", "trackContactInfoSlotDraw", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "contactInfoSlotPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contactInfoSlotDrawingTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "c", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "<init>", "(Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ContactInfoSlotTrackerImpl implements ContactInfoSlotTracker {
    public ViewDataPreparingTracker a;
    public ContentDrawingTracker b;
    public final ScreenFlowTrackerProvider c;

    @Inject
    public ContactInfoSlotTrackerImpl(@NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.c = screenFlowTrackerProvider;
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void startContactInfoSlotDraw() {
        ContentDrawingTracker contentDrawing = this.c.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_CONTACT_INFO_SLOT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentDrawing;
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void startContactInfoSlotPrepare() {
        ViewDataPreparingTracker viewPreparing = this.c.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_CONTACT_INFO_SLOT);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.a = viewPreparing;
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void trackContactInfoSlotDraw() {
        ContentDrawingTracker contentDrawingTracker = this.b;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void trackContactInfoSlotPrepare() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.a;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, false);
        }
        this.a = null;
    }
}
