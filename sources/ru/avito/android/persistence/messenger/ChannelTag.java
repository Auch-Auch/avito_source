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
@Entity(indices = {@Index(name = "tag_local_user_id_and_channel_id", value = {"local_user_id", "channel_id"})}, primaryKeys = {"local_user_id", "channel_id", "tag"}, tableName = "channel_tag")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelTag;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "localUserId", "channelId", "tag", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/avito/android/persistence/messenger/ChannelTag;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getTag", AuthSource.BOOKING_ORDER, "getChannelId", AuthSource.SEND_ABUSE, "getLocalUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelTag {
    @NotNull
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    @NotNull
    public static final String COLUMN_LOCAL_USER_ID = "local_user_id";
    @NotNull
    public static final String COLUMN_TAG = "tag";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @ColumnInfo(name = "local_user_id")
    @NotNull
    public final String a;
    @ColumnInfo(name = "channel_id")
    @NotNull
    public final String b;
    @ColumnInfo(name = "tag")
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelTag$Companion;", "", "", "COLUMN_CHANNEL_ID", "Ljava/lang/String;", "COLUMN_LOCAL_USER_ID", "COLUMN_TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public ChannelTag(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "localUserId", str2, "channelId", str3, "tag");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static /* synthetic */ ChannelTag copy$default(ChannelTag channelTag, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelTag.a;
        }
        if ((i & 2) != 0) {
            str2 = channelTag.b;
        }
        if ((i & 4) != 0) {
            str3 = channelTag.c;
        }
        return channelTag.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final ChannelTag copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "tag");
        return new ChannelTag(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelTag)) {
            return false;
        }
        ChannelTag channelTag = (ChannelTag) obj;
        return Intrinsics.areEqual(this.a, channelTag.a) && Intrinsics.areEqual(this.b, channelTag.b) && Intrinsics.areEqual(this.c, channelTag.c);
    }

    @NotNull
    public final String getChannelId() {
        return this.b;
    }

    @NotNull
    public final String getLocalUserId() {
        return this.a;
    }

    @NotNull
    public final String getTag() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelTag(localUserId=");
        L.append(this.a);
        L.append(", channelId=");
        L.append(this.b);
        L.append(", tag=");
        return a.t(L, this.c, ")");
    }
}
