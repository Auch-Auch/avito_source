package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lru/avito/messenger/api/entity/ChannelSearchItem;", "", "Lru/avito/messenger/api/entity/Channel;", "component1", "()Lru/avito/messenger/api/entity/Channel;", "Lru/avito/messenger/api/entity/ChatMessage;", "component2", "()Lru/avito/messenger/api/entity/ChatMessage;", "channel", "message", "copy", "(Lru/avito/messenger/api/entity/Channel;Lru/avito/messenger/api/entity/ChatMessage;)Lru/avito/messenger/api/entity/ChannelSearchItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/avito/messenger/api/entity/ChatMessage;", "getMessage", "Lru/avito/messenger/api/entity/Channel;", "getChannel", "<init>", "(Lru/avito/messenger/api/entity/Channel;Lru/avito/messenger/api/entity/ChatMessage;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelSearchItem {
    @SerializedName("channel")
    @NotNull
    private final Channel channel;
    @SerializedName("message")
    @Nullable
    private final ChatMessage message;

    public ChannelSearchItem(@NotNull Channel channel2, @Nullable ChatMessage chatMessage) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.channel = channel2;
        this.message = chatMessage;
    }

    public static /* synthetic */ ChannelSearchItem copy$default(ChannelSearchItem channelSearchItem, Channel channel2, ChatMessage chatMessage, int i, Object obj) {
        if ((i & 1) != 0) {
            channel2 = channelSearchItem.channel;
        }
        if ((i & 2) != 0) {
            chatMessage = channelSearchItem.message;
        }
        return channelSearchItem.copy(channel2, chatMessage);
    }

    @NotNull
    public final Channel component1() {
        return this.channel;
    }

    @Nullable
    public final ChatMessage component2() {
        return this.message;
    }

    @NotNull
    public final ChannelSearchItem copy(@NotNull Channel channel2, @Nullable ChatMessage chatMessage) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        return new ChannelSearchItem(channel2, chatMessage);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelSearchItem)) {
            return false;
        }
        ChannelSearchItem channelSearchItem = (ChannelSearchItem) obj;
        return Intrinsics.areEqual(this.channel, channelSearchItem.channel) && Intrinsics.areEqual(this.message, channelSearchItem.message);
    }

    @NotNull
    public final Channel getChannel() {
        return this.channel;
    }

    @Nullable
    public final ChatMessage getMessage() {
        return this.message;
    }

    public int hashCode() {
        Channel channel2 = this.channel;
        int i = 0;
        int hashCode = (channel2 != null ? channel2.hashCode() : 0) * 31;
        ChatMessage chatMessage = this.message;
        if (chatMessage != null) {
            i = chatMessage.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelSearchItem(channel=");
        L.append(this.channel);
        L.append(", message=");
        L.append(this.message);
        L.append(")");
        return L.toString();
    }
}
