package com.avito.android.location.analytics.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/avito/android/location/analytics/events/HomeRequestWithUserLocationEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "getEventId", "eventId", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "geoInfo", "", "", "getParams", "()Ljava/util/Map;", "params", "locationId", "fromPage", "coordinatesResolveTime", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class HomeRequestWithUserLocationEvent implements ClickStreamEvent {
    public final List<String> a;
    public final /* synthetic */ ParametrizedClickStreamEvent b;

    public HomeRequestWithUserLocationEvent(@NotNull List<String> list, @Nullable String str, @Nullable String str2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(list, "geoInfo");
        HashMap hashMapOf = r.hashMapOf(TuplesKt.to(Names.GEO, list));
        if (str != null) {
            hashMapOf.put("lid", str);
        }
        if (str2 != null) {
            hashMapOf.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, str2);
        }
        if (num != null) {
            hashMapOf.put("coordinates_resolve_time", Integer.valueOf(num.intValue()));
        }
        this.b = new ParametrizedClickStreamEvent(3508, 3, hashMapOf, null, 8, null);
        this.a = list;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.b.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.b.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b.getVersion();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeRequestWithUserLocationEvent(List list, String str, String str2, Integer num, int i, j jVar) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num);
    }
}
