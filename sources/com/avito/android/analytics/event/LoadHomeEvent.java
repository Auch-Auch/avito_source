package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/event/LoadHomeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "e", "Ljava/lang/String;", "locationId", "", "stateId", "<init>", "(JLjava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LoadHomeEvent extends TreeClickStreamEvent {
    public final String e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadHomeEvent(long j, @NotNull String str) {
        super(j, null, 2648, 0);
        Intrinsics.checkNotNullParameter(str, "locationId");
        this.e = str;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        return q.mapOf(TuplesKt.to("lid", this.e));
    }
}
