package com.avito.android.publish.details.analytics;

import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J#\u0010\t\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTrackerImpl;", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;", "", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;", "flowContext", "", "startPrepare", "([Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)V", "trackPrepare", "startDraw", "trackDraw", "()V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", AuthSource.BOOKING_ORDER, "Ljava/util/HashSet;", "flowTrackersOnDraw", "Lcom/avito/android/publish/details/analytics/FlowTrackerFactory;", "c", "Lcom/avito/android/publish/details/analytics/FlowTrackerFactory;", "flowTrackerFactory", "", "Lcom/avito/android/publish/details/analytics/FlowTracker;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "flowTrackerCache", "<init>", "(Lcom/avito/android/publish/details/analytics/FlowTrackerFactory;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDetailsFlowTrackerImpl implements PublishDetailsFlowTracker {
    public final Map<PublishDetailsFlowTracker.FlowContext, FlowTracker> a = new LinkedHashMap();
    public final HashSet<PublishDetailsFlowTracker.FlowContext> b = new HashSet<>();
    public final FlowTrackerFactory c;

    @Inject
    public PublishDetailsFlowTrackerImpl(@NotNull FlowTrackerFactory flowTrackerFactory) {
        Intrinsics.checkNotNullParameter(flowTrackerFactory, "flowTrackerFactory");
        this.c = flowTrackerFactory;
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsFlowTracker
    public void startDraw(@NotNull PublishDetailsFlowTracker.FlowContext... flowContextArr) {
        Intrinsics.checkNotNullParameter(flowContextArr, "flowContext");
        for (PublishDetailsFlowTracker.FlowContext flowContext : flowContextArr) {
            FlowTracker flowTracker = this.a.get(flowContext);
            if (flowTracker != null) {
                flowTracker.startDraw();
            }
            this.b.add(flowContext);
        }
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsFlowTracker
    public void startPrepare(@NotNull PublishDetailsFlowTracker.FlowContext... flowContextArr) {
        Intrinsics.checkNotNullParameter(flowContextArr, "flowContext");
        for (PublishDetailsFlowTracker.FlowContext flowContext : flowContextArr) {
            FlowTracker createFlowTracker = this.c.createFlowTracker(flowContext);
            if (createFlowTracker != null) {
                this.a.put(flowContext, createFlowTracker);
                createFlowTracker.startPrepare();
            }
        }
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsFlowTracker
    public void trackDraw() {
        for (T t : this.b) {
            FlowTracker flowTracker = this.a.get(t);
            if (flowTracker != null) {
                flowTracker.trackDraw();
            }
            this.a.remove(t);
        }
        this.b.clear();
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsFlowTracker
    public void trackPrepare(@NotNull PublishDetailsFlowTracker.FlowContext... flowContextArr) {
        Intrinsics.checkNotNullParameter(flowContextArr, "flowContext");
        for (PublishDetailsFlowTracker.FlowContext flowContext : flowContextArr) {
            FlowTracker flowTracker = this.a.get(flowContext);
            if (flowTracker != null) {
                flowTracker.trackPrepare();
            }
        }
    }
}
