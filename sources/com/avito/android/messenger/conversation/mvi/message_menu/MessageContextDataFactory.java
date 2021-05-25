package com.avito.android.messenger.conversation.mvi.message_menu;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.config.MessengerConfig;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;", "", "Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "", "url", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "createContextData", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageContextDataFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ MessageContextData createContextData$default(MessageContextDataFactory messageContextDataFactory, MessengerConfig messengerConfig, ChannelItem.Message.BodyOrBubble bodyOrBubble, LocalMessage localMessage, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str = null;
                }
                return messageContextDataFactory.createContextData(messengerConfig, bodyOrBubble, localMessage, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createContextData");
        }
    }

    @Nullable
    MessageContextData createContextData(@NotNull MessengerConfig messengerConfig, @NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @Nullable String str);
}
