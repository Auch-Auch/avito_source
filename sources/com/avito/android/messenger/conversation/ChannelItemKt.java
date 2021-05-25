package com.avito.android.messenger.conversation;

import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\u0002\u0010\u0005\"\u0018\u0010\b\u001a\u00020\u0007*\u00020\u00068Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u0007*\u00020\u00068Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\t\"\u0018\u0010\f\u001a\u00020\u0007*\u00020\u000b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u000f\u001a\u00020\u0007*\u00020\u000b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "toBodyOrBubble", "(Lcom/avito/android/remote/model/messenger/message/MessageBody;)Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;)Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;", "", "isAtGroupStart", "(Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;)Z", "isAtGroupEnd", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "isPending", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;)Z", "getHasError", "hasError", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelItemKt {
    public static final boolean getHasError(@NotNull ChannelItem.Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$hasError");
        return message.getStatus() == MessageDeliveryStatus.ERROR;
    }

    public static final boolean isAtGroupEnd(@NotNull ChannelItem.GroupFlags groupFlags) {
        Intrinsics.checkNotNullParameter(groupFlags, "$this$isAtGroupEnd");
        return groupFlags.isAtUserGroupEnd() || groupFlags.isAtDateGroupEnd() || groupFlags.isBeforeSystemMessage() || groupFlags.isLastOldMessage();
    }

    public static final boolean isAtGroupStart(@NotNull ChannelItem.GroupFlags groupFlags) {
        Intrinsics.checkNotNullParameter(groupFlags, "$this$isAtGroupStart");
        return groupFlags.isAtUserGroupStart() || groupFlags.isAtDateGroupStart() || groupFlags.isAfterSystemMessage() || groupFlags.isFirstNewMessage();
    }

    public static final boolean isPending(@NotNull ChannelItem.Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$isPending");
        return message.getStatus() == MessageDeliveryStatus.SENDING;
    }

    @NotNull
    public static final ChannelItem.Message.BodyOrBubble toBodyOrBubble(@NotNull MessageBody messageBody) {
        Intrinsics.checkNotNullParameter(messageBody, "$this$toBodyOrBubble");
        return new ChannelItem.Message.BodyOrBubble.Body(messageBody);
    }

    @NotNull
    public static final ChannelItem.Message.BodyOrBubble toBodyOrBubble(@NotNull MessageBody.SystemMessageBody.Platform.Bubble bubble) {
        Intrinsics.checkNotNullParameter(bubble, "$this$toBodyOrBubble");
        return new ChannelItem.Message.BodyOrBubble.Bubble(bubble);
    }
}
