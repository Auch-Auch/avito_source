package com.avito.android.messenger.conversation.adapter.item;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/item/ItemMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/item/ItemMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/item/ItemMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "", "d", "Ljava/lang/String;", "notLoadedItemDescription", "c", "notLoadedItemTitle", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMessagePresenter implements ItemPresenter<ItemMessageView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;
    public final String c;
    public final String d;

    public ItemMessagePresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(str, "notLoadedItemTitle");
        Intrinsics.checkNotNullParameter(str2, "notLoadedItemDescription");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
        this.c = str;
        this.d = str2;
    }

    public void bindView(@NotNull ItemMessageView itemMessageView, @NotNull ChannelItem.Message message, int i) {
        Intrinsics.checkNotNullParameter(itemMessageView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (itemMessageView instanceof IncomingMessageView) {
            this.a.bindView(itemMessageView, message, i);
        } else if (itemMessageView instanceof OutgoingMessageView) {
            this.b.bindView(itemMessageView, message, i);
        }
        MessageBody body = message.getBodyOrBubble().getBody();
        if (body instanceof MessageBody.Item) {
            MessageBody.Item item = (MessageBody.Item) body;
            itemMessageView.setTitle(item.getTitle());
            itemMessageView.setPrice(item.getPrice());
            itemMessageView.setLocation(item.getLocation());
            itemMessageView.loadImage(item.getImage());
        } else if (body instanceof MessageBody.ItemReference) {
            itemMessageView.setTitle(this.c);
            itemMessageView.setLocation(this.d);
            itemMessageView.setPrice(null);
            itemMessageView.loadImage(null);
        } else {
            itemMessageView.setTitle("");
            itemMessageView.setLocation("");
            itemMessageView.setPrice(null);
            itemMessageView.loadImage(null);
            Logs.debug$default("ItemMessagePresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
        }
    }
}
