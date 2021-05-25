package com.avito.android.public_profile.analytics.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00118\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/avito/android/public_profile/analytics/event/TabSwitchEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "I", "getShortcut", "()I", "shortcut", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getUserKey", "userKey", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "getVersion", "version", "<init>", "(ILjava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public class TabSwitchEvent implements ClickStreamEvent {
    public final int a;
    @NotNull
    public final String b;
    public final /* synthetic */ ParametrizedClickStreamEvent c;

    public TabSwitchEvent(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        this.c = new ParametrizedClickStreamEvent(2852, 0, r.mapOf(TuplesKt.to("shortcut", Integer.valueOf(i)), TuplesKt.to("user_key", str)), null, 8, null);
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

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c.getParams();
    }

    public final int getShortcut() {
        return this.a;
    }

    @NotNull
    public final String getUserKey() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c.getVersion();
    }
}
