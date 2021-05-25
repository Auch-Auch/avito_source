package com.avito.android.lib.design.ticking_button;

import a2.b.a.a.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/ticking_button/DefaultTickingTimeFormatter;", "Lcom/avito/android/lib/design/ticking_button/TickingTimeFormatter;", "", "timeSeconds", "", "formatSeconds", "(J)Ljava/lang/String;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultTickingTimeFormatter implements TickingTimeFormatter {
    @Override // com.avito.android.lib.design.ticking_button.TickingTimeFormatter
    @NotNull
    public String formatSeconds(long j) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j);
        if (hours > 0) {
            long minutes = timeUnit.toMinutes(j);
            TimeUnit timeUnit2 = TimeUnit.HOURS;
            long minutes2 = minutes - timeUnit2.toMinutes(hours);
            return a.H(new Object[]{Long.valueOf(hours), Long.valueOf(minutes2), Long.valueOf((j - timeUnit2.toSeconds(hours)) - TimeUnit.MINUTES.toSeconds(minutes2))}, 3, "%01d:%02d:%02d", "java.lang.String.format(format, *args)");
        }
        long minutes3 = timeUnit.toMinutes(j);
        return a.H(new Object[]{Long.valueOf(minutes3), Long.valueOf(j - TimeUnit.MINUTES.toSeconds(minutes3))}, 2, "%01d:%02d", "java.lang.String.format(format, *args)");
    }
}
