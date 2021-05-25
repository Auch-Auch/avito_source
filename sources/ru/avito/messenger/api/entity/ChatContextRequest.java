package ru.avito.messenger.api.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lru/avito/messenger/api/entity/ChatContextRequest;", "", "", "", "userIds", "Ljava/util/List;", "getUserIds", "()Ljava/util/List;", "channelId", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "type", "getType", "itemId", "getItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatContextRequest {
    @SerializedName("channelId")
    @NotNull
    private final String channelId;
    @SerializedName("itemId")
    @NotNull
    private final String itemId;
    @SerializedName("type")
    @NotNull
    private final String type;
    @SerializedName("userIds")
    @NotNull
    private final List<String> userIds;

    public ChatContextRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "itemId");
        Intrinsics.checkNotNullParameter(list, "userIds");
        this.channelId = str;
        this.type = str2;
        this.itemId = str3;
        this.userIds = list;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final List<String> getUserIds() {
        return this.userIds;
    }
}
