package com.avito.android.messenger.conversation.formatter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.CalendarsKt;
import com.avito.android.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@NotThreadSafe
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/formatter/MessageDateFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "", "format", "(Ljava/lang/Long;)Ljava/lang/String;", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "e", "Ljava/util/Locale;", "locale", "Ljava/text/SimpleDateFormat;", AuthSource.BOOKING_ORDER, "Ljava/text/SimpleDateFormat;", "weekFormat", "c", "otherFormat", AuthSource.SEND_ABUSE, "todayFormat", "todayFormatPattern", "weekFormatPattern", "otherFormatPattern", "<init>", "(Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageDateFormatter implements Formatter<Long> {
    public final SimpleDateFormat a;
    public final SimpleDateFormat b;
    public final SimpleDateFormat c;
    public final TimeSource d;
    public final Locale e;

    public MessageDateFormatter(@NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(str, "todayFormatPattern");
        Intrinsics.checkNotNullParameter(str2, "weekFormatPattern");
        Intrinsics.checkNotNullParameter(str3, "otherFormatPattern");
        this.d = timeSource;
        this.e = locale;
        this.a = new SimpleDateFormat(str, locale);
        this.b = new SimpleDateFormat(str2, locale);
        this.c = new SimpleDateFormat(str3, locale);
    }

    @NotNull
    public String format(@Nullable Long l) {
        String str;
        if (l == null) {
            return "";
        }
        long longValue = l.longValue();
        TimeZone timeZone = this.d.getTimeZone();
        Calendar instance = Calendar.getInstance(timeZone, this.e);
        instance.setTimeInMillis(this.d.now());
        CalendarsKt.clearTime(instance);
        this.a.setTimeZone(timeZone);
        this.b.setTimeZone(timeZone);
        this.c.setTimeZone(timeZone);
        Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
        long timeInMillis = instance.getTimeInMillis() - longValue;
        if (-86399999 <= timeInMillis && 0 >= timeInMillis) {
            str = this.a.format(Long.valueOf(longValue));
        } else if (1 <= timeInMillis && 604800000 >= timeInMillis) {
            str = this.b.format(Long.valueOf(longValue));
        } else {
            str = this.c.format(Long.valueOf(longValue));
        }
        Intrinsics.checkNotNullExpressionValue(str, "when (timeDiff) {\n      …(valueToFormat)\n        }");
        return m.capitalize(str);
    }
}
