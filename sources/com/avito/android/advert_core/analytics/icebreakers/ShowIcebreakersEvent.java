package com.avito.android.advert_core.analytics.icebreakers;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert_core/analytics/icebreakers/ShowIcebreakersEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "iid", "cid", "mcid", "title", "pos", "", "icebreakerIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ShowIcebreakersEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0032: APUT  
      (r1v2 kotlin.Pair[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x002d: INVOKE  (r3v3 kotlin.Pair) = ("cid"), (r3v2 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public ShowIcebreakersEvent(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, int i, @NotNull List<Integer> list) {
        a.c1(str, "iid", str4, "title", list, "icebreakerIds");
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("iid", str);
        String str5 = "";
        pairArr[1] = TuplesKt.to("cid", str2 != null ? str2 : str5);
        pairArr[2] = TuplesKt.to("mcid", str3 != null ? str3 : str5);
        pairArr[3] = TuplesKt.to("title", str4);
        pairArr[4] = TuplesKt.to(VKApiConst.POSITION, Integer.valueOf(i));
        pairArr[5] = TuplesKt.to("ice_breakers_ids", list);
        this.a = new ParametrizedClickStreamEvent(4209, 3, r.mutableMapOf(pairArr), null, 8, null);
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
