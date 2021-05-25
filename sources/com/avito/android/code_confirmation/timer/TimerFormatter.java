package com.avito.android.code_confirmation.timer;

import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.util.Formatter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/code_confirmation/timer/TimerFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "", "format", "(Ljava/lang/Long;)Ljava/lang/String;", "<init>", "()V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class TimerFormatter implements Formatter<Long> {
    @NotNull
    public String format(@Nullable Long l) {
        return DateTimeFormatter.Companion.convertMillisecondsToTimeString(l != null ? l.longValue() : 0);
    }
}
