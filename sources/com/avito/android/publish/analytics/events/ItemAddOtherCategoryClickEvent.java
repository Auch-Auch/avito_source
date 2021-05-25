package com.avito.android.publish.analytics.events;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/analytics/events/ItemAddOtherCategoryClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", "getVersion", "version", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "dataProvider", "<init>", "(Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ItemAddOtherCategoryClickEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public ItemAddOtherCategoryClickEvent(@NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "dataProvider");
        this.a = new ParametrizedClickStreamEvent(3541, 3, q.mapOf(publishAnalyticsDataProvider.getSessionIdKeyValue()), null, 8, null);
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

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ItemAddOtherCategoryClickEvent(eventId = 3541, params=");
        L.append(getParams());
        L.append(')');
        return L.toString();
    }
}
