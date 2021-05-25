package com.avito.android.date_time_formatter;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.CalendarsKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@NotThreadSafe
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/avito/android/date_time_formatter/RelativeDateFormatterImpl;", "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "", "timeMillis", "", "format", "(Ljava/lang/Long;)Ljava/lang/String;", "Ljava/util/Date;", "f", "Ljava/util/Date;", Sort.DATE, "Ljava/text/SimpleDateFormat;", AuthSource.BOOKING_ORDER, "Ljava/text/SimpleDateFormat;", "timeFormat", "d", "Ljava/lang/String;", "yesterdayTitle", "Lcom/avito/android/server_time/TimeSource;", g.a, "Lcom/avito/android/server_time/TimeSource;", "mTimeSource", "c", "weekdayFormat", AuthSource.SEND_ABUSE, "dateFormat", "Ljava/util/Calendar;", "e", "Ljava/util/Calendar;", FormattedDateDisplayingType.TYPE_CALENDAR, "Landroid/content/res/Resources;", "resources", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/server_time/TimeSource;Landroid/content/res/Resources;Ljava/util/Locale;)V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class RelativeDateFormatterImpl implements RelativeDateFormatter {
    public final SimpleDateFormat a;
    public final SimpleDateFormat b;
    public final SimpleDateFormat c;
    public final String d;
    public final Calendar e;
    public final Date f = new Date();
    public final TimeSource g;

    @Inject
    public RelativeDateFormatterImpl(@NotNull TimeSource timeSource, @NotNull Resources resources, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(timeSource, "mTimeSource");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.g = timeSource;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy", locale);
        this.a = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", locale);
        this.b = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("EEEE", locale);
        this.c = simpleDateFormat3;
        TimeZone timeZone = timeSource.getTimeZone();
        Calendar instance = Calendar.getInstance(timeZone, locale);
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance(timeZone, locale)");
        this.e = instance;
        simpleDateFormat.setTimeZone(timeZone);
        simpleDateFormat2.setTimeZone(timeZone);
        simpleDateFormat3.setTimeZone(timeZone);
        String string = resources.getString(R.string.yesterday_cap);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.yesterday_cap)");
        this.d = string;
    }

    @NotNull
    public String format(@Nullable Long l) {
        if (l == null) {
            return "";
        }
        long longValue = l.longValue();
        this.e.setTimeInMillis(this.g.now());
        CalendarsKt.clearTime(this.e);
        long timeInMillis = this.e.getTimeInMillis();
        this.f.setTime(longValue);
        if (longValue >= timeInMillis) {
            String format = this.b.format(this.f);
            Intrinsics.checkNotNullExpressionValue(format, "timeFormat.format(date)");
            return format;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (longValue >= timeInMillis - timeUnit.toMillis(1)) {
            return this.d;
        }
        if (longValue >= timeInMillis - timeUnit.toMillis(6)) {
            String format2 = this.c.format(this.f);
            Intrinsics.checkNotNullExpressionValue(format2, "weekdayFormat.format(date)");
            return format2;
        }
        String format3 = this.a.format(this.f);
        Intrinsics.checkNotNullExpressionValue(format3, "dateFormat.format(date)");
        return format3;
    }
}
