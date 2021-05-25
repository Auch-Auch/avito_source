package com.avito.android.remote.model.search.map;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BW\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b#\u0010$R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/search/map/MarkersResponse;", "", "", "Lcom/avito/android/remote/model/search/map/Rash;", "rash", "Ljava/util/List;", "getRash", "()Ljava/util/List;", "", "subscriptionId", "Ljava/lang/String;", "getSubscriptionId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/map/GoToSerpButton;", "goToSerpButton", "Lcom/avito/android/remote/model/search/map/GoToSerpButton;", "getGoToSerpButton", "()Lcom/avito/android/remote/model/search/map/GoToSerpButton;", "Lcom/avito/android/remote/model/search/map/Counter;", "counters", "Lcom/avito/android/remote/model/search/map/Counter;", "getCounters", "()Lcom/avito/android/remote/model/search/map/Counter;", "", "isSubscribed", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/search/map/Area;", "area", "Lcom/avito/android/remote/model/search/map/Area;", "getArea", "()Lcom/avito/android/remote/model/search/map/Area;", "Lcom/avito/android/remote/model/search/map/Pin;", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "getMarkers", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/search/map/Area;Lcom/avito/android/remote/model/search/map/Counter;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/search/map/GoToSerpButton;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class MarkersResponse {
    @SerializedName("mapArea")
    @Nullable
    private final Area area;
    @SerializedName("counters")
    @Nullable
    private final Counter counters;
    @SerializedName("goToSerpButton")
    @Nullable
    private final GoToSerpButton goToSerpButton;
    @SerializedName("isSubscribed")
    @Nullable
    private final Boolean isSubscribed;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_MARKERS)
    @NotNull
    private final List<Pin> markers;
    @SerializedName("rash")
    @Nullable
    private final List<Rash> rash;
    @SerializedName("subscriptionId")
    @Nullable
    private final String subscriptionId;

    public MarkersResponse(@NotNull List<Pin> list, @Nullable List<Rash> list2, @Nullable Area area2, @Nullable Counter counter, @Nullable String str, @Nullable Boolean bool, @Nullable GoToSerpButton goToSerpButton2) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
        this.markers = list;
        this.rash = list2;
        this.area = area2;
        this.counters = counter;
        this.subscriptionId = str;
        this.isSubscribed = bool;
        this.goToSerpButton = goToSerpButton2;
    }

    @Nullable
    public final Area getArea() {
        return this.area;
    }

    @Nullable
    public final Counter getCounters() {
        return this.counters;
    }

    @Nullable
    public final GoToSerpButton getGoToSerpButton() {
        return this.goToSerpButton;
    }

    @NotNull
    public final List<Pin> getMarkers() {
        return this.markers;
    }

    @Nullable
    public final List<Rash> getRash() {
        return this.rash;
    }

    @Nullable
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @Nullable
    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }
}
