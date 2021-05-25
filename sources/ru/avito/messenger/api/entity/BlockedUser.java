package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.context.ChannelContext;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0014\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\rR\u001c\u0010\u0015\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u0013¨\u0006+"}, d2 = {"Lru/avito/messenger/api/entity/BlockedUser;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lru/avito/messenger/api/entity/ChannelUser;", "component1", "()Lru/avito/messenger/api/entity/ChannelUser;", "Lru/avito/messenger/api/entity/context/ChannelContext;", "component2", "()Lru/avito/messenger/api/entity/context/ChannelContext;", "", "component3", "()J", "user", "context", "created", "copy", "(Lru/avito/messenger/api/entity/ChannelUser;Lru/avito/messenger/api/entity/context/ChannelContext;J)Lru/avito/messenger/api/entity/BlockedUser;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/avito/messenger/api/entity/ChannelUser;", "getUser", "Lru/avito/messenger/api/entity/context/ChannelContext;", "getContext", "J", "getCreated", "<init>", "(Lru/avito/messenger/api/entity/ChannelUser;Lru/avito/messenger/api/entity/context/ChannelContext;J)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlockedUser implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<BlockedUser> CREATOR = Parcels.creator(BlockedUser$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("context")
    @NotNull
    private final ChannelContext context;
    @SerializedName("created")
    private final long created;
    @SerializedName("user")
    @NotNull
    private final ChannelUser user;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/BlockedUser$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/BlockedUser;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public BlockedUser(@NotNull ChannelUser channelUser, @NotNull ChannelContext channelContext, long j) {
        Intrinsics.checkNotNullParameter(channelUser, "user");
        Intrinsics.checkNotNullParameter(channelContext, "context");
        this.user = channelUser;
        this.context = channelContext;
        this.created = j;
    }

    public static /* synthetic */ BlockedUser copy$default(BlockedUser blockedUser, ChannelUser channelUser, ChannelContext channelContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            channelUser = blockedUser.user;
        }
        if ((i & 2) != 0) {
            channelContext = blockedUser.context;
        }
        if ((i & 4) != 0) {
            j = blockedUser.created;
        }
        return blockedUser.copy(channelUser, channelContext, j);
    }

    @NotNull
    public final ChannelUser component1() {
        return this.user;
    }

    @NotNull
    public final ChannelContext component2() {
        return this.context;
    }

    public final long component3() {
        return this.created;
    }

    @NotNull
    public final BlockedUser copy(@NotNull ChannelUser channelUser, @NotNull ChannelContext channelContext, long j) {
        Intrinsics.checkNotNullParameter(channelUser, "user");
        Intrinsics.checkNotNullParameter(channelContext, "context");
        return new BlockedUser(channelUser, channelContext, j);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockedUser)) {
            return false;
        }
        BlockedUser blockedUser = (BlockedUser) obj;
        return Intrinsics.areEqual(this.user, blockedUser.user) && Intrinsics.areEqual(this.context, blockedUser.context) && this.created == blockedUser.created;
    }

    @NotNull
    public final ChannelContext getContext() {
        return this.context;
    }

    public final long getCreated() {
        return this.created;
    }

    @NotNull
    public final ChannelUser getUser() {
        return this.user;
    }

    @Override // java.lang.Object
    public int hashCode() {
        ChannelUser channelUser = this.user;
        int i = 0;
        int hashCode = (channelUser != null ? channelUser.hashCode() : 0) * 31;
        ChannelContext channelContext = this.context;
        if (channelContext != null) {
            i = channelContext.hashCode();
        }
        return ((hashCode + i) * 31) + c.a(this.created);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BlockedUser(user=");
        L.append(this.user);
        L.append(", context=");
        L.append(this.context);
        L.append(", created=");
        return a.l(L, this.created, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.user, i);
        parcel.writeParcelable(this.context, i);
        parcel.writeLong(this.created);
    }
}
