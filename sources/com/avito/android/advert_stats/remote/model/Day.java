package com.avito.android.advert_stats.remote.model;

import com.avito.android.remote.model.Sort;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_stats/remote/model/Day;", "", "Lcom/avito/android/advert_stats/remote/model/ViewsStat;", "stats", "Lcom/avito/android/advert_stats/remote/model/ViewsStat;", "getStats", "()Lcom/avito/android/advert_stats/remote/model/ViewsStat;", "", "", VKApiConst.SERVICES, "Ljava/util/List;", "getServices", "()Ljava/util/List;", "", Sort.DATE, "J", "getDate", "()J", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "<init>", "(JLjava/lang/String;Lcom/avito/android/advert_stats/remote/model/ViewsStat;Ljava/util/List;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class Day {
    @SerializedName(Sort.DATE)
    private final long date;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName(VKApiConst.SERVICES)
    @Nullable
    private final List<String> services;
    @SerializedName("stats")
    @Nullable
    private final ViewsStat stats;

    public Day(long j, @Nullable String str, @Nullable ViewsStat viewsStat, @Nullable List<String> list) {
        this.date = j;
        this.description = str;
        this.stats = viewsStat;
        this.services = list;
    }

    public final long getDate() {
        return this.date;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final List<String> getServices() {
        return this.services;
    }

    @Nullable
    public final ViewsStat getStats() {
        return this.stats;
    }
}
