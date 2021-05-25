package com.avito.android.analytics.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.UserDataStore;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/avito/android/analytics/events/CropSourceEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "J", "getSourceType", "()J", "sourceType", "", "getVersion", "()I", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "getEventId", "eventId", "<init>", "(J)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CropSourceEvent implements ClickStreamEvent {
    public final long a;
    public final /* synthetic */ ParametrizedClickStreamEvent b;

    public CropSourceEvent(long j) {
        this.b = new ParametrizedClickStreamEvent(2282, 1, q.mapOf(TuplesKt.to(UserDataStore.STATE, Long.valueOf(j))), null, 8, null);
        this.a = j;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.b.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.b.getParams();
    }

    public final long getSourceType() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b.getVersion();
    }
}
