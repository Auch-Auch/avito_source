package ru.avito.android.persistence.messenger;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Entity(indices = {@Index(name = "user_and_channel_ids", unique = true, value = {"local_user_id", "user_id", "channel_id"})}, primaryKeys = {"local_user_id", "user_id", "channel_id"}, tableName = "user")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u0000 02\u00020\u0001:\u00010BM\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J^\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010\nR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010\u0004¨\u00061"}, d2 = {"Lru/avito/android/persistence/messenger/UserEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Long;", "component6", "component7", "localUserId", ChannelContext.Item.USER_ID, "channelId", "name", "lastActionTime", "timeDiff", "jsonPublicProfile", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lru/avito/android/persistence/messenger/UserEntity;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/Long;", "getLastActionTime", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLocalUserId", AuthSource.BOOKING_ORDER, "getUserId", "d", "getName", "c", "getChannelId", "f", "getTimeDiff", g.a, "getJsonPublicProfile", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserEntity {
    @NotNull
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    @NotNull
    public static final String COLUMN_JSON_PUBLIC_PROFILE = "json_public_profile";
    @NotNull
    public static final String COLUMN_LAST_ACTION_TIME = "last_action_time";
    @NotNull
    public static final String COLUMN_LOCAL_USER_ID = "local_user_id";
    @NotNull
    public static final String COLUMN_NAME = "name";
    @NotNull
    public static final String COLUMN_TIME_DIFF = "time_diff";
    @NotNull
    public static final String COLUMN_USER_ID = "user_id";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @ColumnInfo(name = "local_user_id")
    @NotNull
    public final String a;
    @ColumnInfo(name = "user_id")
    @NotNull
    public final String b;
    @ColumnInfo(name = "channel_id")
    @NotNull
    public final String c;
    @ColumnInfo(name = "name")
    @Nullable
    public final String d;
    @ColumnInfo(name = COLUMN_LAST_ACTION_TIME)
    @Nullable
    public final Long e;
    @ColumnInfo(name = COLUMN_TIME_DIFF)
    @Nullable
    public final Long f;
    @ColumnInfo(name = COLUMN_JSON_PUBLIC_PROFILE)
    @Nullable
    public final String g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lru/avito/android/persistence/messenger/UserEntity$Companion;", "", "", "COLUMN_CHANNEL_ID", "Ljava/lang/String;", "COLUMN_JSON_PUBLIC_PROFILE", "COLUMN_LAST_ACTION_TIME", "COLUMN_LOCAL_USER_ID", "COLUMN_NAME", "COLUMN_TIME_DIFF", "COLUMN_USER_ID", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public UserEntity(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Long l, @Nullable Long l2, @Nullable String str5) {
        a.Z0(str, "localUserId", str2, ChannelContext.Item.USER_ID, str3, "channelId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = l;
        this.f = l2;
        this.g = str5;
    }

    public static /* synthetic */ UserEntity copy$default(UserEntity userEntity, String str, String str2, String str3, String str4, Long l, Long l2, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userEntity.a;
        }
        if ((i & 2) != 0) {
            str2 = userEntity.b;
        }
        if ((i & 4) != 0) {
            str3 = userEntity.c;
        }
        if ((i & 8) != 0) {
            str4 = userEntity.d;
        }
        if ((i & 16) != 0) {
            l = userEntity.e;
        }
        if ((i & 32) != 0) {
            l2 = userEntity.f;
        }
        if ((i & 64) != 0) {
            str5 = userEntity.g;
        }
        return userEntity.copy(str, str2, str3, str4, l, l2, str5);
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

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final Long component5() {
        return this.e;
    }

    @Nullable
    public final Long component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final UserEntity copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Long l, @Nullable Long l2, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return new UserEntity(str, str2, str3, str4, l, l2, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) obj;
        return Intrinsics.areEqual(this.a, userEntity.a) && Intrinsics.areEqual(this.b, userEntity.b) && Intrinsics.areEqual(this.c, userEntity.c) && Intrinsics.areEqual(this.d, userEntity.d) && Intrinsics.areEqual(this.e, userEntity.e) && Intrinsics.areEqual(this.f, userEntity.f) && Intrinsics.areEqual(this.g, userEntity.g);
    }

    @NotNull
    public final String getChannelId() {
        return this.c;
    }

    @Nullable
    public final String getJsonPublicProfile() {
        return this.g;
    }

    @Nullable
    public final Long getLastActionTime() {
        return this.e;
    }

    @NotNull
    public final String getLocalUserId() {
        return this.a;
    }

    @Nullable
    public final String getName() {
        return this.d;
    }

    @Nullable
    public final Long getTimeDiff() {
        return this.f;
    }

    @NotNull
    public final String getUserId() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Long l = this.e;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.f;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str5 = this.g;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserEntity(localUserId=");
        L.append(this.a);
        L.append(", userId=");
        L.append(this.b);
        L.append(", channelId=");
        L.append(this.c);
        L.append(", name=");
        L.append(this.d);
        L.append(", lastActionTime=");
        L.append(this.e);
        L.append(", timeDiff=");
        L.append(this.f);
        L.append(", jsonPublicProfile=");
        return a.t(L, this.g, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserEntity(String str, String str2, String str3, String str4, Long l, Long l2, String str5, int i, j jVar) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : str5);
    }
}
