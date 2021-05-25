package ru.avito.messenger.api.entity.event;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0007\u001a\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lru/avito/messenger/api/entity/event/ChatClearEvent;", "Lru/avito/messenger/api/entity/event/ChatEvent;", "", "component1", "()Ljava/lang/String;", "component2", "uid", "Ljava/lang/String;", "channelId", "getChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatClearEvent implements ChatEvent {
    @SerializedName("channelId")
    @NotNull
    private final String channelId;
    @SerializedName("uid")
    @JvmField
    @NotNull
    public final String uid;

    public ChatClearEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "uid");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        this.uid = str;
        this.channelId = str2;
    }

    @NotNull
    public final String component1() {
        return this.uid;
    }

    @NotNull
    public final String component2() {
        return getChannelId();
    }

    @Override // ru.avito.messenger.api.entity.event.ChatEvent
    @NotNull
    public String getChannelId() {
        return this.channelId;
    }
}
