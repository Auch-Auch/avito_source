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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u001e\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0016R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\fR\u0016\u0010(\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010\bR\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0016¨\u0006-"}, d2 = {"Lcom/avito/android/analytics/event/perfomance/ScreenServerLoadingEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "description", "", "getVersion", "()I", "version", "", "k", "J", "startupTime", "", "", "getParams", "()Ljava/util/Map;", "params", "c", "duration", "d", "Ljava/lang/String;", "networkType", "i", OkListener.KEY_EXCEPTION, "j", "screenTouchTime", "h", "spanEndTime", AuthSource.SEND_ABUSE, "screenName", "f", "contentType", g.a, "I", "page", AuthSource.BOOKING_ORDER, "timestamp", "getEventId", "eventId", "e", "connectionSpeed", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;JJ)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenServerLoadingEvent implements ClickStreamEvent {
    public final String a;
    public final long b;
    public final long c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final long h;
    public final String i;
    public final long j;
    public final long k;
    public final /* synthetic */ ParametrizedClickStreamEvent l;

    public ScreenServerLoadingEvent(@NotNull String str, long j2, long j3, @NotNull String str2, @Nullable String str3, @NotNull String str4, int i2, long j4, @Nullable String str5, long j5, long j6) {
        a.Z0(str, "screenName", str2, "networkType", str4, "contentType");
        boolean z = false;
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to(VKApiUserFull.SCREEN_NAME, str), TuplesKt.to("screen_start_time", Long.valueOf(j2)), TuplesKt.to("mobile_event_duration", Long.valueOf(j3)), TuplesKt.to("network_type", str2), TuplesKt.to(FirebaseAnalytics.Param.CONTENT_TYPE, str4), TuplesKt.to("mobile_app_page_number", Integer.valueOf(i2)), TuplesKt.to("span_end_time", Long.valueOf(j4)), TuplesKt.to("screen_touch_time", Long.valueOf(j5)), TuplesKt.to("app_startup_time", Long.valueOf(j6)));
        if (str5 != null) {
            TuplesKt.to("exception_id", str5);
        }
        if (str3 != null ? true : z) {
            TuplesKt.to("connection_speed", str3);
        }
        this.l = new ParametrizedClickStreamEvent(3223, 8, mutableMapOf, null, 8, null);
        this.a = str;
        this.b = j2;
        this.c = j3;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i2;
        this.h = j4;
        this.i = str5;
        this.j = j5;
        this.k = j6;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.l.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.l.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.l.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.l.getVersion();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ScreenServerLoadingEvent(screenName='");
        L.append(this.a);
        L.append("', timestamp=");
        L.append(this.b);
        L.append(", duration=");
        L.append(this.c);
        L.append(", ");
        L.append("networkType='");
        L.append(this.d);
        L.append("', connectionSpeed=");
        L.append(this.e);
        L.append(", contentType='");
        a.m1(L, this.f, "', ", "page=");
        L.append(this.g);
        L.append(", spanEndTime=");
        L.append(this.h);
        L.append(", exception=");
        L.append(this.i);
        L.append(", screenTouchTime=");
        L.append(this.j);
        L.append(", ");
        L.append("startupTime=");
        return a.k(L, this.k, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenServerLoadingEvent(String str, long j2, long j3, String str2, String str3, String str4, int i2, long j4, String str5, long j5, long j6, int i3, j jVar) {
        this(str, j2, j3, str2, str3, str4, i2, j4, (i3 & 256) != 0 ? null : str5, (i3 & 512) != 0 ? 0 : j5, j6);
    }
}
