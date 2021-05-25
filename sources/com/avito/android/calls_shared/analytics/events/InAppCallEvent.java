package com.avito.android.calls_shared.analytics.events;

import com.avito.android.analytics.clickstream.event.HasSensitiveData;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.analytics.CallEventParams;
import com.avito.android.calls_shared.analytics.events.AppCallEventType;
import com.avito.android.calls_shared.analytics.mapping.CallTypesToEventParamMapperKt;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/InAppCallEvent;", "Lcom/avito/android/analytics/clickstream/event/HasSensitiveData;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "Lcom/avito/android/calls_shared/AppCallScenario;", "scenario", "callId", "Lcom/avito/android/calls_shared/CallSide;", "callSide", "itemId", "networkType", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "callEvent", "", "notificationsAllowed", "micAccess", "<init>", "(Lcom/avito/android/calls_shared/AppCallScenario;Ljava/lang/String;Lcom/avito/android/calls_shared/CallSide;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;Ljava/lang/Boolean;Z)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class InAppCallEvent implements HasSensitiveData, ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0070: APUT  
      (r1v1 kotlin.Pair[])
      (5 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x006b: INVOKE  (r4v12 kotlin.Pair) = ("appcall_result"), (r5v6 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public InAppCallEvent(@NotNull AppCallScenario appCallScenario, @NotNull String str, @NotNull CallSide callSide, @Nullable String str2, @NotNull String str3, @NotNull AppCallEventType appCallEventType, @Nullable Boolean bool, boolean z) {
        Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
        Intrinsics.checkNotNullParameter(str, "callId");
        Intrinsics.checkNotNullParameter(callSide, "callSide");
        Intrinsics.checkNotNullParameter(str3, "networkType");
        Intrinsics.checkNotNullParameter(appCallEventType, "callEvent");
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("iid", str2);
        pairArr[1] = TuplesKt.to(CallEventParams.CALL_SCENARIO, CallTypesToEventParamMapperKt.getEventValue(appCallScenario));
        pairArr[2] = TuplesKt.to(CallEventParams.CALL_ID, str);
        pairArr[3] = TuplesKt.to("appcall_network", str3);
        pairArr[4] = TuplesKt.to("appcall_eventtype", Integer.valueOf(appCallEventType.getId()));
        String str4 = null;
        AppCallEventType.Disconnected disconnected = (AppCallEventType.Disconnected) (!(appCallEventType instanceof AppCallEventType.Disconnected) ? null : appCallEventType);
        pairArr[5] = TuplesKt.to("appcall_result", disconnected != null ? disconnected.getResult() : str4);
        pairArr[6] = TuplesKt.to("appcall_system_notification", bool);
        pairArr[7] = TuplesKt.to(CallEventParams.CALL_SIDE, Integer.valueOf(CallTypesToEventParamMapperKt.getEventValue(callSide)));
        pairArr[8] = TuplesKt.to(CallEventParams.CALL_MIC_ACCESS, Boolean.valueOf(z));
        this.a = new ParametrizedClickStreamEvent(4101, 7, Collections.filterValuesNotNull(r.mapOf(pairArr)), null, 8, null);
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
