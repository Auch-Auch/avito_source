package com.avito.android.advert_stats.item;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert_stats/item/StatisticDatesFormatterImpl;", "Lcom/avito/android/advert_stats/item/StatisticDatesFormatter;", "", Sort.DATE, "", "formatDay", "(J)Ljava/lang/String;", Tracker.Events.CREATIVE_START, "end", "formatDaysRange", "(JJ)Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "shortDateFormatter", AuthSource.BOOKING_ORDER, "singleDateFormatter", "Ljava/util/Locale;", AuthSource.SEND_ABUSE, "Ljava/util/Locale;", "locale", "d", "rangeDatePattern", "<init>", "()V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatisticDatesFormatterImpl implements StatisticDatesFormatter {
    public final Locale a;
    public final SimpleDateFormat b;
    public final SimpleDateFormat c;
    public final SimpleDateFormat d;

    @Inject
    public StatisticDatesFormatterImpl() {
        Locale locale = new Locale("ru", "RU");
        this.a = locale;
        this.b = new SimpleDateFormat("EEEE, d MMMM", locale);
        this.c = new SimpleDateFormat("d", locale);
        this.d = new SimpleDateFormat("d MMMM", locale);
    }

    @Override // com.avito.android.advert_stats.item.StatisticDatesFormatter
    @NotNull
    public String formatDay(long j) {
        String format = this.b.format(Long.valueOf(j * ((long) 1000)));
        Intrinsics.checkNotNullExpressionValue(format, "singleDateFormatter.format(date * MILLIS)");
        return format;
    }

    @Override // com.avito.android.advert_stats.item.StatisticDatesFormatter
    @NotNull
    public String formatDaysRange(long j, long j2) {
        long j3 = (long) 1000;
        long j4 = j * j3;
        long j5 = j2 * j3;
        Calendar instance = Calendar.getInstance(this.a);
        Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
        instance.setTimeInMillis(j4);
        int i = instance.get(2);
        instance.setTimeInMillis(j5);
        if (i == instance.get(2)) {
            return a.L2(this.c.format(Long.valueOf(j4)), '-', this.d.format(Long.valueOf(j5)));
        }
        return a.e3(this.d.format(Long.valueOf(j4)), " – ", this.d.format(Long.valueOf(j5)));
    }
}
