package com.avito.android.analytics.event.perfomance;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00178\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\f¨\u0006$"}, d2 = {"Lcom/avito/android/analytics/event/perfomance/ScreenInitEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "", "getEventId", "()I", "eventId", "", "e", "J", "screenTouchTime", "getVersion", "version", "f", "startupTime", "c", "duration", g.a, "Ljava/lang/String;", "contentType", "", "", "getParams", "()Ljava/util/Map;", "params", "d", "spanEndTime", AuthSource.SEND_ABUSE, "screenName", AuthSource.BOOKING_ORDER, "timestamp", "<init>", "(Ljava/lang/String;JJJJJLjava/lang/String;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenInitEvent implements ClickStreamEvent {
    public final String a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final String g;
    public final /* synthetic */ ParametrizedClickStreamEvent h;

    public ScreenInitEvent(@NotNull String str, long j, long j2, long j3, long j4, long j5, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        this.h = new ParametrizedClickStreamEvent(3221, 13, r.mapOf(TuplesKt.to(VKApiUserFull.SCREEN_NAME, str), TuplesKt.to("screen_start_time", Long.valueOf(j)), TuplesKt.to("mobile_event_duration", Long.valueOf(j2)), TuplesKt.to("span_end_time", Long.valueOf(j3)), TuplesKt.to("screen_touch_time", Long.valueOf(j4)), TuplesKt.to("app_startup_time", Long.valueOf(j5)), TuplesKt.to(FirebaseAnalytics.Param.CONTENT_TYPE, str2)), null, 8, null);
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = str2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.h.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.h.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.h.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.h.getVersion();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ScreenInitEvent(screenName='");
        L.append(this.a);
        L.append("', timestamp=");
        L.append(this.b);
        L.append(", duration=");
        L.append(this.c);
        L.append(", ");
        L.append("spanEndTime=");
        L.append(this.d);
        L.append(", screenTouchTime=");
        L.append(this.e);
        L.append(", startupTime=");
        L.append(this.f);
        L.append(", ");
        L.append("contentType='");
        return a.t(L, this.g, "')");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenInitEvent(String str, long j, long j2, long j3, long j4, long j5, String str2, int i, j jVar) {
        this(str, j, j2, j3, (i & 16) != 0 ? 0 : j4, j5, str2);
    }
}
