package com.avito.android.calls_shared.analytics.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.analytics.CallEventParams;
import com.avito.android.calls_shared.analytics.mapping.CallTypesToEventParamMapperKt;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/CallPermissionsCheckedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "Lcom/avito/android/calls_shared/CallId;", "callId", "Lcom/avito/android/calls_shared/CallSide;", "callSide", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallSide;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallPermissionsCheckedEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public CallPermissionsCheckedEvent(@NotNull String str, @NotNull CallSide callSide) {
        Intrinsics.checkNotNullParameter(str, "callId");
        Intrinsics.checkNotNullParameter(callSide, "callSide");
        this.a = new ParametrizedClickStreamEvent(4783, 2, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to(CallEventParams.CALL_ID, str), TuplesKt.to(CallEventParams.CALL_SIDE, Integer.valueOf(CallTypesToEventParamMapperKt.getEventValue(callSide))))), null, 8, null);
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
