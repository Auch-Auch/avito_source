package com.avito.user_stats.model;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/avito/user_stats/model/UserStatsTabData;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/user_stats/model/EmptyScreenData;", "component3", "()Lcom/avito/user_stats/model/EmptyScreenData;", "", "Lcom/avito/user_stats/model/StatsData;", "component4", "()Ljava/util/List;", "id", "title", InternalConstsKt.PLACEHOLDER, "data", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/user_stats/model/EmptyScreenData;Ljava/util/List;)Lcom/avito/user_stats/model/UserStatsTabData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getData", "getId", "Lcom/avito/user_stats/model/EmptyScreenData;", "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/user_stats/model/EmptyScreenData;Ljava/util/List;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabData {
    @SerializedName("data")
    @Nullable
    private final List<StatsData> data;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final EmptyScreenData placeholder;
    @SerializedName("title")
    @NotNull
    private final String title;

    public UserStatsTabData(@NotNull String str, @NotNull String str2, @Nullable EmptyScreenData emptyScreenData, @Nullable List<StatsData> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.placeholder = emptyScreenData;
        this.data = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.user_stats.model.UserStatsTabData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserStatsTabData copy$default(UserStatsTabData userStatsTabData, String str, String str2, EmptyScreenData emptyScreenData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userStatsTabData.id;
        }
        if ((i & 2) != 0) {
            str2 = userStatsTabData.title;
        }
        if ((i & 4) != 0) {
            emptyScreenData = userStatsTabData.placeholder;
        }
        if ((i & 8) != 0) {
            list = userStatsTabData.data;
        }
        return userStatsTabData.copy(str, str2, emptyScreenData, list);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final EmptyScreenData component3() {
        return this.placeholder;
    }

    @Nullable
    public final List<StatsData> component4() {
        return this.data;
    }

    @NotNull
    public final UserStatsTabData copy(@NotNull String str, @NotNull String str2, @Nullable EmptyScreenData emptyScreenData, @Nullable List<StatsData> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new UserStatsTabData(str, str2, emptyScreenData, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStatsTabData)) {
            return false;
        }
        UserStatsTabData userStatsTabData = (UserStatsTabData) obj;
        return Intrinsics.areEqual(this.id, userStatsTabData.id) && Intrinsics.areEqual(this.title, userStatsTabData.title) && Intrinsics.areEqual(this.placeholder, userStatsTabData.placeholder) && Intrinsics.areEqual(this.data, userStatsTabData.data);
    }

    @Nullable
    public final List<StatsData> getData() {
        return this.data;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final EmptyScreenData getPlaceholder() {
        return this.placeholder;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        EmptyScreenData emptyScreenData = this.placeholder;
        int hashCode3 = (hashCode2 + (emptyScreenData != null ? emptyScreenData.hashCode() : 0)) * 31;
        List<StatsData> list = this.data;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserStatsTabData(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", placeholder=");
        L.append(this.placeholder);
        L.append(", data=");
        return a.w(L, this.data, ")");
    }
}
