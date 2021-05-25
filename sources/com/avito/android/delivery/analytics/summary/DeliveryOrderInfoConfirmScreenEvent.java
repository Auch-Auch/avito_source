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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u001b\u0010\tR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0004R\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u001f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/delivery/analytics/summary/DeliveryOrderInfoConfirmScreenEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "c", "Z", "isMarketplace", "()Z", "", "getVersion", "()I", "version", "e", "Ljava/lang/String;", "getCartItems", "cartItems", AuthSource.SEND_ABUSE, "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "getEventId", "eventId", AuthSource.BOOKING_ORDER, "getUserId", ChannelContext.Item.USER_ID, "d", "isCart", "f", "getSafedealServices", "safedealServices", "", "", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryOrderInfoConfirmScreenEvent implements ClickStreamEvent {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    public final boolean c;
    public final boolean d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    public final /* synthetic */ ParametrizedClickStreamEvent g;

    public DeliveryOrderInfoConfirmScreenEvent(@Nullable String str, @Nullable String str2, boolean z, boolean z2, @Nullable String str3, @Nullable String str4) {
        this.g = new ParametrizedClickStreamEvent(2749, 10, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("iid", str), TuplesKt.to("uid", str2), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, Boolean.valueOf(z)), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, Boolean.valueOf(z2)), TuplesKt.to("busket_items", str3), TuplesKt.to("safedeal_services", str4))), "Avito.Delivery / Создание заказа на доставку / Экран подтверждения информации о заказе");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
        this.e = str3;
        this.f = str4;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.g.description();
    }

    @Nullable
    public final String getAdvertId() {
        return this.a;
    }

    @Nullable
    public final String getCartItems() {
        return this.e;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.g.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.g.getParams();
    }

    @Nullable
    public final String getSafedealServices() {
        return this.f;
    }

    @Nullable
    public final String getUserId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.g.getVersion();
    }

    public final boolean isCart() {
        return this.d;
    }

    public final boolean isMarketplace() {
        return this.c;
    }
}
