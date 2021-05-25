package com.avito.android.publish.details.analytics;

import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.details.analytics.flow_tracker.AnonymousNumberSlotFlowTracker;
import com.avito.android.publish.details.analytics.flow_tracker.AutoPublishSlotFlowTracker;
import com.avito.android.publish.details.analytics.flow_tracker.ContactInfoSlotFlowTracker;
import com.avito.android.publish.details.analytics.flow_tracker.InformationWithUserIdSlotFlowTracker;
import com.avito.android.publish.details.analytics.flow_tracker.InitFlowTracker;
import com.avito.android.publish.details.analytics.flow_tracker.MarketPriceSlotFlowTracker;
import com.avito.android.publish.details.analytics.flow_tracker.UpdateFlowTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/details/analytics/FlowTrackerFactoryImpl;", "Lcom/avito/android/publish/details/analytics/FlowTrackerFactory;", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;", "flowContext", "Lcom/avito/android/publish/details/analytics/FlowTracker;", "createFlowTracker", "(Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)Lcom/avito/android/publish/details/analytics/FlowTracker;", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "screenTracker", "<init>", "(Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class FlowTrackerFactoryImpl implements FlowTrackerFactory {
    public final PublishDetailsTracker a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PublishDetailsFlowTracker.FlowContext.values();
            int[] iArr = new int[11];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[10] = 2;
            iArr[3] = 3;
            iArr[7] = 4;
            iArr[4] = 5;
            iArr[5] = 6;
            iArr[6] = 7;
        }
    }

    @Inject
    public FlowTrackerFactoryImpl(@NotNull PublishDetailsTracker publishDetailsTracker) {
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "screenTracker");
        this.a = publishDetailsTracker;
    }

    @Override // com.avito.android.publish.details.analytics.FlowTrackerFactory
    @Nullable
    public FlowTracker createFlowTracker(@NotNull PublishDetailsFlowTracker.FlowContext flowContext) {
        Intrinsics.checkNotNullParameter(flowContext, "flowContext");
        int ordinal = flowContext.ordinal();
        if (ordinal == 1) {
            return new InitFlowTracker(this.a);
        }
        if (ordinal == 10) {
            return new UpdateFlowTracker(this.a);
        }
        if (ordinal == 3) {
            return new AnonymousNumberSlotFlowTracker(this.a);
        }
        if (ordinal == 4) {
            return new ContactInfoSlotFlowTracker(this.a);
        }
        if (ordinal == 5) {
            return new InformationWithUserIdSlotFlowTracker(this.a);
        }
        if (ordinal == 6) {
            return new MarketPriceSlotFlowTracker(this.a);
        }
        if (ordinal != 7) {
            return null;
        }
        return new AutoPublishSlotFlowTracker(this.a);
    }
}
