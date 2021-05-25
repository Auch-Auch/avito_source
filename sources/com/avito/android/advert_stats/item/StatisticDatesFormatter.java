package com.avito.android.advert_stats.item;

import com.avito.android.remote.model.Sort;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_stats/item/StatisticDatesFormatter;", "", "", Sort.DATE, "", "formatDay", "(J)Ljava/lang/String;", Tracker.Events.CREATIVE_START, "end", "formatDaysRange", "(JJ)Ljava/lang/String;", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface StatisticDatesFormatter {
    @NotNull
    String formatDay(long j);

    @NotNull
    String formatDaysRange(long j, long j2);
}
