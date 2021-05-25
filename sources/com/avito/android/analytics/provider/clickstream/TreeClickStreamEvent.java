package com.avito.android.analytics.provider.clickstream;

import androidx.annotation.VisibleForTesting;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\"\u001a\u00020\u001a¢\u0006\u0004\b$\u0010%J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\f\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0006¨\u0006&"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "", "params", "key", "value", "", "putParam", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)V", "", AuthSource.SEND_ABUSE, "J", "getStateId", "()J", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "", "c", "I", "getEventId", "()I", "eventId", "d", "getVersion", "version", "getParams", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;II)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public abstract class TreeClickStreamEvent implements ClickStreamEvent {
    public final long a;
    @Nullable
    public final TreeClickStreamParent b;
    public final int c;
    public final int d;

    public TreeClickStreamEvent(@VisibleForTesting long j, @VisibleForTesting @Nullable TreeClickStreamParent treeClickStreamParent, int i, int i2) {
        this.a = j;
        this.b = treeClickStreamParent;
        this.c = i;
        this.d = i2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @VisibleForTesting(otherwise = 4)
    @NotNull
    public abstract Map<String, Object> extraParams();

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        Map<String, Object> map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.a;
        if (j != 0) {
            linkedHashMap.put("state_id", Long.valueOf(j));
        }
        TreeClickStreamParent treeClickStreamParent = this.b;
        if (treeClickStreamParent == null || (map = treeClickStreamParent.getParams()) == null) {
            map = r.emptyMap();
        }
        linkedHashMap.putAll(map);
        linkedHashMap.putAll(extraParams());
        return linkedHashMap;
    }

    @Nullable
    public final TreeClickStreamParent getParent() {
        return this.b;
    }

    public final long getStateId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.d;
    }

    public final void putParam(@NotNull Map<String, Object> map, @NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj != null) {
            map.put(str, obj);
        }
    }
}
