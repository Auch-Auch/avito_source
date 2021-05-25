package com.avito.android.inline_filters.analytics;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.SimpleClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/avito/android/inline_filters/analytics/InlineFilterClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "d", "Ljava/lang/String;", "filterId", "", "getVersion", "()I", "version", "c", "filterName", "getEventId", "eventId", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", AuthSource.BOOKING_ORDER, "cid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilterClickEvent implements ClickStreamEvent {
    @NotNull
    public final Map<String, Object> a;
    public final String b;
    public final String c;
    public final String d;
    public final /* synthetic */ SimpleClickStreamEvent e = new SimpleClickStreamEvent(4159, 2);

    public InlineFilterClickEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "cid", str2, "filterName", str3, "filterId");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.a = r.mutableMapOf(TuplesKt.to("filter_name", str2), TuplesKt.to("filter_id", str3), TuplesKt.to("cid", str));
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
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.e.getVersion();
    }
}
