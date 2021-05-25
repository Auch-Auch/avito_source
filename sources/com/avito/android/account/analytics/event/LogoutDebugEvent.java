package com.avito.android.account.analytics.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/account/analytics/event/LogoutDebugEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSource", "source", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Ljava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class LogoutDebugEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    public final /* synthetic */ ParametrizedClickStreamEvent b;

    public LogoutDebugEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.b = new ParametrizedClickStreamEvent(4402, 0, q.mapOf(TuplesKt.to("s", str)), null, 8, null);
        this.a = str;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.b.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.b.getParams();
    }

    @NotNull
    public final String getSource() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b.getVersion();
    }
}
