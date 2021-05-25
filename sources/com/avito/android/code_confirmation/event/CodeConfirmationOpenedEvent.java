package com.avito.android.code_confirmation.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/code_confirmation/event/CodeConfirmationOpenedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSrc", "src", "", "getVersion", "()I", "version", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "getPhone", "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeConfirmationOpenedEvent implements ClickStreamEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public CodeConfirmationOpenedEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "src");
        this.c = new ParametrizedClickStreamEvent(2077, 3, r.mapOf(TuplesKt.to("phone", str), TuplesKt.to("s", str2)), null, 8, null);
        this.a = str;
        this.b = str2;
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
    public final String getPhone() {
        return this.a;
    }

    @NotNull
    public final String getSrc() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c.getVersion();
    }
}
