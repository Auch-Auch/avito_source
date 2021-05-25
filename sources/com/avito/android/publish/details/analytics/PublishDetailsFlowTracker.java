package com.avito.android.publish.details.analytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\fJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007J#\u0010\t\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H&¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;", "", "", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;", "flowContext", "", "startPrepare", "([Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)V", "trackPrepare", "startDraw", "trackDraw", "()V", "FlowContext", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDetailsFlowTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INIT", "PARAMETER_VALUE_UPDATE", "ANONYMOUS_NUMBER_SLOT_UPDATE", "CONTACT_INFO_SLOT_UPDATE", "INFORMATION_WITH_USER_ID_SLOT_UPDATE", "MARKET_PRICE_SLOT_UPDATE", "AUTO_PUBLISH_SLOT_UPDATE", "POST_PROCESSING", "SUBMIT", "FORM_UPDATE", "publish_release"}, k = 1, mv = {1, 4, 2})
    public enum FlowContext {
        UNKNOWN,
        INIT,
        PARAMETER_VALUE_UPDATE,
        ANONYMOUS_NUMBER_SLOT_UPDATE,
        CONTACT_INFO_SLOT_UPDATE,
        INFORMATION_WITH_USER_ID_SLOT_UPDATE,
        MARKET_PRICE_SLOT_UPDATE,
        AUTO_PUBLISH_SLOT_UPDATE,
        POST_PROCESSING,
        SUBMIT,
        FORM_UPDATE
    }

    void startDraw(@NotNull FlowContext... flowContextArr);

    void startPrepare(@NotNull FlowContext... flowContextArr);

    void trackDraw();

    void trackPrepare(@NotNull FlowContext... flowContextArr);
}
