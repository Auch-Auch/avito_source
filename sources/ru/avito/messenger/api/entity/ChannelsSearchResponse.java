package ru.avito.messenger.api.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/api/entity/ChannelsSearchResponse;", "", "", "hasMore", "Z", "getHasMore", "()Z", "", "Lru/avito/messenger/api/entity/ChannelSearchItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchResponse {
    @SerializedName("hasMore")
    private final boolean hasMore;
    @SerializedName("documents")
    @NotNull
    private final List<ChannelSearchItem> items;

    public ChannelsSearchResponse(@NotNull List<ChannelSearchItem> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.hasMore = z;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    @NotNull
    public final List<ChannelSearchItem> getItems() {
        return this.items;
    }
}
