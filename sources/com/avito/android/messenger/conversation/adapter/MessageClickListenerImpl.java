package com.avito.android.messenger.conversation.adapter;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageClickListenerImpl;", "Lcom/avito/android/messenger/conversation/adapter/MessageClickListener;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "message", "", "onMessageErrorClick", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;)V", "onMessageBodyClick", "", "onMessageLongClick", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;)Z", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "messageListPresenter", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "messageMenuPresenter", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageClickListenerImpl implements MessageClickListener {
    public final MessageListPresenter a;
    public final MessageMenuPresenter b;

    public MessageClickListenerImpl(@NotNull MessageListPresenter messageListPresenter, @NotNull MessageMenuPresenter messageMenuPresenter) {
        Intrinsics.checkNotNullParameter(messageListPresenter, "messageListPresenter");
        Intrinsics.checkNotNullParameter(messageMenuPresenter, "messageMenuPresenter");
        this.a = messageListPresenter;
        this.b = messageMenuPresenter;
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageClickListener
    public void onMessageBodyClick(@NotNull ChannelItem.Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.a.onMessageClick(message.getBodyOrBubble(), message.getLocalMessage(), message.getMetaInfo());
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageClickListener
    public void onMessageErrorClick(@NotNull ChannelItem.Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.b.showMenuForMessage(message.getBodyOrBubble(), message.getLocalMessage());
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageClickListener
    public boolean onMessageLongClick(@NotNull ChannelItem.Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.b.showMenuForMessage(message.getBodyOrBubble(), message.getLocalMessage());
        return true;
    }
}
