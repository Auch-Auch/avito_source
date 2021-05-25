package com.avito.android.publish.slots.market_price.analytics;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0015\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/publish/slots/market_price/analytics/ItemAddImvShieldShowEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "", "getEventId", "()I", "eventId", "", "c", "J", "marketPrice", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;", "d", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;", "priceRange", AuthSource.BOOKING_ORDER, "price", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "dataProvider", "<init>", "(Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;JJLcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ItemAddImvShieldShowEvent implements ClickStreamEvent {
    public final PublishAnalyticsDataProvider a;
    public final long b;
    public final long c;
    public final MarketPriceResponse.PriceRange d;
    public final /* synthetic */ ParametrizedClickStreamEvent e;

    public ItemAddImvShieldShowEvent(@NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, long j, long j2, @NotNull MarketPriceResponse.PriceRange priceRange) {
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(priceRange, "priceRange");
        this.e = new ParametrizedClickStreamEvent(4116, 6, ItemAddImvShieldShowEventKt.access$createParams(publishAnalyticsDataProvider, j, j2, priceRange), null, 8, null);
        this.a = publishAnalyticsDataProvider;
        this.b = j;
        this.c = j2;
        this.d = priceRange;
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

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ItemAddScreenOpenEvent (eventId = 4116, params = ");
        L.append(ItemAddImvShieldShowEventKt.access$createParams(this.a, this.b, this.c, this.d));
        L.append(')');
        return L.toString();
    }
}
