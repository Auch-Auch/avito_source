package com.avito.android.publish.slots.market_price;

import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.publish.analytics.events.InfoLinkClickEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/publish/slots/market_price/MarketPriceSlotWrapper$infoPageOpenListener$1", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "", "url", "", "onUrlClick", "(Ljava/lang/String;)Z", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceSlotWrapper$infoPageOpenListener$1 implements OnUrlClickListener {
    public final /* synthetic */ MarketPriceSlotWrapper a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public MarketPriceSlotWrapper$infoPageOpenListener$1(MarketPriceSlotWrapper marketPriceSlotWrapper) {
        this.a = marketPriceSlotWrapper;
    }

    @Override // com.avito.android.deep_linking.links.OnUrlClickListener
    public boolean onUrlClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.a.o.track(new InfoLinkClickEvent(this.a.n, str));
        return false;
    }
}
