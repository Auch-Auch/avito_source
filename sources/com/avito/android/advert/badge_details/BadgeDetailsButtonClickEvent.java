package com.avito.android.advert.badge_details;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert/badge_details/BadgeDetailsButtonClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", AuthSource.BOOKING_ORDER, "I", "getBadgeId", "badgeId", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;I)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeDetailsButtonClickEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    public final int b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public BadgeDetailsButtonClickEvent(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.c = new ParametrizedClickStreamEvent(4477, 0, r.mutableMapOf(TuplesKt.to("iid", str), TuplesKt.to("badge_id", Integer.valueOf(i))), null, 8, null);
        this.a = str;
        this.b = i;
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

    public final int getBadgeId() {
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
