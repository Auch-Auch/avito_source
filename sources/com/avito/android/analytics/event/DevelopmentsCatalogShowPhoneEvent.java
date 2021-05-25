package com.avito.android.analytics.event;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/avito/android/analytics/event/DevelopmentsCatalogShowPhoneEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "f", "Ljava/lang/String;", "locationId", "", "", "d", "Ljava/util/List;", "metroIds", "e", "searchContext", "", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.BOOKING_ORDER, "I", "getVersion", "()I", "version", "c", "developmentId", AuthSource.SEND_ABUSE, "getEventId", "eventId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogShowPhoneEvent implements ClickStreamEvent {
    public final int a = 3461;
    public final int b = 2;
    public final String c;
    public final List<Integer> d;
    public final String e;
    public final String f;

    public DevelopmentsCatalogShowPhoneEvent(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        Intrinsics.checkNotNullParameter(list, "metroIds");
        this.c = str;
        this.d = list;
        this.e = str2;
        this.f = str3;
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
