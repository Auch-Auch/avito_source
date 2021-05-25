package com.avito.android.calls_shared.analytics.events;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.util.Collections;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/CallPushReceivedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "pushId", Constants.FirelogAnalytics.PARAM_TTL, "sentPriority", "receivedPriority", "", "sentTimestamp", "", "notificationsEnabled", "voxCallId", "voxUserId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallPushReceivedEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public CallPushReceivedEvent(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, long j, boolean z, @Nullable String str4, @Nullable String str5) {
        a.Z0(str, "pushId", str2, "sentPriority", str3, "receivedPriority");
        this.a = new ParametrizedClickStreamEvent(4245, 3, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("vox_push", str), TuplesKt.to("vox_call_id", str4), TuplesKt.to("vox_push_ttl", Integer.valueOf(i)), TuplesKt.to("vox_userid", str5), TuplesKt.to("push_priority_recieved", str3), TuplesKt.to("push_priority_sent", str2), TuplesKt.to("push_sent_time", Long.valueOf(j)), TuplesKt.to("appcall_system_notification", Boolean.valueOf(z)))), null, 8, null);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.a.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.a.getVersion();
    }
}
