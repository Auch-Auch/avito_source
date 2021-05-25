package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/avito/user_stats/model/UserStatsScreenData;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/user_stats/model/UserStatsTabData;", "component2", "()Ljava/util/List;", "title", "tabs", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/user_stats/model/UserStatsScreenData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getTabs", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsScreenData {
    @SerializedName("tabs")
    @NotNull
    private final List<UserStatsTabData> tabs;
    @SerializedName("title")
    @NotNull
    private final String title;

    public UserStatsScreenData(@NotNull String str, @NotNull List<UserStatsTabData> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.title = str;
        this.tabs = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.user_stats.model.UserStatsScreenData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserStatsScreenData copy$default(UserStatsScreenData userStatsScreenData, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userStatsScreenData.title;
        }
        if ((i & 2) != 0) {
            list = userStatsScreenData.tabs;
        }
        return userStatsScreenData.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<UserStatsTabData> component2() {
        return this.tabs;
    }

    @NotNull
    public final UserStatsScreenData copy(@NotNull String str, @NotNull List<UserStatsTabData> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "tabs");
        return new UserStatsScreenData(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStatsScreenData)) {
            return false;
        }
        UserStatsScreenData userStatsScreenData = (UserStatsScreenData) obj;
        return Intrinsics.areEqual(this.title, userStatsScreenData.title) && Intrinsics.areEqual(this.tabs, userStatsScreenData.tabs);
    }

    @NotNull
    public final List<UserStatsTabData> getTabs() {
        return this.tabs;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<UserStatsTabData> list = this.tabs;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserStatsScreenData(title=");
        L.append(this.title);
        L.append(", tabs=");
        return a.w(L, this.tabs, ")");
    }
}
