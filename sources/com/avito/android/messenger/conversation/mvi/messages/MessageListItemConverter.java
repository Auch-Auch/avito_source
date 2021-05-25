package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JK\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u00060\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "messagesAndMetaInfo", "", "currentUserId", "Lcom/avito/android/remote/model/User;", "users", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", Tracker.Events.CREATIVE_EXPAND, "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "messages", "", "newMessagesDividerPosition", "Lcom/avito/android/messenger/conversation/ChannelItem;", "finishConversion", "(Ljava/util/List;Ljava/util/List;I)Ljava/util/List;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageListItemConverter {
    @NotNull
    List<ChannelItem.Message> expand(@NotNull List<Pair<LocalMessage, MessageMetaInfo>> list, @NotNull String str, @NotNull List<User> list2);

    @NotNull
    List<ChannelItem> finishConversion(@NotNull List<ChannelItem.Message> list, @NotNull List<User> list2, int i);
}
