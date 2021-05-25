package com.avito.android.analytics.clickstream;

import com.avito.android.remote.auth.AuthSource;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", "", "", "value", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "formatTime", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/String;", "", "format", "(D)Ljava/lang/String;", "Ljava/text/NumberFormat;", AuthSource.SEND_ABUSE, "Ljava/text/NumberFormat;", "formatter", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class AnalyticMetricsFormatter {
    public final NumberFormat a;

    public AnalyticMetricsFormatter() {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
        Intrinsics.checkNotNullExpressionValue(numberInstance, "NumberFormat.getNumberInstance(Locale.US)");
        this.a = numberInstance;
        numberInstance.setGroupingUsed(false);
        numberInstance.setMinimumFractionDigits(0);
        numberInstance.setMaximumFractionDigits(6);
    }

    @NotNull
    public final String format(double d) {
        String format = this.a.format(d);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(value)");
        return format;
    }

    @NotNull
    public final String formatTime(long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        String format = this.a.format(((double) timeUnit.toMillis(j)) / ((double) 1000));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(timeUni…value) / 1000.toDouble())");
        return format;
    }
}
