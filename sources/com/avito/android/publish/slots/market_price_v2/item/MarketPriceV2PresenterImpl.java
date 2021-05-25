package com.avito.android.publish.slots.market_price_v2.item;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.items.MarketPriceV2Item;
import com.avito.android.publish.analytics.events.InfoLinkClickEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceResponse;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.color.ContextsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b-\u0010.J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR:\u0010\u0014\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR:\u0010(\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010#0# \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010#0#\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0013R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2PresenterImpl;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Presenter;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2View;", "view", "Lcom/avito/android/items/MarketPriceV2Item;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2View;Lcom/avito/android/items/MarketPriceV2Item;I)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "f", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", "c", "Lcom/jakewharton/rxrelay2/PublishRelay;", "deepLinkClickRelay", "Lcom/avito/android/analytics/Analytics;", "h", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/Observable;", "d", "Lio/reactivex/Observable;", "getDeepLinkClickStream", "()Lio/reactivex/Observable;", "deepLinkClickStream", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Formatter;", "e", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Formatter;", "priceFormatter", "", AuthSource.BOOKING_ORDER, "getUrlClickStream", "urlClickStream", AuthSource.SEND_ABUSE, "urlClickRelay", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", g.a, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "<init>", "(Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Formatter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/analytics/Analytics;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceV2PresenterImpl implements MarketPriceV2Presenter {
    public final PublishRelay<String> a;
    @NotNull
    public final Observable<String> b;
    public final PublishRelay<DeepLink> c;
    @NotNull
    public final Observable<DeepLink> d;
    public final MarketPriceV2Formatter e;
    public final AttributedTextFormatter f;
    public final PublishAnalyticsDataProvider g;
    public final Analytics h;

    @Inject
    public MarketPriceV2PresenterImpl(@NotNull MarketPriceV2Formatter marketPriceV2Formatter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(marketPriceV2Formatter, "priceFormatter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.e = marketPriceV2Formatter;
        this.f = attributedTextFormatter;
        this.g = publishAnalyticsDataProvider;
        this.h = analytics;
        PublishRelay<String> create = PublishRelay.create();
        this.a = create;
        Observable<String> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "urlClickRelay.hide()");
        this.b = hide;
        PublishRelay<DeepLink> create2 = PublishRelay.create();
        this.c = create2;
        Observable<DeepLink> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "deepLinkClickRelay.hide()");
        this.d = hide2;
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Presenter
    @NotNull
    public Observable<DeepLink> getDeepLinkClickStream() {
        return this.d;
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Presenter
    @NotNull
    public Observable<String> getUrlClickStream() {
        return this.b;
    }

    public void bindView(@NotNull MarketPriceV2View marketPriceV2View, @NotNull MarketPriceV2Item marketPriceV2Item, int i) {
        Intrinsics.checkNotNullParameter(marketPriceV2View, "view");
        Intrinsics.checkNotNullParameter(marketPriceV2Item, "item");
        MarketPriceResponse.PriceRangeV2 priceRange = marketPriceV2Item.getPriceRange();
        marketPriceV2View.setMarketPriceDescription(this.e.formatPriceDescription(marketPriceV2View.getContext(), priceRange.getDescription(), priceRange.getPriceBadge()));
        AttributedText priceDetails = marketPriceV2Item.getPriceDetails();
        if (priceDetails != null) {
            priceDetails.setOnUrlClickListener(new OnUrlClickListener(this) { // from class: com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2PresenterImpl$bindView$$inlined$let$lambda$1
                public final /* synthetic */ MarketPriceV2PresenterImpl a;

                {
                    this.a = r1;
                }

                @Override // com.avito.android.deep_linking.links.OnUrlClickListener
                public boolean onUrlClick(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "url");
                    this.a.h.track(new InfoLinkClickEvent(this.a.g, str));
                    this.a.a.accept(str);
                    return true;
                }
            });
            priceDetails.setOnDeepLinkClickListener(new OnDeepLinkClickListener(this) { // from class: com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2PresenterImpl$bindView$$inlined$let$lambda$2
                public final /* synthetic */ MarketPriceV2PresenterImpl a;

                {
                    this.a = r1;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                    this.a.c.accept(deepLink);
                }
            });
        }
        marketPriceV2View.setMarketPriceDetails(this.f.format(marketPriceV2View.getContext(), marketPriceV2Item.getPriceDetails()));
        marketPriceV2View.clearNotices();
        UniversalColor noticeColor = priceRange.getNoticeColor();
        Integer valueOf = noticeColor != null ? Integer.valueOf(ContextsKt.getColorFrom(marketPriceV2View.getContext(), noticeColor)) : null;
        List<String> notices = priceRange.getNotices();
        if (notices != null) {
            Iterator<T> it = notices.iterator();
            while (it.hasNext()) {
                marketPriceV2View.addNotice(this.e.formatPriceNotice(it.next(), marketPriceV2Item.getUserPrice(), marketPriceV2Item.getMarketPrice()), valueOf);
            }
        }
        marketPriceV2View.setCallout(priceRange.getCallout());
    }
}
