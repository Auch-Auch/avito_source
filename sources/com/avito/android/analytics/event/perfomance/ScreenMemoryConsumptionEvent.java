package com.avito.android.analytics.event.perfomance;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/avito/android/analytics/event/perfomance/ScreenMemoryConsumptionEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", "getVersion", "version", "screenName", "", "nativeHeapSize", "javaHeapSize", "totalPrivateSize", "gcCount", "gcTime", "blockingGcCount", "blockingGcTime", "allocatedSize", "freedSize", "timeRange", "<init>", "(Ljava/lang/String;JJJJJJJJJJ)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenMemoryConsumptionEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public ScreenMemoryConsumptionEvent(@NotNull String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.a = new ParametrizedClickStreamEvent(4274, 0, r.mutableMapOf(TuplesKt.to(VKApiUserFull.SCREEN_NAME, str), TuplesKt.to("native_heap_size", Long.valueOf(j)), TuplesKt.to("java_heap_size", Long.valueOf(j2)), TuplesKt.to("total_private_size", Long.valueOf(j3)), TuplesKt.to("gc_count", Long.valueOf(j4)), TuplesKt.to("gc_time", Long.valueOf(j5)), TuplesKt.to("blocking_gc_count", Long.valueOf(j6)), TuplesKt.to("blocking_gc_time", Long.valueOf(j7)), TuplesKt.to("allocated_size", Long.valueOf(j8)), TuplesKt.to("freed_size", Long.valueOf(j9)), TuplesKt.to("time_range", Long.valueOf(j10))), null, 8, null);
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
