package com.avito.android.advert_core.car_market_price.price_chart;

import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PriceDetails;
import com.avito.android.remote.model.PriceRanges;
import com.avito.android.remote.model.Range;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.text.AttributedTextFormatter;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r*\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenterImpl;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter$Router;)V", "detachRouter", "()V", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartView;", "view", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartItem;", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartView;Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartItem;I)V", AuthSource.SEND_ABUSE, "(I)I", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Lcom/avito/android/util/DeviceMetrics;", "d", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter$Router;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartResourceProvider;", "resourcesProvider", "<init>", "(Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartResourceProvider;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/util/DeviceMetrics;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CarMarketPriceChartPresenterImpl implements CarMarketPriceChartPresenter {
    public CarMarketPriceChartPresenter.Router a;
    public final CarMarketPriceChartResourceProvider b;
    public final AttributedTextFormatter c;
    public final DeviceMetrics d;

    @Inject
    public CarMarketPriceChartPresenterImpl(@NotNull CarMarketPriceChartResourceProvider carMarketPriceChartResourceProvider, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(carMarketPriceChartResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.b = carMarketPriceChartResourceProvider;
        this.c = attributedTextFormatter;
        this.d = deviceMetrics;
    }

    public final int a(int i) {
        return (int) (this.d.getDisplayScaleFactor() * ((float) i));
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter
    public void attachRouter(@NotNull CarMarketPriceChartPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter
    public void detachRouter() {
        this.a = null;
    }

    public void bindView(@NotNull CarMarketPriceChartView carMarketPriceChartView, @NotNull CarMarketPriceChartItem carMarketPriceChartItem, int i) {
        List list;
        String str;
        Intrinsics.checkNotNullParameter(carMarketPriceChartView, "view");
        Intrinsics.checkNotNullParameter(carMarketPriceChartItem, "item");
        PriceRanges priceRanges = carMarketPriceChartItem.getPriceRanges();
        carMarketPriceChartView.setTitle(priceRanges.getTitle());
        carMarketPriceChartView.setSubtitle(priceRanges.getSubtitle());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        PriceDetails details = priceRanges.getDetails();
        if (details != null) {
            DeepLink url = details.getUrl();
            if (url == null) {
                str = details.getText();
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                list = d.listOf(new DeepLinkAttribute("link", details.getText(), url, null, url.getUri().toString(), 8, null));
                str = "{{link}}";
            }
            AttributedText attributedText = new AttributedText(str, list);
            attributedText.setOnDeepLinkClickListener(new OnDeepLinkClickListener(this, objectRef, carMarketPriceChartView) { // from class: com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenterImpl$bindView$$inlined$let$lambda$1
                public final /* synthetic */ CarMarketPriceChartPresenterImpl a;
                public final /* synthetic */ CarMarketPriceChartView b;

                {
                    this.a = r1;
                    this.b = r3;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                    CarMarketPriceChartPresenter.Router router = this.a.a;
                    if (router != null) {
                        router.followDeepLink(deepLink);
                    }
                }
            });
            objectRef.element = (T) this.c.format(carMarketPriceChartView.getContext(), attributedText);
        }
        carMarketPriceChartView.setDetails(objectRef.element);
        List<Range> ranges = priceRanges.getRanges();
        carMarketPriceChartView.clearChartSections();
        int displayWidth = (this.d.getDisplayWidth() - (a(16) + ((a(2) * 3) + (this.b.getContentHorizontalPadding() * 2)))) / 3;
        int i2 = -1;
        int i3 = 0;
        for (T t : ranges) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            boolean areEqual = Intrinsics.areEqual(t2.isAccented(), Boolean.TRUE);
            int i5 = areEqual ? i3 : i2;
            String title = t2.getTitle();
            UniversalColor universalTitleColor = t2.getUniversalTitleColor();
            UniversalColor universalRangeColor = t2.getUniversalRangeColor();
            int size = ranges.size();
            float a3 = (float) a(4);
            boolean z = i3 == 0;
            boolean z2 = i3 == size + -1;
            float f = z ? a3 : 0.0f;
            if (!z2) {
                a3 = 0.0f;
            }
            carMarketPriceChartView.addChartSection(title, universalTitleColor, universalRangeColor, new float[]{f, f, a3, a3, a3, a3, f, f}, areEqual, displayWidth, i3 < ranges.size() + -1 ? a(2) : 0);
            i3 = i4;
            i2 = i5;
        }
        if (i2 != -1) {
            carMarketPriceChartView.moveChartToPosition(i2, i2 == 0 ? 0 : displayWidth + 4 + 8);
        }
    }
}
