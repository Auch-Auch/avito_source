package com.avito.android.date_time_formatter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/avito/android/date_time_formatter/SimpleDateFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "", "format", "(Ljava/lang/Long;)Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", AuthSource.SEND_ABUSE, "Ljava/text/SimpleDateFormat;", "dateFormat", "pattern", "Ljava/util/Locale;", "locale", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "<init>", "(Ljava/lang/String;Ljava/util/Locale;Lcom/avito/android/server_time/TimeSource;)V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleDateFormatter implements Formatter<Long> {
    public final SimpleDateFormat a;

    public SimpleDateFormatter(@NotNull String str, @NotNull Locale locale, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeSource.getTimeZone());
        Unit unit = Unit.INSTANCE;
        this.a = simpleDateFormat;
    }

    @NotNull
    public String format(@Nullable Long l) {
        if (l != null) {
            String format = this.a.format(new Date(l.longValue()));
            if (format != null) {
                return format;
            }
        }
        return "";
    }
}
