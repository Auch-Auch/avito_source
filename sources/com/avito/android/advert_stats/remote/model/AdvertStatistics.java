package com.avito.android.advert_stats.remote.model;

import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/advert_stats/remote/model/AdvertStatistics;", "", "", "maxValue", "I", "getMaxValue", "()I", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "", "Lcom/avito/android/advert_stats/remote/model/Week;", "weeks", "Ljava/util/List;", "getWeeks", "()Ljava/util/List;", "", "Lcom/avito/android/advert_stats/remote/model/Vas;", VKApiConst.SERVICES, "Ljava/util/Map;", "getServices", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/Action;", "hint", "Lcom/avito/android/remote/model/Action;", "getHint", "()Lcom/avito/android/remote/model/Action;", "action", "getAction", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/util/Map;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Action;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStatistics {
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("hint")
    @Nullable
    private final Action hint;
    @SerializedName("maxValue")
    private final int maxValue;
    @SerializedName(VKApiConst.SERVICES)
    @Nullable
    private final Map<String, Vas> services;
    @SerializedName("weeks")
    @NotNull
    private final List<Week> weeks;

    public AdvertStatistics(int i, @NotNull List<Week> list, @Nullable String str, @Nullable Map<String, Vas> map, @Nullable Action action2, @Nullable Action action3) {
        Intrinsics.checkNotNullParameter(list, "weeks");
        this.maxValue = i;
        this.weeks = list;
        this.description = str;
        this.services = map;
        this.action = action2;
        this.hint = action3;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Action getHint() {
        return this.hint;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    @Nullable
    public final Map<String, Vas> getServices() {
        return this.services;
    }

    @NotNull
    public final List<Week> getWeeks() {
        return this.weeks;
    }
}
