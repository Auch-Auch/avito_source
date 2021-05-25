package com.avito.android.in_app_calls.analytics;

import com.avito.android.analytics.clickstream.event.HasSensitiveData;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.calls_shared.analytics.CallEventParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/InAppCallFeedbackEvent;", "Lcom/avito/android/analytics/clickstream/event/HasSensitiveData;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "callId", "", "callIsIncoming", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "callRating", "itemId", "<init>", "(Ljava/lang/String;ZLcom/avito/android/in_app_calls/analytics/AppCallRating;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class InAppCallFeedbackEvent implements HasSensitiveData, ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002a: APUT  
      (r0v3 kotlin.Pair[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0026: INVOKE  (r9v3 kotlin.Pair) = 
      (wrap: java.lang.String : ?: SGET   com.avito.android.calls_shared.analytics.CallEventParams.CALL_SIDE java.lang.String)
      (wrap: java.lang.Integer : 0x0020: INVOKE  (r9v2 java.lang.Integer) = (r9v1 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public InAppCallFeedbackEvent(@NotNull String str, boolean z, @NotNull AppCallRating appCallRating, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "callId");
        Intrinsics.checkNotNullParameter(appCallRating, "callRating");
        Pair[] pairArr = new Pair[3];
        boolean z2 = false;
        pairArr[0] = TuplesKt.to(CallEventParams.CALL_ID, str);
        pairArr[1] = TuplesKt.to(CallEventParams.CALL_SIDE, Integer.valueOf(z ? 2 : 1));
        pairArr[2] = TuplesKt.to("call_rating", Integer.valueOf(appCallRating.getRatingValue()));
        Map mapOf = r.mapOf(pairArr);
        if (str2 != null ? true : z2) {
            Intrinsics.checkNotNull(str2);
            mapOf = r.plus(mapOf, TuplesKt.to("iid", str2));
        }
        this.a = new ParametrizedClickStreamEvent(4099, 0, mapOf, null, 8, null);
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
