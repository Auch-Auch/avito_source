package com.avito.android.publish.analytics.events;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish/analytics/events/ItemAddCloseEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "screenId", "", "getEventId", "()I", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "getVersion", "version", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "dataProvider", "<init>", "(Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ItemAddCloseEvent implements ClickStreamEvent {
    public final PublishAnalyticsDataProvider a;
    public final String b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public ItemAddCloseEvent(@NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @Nullable String str) {
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "dataProvider");
        this.c = new ParametrizedClickStreamEvent(2608, 4, r.plus(publishAnalyticsDataProvider.getCommonAnalyticsParameters(), Collections.filterValuesNotNull(q.mapOf(TuplesKt.to("item_add_screen", str)))), null, 8, null);
        this.a = publishAnalyticsDataProvider;
        this.b = str;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.c.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.c.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c.getVersion();
    }

    @NotNull
    public String toString() {
        Object obj;
        StringBuilder L = a.L("ItemAddCloseEvent(eventId = 2608, sessionId=");
        L.append(this.a.getSessionIdKeyValue());
        L.append(", screenId=");
        String str = this.b;
        if (str == null || (obj = TuplesKt.to("item_add_screen", str)) == null) {
            obj = "";
        }
        L.append(obj);
        L.append(')');
        return L.toString();
    }
}
