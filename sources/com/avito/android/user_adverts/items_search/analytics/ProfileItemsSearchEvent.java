package com.avito.android.user_adverts.items_search.analytics;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.util.Collections;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "count", "shortcut", "Lcom/avito/android/user_adverts/items_search/analytics/PageType;", "pageType", "query", "<init>", "(ILjava/lang/String;Lcom/avito/android/user_adverts/items_search/analytics/PageType;Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsSearchEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0046: APUT  
      (r1v1 kotlin.Pair[])
      (3 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0041: INVOKE  (r9v10 kotlin.Pair) = (wrap: java.lang.String : ?: SGET   com.vk.sdk.api.VKApiConst.Q java.lang.String), (r12v1 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public ProfileItemsSearchEvent(int i, @NotNull String str, @NotNull PageType pageType, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("total", Integer.valueOf(i));
        pairArr[1] = TuplesKt.to("profile_tab", str);
        pairArr[2] = TuplesKt.to("pagetype", pageType.name());
        pairArr[3] = TuplesKt.to(VKApiConst.Q, Intrinsics.areEqual("", str2) ? "EMPTY_QUERY" : str2);
        this.a = new ParametrizedClickStreamEvent(4357, 3, Collections.filterValuesNotNull(r.mapOf(pairArr)), null, 8, null);
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
    public /* synthetic */ ProfileItemsSearchEvent(int i, String str, PageType pageType, String str2, int i2, j jVar) {
        this((i2 & 1) != 0 ? -1 : i, str, pageType, (i2 & 8) != 0 ? null : str2);
    }
}
