package com.avito.android.advert_stats.item;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.advert_stats.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0015\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u001c\u0010!\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\u0004R\u001c\u0010$\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/advert_stats/item/PlotDimensionsProviderImpl;", "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "", "getBarWidth", "()I", "barWidth", "Lcom/avito/android/util/DeviceMetrics;", "k", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "j", "I", "getEmptyBarHeight", "emptyBarHeight", "c", "topPadding", AuthSource.SEND_ABUSE, "startGap", "d", "bottomPadding", "getPlotSideMargin", "plotSideMargin", "h", "getBarHeight", "barHeight", AuthSource.BOOKING_ORDER, "gapBetweenBarSmall", "e", "barBottomMargin", "f", "textArea", g.a, "getPlotHeight", "plotHeight", "i", "getMinBarHeight", "minBarHeight", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class PlotDimensionsProviderImpl implements PlotDimensionsProvider {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final DeviceMetrics k;

    public PlotDimensionsProviderImpl(@NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.k = deviceMetrics;
        this.a = resources.getDimensionPixelSize(R.dimen.start_gap);
        this.b = resources.getDimensionPixelSize(R.dimen.gap_between_bars_small);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.recycler_top_padding);
        this.c = dimensionPixelSize;
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.recycler_bottom_padding);
        this.d = dimensionPixelSize2;
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.bar_bottom_margin);
        this.e = dimensionPixelSize3;
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.text_area);
        this.f = dimensionPixelSize4;
        this.g = (Math.max(deviceMetrics.getDisplayWidth(), deviceMetrics.getDisplayHeight()) * 34) / 100;
        this.h = (((getPlotHeight() - dimensionPixelSize) - dimensionPixelSize2) - dimensionPixelSize4) - dimensionPixelSize3;
        this.i = resources.getDimensionPixelSize(R.dimen.bar_min_height);
        this.j = resources.getDimensionPixelSize(R.dimen.empty_bar_height);
    }

    @Override // com.avito.android.advert_stats.item.PlotDimensionsProvider
    public int getBarHeight() {
        return this.h;
    }

    @Override // com.avito.android.advert_stats.item.PlotDimensionsProvider
    public int getBarWidth() {
        int i2 = this.b;
        int displayWidth = ((this.k.getDisplayWidth() - ((i2 * 2) * 7)) - ((i2 * 2) + (this.a * 2))) / 7;
        return displayWidth % 2 == 0 ? displayWidth : displayWidth - 1;
    }

    @Override // com.avito.android.advert_stats.item.PlotDimensionsProvider
    public int getEmptyBarHeight() {
        return this.j;
    }

    @Override // com.avito.android.advert_stats.item.PlotDimensionsProvider
    public int getMinBarHeight() {
        return this.i;
    }

    @Override // com.avito.android.advert_stats.item.PlotDimensionsProvider
    public int getPlotHeight() {
        return this.g;
    }

    @Override // com.avito.android.advert_stats.item.PlotDimensionsProvider
    public int getPlotSideMargin() {
        return ((this.k.getDisplayWidth() - ((this.b * 2) * 7)) - (getBarWidth() * 7)) / 2;
    }
}
