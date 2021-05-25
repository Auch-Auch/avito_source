package com.avito.android.advert_core.analytics.delivery;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.SearchContextWrapperKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J5\u0010\b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006#"}, d2 = {"Lcom/avito/android/advert_core/analytics/delivery/SafeDealBuyButtonClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "", "", "Lkotlin/Pair;", "entry", "", AuthSource.SEND_ABUSE, "(Ljava/util/Map;Lkotlin/Pair;)V", "", "c", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "", AuthSource.BOOKING_ORDER, "I", "getVersion", "()I", "version", "getEventId", "eventId", "itemId", ChannelContext.Item.USER_ID, "categoryId", "source", "", "isUserAuthorized", "safeDealServices", "context", "isMarketplace", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SafeDealBuyButtonClickEvent implements ClickStreamEvent {
    public final int a;
    public final int b;
    @NotNull
    public final Map<String, Object> c;

    public SafeDealBuyButtonClickEvent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z, @Nullable String str5, @Nullable String str6, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a = 2483;
        this.b = 7;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(linkedHashMap, TuplesKt.to("iid", str));
        a(linkedHashMap, TuplesKt.to("uid", str2));
        a(linkedHashMap, TuplesKt.to("cid", str3));
        a(linkedHashMap, TuplesKt.to("srcp", str4));
        a(linkedHashMap, TuplesKt.to("is_user_auth", Boolean.valueOf(z)));
        a(linkedHashMap, TuplesKt.to("safedeal_services", str5));
        a(linkedHashMap, TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, Boolean.valueOf(z2)));
        a(linkedHashMap, TuplesKt.to("x", SearchContextWrapperKt.extractSearchXFromContext(new SearchContextWrapper(str6))));
        this.c = linkedHashMap;
    }

    public final void a(Map<String, Object> map, Pair<String, ? extends Object> pair) {
        Object second = pair.getSecond();
        if (second != null) {
            map.put(pair.getFirst(), second);
        }
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SafeDealBuyButtonClickEvent(String str, String str2, String str3, String str4, boolean z, String str5, String str6, boolean z2, int i, j jVar) {
        this(str, str2, str3, str4, z, str5, str6, (i & 128) != 0 ? false : z2);
    }
}
