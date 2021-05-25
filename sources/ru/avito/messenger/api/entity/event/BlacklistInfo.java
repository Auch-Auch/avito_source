package ru.avito.messenger.api.entity.event;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.entity.messenger.BlacklistContext;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lru/avito/messenger/api/entity/event/BlacklistInfo;", "Lru/avito/messenger/api/entity/event/ChatEvent;", "", "getChannelId", "()Ljava/lang/String;", "channelId", "ownerId", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "getInterlocutorId", "interlocutorId", "Lru/avito/messenger/internal/entity/messenger/BlacklistContext;", "context", "Lru/avito/messenger/internal/entity/messenger/BlacklistContext;", "", "created", "J", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLru/avito/messenger/internal/entity/messenger/BlacklistContext;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistInfo implements ChatEvent {
    @SerializedName("context")
    @JvmField
    @NotNull
    public final BlacklistContext context;
    @SerializedName("created")
    @JvmField
    public final long created;
    @SerializedName("ownerId")
    @JvmField
    @NotNull
    public final String ownerId;
    @SerializedName(ChannelContext.Item.USER_ID)
    @JvmField
    @NotNull
    public final String userId;

    public BlacklistInfo(@NotNull String str, @NotNull String str2, long j, @NotNull BlacklistContext blacklistContext) {
        Intrinsics.checkNotNullParameter(str, "ownerId");
        Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(blacklistContext, "context");
        this.ownerId = str;
        this.userId = str2;
        this.created = j;
        this.context = blacklistContext;
    }

    @Override // ru.avito.messenger.api.entity.event.ChatEvent
    @NotNull
    public String getChannelId() {
        return "";
    }

    @NotNull
    public final String getInterlocutorId() {
        return this.userId;
    }
}
