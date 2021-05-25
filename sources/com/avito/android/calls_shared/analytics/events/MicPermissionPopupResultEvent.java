package com.avito.android.calls_shared.analytics.events;

import com.avito.android.analytics.clickstream.event.HasSensitiveData;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.calls_shared.MicAccessScenario;
import com.avito.android.calls_shared.analytics.CallEventParams;
import com.avito.android.calls_shared.analytics.mapping.CallTypesToEventParamMapperKt;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/MicPermissionPopupResultEvent;", "Lcom/avito/android/analytics/clickstream/event/HasSensitiveData;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "", "granted", "Lcom/avito/android/calls_shared/MicAccessScenario;", "scenario", "itemId", "callId", "<init>", "(ZLcom/avito/android/calls_shared/MicAccessScenario;Ljava/lang/String;Ljava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class MicPermissionPopupResultEvent implements HasSensitiveData, ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public MicPermissionPopupResultEvent(boolean z, @NotNull MicAccessScenario micAccessScenario, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(micAccessScenario, "scenario");
        this.a = new ParametrizedClickStreamEvent(4100, 2, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("iid", str), TuplesKt.to(CallEventParams.CALL_MIC_ACCESS, Boolean.valueOf(z)), TuplesKt.to(CallEventParams.CALL_ID, str2), TuplesKt.to(CallEventParams.CALL_MIC_ACCESS_SCENARIO, CallTypesToEventParamMapperKt.getEventValue(micAccessScenario)))), null, 8, null);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MicPermissionPopupResultEvent(boolean z, MicAccessScenario micAccessScenario, String str, String str2, int i, j jVar) {
        this(z, micAccessScenario, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }
}
