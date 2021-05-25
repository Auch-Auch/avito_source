package com.avito.android.analytics.event.favorite;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/analytics/event/favorite/UnsubscribeSellerButtonEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserKey", "userKey", "", "", "getParams", "()Ljava/util/Map;", "params", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "getSource", "()Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "", "getEventId", "()I", "eventId", "getVersion", "version", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class UnsubscribeSellerButtonEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    @NotNull
    public final SubscriptionSource b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public UnsubscribeSellerButtonEvent(@NotNull String str, @NotNull SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(subscriptionSource, "source");
        this.c = new ParametrizedClickStreamEvent(4115, 1, r.mapOf(TuplesKt.to("puid", str), TuplesKt.to("s", subscriptionSource.getValue())), null, 8, null);
        this.a = str;
        this.b = subscriptionSource;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.c.description();
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

    @NotNull
    public final SubscriptionSource getSource() {
        return this.b;
    }

    @NotNull
    public final String getUserKey() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c.getVersion();
    }
}
