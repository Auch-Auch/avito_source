package com.avito.android.advert_core.analytics.cart;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Collections;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.SearchContextWrapperKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert_core/analytics/cart/MarketplaceBuyButtonClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "itemId", ChannelContext.Item.USER_ID, "categoryId", "source", "", "isUserAuthorized", "safeDealServices", "context", "isMarketplace", "isCart", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceBuyButtonClickEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public MarketplaceBuyButtonClickEvent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a = new ParametrizedClickStreamEvent(2483, 10, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("iid", str), TuplesKt.to("uid", str2), TuplesKt.to("cid", str3), TuplesKt.to("srcp", str4), TuplesKt.to("is_user_auth", bool), TuplesKt.to("safedeal_services", str5), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, bool2), TuplesKt.to(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, Boolean.valueOf(z)), TuplesKt.to("x", SearchContextWrapperKt.extractSearchXFromContext(new SearchContextWrapper(str6))))), "Avito.Delivery / Создание заказа на доставку / Клик на кнопку 'купить с доставкой'");
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
    public /* synthetic */ MarketplaceBuyButtonClickEvent(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, Boolean bool2, boolean z, int i, j jVar) {
        this(str, str2, str3, str4, bool, str5, str6, (i & 128) != 0 ? null : bool2, (i & 256) != 0 ? false : z);
    }
}
