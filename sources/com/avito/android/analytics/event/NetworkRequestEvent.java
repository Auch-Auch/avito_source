package com.avito.android.analytics.event;

import a2.b.a.a.a;
import com.avito.android.analytics.clickstream.ClickStreamEventTrackerImplKt;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/avito/android/analytics/event/NetworkRequestEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getRefId", "refId", "", AuthSource.SEND_ABUSE, "I", "getLoggableEventId", "()I", "loggableEventId", "getEventId", "eventId", "getVersion", "version", "<init>", "(ILjava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class NetworkRequestEvent implements ClickStreamEvent {
    public final int a;
    @NotNull
    public final String b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public NetworkRequestEvent(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "refId");
        this.c = new ParametrizedClickStreamEvent(i, 0, q.mapOf(TuplesKt.to(ClickStreamEventTrackerImplKt.REF_ID, str)), null, 8, null);
        this.a = i;
        this.b = str;
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

    public final int getLoggableEventId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c.getParams();
    }

    @NotNull
    public final String getRefId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c.getVersion();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("refId = ");
        L.append(this.b);
        L.append(", eventId=");
        L.append(getEventId());
        return L.toString();
    }
}
