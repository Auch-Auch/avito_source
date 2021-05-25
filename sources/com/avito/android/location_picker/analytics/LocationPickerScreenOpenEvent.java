package com.avito.android.location_picker.analytics;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014¨\u0006!"}, d2 = {"Lcom/avito/android/location_picker/analytics/LocationPickerScreenOpenEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "d", "Ljava/util/List;", Names.GEO, "c", "districtIds", AuthSource.BOOKING_ORDER, "metroIds", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", AuthSource.SEND_ABUSE, "directionIds", "getVersion", "version", "geoSession", "categoryId", "locationId", "", "selectedRadius", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerScreenOpenEvent implements ClickStreamEvent {
    public final List<String> a;
    public final List<String> b;
    public final List<String> c;
    public final List<String> d;
    public final /* synthetic */ ParametrizedClickStreamEvent e;

    public LocationPickerScreenOpenEvent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(str, "geoSession");
        HashMap hashMapOf = r.hashMapOf(TuplesKt.to("from_block", 1), TuplesKt.to(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, "radius_small"), TuplesKt.to("geo_session", str));
        if (str2 != null) {
            hashMapOf.put("cid", str2);
        }
        if (str3 != null) {
            hashMapOf.put("lid", str3);
        }
        if (l != null) {
            hashMapOf.put("srd", Long.valueOf(l.longValue()));
        }
        if (list4 != null) {
            hashMapOf.put(Names.GEO, list4);
        }
        if (list != null && (!list.isEmpty())) {
            hashMapOf.put("did", list);
        }
        if (list3 != null && (!list3.isEmpty())) {
            hashMapOf.put("roads", list3);
        }
        if (list2 != null && (!list2.isEmpty())) {
            hashMapOf.put("metro", list2);
        }
        this.e = new ParametrizedClickStreamEvent(3290, 4, hashMapOf, null, 8, null);
        this.a = list;
        this.b = list2;
        this.c = list3;
        this.d = list4;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.e.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.e.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.e.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.e.getVersion();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationPickerScreenOpenEvent(String str, String str2, String str3, List list, List list2, List list3, List list4, Long l, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : list4, (i & 128) == 0 ? l : null);
    }
}
