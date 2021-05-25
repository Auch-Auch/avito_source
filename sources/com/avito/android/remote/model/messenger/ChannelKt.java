package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\"\u0018\u0010\u0002\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00020\u0004*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0018\u0010\n\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/messenger/Channel;", "", "isNotAnswered", "(Lcom/avito/android/remote/model/messenger/Channel;)Z", "", "getItemId", "(Lcom/avito/android/remote/model/messenger/Channel;)Ljava/lang/String;", "itemId", "getShortStr", "shortStr", "isReadOnly", "models_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelKt {
    @Nullable
    public static final String getItemId(@NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$itemId");
        ChannelContext context = channel.getContext();
        if (!(context instanceof ChannelContext.Item)) {
            context = null;
        }
        ChannelContext.Item item = (ChannelContext.Item) context;
        if (item != null) {
            return item.getId();
        }
        return null;
    }

    @NotNull
    public static final String getShortStr(@NotNull Channel channel) {
        String str;
        Intrinsics.checkNotNullParameter(channel, "$this$shortStr");
        StringBuilder sb = new StringBuilder();
        sb.append("Channel{id=");
        sb.append(channel.getChannelId());
        sb.append(", lastMessage=");
        LocalMessage lastMessage = channel.getLastMessage();
        if (lastMessage != null) {
            StringBuilder L = a.L("LocalMessage(localId='");
            L.append(lastMessage.localId);
            L.append("', remoteId='");
            L.append(lastMessage.remoteId);
            L.append("', channelId='");
            L.append(lastMessage.channelId);
            L.append("', fromId='");
            str = a.t(L, lastMessage.fromId, "')");
        } else {
            str = null;
        }
        return a.s(sb, str, '}');
    }

    public static final boolean isNotAnswered(@NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isNotAnswered");
        return !channel.isAnswered();
    }

    public static final boolean isReadOnly(@NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isReadOnly");
        InputState inputState = channel.getInputState();
        if (inputState == null || !inputState.isDisabled()) {
            return channel.getInputState() == null && channel.getReadOnlyState() != null;
        }
        return true;
    }
}
