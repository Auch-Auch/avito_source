package com.avito.android.calls_shared.analytics.events;

import com.avito.android.analytics.clickstream.event.HasSensitiveData;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.calls_shared.AppCallScenario;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\u0010\u0013\u001a\u00060\u0003j\u0002`\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/InAppCallContacted;", "Lcom/avito/android/analytics/clickstream/event/HasSensitiveData;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "itemId", "Lcom/avito/android/calls_shared/CallId;", "callId", "Lcom/avito/android/calls_shared/AppCallScenario;", "scenario", "", "micAccess", "callerId", "receiverId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/calls_shared/AppCallScenario;ZLjava/lang/String;Ljava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class InAppCallContacted implements HasSensitiveData, ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public InAppCallContacted(@NotNull String str, @NotNull String str2, @NotNull AppCallScenario appCallScenario, boolean z, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "callId");
        Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
        this.a = new ParametrizedClickStreamEvent(4813, 1, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("iid", str), TuplesKt.to(CallEventParams.CALL_ID, str2), TuplesKt.to(CallEventParams.CALL_SCENARIO, CallTypesToEventParamMapperKt.getEventValue(appCallScenario)), TuplesKt.to(CallEventParams.CALL_MIC_ACCESS, Boolean.valueOf(z)), TuplesKt.to(CallEventParams.CALL_CALLER_ID, str3), TuplesKt.to(CallEventParams.CALL_RECEIVER_ID, str4))), null, 8, null);
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
    public /* synthetic */ InAppCallContacted(String str, String str2, AppCallScenario appCallScenario, boolean z, String str3, String str4, int i, j jVar) {
        this(str, str2, appCallScenario, z, str3, (i & 32) != 0 ? null : str4);
    }
}
