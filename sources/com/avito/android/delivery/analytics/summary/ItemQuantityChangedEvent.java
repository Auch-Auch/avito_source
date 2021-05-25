package com.avito.android.delivery.analytics.summary;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/delivery/analytics/summary/ItemQuantityChangedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getQuantity", "()Ljava/lang/Integer;", FirebaseAnalytics.Param.QUANTITY, "", "", "getParams", "()Ljava/util/Map;", "params", "getVersion", "version", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/delivery/analytics/summary/ChangeType;", "c", "Lcom/avito/android/delivery/analytics/summary/ChangeType;", "getChangeType", "()Lcom/avito/android/delivery/analytics/summary/ChangeType;", "changeType", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/delivery/analytics/summary/ChangeType;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ItemQuantityChangedEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    @Nullable
    public final Integer b;
    @Nullable
    public final ChangeType c;
    public final /* synthetic */ ParametrizedClickStreamEvent d;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002e: APUT  
      (r1v1 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0029: INVOKE  (r2v5 kotlin.Pair) = ("cart_stepper"), (r2v4 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public ItemQuantityChangedEvent(@NotNull String str, @Nullable Integer num, @Nullable ChangeType changeType) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("iid", str);
        pairArr[1] = TuplesKt.to("block_items_display", num);
        pairArr[2] = TuplesKt.to("cart_stepper", changeType != null ? changeType.toString() : null);
        this.d = new ParametrizedClickStreamEvent(4583, 0, Collections.filterValuesNotNull(r.mapOf(pairArr)), "Avito.Marketplace / Корзина / Изменение количества товара");
        this.a = str;
        this.b = num;
        this.c = changeType;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.d.description();
    }

    @NotNull
    public final String getAdvertId() {
        return this.a;
    }

    @Nullable
    public final ChangeType getChangeType() {
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

    @Nullable
    public final Integer getQuantity() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.d.getVersion();
    }
}
