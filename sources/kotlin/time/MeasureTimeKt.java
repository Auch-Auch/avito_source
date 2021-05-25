package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0007\u001a:\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\bø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\u000b\u001a>\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\b*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\bø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\f\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"Lkotlin/Function0;", "", "block", "Lkotlin/time/Duration;", "measureTime", "(Lkotlin/jvm/functions/Function0;)D", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)D", "T", "Lkotlin/time/TimedValue;", "measureTimedValue", "(Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class MeasureTimeKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeMark markNow = TimeSource.Monotonic.INSTANCE.markNow();
        function0.invoke();
        return markNow.mo439elapsedNowUwyO8pc();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return new TimedValue<>(function0.invoke(), TimeSource.Monotonic.INSTANCE.markNow().mo439elapsedNowUwyO8pc(), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(@NotNull TimeSource timeSource, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(timeSource, "$this$measureTime");
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeMark markNow = timeSource.markNow();
        function0.invoke();
        return markNow.mo439elapsedNowUwyO8pc();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(@NotNull TimeSource timeSource, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(timeSource, "$this$measureTimedValue");
        Intrinsics.checkNotNullParameter(function0, "block");
        return new TimedValue<>(function0.invoke(), timeSource.markNow().mo439elapsedNowUwyO8pc(), null);
    }
}
