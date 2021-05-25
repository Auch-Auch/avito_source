package com.avito.android.safedeal.delivery_courier.analytics;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0016\u0010\u001a\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0004R\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001d8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/analytics/OpenCourierSummaryScreenEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "component1", "component2", SDKConstants.PARAM_USER_ID, "itemID", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/safedeal/delivery_courier/analytics/OpenCourierSummaryScreenEvent;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getItemID", "getEventId", "eventId", "getVersion", "version", AuthSource.SEND_ABUSE, "getUserID", "", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class OpenCourierSummaryScreenEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public OpenCourierSummaryScreenEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_USER_ID);
        Intrinsics.checkNotNullParameter(str2, "itemID");
        this.c = new ParametrizedClickStreamEvent(4033, 0, r.mapOf(TuplesKt.to("uid", str), TuplesKt.to("iid", str2)), "Avito.Safedeal / Courier / Показ виджета \"Оформление заказа курьерской доставкой\"");
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ OpenCourierSummaryScreenEvent copy$default(OpenCourierSummaryScreenEvent openCourierSummaryScreenEvent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openCourierSummaryScreenEvent.a;
        }
        if ((i & 2) != 0) {
            str2 = openCourierSummaryScreenEvent.b;
        }
        return openCourierSummaryScreenEvent.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final OpenCourierSummaryScreenEvent copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_USER_ID);
        Intrinsics.checkNotNullParameter(str2, "itemID");
        return new OpenCourierSummaryScreenEvent(str, str2);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.c.description();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenCourierSummaryScreenEvent)) {
            return false;
        }
        OpenCourierSummaryScreenEvent openCourierSummaryScreenEvent = (OpenCourierSummaryScreenEvent) obj;
        return Intrinsics.areEqual(this.a, openCourierSummaryScreenEvent.a) && Intrinsics.areEqual(this.b, openCourierSummaryScreenEvent.b);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.c.getEventId();
    }

    @NotNull
    public final String getItemID() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c.getParams();
    }

    @NotNull
    public final String getUserID() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c.getVersion();
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OpenCourierSummaryScreenEvent(userID=");
        L.append(this.a);
        L.append(", itemID=");
        return a.t(L, this.b, ")");
    }
}
