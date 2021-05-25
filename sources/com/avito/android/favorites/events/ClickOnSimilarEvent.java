package com.avito.android.favorites.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/avito/android/favorites/events/ClickOnSimilarEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "getEventId", "eventId", "itemId", ChannelContext.Item.USER_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class ClickOnSimilarEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0019: APUT  
      (r2v0 kotlin.Pair[])
      (0 ??[int, short, byte, char])
      (wrap: kotlin.Pair : 0x0014: INVOKE  (r6v2 kotlin.Pair) = ("uid"), (r6v1 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public ClickOnSimilarEvent(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("uid", str2 == null ? "" : str2);
        pairArr[1] = TuplesKt.to("iid", str);
        this.a = new ParametrizedClickStreamEvent(4977, 2, Collections.filterValuesNotNull(r.mapOf(pairArr)), "Пользовательские события / Закладки / Клик на показать похожие при распроданном объявлении в избранном");
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
