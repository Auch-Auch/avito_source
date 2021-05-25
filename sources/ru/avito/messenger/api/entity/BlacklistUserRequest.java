package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lru/avito/messenger/api/entity/BlacklistUserRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", ChannelContext.Item.USER_ID, "channelId", "itemId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/avito/messenger/api/entity/BlacklistUserRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getItemId", "getChannelId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistUserRequest {
    @SerializedName("channelId")
    @NotNull
    private final String channelId;
    @SerializedName("itemId")
    @Nullable
    private final String itemId;
    @SerializedName(ChannelContext.Item.USER_ID)
    @NotNull
    private final String userId;

    public BlacklistUserRequest(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        this.userId = str;
        this.channelId = str2;
        this.itemId = str3;
    }

    public static /* synthetic */ BlacklistUserRequest copy$default(BlacklistUserRequest blacklistUserRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blacklistUserRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = blacklistUserRequest.channelId;
        }
        if ((i & 4) != 0) {
            str3 = blacklistUserRequest.itemId;
        }
        return blacklistUserRequest.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @NotNull
    public final String component2() {
        return this.channelId;
    }

    @Nullable
    public final String component3() {
        return this.itemId;
    }

    @NotNull
    public final BlacklistUserRequest copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return new BlacklistUserRequest(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlacklistUserRequest)) {
            return false;
        }
        BlacklistUserRequest blacklistUserRequest = (BlacklistUserRequest) obj;
        return Intrinsics.areEqual(this.userId, blacklistUserRequest.userId) && Intrinsics.areEqual(this.channelId, blacklistUserRequest.channelId) && Intrinsics.areEqual(this.itemId, blacklistUserRequest.itemId);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channelId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.itemId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BlacklistUserRequest(userId=");
        L.append(this.userId);
        L.append(", channelId=");
        L.append(this.channelId);
        L.append(", itemId=");
        return a.t(L, this.itemId, ")");
    }
}
