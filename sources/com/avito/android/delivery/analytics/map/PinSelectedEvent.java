package com.avito.android.delivery.analytics.map;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/delivery/analytics/map/PinSelectedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", AuthSource.BOOKING_ORDER, "Z", "isCart", "()Z", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "getVersion", "version", "c", "getCartItems", "cartItems", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class PinSelectedEvent implements ClickStreamEvent {
    @Nullable
    public final String a;
    public final boolean b;
    @Nullable
    public final String c;
    public final /* synthetic */ ParametrizedClickStreamEvent d;

    public PinSelectedEvent(@Nullable String str, boolean z, @Nullable String str2) {
        this.d = new ParametrizedClickStreamEvent(4759, 1, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("iid", str), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, Boolean.valueOf(z)), TuplesKt.to("busket_items", str2))), "Avito.Delivery / Создание заказа на доставку / Выбор пина на карте пвз");
        this.a = str;
        this.b = z;
        this.c = str2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.d.description();
    }

    @Nullable
    public final String getAdvertId() {
        return this.a;
    }

    @Nullable
    public final String getCartItems() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.d.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.d.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.d.getVersion();
    }

    public final boolean isCart() {
        return this.b;
    }
}
