package com.avito.android.analytics.screens.tracker;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "", "", "value", "", "format", "(Ljava/lang/Double;)Ljava/lang/String;", "result", "formatError", "(Ljava/lang/String;)Ljava/lang/String;", "", PublicConstantsKt.FAILURE, "(Z)Ljava/lang/String;", "", Types.INT, "formatInt$analytics_screens_release", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatInt", "Ljava/text/NumberFormat;", AuthSource.SEND_ABUSE, "Ljava/text/NumberFormat;", "formatter", "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
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

    @Nullable
    public final String format(@Nullable Double d) {
        if (d == null) {
            return null;
        }
        return this.a.format(d.doubleValue());
    }

    @Nullable
    public final String formatError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        if (Intrinsics.areEqual(str, "success")) {
            return null;
        }
        return "unknown";
    }

    @Nullable
    public final String formatError(boolean z) {
        if (z) {
            return "unknown";
        }
        return null;
    }

    @NotNull
    public final String formatInt$analytics_screens_release(@Nullable Integer num) {
        if (num == null || num.intValue() <= 0) {
            return PublicConstantsKt.ETC;
        }
        if (num.intValue() >= 5) {
            return "more";
        }
        return a.H(new Object[]{num}, 1, "%03d", "java.lang.String.format(format, *args)");
    }
}
