package com.avito.android.date_time_formatter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;", "", "", "time", "", "case", "todayAtTime", "(Ljava/lang/String;I)Ljava/lang/String;", "yesterdayAtTime", "day", "dateAtTime", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "year", "dateAtYear", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface DateTimeFormatterResourceProvider {
    @NotNull
    String dateAtTime(@NotNull String str, @NotNull String str2);

    @NotNull
    String dateAtYear(@NotNull String str, @NotNull String str2);

    @NotNull
    String todayAtTime(@NotNull String str, int i);

    @NotNull
    String yesterdayAtTime(@NotNull String str, int i);
}
