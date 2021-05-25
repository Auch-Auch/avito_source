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
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0014\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010$\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\fR\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\fR\u0016\u0010&\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\b¨\u0006)"}, d2 = {"Lcom/avito/android/analytics/event/perfomance/ScreenDataPreparingEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "", "getVersion", "()I", "version", "", "h", "J", "screenTouchTime", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "screenName", "e", "I", "page", "", "", "getParams", "()Ljava/util/Map;", "params", "i", "startupTime", "d", "contentType", "f", "spanEndTime", g.a, OkListener.KEY_EXCEPTION, AuthSource.BOOKING_ORDER, "timestamp", "c", "duration", "getEventId", "eventId", "<init>", "(Ljava/lang/String;JJLjava/lang/String;IJLjava/lang/String;JJ)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenDataPreparingEvent implements ClickStreamEvent {
    public final String a;
    public final long b;
    public final long c;
    public final String d;
    public final int e;
    public final long f;
    public final String g;
    public final long h;
    public final long i;
    public final /* synthetic */ ParametrizedClickStreamEvent j;

    public ScreenDataPreparingEvent(@NotNull String str, long j2, long j3, @NotNull String str2, int i2, long j4, @Nullable String str3, long j5, long j6) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        boolean z = false;
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to(VKApiUserFull.SCREEN_NAME, str), TuplesKt.to("screen_start_time", Long.valueOf(j2)), TuplesKt.to("mobile_event_duration", Long.valueOf(j3)), TuplesKt.to(FirebaseAnalytics.Param.CONTENT_TYPE, str2), TuplesKt.to("mobile_app_page_number", Integer.valueOf(i2)), TuplesKt.to("span_end_time", Long.valueOf(j4)), TuplesKt.to("screen_touch_time", Long.valueOf(j5)), TuplesKt.to("app_startup_time", Long.valueOf(j6)));
        if (str3 != null ? true : z) {
            TuplesKt.to("exception_id", str3);
        }
        this.j = new ParametrizedClickStreamEvent(3225, 8, mutableMapOf, null, 8, null);
        this.a = str;
        this.b = j2;
        this.c = j3;
        this.d = str2;
        this.e = i2;
        this.f = j4;
        this.g = str3;
        this.h = j5;
        this.i = j6;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.j.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.j.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.j.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.j.getVersion();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ScreenDataPreparingEvent(screenName='");
        L.append(this.a);
        L.append("', timestamp=");
        L.append(this.b);
        L.append(", duration=");
        L.append(this.c);
        L.append(", ");
        L.append("contentType='");
        L.append(this.d);
        L.append("', page=");
        L.append(this.e);
        L.append(", spanEndTime=");
        L.append(this.f);
        L.append(", exception=");
        a.m1(L, this.g, ", ", "screenTouchTime=");
        L.append(this.h);
        L.append(", startupTime=");
        return a.k(L, this.i, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenDataPreparingEvent(String str, long j2, long j3, String str2, int i2, long j4, String str3, long j5, long j6, int i3, j jVar) {
        this(str, j2, j3, str2, i2, j4, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? 0 : j5, j6);
    }
}
