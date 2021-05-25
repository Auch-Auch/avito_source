package com.avito.android.cart.analytics.summary;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.cart.summary.ItemQuantity;
import com.avito.android.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/avito/android/cart/analytics/summary/CartSummaryOpenedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "xHash", "", "Lcom/avito/android/cart/summary/ItemQuantity;", "cartItems", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartSummaryOpenedEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public CartSummaryOpenedEvent(@Nullable String str, @NotNull List<ItemQuantity> list) {
        Intrinsics.checkNotNullParameter(list, "cartItems");
        this.a = new ParametrizedClickStreamEvent(4657, 4, Collections.filterValuesNotNull(r.mapOf(TuplesKt.to("x", str), TuplesKt.to("busket_items", CollectionsKt___CollectionsKt.joinToString$default(list, null, "{", "}", 0, null, null, 57, null)))), "Avito.Marketplace / Корзина / Отрисовка страницы корзины");
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
