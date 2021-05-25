package com.avito.android.account.analytics.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\tR\u0016\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u00188\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/account/analytics/event/SessionUpdateEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Z", "getHasSession", "()Z", "hasSession", "", "getVersion", "()I", "version", AuthSource.BOOKING_ORDER, "getHasToken", "hasToken", "getEventId", "eventId", "c", "Ljava/lang/String;", "getContext", "context", "", "", "getParams", "()Ljava/util/Map;", "params", "<init>", "(ZZLjava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class SessionUpdateEvent implements ClickStreamEvent {
    public final boolean a;
    public final boolean b;
    @NotNull
    public final String c;
    public final /* synthetic */ ParametrizedClickStreamEvent d;

    public SessionUpdateEvent(boolean z, boolean z2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "context");
        this.d = new ParametrizedClickStreamEvent(4403, 0, r.mapOf(TuplesKt.to("is_auth", Boolean.valueOf(z)), TuplesKt.to("bool_param", Boolean.valueOf(z2)), TuplesKt.to("s", str)), null, 8, null);
        this.a = z;
        this.b = z2;
        this.c = str;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.d.description();
    }

    @NotNull
    public final String getContext() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.d.getEventId();
    }

    public final boolean getHasSession() {
        return this.a;
    }

    public final boolean getHasToken() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.d.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.d.getVersion();
    }
}
