package com.avito.android.developments_catalog.analytics.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/avito/android/developments_catalog/analytics/events/DevelopmentsCatalogAvitoOfferEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "", "d", "Ljava/util/List;", "metroIds", "", "c", "Ljava/lang/String;", "developmentId", "", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "I", "getEventId", "()I", "eventId", AuthSource.BOOKING_ORDER, "getVersion", "version", "e", "locationId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogAvitoOfferEvent implements ClickStreamEvent {
    public final int a = 3460;
    public final int b = 3;
    public final String c;
    public final List<Integer> d;
    public final String e;

    public DevelopmentsCatalogAvitoOfferEvent(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        Intrinsics.checkNotNullParameter(list, "metroIds");
        this.c = str;
        this.d = list;
        this.e = str2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("RealtyDevelopment_id", this.c);
        if (!this.d.isEmpty()) {
            linkedHashMap.put("metro", this.d);
        }
        linkedHashMap.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, "item");
        linkedHashMap.put("mcid", 4918);
        linkedHashMap.put("cid", 24);
        String str = this.e;
        if (str != null) {
            linkedHashMap.put("lid", str);
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b;
    }
}
