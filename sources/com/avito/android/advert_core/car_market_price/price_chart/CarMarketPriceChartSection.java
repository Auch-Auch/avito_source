package com.avito.android.advert_core.car_market_price.price_chart;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartSection;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "color", "", "isAccented", "setTitleColor", "(IZ)V", "lineColor", "", "lineCornersRadii", "setLineDrawableParams", "(IZ[F)V", "isDotVisible", "()Z", "setDotVisible", "(Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface CarMarketPriceChartSection {
    boolean isDotVisible();

    void setDotVisible(boolean z);

    void setLineDrawableParams(int i, boolean z, @NotNull float[] fArr);

    void setTitle(@NotNull String str);

    void setTitleColor(int i, boolean z);
}
