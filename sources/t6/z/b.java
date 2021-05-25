package t6.z;

import java.util.concurrent.TimeUnit;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
public class b {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void DurationUnit$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double convertDurationUnit(double d, @NotNull TimeUnit timeUnit, @NotNull TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter(timeUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(timeUnit2, "targetUnit");
        long convert = timeUnit2.convert(1, timeUnit);
        if (convert > 0) {
            return d * ((double) convert);
        }
        return d / ((double) timeUnit.convert(1, timeUnit2));
    }
}
