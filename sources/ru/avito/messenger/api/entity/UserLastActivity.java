package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lru/avito/messenger/api/entity/UserLastActivity;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "component3", ChannelContext.Item.USER_ID, "lastActionTime", "timeDiff", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lru/avito/messenger/api/entity/UserLastActivity;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getTimeDiff", "Ljava/lang/String;", "getUserId", "getLastActionTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserLastActivity {
    @SerializedName("lastActionTime")
    @Nullable
    private final Long lastActionTime;
    @SerializedName("timeDiff")
    @Nullable
    private final Long timeDiff;
    @SerializedName("id")
    @NotNull
    private final String userId;

    public UserLastActivity(@NotNull String str, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        this.userId = str;
        this.lastActionTime = l;
        this.timeDiff = l2;
    }

    public static /* synthetic */ UserLastActivity copy$default(UserLastActivity userLastActivity, String str, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userLastActivity.userId;
        }
        if ((i & 2) != 0) {
            l = userLastActivity.lastActionTime;
        }
        if ((i & 4) != 0) {
            l2 = userLastActivity.timeDiff;
        }
        return userLastActivity.copy(str, l, l2);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final Long component2() {
        return this.lastActionTime;
    }

    @Nullable
    public final Long component3() {
        return this.timeDiff;
    }

    @NotNull
    public final UserLastActivity copy(@NotNull String str, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        return new UserLastActivity(str, l, l2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLastActivity)) {
            return false;
        }
        UserLastActivity userLastActivity = (UserLastActivity) obj;
        return Intrinsics.areEqual(this.userId, userLastActivity.userId) && Intrinsics.areEqual(this.lastActionTime, userLastActivity.lastActionTime) && Intrinsics.areEqual(this.timeDiff, userLastActivity.timeDiff);
    }

    @Nullable
    public final Long getLastActionTime() {
        return this.lastActionTime;
    }

    @Nullable
    public final Long getTimeDiff() {
        return this.timeDiff;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.lastActionTime;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.timeDiff;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserLastActivity(userId=");
        L.append(this.userId);
        L.append(", lastActionTime=");
        L.append(this.lastActionTime);
        L.append(", timeDiff=");
        L.append(this.timeDiff);
        L.append(")");
        return L.toString();
    }
}
