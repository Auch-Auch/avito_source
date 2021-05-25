package t6.v;

import com.avito.android.lib.design.input.FormatterType;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
public class d {
    public static final void checkStepIsPositive(boolean z, @NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, AnalyticFieldsName.step);
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + FormatterType.defaultDecimalSeparator);
        }
    }

    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "$this$rangeTo");
        Intrinsics.checkNotNullParameter(t2, "that");
        return new c(t, t2);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Double> rangeTo(double d, double d2) {
        return new a(d, d2);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Float> rangeTo(float f, float f2) {
        return new b(f, f2);
    }
}
