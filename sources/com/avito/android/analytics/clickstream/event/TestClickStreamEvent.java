package com.avito.android.analytics.clickstream.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/analytics/clickstream/event/TestClickStreamEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringParam", "stringParam", "", "getEventId", "()I", "eventId", "c", "I", "getIntParam", "intParam", "", AuthSource.SEND_ABUSE, "Z", "getBoolParam", "()Z", "boolParam", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "<init>", "(ZLjava/lang/String;I)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class TestClickStreamEvent implements ClickStreamEvent {
    public final boolean a;
    @NotNull
    public final String b;
    public final int c;
    public final /* synthetic */ ParametrizedClickStreamEvent d;

    public TestClickStreamEvent() {
        this(false, null, 0, 7, null);
    }

    public TestClickStreamEvent(boolean z, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "stringParam");
        this.d = new ParametrizedClickStreamEvent(2108, 0, r.mapOf(TuplesKt.to("bool_param", Boolean.valueOf(z)), TuplesKt.to("string_param", str), TuplesKt.to("int_param", Integer.valueOf(i))), null, 8, null);
        this.a = z;
        this.b = str;
        this.c = i;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.d.description();
    }

    public final boolean getBoolParam() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.d.getEventId();
    }

    public final int getIntParam() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.d.getParams();
    }

    @NotNull
    public final String getStringParam() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.d.getVersion();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TestClickStreamEvent(boolean z, String str, int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? "lorem ipsum" : str, (i2 & 4) != 0 ? 248 : i);
    }
}
