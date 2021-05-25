package com.avito.android.messenger.conversation.adapter;

import com.avito.android.messenger.conversation.ChannelItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageClickListener;", "", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "message", "", "onMessageErrorClick", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;)V", "onMessageBodyClick", "", "onMessageLongClick", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;)Z", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageClickListener {
    void onMessageBodyClick(@NotNull ChannelItem.Message message);

    void onMessageErrorClick(@NotNull ChannelItem.Message message);

    boolean onMessageLongClick(@NotNull ChannelItem.Message message);
}
