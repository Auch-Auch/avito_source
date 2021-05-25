package com.avito.android.messenger;

import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.InputState;
import com.avito.android.remote.model.messenger.ReadOnlyState;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.ChannelUser;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.Image;
import ru.avito.messenger.api.entity.body.item.BodyItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/MessengerEntityConverter;", "", "Lru/avito/messenger/api/entity/ChatMessage;", "message", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "convertMessage", "(Lru/avito/messenger/api/entity/ChatMessage;)Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/messenger/api/entity/Channel;", "channel", "Lcom/avito/android/remote/model/messenger/Channel;", "convertChannel", "(Lru/avito/messenger/api/entity/Channel;)Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/messenger/api/entity/ReadOnlyState;", "readOnlyState", "Lcom/avito/android/remote/model/messenger/ReadOnlyState;", "convertChannelReadOnlyState", "(Lru/avito/messenger/api/entity/ReadOnlyState;)Lcom/avito/android/remote/model/messenger/ReadOnlyState;", "Lru/avito/messenger/api/entity/InputState;", "inputState", "Lcom/avito/android/remote/model/messenger/InputState;", "convertChannelInputState", "(Lru/avito/messenger/api/entity/InputState;)Lcom/avito/android/remote/model/messenger/InputState;", "Lru/avito/messenger/api/entity/body/item/BodyItem;", "item", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "convertBody", "(Lru/avito/messenger/api/entity/body/item/BodyItem;)Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/Image;", "image", "convertImageBody", "(Lru/avito/messenger/api/entity/Image;)Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/ChannelUser;", "user", "Lcom/avito/android/remote/model/User;", "convertUser", "(Lru/avito/messenger/api/entity/ChannelUser;)Lcom/avito/android/remote/model/User;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerEntityConverter {
    @NotNull
    MessageBody convertBody(@NotNull BodyItem bodyItem);

    @NotNull
    Channel convertChannel(@NotNull ru.avito.messenger.api.entity.Channel channel);

    @NotNull
    InputState convertChannelInputState(@NotNull ru.avito.messenger.api.entity.InputState inputState);

    @NotNull
    ReadOnlyState convertChannelReadOnlyState(@NotNull ru.avito.messenger.api.entity.ReadOnlyState readOnlyState);

    @NotNull
    MessageBody convertImageBody(@NotNull Image image);

    @NotNull
    LocalMessage convertMessage(@NotNull ChatMessage chatMessage);

    @NotNull
    User convertUser(@NotNull ChannelUser channelUser);
}
