package com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order;

import android.content.Intent;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.links.DeliveryOrderCancelLink;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessorImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessor;", "Lcom/avito/android/deep_linking/links/DeliveryOrderCancelLink;", "deeplink", "", "doProcess", "(Lcom/avito/android/deep_linking/links/DeliveryOrderCancelLink;)Z", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Landroid/content/Intent;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getOpenScreenIntentStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openScreenIntentStream", "Lcom/avito/android/ActivityIntentFactory;", "e", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "<init>", "(Lcom/avito/android/ActivityIntentFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryOrderCancelLinkProcessorImpl extends DeliveryOrderCancelLinkProcessor {
    @NotNull
    public final SingleLiveEvent<Intent> d = new SingleLiveEvent<>();
    public final ActivityIntentFactory e;

    public DeliveryOrderCancelLinkProcessorImpl(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        this.e = activityIntentFactory;
    }

    public boolean doProcess(@NotNull DeliveryOrderCancelLink deliveryOrderCancelLink) {
        Intrinsics.checkNotNullParameter(deliveryOrderCancelLink, "deeplink");
        getOpenScreenIntentStream().postValue(this.e.deliveryRdsOrderCancellationIntent(deliveryOrderCancelLink.getOrderId()));
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessor
    @NotNull
    public SingleLiveEvent<Intent> getOpenScreenIntentStream() {
        return this.d;
    }
}
