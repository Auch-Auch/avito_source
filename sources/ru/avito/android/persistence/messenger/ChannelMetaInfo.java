package ru.avito.android.persistence.messenger;

import a2.b.a.a.a;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Entity(indices = {@Index(name = "local_user_id_and_channel_id", unique = true, value = {"local_user_id", "channel_id"})}, primaryKeys = {"local_user_id", "channel_id"}, tableName = "channel_meta_data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelMetaInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "localUserId", "channelId", "lastSyncedMessageTimeStamp", "copy", "(Ljava/lang/String;Ljava/lang/String;J)Lru/avito/android/persistence/messenger/ChannelMetaInfo;", "toString", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLocalUserId", AuthSource.BOOKING_ORDER, "getChannelId", "c", "J", "getLastSyncedMessageTimeStamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelMetaInfo {
    @NotNull
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    @NotNull
    public static final String COLUMN_LAST_SYNCED_MESSAGE_TIMESTAMP = "last_synced_message_timestamp";
    @NotNull
    public static final String COLUMN_LOCAL_USER_ID = "local_user_id";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @ColumnInfo(name = "local_user_id")
    @NotNull
    public final String a;
    @ColumnInfo(name = "channel_id")
    @NotNull
    public final String b;
    @ColumnInfo(name = COLUMN_LAST_SYNCED_MESSAGE_TIMESTAMP)
    public final long c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelMetaInfo$Companion;", "", "", "COLUMN_CHANNEL_ID", "Ljava/lang/String;", "COLUMN_LAST_SYNCED_MESSAGE_TIMESTAMP", "COLUMN_LOCAL_USER_ID", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public ChannelMetaInfo(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public static /* synthetic */ ChannelMetaInfo copy$default(ChannelMetaInfo channelMetaInfo, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelMetaInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = channelMetaInfo.b;
        }
        if ((i & 4) != 0) {
            j = channelMetaInfo.c;
        }
        return channelMetaInfo.copy(str, str2, j);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final ChannelMetaInfo copy(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return new ChannelMetaInfo(str, str2, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelMetaInfo)) {
            return false;
        }
        ChannelMetaInfo channelMetaInfo = (ChannelMetaInfo) obj;
        return !(Intrinsics.areEqual(this.a, channelMetaInfo.a) ^ true) && !(Intrinsics.areEqual(this.b, channelMetaInfo.b) ^ true) && this.c == channelMetaInfo.c;
    }

    @NotNull
    public final String getChannelId() {
        return this.b;
    }

    public final long getLastSyncedMessageTimeStamp() {
        return this.c;
    }

    @NotNull
    public final String getLocalUserId() {
        return this.a;
    }

    public int hashCode() {
        return c.a(this.c) + a.B0(this.b, this.a.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelMetaInfo(localUserId=");
        L.append(this.a);
        L.append(", channelId=");
        L.append(this.b);
        L.append(", lastSyncedMessageTimeStamp=");
        return a.l(L, this.c, ")");
    }
}
