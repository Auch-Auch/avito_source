package com.avito.android.messenger.channels.mvi.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.android.persistence.messenger.ChannelTag;
import ru.avito.android.persistence.messenger.MessageEntity;
import ru.avito.android.persistence.messenger.UserEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJF\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000fR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\f¨\u0006."}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelDbEntities;", "", "Lru/avito/android/persistence/messenger/ChannelEntity;", "component1", "()Lru/avito/android/persistence/messenger/ChannelEntity;", "", "Lru/avito/android/persistence/messenger/UserEntity;", "component2", "()Ljava/util/List;", "", "Lru/avito/android/persistence/messenger/ChannelTag;", "component3", "()Ljava/util/Collection;", "Lru/avito/android/persistence/messenger/MessageEntity;", "component4", "()Lru/avito/android/persistence/messenger/MessageEntity;", "channelEntity", "userEntities", "channelTags", "lastMessage", "copy", "(Lru/avito/android/persistence/messenger/ChannelEntity;Ljava/util/List;Ljava/util/Collection;Lru/avito/android/persistence/messenger/MessageEntity;)Lcom/avito/android/messenger/channels/mvi/data/ChannelDbEntities;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getUserEntities", AuthSource.SEND_ABUSE, "Lru/avito/android/persistence/messenger/ChannelEntity;", "getChannelEntity", "d", "Lru/avito/android/persistence/messenger/MessageEntity;", "getLastMessage", "c", "Ljava/util/Collection;", "getChannelTags", "<init>", "(Lru/avito/android/persistence/messenger/ChannelEntity;Ljava/util/List;Ljava/util/Collection;Lru/avito/android/persistence/messenger/MessageEntity;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelDbEntities {
    @NotNull
    public final ChannelEntity a;
    @NotNull
    public final List<UserEntity> b;
    @NotNull
    public final Collection<ChannelTag> c;
    @Nullable
    public final MessageEntity d;

    public ChannelDbEntities(@NotNull ChannelEntity channelEntity, @NotNull List<UserEntity> list, @NotNull Collection<ChannelTag> collection, @Nullable MessageEntity messageEntity) {
        Intrinsics.checkNotNullParameter(channelEntity, "channelEntity");
        Intrinsics.checkNotNullParameter(list, "userEntities");
        Intrinsics.checkNotNullParameter(collection, "channelTags");
        this.a = channelEntity;
        this.b = list;
        this.c = collection;
        this.d = messageEntity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.channels.mvi.data.ChannelDbEntities */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelDbEntities copy$default(ChannelDbEntities channelDbEntities, ChannelEntity channelEntity, List list, Collection collection, MessageEntity messageEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            channelEntity = channelDbEntities.a;
        }
        if ((i & 2) != 0) {
            list = channelDbEntities.b;
        }
        if ((i & 4) != 0) {
            collection = channelDbEntities.c;
        }
        if ((i & 8) != 0) {
            messageEntity = channelDbEntities.d;
        }
        return channelDbEntities.copy(channelEntity, list, collection, messageEntity);
    }

    @NotNull
    public final ChannelEntity component1() {
        return this.a;
    }

    @NotNull
    public final List<UserEntity> component2() {
        return this.b;
    }

    @NotNull
    public final Collection<ChannelTag> component3() {
        return this.c;
    }

    @Nullable
    public final MessageEntity component4() {
        return this.d;
    }

    @NotNull
    public final ChannelDbEntities copy(@NotNull ChannelEntity channelEntity, @NotNull List<UserEntity> list, @NotNull Collection<ChannelTag> collection, @Nullable MessageEntity messageEntity) {
        Intrinsics.checkNotNullParameter(channelEntity, "channelEntity");
        Intrinsics.checkNotNullParameter(list, "userEntities");
        Intrinsics.checkNotNullParameter(collection, "channelTags");
        return new ChannelDbEntities(channelEntity, list, collection, messageEntity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelDbEntities)) {
            return false;
        }
        ChannelDbEntities channelDbEntities = (ChannelDbEntities) obj;
        return Intrinsics.areEqual(this.a, channelDbEntities.a) && Intrinsics.areEqual(this.b, channelDbEntities.b) && Intrinsics.areEqual(this.c, channelDbEntities.c) && Intrinsics.areEqual(this.d, channelDbEntities.d);
    }

    @NotNull
    public final ChannelEntity getChannelEntity() {
        return this.a;
    }

    @NotNull
    public final Collection<ChannelTag> getChannelTags() {
        return this.c;
    }

    @Nullable
    public final MessageEntity getLastMessage() {
        return this.d;
    }

    @NotNull
    public final List<UserEntity> getUserEntities() {
        return this.b;
    }

    public int hashCode() {
        ChannelEntity channelEntity = this.a;
        int i = 0;
        int hashCode = (channelEntity != null ? channelEntity.hashCode() : 0) * 31;
        List<UserEntity> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Collection<ChannelTag> collection = this.c;
        int hashCode3 = (hashCode2 + (collection != null ? collection.hashCode() : 0)) * 31;
        MessageEntity messageEntity = this.d;
        if (messageEntity != null) {
            i = messageEntity.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelDbEntities(channelEntity=");
        L.append(this.a);
        L.append(", userEntities=");
        L.append(this.b);
        L.append(", channelTags=");
        L.append(this.c);
        L.append(", lastMessage=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}
