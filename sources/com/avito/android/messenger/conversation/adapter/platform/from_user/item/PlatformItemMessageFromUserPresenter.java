package com.avito.android.messenger.conversation.adapter.platform.from_user.item;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformItemMessageFromUserPresenter implements ItemPresenter<PlatformItemMessageFromUserView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;

    public PlatformItemMessageFromUserPresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
    }

    public void bindView(@NotNull PlatformItemMessageFromUserView platformItemMessageFromUserView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(platformItemMessageFromUserView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (platformItemMessageFromUserView instanceof IncomingMessageView) {
            this.a.bindView(platformItemMessageFromUserView, message, i);
        } else if (platformItemMessageFromUserView instanceof OutgoingMessageView) {
            this.b.bindView(platformItemMessageFromUserView, message, i);
        }
        MessageBody.SystemMessageBody.Platform.Bubble bubble = message.getBodyOrBubble().getBubble();
        if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Item)) {
            bubble = null;
        }
        MessageBody.SystemMessageBody.Platform.Bubble.Item item = (MessageBody.SystemMessageBody.Platform.Bubble.Item) bubble;
        if (item != null) {
            platformItemMessageFromUserView.setTitle(item.getTitle());
            platformItemMessageFromUserView.setNewPrice(item.getPriceString());
            platformItemMessageFromUserView.setOldPrice(item.getOldPriceString());
            platformItemMessageFromUserView.setLocation(item.getLocationWithMetro());
            platformItemMessageFromUserView.setImage(item.getImageBySizes());
            return;
        }
        platformItemMessageFromUserView.setTitle("");
        platformItemMessageFromUserView.setNewPrice("");
        platformItemMessageFromUserView.setOldPrice(null);
        platformItemMessageFromUserView.setLocation(null);
        platformItemMessageFromUserView.setImage(null);
        Logs.debug$default("PlatformItemMessageFromUserPresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}
