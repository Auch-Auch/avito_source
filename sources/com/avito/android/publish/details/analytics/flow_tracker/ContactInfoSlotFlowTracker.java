package com.avito.android.publish.details.analytics.flow_tracker;

import com.avito.android.publish.details.analytics.FlowTracker;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/details/analytics/flow_tracker/ContactInfoSlotFlowTracker;", "Lcom/avito/android/publish/details/analytics/FlowTracker;", "", "startPrepare", "()V", "trackPrepare", "startDraw", "trackDraw", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "screenTracker", "<init>", "(Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ContactInfoSlotFlowTracker implements FlowTracker {
    public final PublishDetailsTracker a;

    public ContactInfoSlotFlowTracker(@NotNull PublishDetailsTracker publishDetailsTracker) {
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "screenTracker");
        this.a = publishDetailsTracker;
    }

    @Override // com.avito.android.publish.details.analytics.FlowTracker
    public void startDraw() {
        this.a.startContactInfoSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.FlowTracker
    public void startPrepare() {
        this.a.startContactInfoSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.FlowTracker
    public void trackDraw() {
        this.a.trackContactInfoSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.FlowTracker
    public void trackPrepare() {
        this.a.trackContactInfoSlotPrepare();
    }
}
