package com.avito.android.delivery.analytics.summary;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001e\u001a\u00020\u001b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006#"}, d2 = {"Lcom/avito/android/delivery/analytics/summary/DeliverySummaryEditOrderInfoScreenEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "", "", "getParams", "()Ljava/util/Map;", "params", "", "d", "Z", "isCart", "()Z", AuthSource.BOOKING_ORDER, "getUserId", ChannelContext.Item.USER_ID, "c", "isMarketplace", "e", "getSafedealServices", "safedealServices", "", "getVersion", "()I", "version", "getEventId", "eventId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliverySummaryEditOrderInfoScreenEvent implements ClickStreamEvent {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    public final boolean c;
    public final boolean d;
    @Nullable
    public final String e;
    public final /* synthetic */ ParametrizedClickStreamEvent f;

    public DeliverySummaryEditOrderInfoScreenEvent(@Nullable String str, @Nullable String str2, boolean z, boolean z2, @Nullable String str3) {
        this.f = new ParametrizedClickStreamEvent(4867, 0, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("iid", str), TuplesKt.to("uid", str2), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, Boolean.valueOf(z)), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, Boolean.valueOf(z2)), TuplesKt.to("safedeal_services", str3))), "Avito.Delivery / Создание заказа на доставку / Изменение выбранного ПВЗ");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
        this.e = str3;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.f.description();
    }

    @Nullable
    public final String getAdvertId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.f.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.f.getParams();
    }

    @Nullable
    public final String getSafedealServices() {
        return this.e;
    }

    @Nullable
    public final String getUserId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.f.getVersion();
    }

    public final boolean isCart() {
        return this.d;
    }

    public final boolean isMarketplace() {
        return this.c;
    }
}
