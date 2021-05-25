package com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeliveryOrderCancelLink;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessor;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessor;", "Lcom/avito/android/deep_linking/links/DeliveryOrderCancelLink;", "Landroidx/lifecycle/LiveData;", "Landroid/content/Intent;", "getOpenScreenIntentStream", "()Landroidx/lifecycle/LiveData;", "openScreenIntentStream", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class DeliveryOrderCancelLinkProcessor extends AbstractDeeplinkProcessor<DeliveryOrderCancelLink> {
    public DeliveryOrderCancelLinkProcessor() {
        super(DeliveryOrderCancelLink.class);
    }

    @NotNull
    public abstract LiveData<Intent> getOpenScreenIntentStream();
}
