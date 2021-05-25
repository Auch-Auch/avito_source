package ru.avito.messenger.api.entity.event;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "Lru/avito/messenger/api/entity/event/UserChatEvent;", "", "uid", "Ljava/lang/String;", "channelId", "getChannelId", "()Ljava/lang/String;", "fromId", "getFromId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatTypingEvent implements UserChatEvent {
    @SerializedName("channelId")
    @NotNull
    private final String channelId;
    @SerializedName("fromUid")
    @NotNull
    private final String fromId;
    @SerializedName("uid")
    @JvmField
    @NotNull
    public final String uid;

    public ChatTypingEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "channelId", str2, "fromId", str3, "uid");
        this.channelId = str;
        this.fromId = str2;
        this.uid = str3;
    }

    @Override // ru.avito.messenger.api.entity.event.UserChatEvent, ru.avito.messenger.api.entity.event.ChatEvent
    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    @Override // ru.avito.messenger.api.entity.event.UserChatEvent
    @NotNull
    public String getFromId() {
        return this.fromId;
    }
}
