package com.avito.android.util;

import android.annotation.SuppressLint;
import com.avito.android.remote.auth.AuthSource;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/DayAndMonthDateFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "", "format", "(Ljava/lang/Long;)Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", AuthSource.BOOKING_ORDER, "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/DateFormatSymbols;", AuthSource.SEND_ABUSE, "Ljava/text/DateFormatSymbols;", "symbols", "<init>", "()V", "formatters_release"}, k = 1, mv = {1, 4, 2})
public final class DayAndMonthDateFormatter implements Formatter<Long> {
    public final DateFormatSymbols a;
    @SuppressLint({"SimpleDateFormat"})
    public final SimpleDateFormat b;

    public DayAndMonthDateFormatter() {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        this.a = dateFormatSymbols;
        dateFormatSymbols.setMonths(new String[]{"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"});
        this.b = new SimpleDateFormat("d MMMM", dateFormatSymbols);
    }

    @NotNull
    public String format(@Nullable Long l) {
        if (l != null) {
            String format = this.b.format(new Date(l.longValue()));
            if (format != null) {
                return format;
            }
        }
        return "";
    }
}
