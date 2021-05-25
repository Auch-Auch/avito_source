package com.avito.android.favorite.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00168\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010 \u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012¨\u0006#"}, d2 = {"Lcom/avito/android/favorite/event/AddToFavoritesEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "d", "Ljava/lang/String;", "getContext", "context", "", "e", "Z", "isMarketplace", "()Z", AuthSource.SEND_ABUSE, "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "", "getEventId", "()I", "eventId", "getVersion", "version", "c", "getSrc", "src", AuthSource.BOOKING_ORDER, "isUserAuthorized", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class AddToFavoritesEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    public final boolean b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    public final boolean e;
    public final /* synthetic */ ParametrizedClickStreamEvent f;

    public AddToFavoritesEvent(@NotNull String str, boolean z, @NotNull String str2, @Nullable String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "src");
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to("is_auth", Boolean.valueOf(z)), TuplesKt.to("iid", str), TuplesKt.to("s", str2), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, Boolean.valueOf(z2)));
        if (str3 != null) {
            mutableMapOf.put("context", str3);
        }
        this.f = new ParametrizedClickStreamEvent(3187, 14, mutableMapOf, null, 8, null);
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = str3;
        this.e = z2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.f.description();
    }

    @NotNull
    public final String getAdvertId() {
        return this.a;
    }

    @Nullable
    public final String getContext() {
        return this.d;
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

    @NotNull
    public final String getSrc() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.f.getVersion();
    }

    public final boolean isMarketplace() {
        return this.e;
    }

    public final boolean isUserAuthorized() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddToFavoritesEvent(String str, boolean z, String str2, String str3, boolean z2, int i, j jVar) {
        this(str, z, str2, str3, (i & 16) != 0 ? false : z2);
    }
}
