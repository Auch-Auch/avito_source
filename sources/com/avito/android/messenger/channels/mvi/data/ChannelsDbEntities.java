package com.avito.android.messenger.channels.mvi.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.android.persistence.messenger.ChannelTag;
import ru.avito.android.persistence.messenger.MessageEntity;
import ru.avito.android.persistence.messenger.UserEntity;
import t6.n.e;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelsDbEntities;", "", "", "toString", "()Ljava/lang/String;", "", "Lru/avito/android/persistence/messenger/UserEntity;", AuthSource.BOOKING_ORDER, "Ljava/util/Collection;", "getUserEntities", "()Ljava/util/Collection;", "userEntities", "Lru/avito/android/persistence/messenger/MessageEntity;", "d", "getLastMessages", "lastMessages", "Lru/avito/android/persistence/messenger/ChannelEntity;", AuthSource.SEND_ABUSE, "getChannelEntities", "channelEntities", "Lru/avito/android/persistence/messenger/ChannelTag;", "c", "getChannelTags", "channelTags", "<init>", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsDbEntities {
    @NotNull
    public final Collection<ChannelEntity> a;
    @NotNull
    public final Collection<UserEntity> b;
    @NotNull
    public final Collection<ChannelTag> c;
    @NotNull
    public final Collection<MessageEntity> d;

    public ChannelsDbEntities(@NotNull Collection<ChannelEntity> collection, @NotNull Collection<UserEntity> collection2, @NotNull Collection<ChannelTag> collection3, @NotNull Collection<MessageEntity> collection4) {
        Intrinsics.checkNotNullParameter(collection, "channelEntities");
        Intrinsics.checkNotNullParameter(collection2, "userEntities");
        Intrinsics.checkNotNullParameter(collection3, "channelTags");
        Intrinsics.checkNotNullParameter(collection4, "lastMessages");
        this.a = collection;
        this.b = collection2;
        this.c = collection3;
        this.d = collection4;
    }

    @NotNull
    public final Collection<ChannelEntity> getChannelEntities() {
        return this.a;
    }

    @NotNull
    public final Collection<ChannelTag> getChannelTags() {
        return this.c;
    }

    @NotNull
    public final Collection<MessageEntity> getLastMessages() {
        return this.d;
    }

    @NotNull
    public final Collection<UserEntity> getUserEntities() {
        return this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelsDbEntities(\n            |   channelEntities=(");
        L.append(this.a.size());
        L.append(')');
        Collection<ChannelEntity> collection = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getChannelId());
        }
        L.append(arrayList);
        L.append(", \n            |   userEntities=(");
        L.append(this.b.size());
        L.append(')');
        Collection<UserEntity> collection2 = this.b;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it2 = collection2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getUserId());
        }
        L.append(arrayList2);
        L.append(", \n            |   channelTags=(");
        L.append(this.c.size());
        L.append(')');
        Collection<ChannelTag> collection3 = this.c;
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(collection3, 10));
        Iterator<T> it3 = collection3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(it3.next().getTag());
        }
        L.append(arrayList3);
        L.append(", \n            |   lastMessages=(");
        L.append(this.d.size());
        L.append(')');
        Collection<MessageEntity> collection4 = this.d;
        ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(collection4, 10));
        Iterator<T> it4 = collection4.iterator();
        while (it4.hasNext()) {
            arrayList4.add(it4.next().getRemoteId());
        }
        L.append(arrayList4);
        L.append("\n            |)");
        return f.trimMargin$default(L.toString(), null, 1, null);
    }
}
