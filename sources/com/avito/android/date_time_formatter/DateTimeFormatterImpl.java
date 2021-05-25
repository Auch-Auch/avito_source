package com.avito.android.date_time_formatter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.server_time.TimeSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverterKt;
import com.avito.android.util.CalendarsKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B+\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/avito/android/date_time_formatter/DateTimeFormatterImpl;", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "", "time", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "format", "(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Ljava/lang/String;", "millis", "", AuthSource.SEND_ABUSE, "(J)I", "Ljava/text/SimpleDateFormat;", AuthSource.BOOKING_ORDER, "Ljava/text/SimpleDateFormat;", "dateFormat", "timeFormat", "c", "yearFormat", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;", "e", "Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;", "resourceProvider", "f", "I", "dayLetterCase", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;Ljava/util/Locale;I)V", "LetterCase", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class DateTimeFormatterImpl implements DateTimeFormatter {
    public final SimpleDateFormat a;
    public final SimpleDateFormat b;
    public final SimpleDateFormat c;
    public final TimeSource d;
    public final DateTimeFormatterResourceProvider e;
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/date_time_formatter/DateTimeFormatterImpl$LetterCase;", "", "<init>", "()V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LetterCase {
    }

    @Inject
    public DateTimeFormatterImpl(@NotNull TimeSource timeSource, @NotNull DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider, @NotNull Locale locale, int i) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(dateTimeFormatterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.d = timeSource;
        this.e = dateTimeFormatterResourceProvider;
        this.f = i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", locale);
        this.a = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d MMMM", locale);
        this.b = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(CalendarDataConverterKt.YEAR_PATTERN, locale);
        this.c = simpleDateFormat3;
        simpleDateFormat.setTimeZone(timeSource.getTimeZone());
        simpleDateFormat2.setTimeZone(timeSource.getTimeZone());
        simpleDateFormat3.setTimeZone(timeSource.getTimeZone());
    }

    public final int a(long j) {
        Calendar instance = Calendar.getInstance(this.d.getTimeZone());
        Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
        instance.setTimeInMillis(j);
        return instance.get(1);
    }

    @Override // com.avito.android.date_time_formatter.DateTimeFormatter
    @NotNull
    public String format(@Nullable Long l, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        if (l == null) {
            return "";
        }
        long millis = timeUnit.toMillis(l.longValue());
        Calendar instance = Calendar.getInstance(this.d.getTimeZone());
        Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
        instance.setTimeInMillis(this.d.now());
        CalendarsKt.clearTime(instance);
        long timeInMillis = instance.getTimeInMillis();
        Date date = new Date(millis);
        boolean z = true;
        int i = (millis > timeInMillis ? 1 : (millis == timeInMillis ? 0 : -1));
        if (i >= 0 || millis >= timeInMillis - TimeUnit.DAYS.toMillis(1)) {
            if (i < 0) {
                z = false;
            }
            if (z) {
                DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider = this.e;
                String format = this.a.format(date);
                Intrinsics.checkNotNullExpressionValue(format, "timeFormat.format(date)");
                return dateTimeFormatterResourceProvider.todayAtTime(format, this.f);
            }
            DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider2 = this.e;
            String format2 = this.a.format(date);
            Intrinsics.checkNotNullExpressionValue(format2, "timeFormat.format(date)");
            return dateTimeFormatterResourceProvider2.yesterdayAtTime(format2, this.f);
        }
        if (a(millis) != a(this.d.now())) {
            z = false;
        }
        if (z) {
            DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider3 = this.e;
            String format3 = this.b.format(date);
            Intrinsics.checkNotNullExpressionValue(format3, "dateFormat.format(date)");
            String format4 = this.a.format(date);
            Intrinsics.checkNotNullExpressionValue(format4, "timeFormat.format(date)");
            return dateTimeFormatterResourceProvider3.dateAtTime(format3, format4);
        }
        DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider4 = this.e;
        String format5 = this.b.format(date);
        Intrinsics.checkNotNullExpressionValue(format5, "dateFormat.format(date)");
        String format6 = this.c.format(date);
        Intrinsics.checkNotNullExpressionValue(format6, "yearFormat.format(date)");
        return dateTimeFormatterResourceProvider4.dateAtYear(format5, format6);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DateTimeFormatterImpl(TimeSource timeSource, DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider, Locale locale, int i, int i2, j jVar) {
        this(timeSource, dateTimeFormatterResourceProvider, locale, (i2 & 8) != 0 ? 0 : i);
    }
}
