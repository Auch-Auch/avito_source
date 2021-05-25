package ru.avito.messenger.api.entity.event;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lru/avito/messenger/api/entity/event/ReadMessageEvent;", "Lru/avito/messenger/api/entity/event/UserChatEvent;", "", "fromId", "Ljava/lang/String;", "getFromId", "()Ljava/lang/String;", "", "timeStamp", "J", "getTimeStamp", "()J", "", "messageIds", "Ljava/util/List;", "getMessageIds", "()Ljava/util/List;", "channelId", "getChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ReadMessageEvent implements UserChatEvent {
    @SerializedName("channelId")
    @NotNull
    private final String channelId;
    @SerializedName("fromUid")
    @NotNull
    private final String fromId;
    @SerializedName("ids")
    @NotNull
    private final List<String> messageIds;
    @SerializedName("time")
    private final long timeStamp;

    public ReadMessageEvent(@NotNull String str, @NotNull String str2, long j, @NotNull List<String> list) {
        a.c1(str, "channelId", str2, "fromId", list, "messageIds");
        this.channelId = str;
        this.fromId = str2;
        this.timeStamp = j;
        this.messageIds = list;
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

    @NotNull
    public final List<String> getMessageIds() {
        return this.messageIds;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }
}
