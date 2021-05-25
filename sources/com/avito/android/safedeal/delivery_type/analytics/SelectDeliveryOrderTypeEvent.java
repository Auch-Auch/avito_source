package com.avito.android.safedeal.delivery_type.analytics;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ>\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u00198\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0016\u0010!\u001a\u00020\u00128\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u0014R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u000e\u0010\nR\u0016\u0010%\u001a\u00020\u00128\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u0014R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/analytics/SelectDeliveryOrderTypeEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "component1", "component2", "component3", "", "component4", "()Ljava/lang/Boolean;", SDKConstants.PARAM_USER_ID, "advertID", "categoryID", "isUserAuth", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/safedeal/delivery_type/analytics/SelectDeliveryOrderTypeEvent;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getAdvertID", "getVersion", "version", "d", "Ljava/lang/Boolean;", "getEventId", "eventId", "c", "getCategoryID", AuthSource.SEND_ABUSE, "getUserID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDeliveryOrderTypeEvent implements ClickStreamEvent {
    @Nullable
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Boolean d;
    public final /* synthetic */ ParametrizedClickStreamEvent e;

    public SelectDeliveryOrderTypeEvent(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str2, "advertID");
        this.e = new ParametrizedClickStreamEvent(3515, 1, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("uid", str), TuplesKt.to("iid", str2), TuplesKt.to("cid", str3), TuplesKt.to("is_user_auth", bool))), "Avito.Safedeal / Safedeal / Показ виджета \"Выберите как получить товар\"");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bool;
    }

    public static /* synthetic */ SelectDeliveryOrderTypeEvent copy$default(SelectDeliveryOrderTypeEvent selectDeliveryOrderTypeEvent, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectDeliveryOrderTypeEvent.a;
        }
        if ((i & 2) != 0) {
            str2 = selectDeliveryOrderTypeEvent.b;
        }
        if ((i & 4) != 0) {
            str3 = selectDeliveryOrderTypeEvent.c;
        }
        if ((i & 8) != 0) {
            bool = selectDeliveryOrderTypeEvent.d;
        }
        return selectDeliveryOrderTypeEvent.copy(str, str2, str3, bool);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final Boolean component4() {
        return this.d;
    }

    @NotNull
    public final SelectDeliveryOrderTypeEvent copy(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str2, "advertID");
        return new SelectDeliveryOrderTypeEvent(str, str2, str3, bool);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.e.description();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectDeliveryOrderTypeEvent)) {
            return false;
        }
        SelectDeliveryOrderTypeEvent selectDeliveryOrderTypeEvent = (SelectDeliveryOrderTypeEvent) obj;
        return Intrinsics.areEqual(this.a, selectDeliveryOrderTypeEvent.a) && Intrinsics.areEqual(this.b, selectDeliveryOrderTypeEvent.b) && Intrinsics.areEqual(this.c, selectDeliveryOrderTypeEvent.c) && Intrinsics.areEqual(this.d, selectDeliveryOrderTypeEvent.d);
    }

    @NotNull
    public final String getAdvertID() {
        return this.b;
    }

    @Nullable
    public final String getCategoryID() {
        return this.c;
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

    @Nullable
    public final String getUserID() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.e.getVersion();
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.d;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode3 + i;
    }

    @Nullable
    public final Boolean isUserAuth() {
        return this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SelectDeliveryOrderTypeEvent(userID=");
        L.append(this.a);
        L.append(", advertID=");
        L.append(this.b);
        L.append(", categoryID=");
        L.append(this.c);
        L.append(", isUserAuth=");
        return a.o(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectDeliveryOrderTypeEvent(String str, String str2, String str3, Boolean bool, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? Boolean.TRUE : bool);
    }
}
