package com.avito.android.messenger.conversation.adapter.platform.from_avito.item;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformItemMessageFromAvitoPresenter implements ItemPresenter<PlatformItemMessageFromAvitoView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;

    public PlatformItemMessageFromAvitoPresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        this.a = incomingMessagePresenter;
    }

    public void bindView(@NotNull PlatformItemMessageFromAvitoView platformItemMessageFromAvitoView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(platformItemMessageFromAvitoView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        this.a.bindView(platformItemMessageFromAvitoView, message, i);
        MessageBody.SystemMessageBody.Platform.Bubble bubble = message.getBodyOrBubble().getBubble();
        if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Item)) {
            bubble = null;
        }
        MessageBody.SystemMessageBody.Platform.Bubble.Item item = (MessageBody.SystemMessageBody.Platform.Bubble.Item) bubble;
        if (item != null) {
            platformItemMessageFromAvitoView.setTitle(item.getTitle());
            platformItemMessageFromAvitoView.setNewPrice(item.getPriceString());
            platformItemMessageFromAvitoView.setOldPrice(item.getOldPriceString());
            platformItemMessageFromAvitoView.setLocation(item.getLocationWithMetro());
            platformItemMessageFromAvitoView.setImage(item.getImageBySizes());
            platformItemMessageFromAvitoView.overrideMargins(message.getOverrideTopMarginDp(), message.getOverrideBottomMarginDp());
            return;
        }
        platformItemMessageFromAvitoView.setTitle("");
        platformItemMessageFromAvitoView.setNewPrice("");
        platformItemMessageFromAvitoView.setOldPrice(null);
        platformItemMessageFromAvitoView.setLocation(null);
        platformItemMessageFromAvitoView.setImage(null);
        Logs.debug$default("PlatformItemMessageFromAvitoPresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}
