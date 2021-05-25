package ru.avito.messenger.api.entity.event;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/event/BlacklistRemoveEvent;", "", "", ChannelContext.Item.USER_ID, "Ljava/lang/String;", "ownerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistRemoveEvent {
    @SerializedName("ownerId")
    @JvmField
    @NotNull
    public final String ownerId;
    @SerializedName(ChannelContext.Item.USER_ID)
    @JvmField
    @NotNull
    public final String userId;

    public BlacklistRemoveEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "ownerId");
        Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
        this.ownerId = str;
        this.userId = str2;
    }
}
