package ru.avito.android.persistence.messenger;

import a2.b.a.a.a;
import androidx.room.ColumnInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lru/avito/android/persistence/messenger/UserIdAndLastActionTime;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "component3", ChannelContext.Item.USER_ID, "lastActionTime", "timeDiff", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lru/avito/android/persistence/messenger/UserIdAndLastActionTime;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getLastActionTime", "c", "getTimeDiff", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserIdAndLastActionTime {
    @ColumnInfo(name = "user_id")
    @NotNull
    public final String a;
    @ColumnInfo(name = UserEntity.COLUMN_LAST_ACTION_TIME)
    @Nullable
    public final Long b;
    @ColumnInfo(name = UserEntity.COLUMN_TIME_DIFF)
    @Nullable
    public final Long c;

    public UserIdAndLastActionTime(@NotNull String str, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        this.a = str;
        this.b = l;
        this.c = l2;
    }

    public static /* synthetic */ UserIdAndLastActionTime copy$default(UserIdAndLastActionTime userIdAndLastActionTime, String str, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userIdAndLastActionTime.a;
        }
        if ((i & 2) != 0) {
            l = userIdAndLastActionTime.b;
        }
        if ((i & 4) != 0) {
            l2 = userIdAndLastActionTime.c;
        }
        return userIdAndLastActionTime.copy(str, l, l2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final Long component2() {
        return this.b;
    }

    @Nullable
    public final Long component3() {
        return this.c;
    }

    @NotNull
    public final UserIdAndLastActionTime copy(@NotNull String str, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        return new UserIdAndLastActionTime(str, l, l2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserIdAndLastActionTime)) {
            return false;
        }
        UserIdAndLastActionTime userIdAndLastActionTime = (UserIdAndLastActionTime) obj;
        return Intrinsics.areEqual(this.a, userIdAndLastActionTime.a) && Intrinsics.areEqual(this.b, userIdAndLastActionTime.b) && Intrinsics.areEqual(this.c, userIdAndLastActionTime.c);
    }

    @Nullable
    public final Long getLastActionTime() {
        return this.b;
    }

    @Nullable
    public final Long getTimeDiff() {
        return this.c;
    }

    @NotNull
    public final String getUserId() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.b;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.c;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserIdAndLastActionTime(userId=");
        L.append(this.a);
        L.append(", lastActionTime=");
        L.append(this.b);
        L.append(", timeDiff=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
