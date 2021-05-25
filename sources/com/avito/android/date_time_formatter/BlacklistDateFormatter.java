package com.avito.android.date_time_formatter;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.CalendarsKt;
import com.avito.android.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@NotThreadSafe
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/avito/android/date_time_formatter/BlacklistDateFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "", "format", "(Ljava/lang/Long;)Ljava/lang/String;", "Ljava/util/Calendar;", "e", "Ljava/util/Calendar;", "targetCalendar", "Landroid/content/res/Resources;", "i", "Landroid/content/res/Resources;", "resources", "d", "todayCalendar", "Lcom/avito/android/server_time/TimeSource;", "h", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/text/SimpleDateFormat;", AuthSource.SEND_ABUSE, "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/util/Date;", "f", "Ljava/util/Date;", "targetDate", "", g.a, "[Ljava/lang/String;", "formattedDaysOfWeek", AuthSource.BOOKING_ORDER, "timeFormat", "c", "Ljava/lang/String;", "yesterdayTitle", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/server_time/TimeSource;Landroid/content/res/Resources;Ljava/util/Locale;)V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistDateFormatter implements Formatter<Long> {
    public final SimpleDateFormat a;
    public final SimpleDateFormat b;
    public final String c;
    public final Calendar d;
    public final Calendar e;
    public final Date f = new Date();
    public String[] g;
    public final TimeSource h;
    public final Resources i;

    public BlacklistDateFormatter(@NotNull TimeSource timeSource, @NotNull Resources resources, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.h = timeSource;
        this.i = resources;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy", locale);
        this.a = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", locale);
        this.b = simpleDateFormat2;
        TimeZone timeZone = timeSource.getTimeZone();
        Calendar instance = Calendar.getInstance(timeZone, locale);
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance(timeZone, locale)");
        this.d = instance;
        Calendar instance2 = Calendar.getInstance(timeZone, locale);
        Intrinsics.checkNotNullExpressionValue(instance2, "Calendar.getInstance(timeZone, locale)");
        this.e = instance2;
        simpleDateFormat.setTimeZone(timeZone);
        simpleDateFormat2.setTimeZone(timeZone);
        String string = resources.getString(R.string.yesterday);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.yesterday)");
        this.c = string;
        this.g = resources.getStringArray(R.array.on_day_of_week);
    }

    @NotNull
    public String format(@Nullable Long l) {
        if (l == null) {
            return "";
        }
        long longValue = l.longValue();
        this.e.setTimeInMillis(longValue);
        this.f.setTime(longValue);
        this.d.setTimeInMillis(this.h.now());
        CalendarsKt.clearTime(this.d);
        long timeInMillis = this.d.getTimeInMillis();
        if (longValue >= timeInMillis) {
            String string = this.i.getString(R.string.blocked_on_date_template, this.b.format(this.f));
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ormat.format(targetDate))");
            return string;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (longValue >= timeInMillis - timeUnit.toMillis(1)) {
            String string2 = this.i.getString(R.string.blocked_date_template, this.c);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…template, yesterdayTitle)");
            return string2;
        } else if (longValue >= timeInMillis - timeUnit.toMillis(6)) {
            int i2 = this.e.get(7) - 1;
            String[] strArr = this.g;
            String str = strArr != null ? strArr[i2] : null;
            if (str != null) {
                String string3 = this.i.getString(R.string.blocked_date_template, str);
                Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…e_template, formattedDay)");
                return string3;
            }
            String string4 = this.i.getString(R.string.blocked_date_template, this.a.format(this.f));
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…ormat.format(targetDate))");
            return string4;
        } else {
            String string5 = this.i.getString(R.string.blocked_date_template, this.a.format(this.f));
            Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…ormat.format(targetDate))");
            return string5;
        }
    }
}
