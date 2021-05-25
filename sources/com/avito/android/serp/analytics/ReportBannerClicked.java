package com.avito.android.serp.analytics;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/avito/android/serp/analytics/ReportBannerClicked;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "", AuthSource.BOOKING_ORDER, "I", "getEventId", "()I", "eventId", "c", "getVersion", "version", "iid", "<init>", "(IILjava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ReportBannerClicked implements ClickStreamEvent {
    @NotNull
    public final Map<String, Object> a;
    public final int b;
    public final int c;

    public ReportBannerClicked(int i, int i2, @Nullable String str) {
        this.b = i;
        this.c = i2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str != null) {
            linkedHashMap.put("iid", str);
        }
        Unit unit = Unit.INSTANCE;
        this.a = linkedHashMap;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReportBannerClicked(int i, int i2, String str, int i3, j jVar) {
        this((i3 & 1) != 0 ? 4639 : i, (i3 & 2) != 0 ? 2 : i2, str);
    }
}
