package com.avito.android.date_time_formatter;

import a2.b.a.a.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "", "", "time", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "format", "(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Ljava/lang/String;", "Companion", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface DateTimeFormatter {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/date_time_formatter/DateTimeFormatter$Companion;", "", "", "period", "", "convertMillisecondsToTimeString", "(J)Ljava/lang/String;", "<init>", "()V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final String convertMillisecondsToTimeString(long j) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long hours = timeUnit.toHours(j);
            if (hours > 0) {
                long minutes = timeUnit.toMinutes(j);
                TimeUnit timeUnit2 = TimeUnit.HOURS;
                long minutes2 = minutes - timeUnit2.toMinutes(hours);
                return a.H(new Object[]{Long.valueOf(hours), Long.valueOf(minutes2), Long.valueOf((timeUnit.toSeconds(j) - timeUnit2.toSeconds(hours)) - TimeUnit.MINUTES.toSeconds(minutes2))}, 3, "%02d:%02d:%02d", "java.lang.String.format(format, *args)");
            }
            long minutes3 = timeUnit.toMinutes(j);
            return a.H(new Object[]{Long.valueOf(minutes3), Long.valueOf(timeUnit.toSeconds(j) - TimeUnit.MINUTES.toSeconds(minutes3))}, 2, "%02d:%02d", "java.lang.String.format(format, *args)");
        }
    }

    @NotNull
    String format(@Nullable Long l, @NotNull TimeUnit timeUnit);
}
