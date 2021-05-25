package com.avito.android.delivery.analytics.summary;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/delivery/analytics/summary/StepperTooltipWasShownEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/delivery/analytics/summary/ErrorType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/analytics/summary/ErrorType;", "getError", "()Lcom/avito/android/delivery/analytics/summary/ErrorType;", "error", "getEventId", "eventId", "<init>", "(Ljava/lang/String;Lcom/avito/android/delivery/analytics/summary/ErrorType;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class StepperTooltipWasShownEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    @Nullable
    public final ErrorType b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0025: APUT  
      (r2v0 kotlin.Pair[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0020: INVOKE  (r3v3 kotlin.Pair) = ("chat_error_case"), (r3v2 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public StepperTooltipWasShownEvent(@NotNull String str, @Nullable ErrorType errorType) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("iid", str);
        pairArr[1] = TuplesKt.to("chat_error_case", errorType != null ? errorType.toString() : null);
        this.c = new ParametrizedClickStreamEvent(4597, 2, Collections.filterValuesNotNull(r.mapOf(pairArr)), "Avito.Marketplace / Корзина / Показ ошибки на степпере");
        this.a = str;
        this.b = errorType;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.c.description();
    }

    @NotNull
    public final String getAdvertId() {
        return this.a;
    }

    @Nullable
    public final ErrorType getError() {
        return this.b;
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
}
