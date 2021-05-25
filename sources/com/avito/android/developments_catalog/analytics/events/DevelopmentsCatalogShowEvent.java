package com.avito.android.developments_catalog.analytics.events;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\nR\u001c\u0010\u001d\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006 "}, d2 = {"Lcom/avito/android/developments_catalog/analytics/events/DevelopmentsCatalogShowEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", AuthSource.SEND_ABUSE, "I", "getEventId", "()I", "eventId", "", "e", "Ljava/lang/String;", "searchContext", "", "d", "Ljava/util/List;", "metroIds", "c", "developmentId", "", "", "getParams", "()Ljava/util/Map;", "params", "f", "locationId", g.a, "fromPage", AuthSource.BOOKING_ORDER, "getVersion", "version", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogShowEvent implements ClickStreamEvent {
    public final int a = 3459;
    public final int b = 3;
    public final String c;
    public final List<Integer> d;
    public final String e;
    public final String f;
    public final String g;

    public DevelopmentsCatalogShowEvent(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
        a.d1(str, "developmentId", list, "metroIds", str4, "fromPage");
        this.c = str;
        this.d = list;
        this.e = str2;
        this.f = str3;
        this.g = str4;
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
        linkedHashMap.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.g);
        String str = this.e;
        if (str != null) {
            linkedHashMap.put("x", str);
        }
        linkedHashMap.put("mcid", 4918);
        linkedHashMap.put("cid", 24);
        String str2 = this.f;
        if (str2 != null) {
            linkedHashMap.put("lid", str2);
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b;
    }
}
