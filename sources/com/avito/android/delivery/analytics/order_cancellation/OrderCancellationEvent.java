package com.avito.android.delivery.analytics.order_cancellation;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u0004R\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/delivery/analytics/order_cancellation/OrderCancellationEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getOrderId", AnalyticFieldsName.orderId, "", "getVersion", "()I", "version", "getEventId", "eventId", "c", "getReasonId", "reasonId", g.a, "getComment", AbuseSendingResult.COMMENT, AuthSource.BOOKING_ORDER, "getUserId", ChannelContext.Item.USER_ID, "d", "getReasonTitle", "reasonTitle", "f", "getDetailedReasonTitle", "detailedReasonTitle", "", "", "getParams", "()Ljava/util/Map;", "params", "e", "getDetailedReasonId", "detailedReasonId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class OrderCancellationEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    public final /* synthetic */ ParametrizedClickStreamEvent h;

    public OrderCancellationEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        a.b1(str, AnalyticFieldsName.orderId, str2, ChannelContext.Item.USER_ID, str3, "reasonId", str4, "reasonTitle");
        this.h = new ParametrizedClickStreamEvent(2828, 6, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("orderid", str), TuplesKt.to("uid", str2), TuplesKt.to("order_cancel_cause", str3), TuplesKt.to("order_cancel_cause_info", str4), TuplesKt.to("order_cancel_cause_txt", str7), TuplesKt.to("order_cancel_cause_info_details_id", str5), TuplesKt.to("order_cancel_cause_info_details", str6))), null, 8, null);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.h.description();
    }

    @Nullable
    public final String getComment() {
        return this.g;
    }

    @Nullable
    public final String getDetailedReasonId() {
        return this.e;
    }

    @Nullable
    public final String getDetailedReasonTitle() {
        return this.f;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.h.getEventId();
    }

    @NotNull
    public final String getOrderId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.h.getParams();
    }

    @NotNull
    public final String getReasonId() {
        return this.c;
    }

    @NotNull
    public final String getReasonTitle() {
        return this.d;
    }

    @NotNull
    public final String getUserId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.h.getVersion();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderCancellationEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, j jVar) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? null : str7);
    }
}
