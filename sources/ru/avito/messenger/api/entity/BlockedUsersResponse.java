package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lru/avito/messenger/api/entity/BlockedUsersResponse;", "", "", "component1", "()I", "", "Lru/avito/messenger/api/entity/BlockedUser;", "component2", "()Ljava/util/List;", "count", "users", "copy", "(ILjava/util/List;)Lru/avito/messenger/api/entity/BlockedUsersResponse;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCount", "Ljava/util/List;", "getUsers", "<init>", "(ILjava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlockedUsersResponse {
    @SerializedName("count")
    private final int count;
    @SerializedName("items")
    @NotNull
    private final List<BlockedUser> users;

    public BlockedUsersResponse(int i, @NotNull List<BlockedUser> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        this.count = i;
        this.users = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.api.entity.BlockedUsersResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlockedUsersResponse copy$default(BlockedUsersResponse blockedUsersResponse, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = blockedUsersResponse.count;
        }
        if ((i2 & 2) != 0) {
            list = blockedUsersResponse.users;
        }
        return blockedUsersResponse.copy(i, list);
    }

    public final int component1() {
        return this.count;
    }

    @NotNull
    public final List<BlockedUser> component2() {
        return this.users;
    }

    @NotNull
    public final BlockedUsersResponse copy(int i, @NotNull List<BlockedUser> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        return new BlockedUsersResponse(i, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockedUsersResponse)) {
            return false;
        }
        BlockedUsersResponse blockedUsersResponse = (BlockedUsersResponse) obj;
        return this.count == blockedUsersResponse.count && Intrinsics.areEqual(this.users, blockedUsersResponse.users);
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final List<BlockedUser> getUsers() {
        return this.users;
    }

    public int hashCode() {
        int i = this.count * 31;
        List<BlockedUser> list = this.users;
        return i + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BlockedUsersResponse(count=");
        L.append(this.count);
        L.append(", users=");
        return a.w(L, this.users, ")");
    }
}
