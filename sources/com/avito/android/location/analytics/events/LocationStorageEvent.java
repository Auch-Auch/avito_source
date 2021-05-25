package com.avito.android.location.analytics.events;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location.LocationSource;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0002`\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/avito/android/location/analytics/events/LocationStorageEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "getVersion", "version", "Ljava/util/HashMap;", "Lcom/avito/android/location/LocationSource;", "Lkotlin/collections/HashMap;", "storageTypes", BookingInfoActivity.EXTRA_FROM_BLOCK, "locationId", "<init>", "(Ljava/util/HashMap;Lcom/avito/android/location/LocationSource;Ljava/lang/String;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class LocationStorageEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public LocationStorageEvent(@NotNull HashMap<LocationSource, String> hashMap, @Nullable LocationSource locationSource, @Nullable String str) {
        String str2;
        String str3;
        String nullIfEmpty;
        Intrinsics.checkNotNullParameter(hashMap, "storageTypes");
        HashMap hashMap2 = new HashMap();
        StringBuilder sb = new StringBuilder();
        StringBuilder L = a.L("ls1:");
        String str4 = hashMap.get(LocationSource.LOCATION_FROM_LIST);
        String str5 = "0";
        L.append((str4 == null || (str2 = LocationStorageEventKt.nullIfEmpty(str4)) == null) ? str5 : str2);
        L.append(',');
        sb.append(L.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ls2:");
        String str6 = hashMap.get(LocationSource.LOCATION_FROM_COORDS);
        sb2.append((str6 == null || (str3 = LocationStorageEventKt.nullIfEmpty(str6)) == null) ? str5 : str3);
        sb2.append(',');
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ls3:");
        String str7 = hashMap.get(LocationSource.LOCATION_FROM_FILTERS);
        if (!(str7 == null || (nullIfEmpty = LocationStorageEventKt.nullIfEmpty(str7)) == null)) {
            str5 = nullIfEmpty;
        }
        sb3.append(str5);
        sb.append(sb3.toString());
        String sb4 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder()\n        …              .toString()");
        hashMap2.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, sb4);
        if (locationSource != null) {
            hashMap2.put("from_block", Integer.valueOf(locationSource.getAnalyticsOrdinal()));
        }
        if (str != null) {
            hashMap2.put("lid", str);
        }
        this.a = new ParametrizedClickStreamEvent(3379, 2, hashMap2, null, 8, null);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.a.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.a.getVersion();
    }
}
