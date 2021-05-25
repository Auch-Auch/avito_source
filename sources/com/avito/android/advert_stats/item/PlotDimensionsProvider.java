package com.avito.android.advert_stats.item;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "", "", "getEmptyBarHeight", "()I", "emptyBarHeight", "getBarHeight", "barHeight", "getMinBarHeight", "minBarHeight", "getPlotHeight", "plotHeight", "getBarWidth", "barWidth", "getPlotSideMargin", "plotSideMargin", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface PlotDimensionsProvider {
    int getBarHeight();

    int getBarWidth();

    int getEmptyBarHeight();

    int getMinBarHeight();

    int getPlotHeight();

    int getPlotSideMargin();
}
