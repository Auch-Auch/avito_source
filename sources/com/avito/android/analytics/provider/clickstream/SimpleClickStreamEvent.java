package com.avito.android.analytics.provider.clickstream;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0013\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\fR(\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/SimpleClickStreamEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "c", "I", "getVersion", "version", AuthSource.BOOKING_ORDER, "getEventId", "eventId", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "<init>", "(II)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleClickStreamEvent implements ClickStreamEvent {
    @NotNull
    public final Map<String, Object> a = r.emptyMap();
    public final int b;
    public final int c;

    public SimpleClickStreamEvent(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(SimpleClickStreamEvent.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.analytics.provider.clickstream.SimpleClickStreamEvent");
        SimpleClickStreamEvent simpleClickStreamEvent = (SimpleClickStreamEvent) obj;
        return getEventId() == simpleClickStreamEvent.getEventId() && getVersion() == simpleClickStreamEvent.getVersion();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c;
    }

    public int hashCode() {
        return getVersion() + (getEventId() * 31);
    }

    @NotNull
    public String toString() {
        return description();
    }
}
