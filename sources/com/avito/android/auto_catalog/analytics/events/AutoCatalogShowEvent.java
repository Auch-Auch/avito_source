package com.avito.android.auto_catalog.analytics.events;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import com.vk.sdk.VKScope;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB-\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "iid", "d", "searchContext", "", AuthSource.SEND_ABUSE, "I", "getEventId", "()I", "eventId", "c", "mcid", "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "e", "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "fromPage", "version", "getVersion", "", "", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;)V", "FromPage", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogShowEvent implements ClickStreamEvent {
    public final int a = 3509;
    public final String b;
    public final String c;
    public final String d;
    public final FromPage e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ITEM", "DIRECT", "AUTO_CARD", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    public enum FromPage {
        ITEM("item"),
        DIRECT(VKScope.DIRECT),
        AUTO_CARD(AdvertDetailsAnalyticsInteractorKt.PAGE_TYPE_AUTO_CARD);
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        FromPage(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    public AutoCatalogShowEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull FromPage fromPage) {
        Intrinsics.checkNotNullParameter(fromPage, "fromPage");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = fromPage;
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
        linkedHashMap.put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.e.getValue());
        String str = this.d;
        if (str != null) {
            linkedHashMap.put("x", str);
        }
        String str2 = this.c;
        if (str2 != null) {
            linkedHashMap.put("mcid", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            linkedHashMap.put("iid", str3);
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return 0;
    }
}
