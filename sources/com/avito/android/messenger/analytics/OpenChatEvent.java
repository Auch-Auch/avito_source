package com.avito.android.messenger.analytics;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/analytics/OpenChatEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "getEventId", "eventId", "channelId", "", "isFromPush", "numberInList", "messageId", "searchQuery", "<init>", "(Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OpenChatEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0024: APUT  
      (r1v1 kotlin.Pair[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x001f: INVOKE  (r9v3 kotlin.Pair) = ("s"), (r9v2 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public OpenChatEvent(@NotNull String str, boolean z, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("chatid", str);
        pairArr[1] = TuplesKt.to("s", z ? "push" : "app");
        pairArr[2] = TuplesKt.to("channel_number", num);
        pairArr[3] = TuplesKt.to("mid", str2);
        pairArr[4] = TuplesKt.to("msg_search_query", str3);
        this.a = new ParametrizedClickStreamEvent(2919, 3, Collections.filterValuesNotNull(r.mapOf(pairArr)), null, 8, null);
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
    public /* synthetic */ OpenChatEvent(String str, boolean z, Integer num, String str2, String str3, int i, j jVar) {
        this(str, z, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }
}
