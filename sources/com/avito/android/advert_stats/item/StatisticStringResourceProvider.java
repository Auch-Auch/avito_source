package com.avito.android.advert_stats.item;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_stats/item/StatisticStringResourceProvider;", "", "", "count", "", "getViews", "(I)Ljava/lang/String;", "getContacts", "getFavorites", "getLegendPredictViews", "()Ljava/lang/String;", "legendPredictViews", "getLegendGeneralViews", "legendGeneralViews", "getTitle", "title", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface StatisticStringResourceProvider {
    @NotNull
    String getContacts(int i);

    @NotNull
    String getFavorites(int i);

    @NotNull
    String getLegendGeneralViews();

    @NotNull
    String getLegendPredictViews();

    @NotNull
    String getTitle();

    @NotNull
    String getViews(int i);
}
