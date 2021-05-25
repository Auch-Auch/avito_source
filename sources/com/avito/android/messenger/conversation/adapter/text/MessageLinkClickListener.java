package com.avito.android.messenger.conversation.adapter.text;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;", "", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "", "url", "", "onMessageLinkClicked", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)V", "onMessageLinkLongClicked", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageLinkClickListener {
    void onMessageLinkClicked(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str);

    void onMessageLinkLongClicked(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str);
}
