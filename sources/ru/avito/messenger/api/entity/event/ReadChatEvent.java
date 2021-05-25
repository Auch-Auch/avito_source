package ru.avito.messenger.api.entity.event;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/api/entity/event/ReadChatEvent;", "Lru/avito/messenger/api/entity/event/UserChatEvent;", "", "fromId", "Ljava/lang/String;", "getFromId", "()Ljava/lang/String;", "channelId", "getChannelId", "", "timeStamp", "J", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ReadChatEvent implements UserChatEvent {
    @SerializedName("channelId")
    @NotNull
    private final String channelId;
    @SerializedName("fromUid")
    @NotNull
    private final String fromId;
    @SerializedName("time")
    @JvmField
    public final long timeStamp;

    public ReadChatEvent(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "fromId");
        this.channelId = str;
        this.fromId = str2;
        this.timeStamp = j;
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
