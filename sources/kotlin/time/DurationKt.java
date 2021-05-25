package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.z.b;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001d\u001a\"\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0005\u001a\u00020\u0004*\u00020\u00072\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\b\u001a\"\u0010\u0005\u001a\u00020\u0004*\u00020\t2\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\n\"#\u0010\u000f\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\"#\u0010\u0014\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\"#\u0010\u000f\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\r\u0010\u0013\u001a\u0004\b\u000b\u0010\u0011\"#\u0010\u0017\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0015\u0010\f\"#\u0010\u001a\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0018\u0010\u0011\"#\u0010\u001d\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001b\u0010\f\"#\u0010\u001d\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001b\u0010\u0011\"#\u0010 \u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001e\u0010\u0011\"#\u0010%\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\"#\u0010\u001d\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010$\u001a\u0004\b\u001b\u0010\"\"#\u0010\u0014\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\f\"#\u0010%\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\u000e\u001a\u0004\b!\u0010\f\"#\u0010 \u001a\u00020\u0004*\u00020\t8F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010$\u001a\u0004\b\u001e\u0010\"\"#\u0010\u001a\u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0018\u0010\f\"#\u0010\u000f\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\r\u0010$\u001a\u0004\b\u000b\u0010\"\"#\u0010 \u001a\u00020\u0004*\u00020\u00008F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001e\u0010\f\"#\u0010\u001a\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010$\u001a\u0004\b\u0018\u0010\"\"#\u0010\u0017\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0016\u0010$\u001a\u0004\b\u0015\u0010\"\"#\u0010%\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\u0011\"#\u0010\u0017\u001a\u00020\u0004*\u00020\u00078F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011\"#\u0010\u0014\u001a\u00020\u0004*\u00020\t8F@\u0007X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010$\u001a\u0004\b\u0010\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "toDuration", "(ILjava/util/concurrent/TimeUnit;)D", "", "(JLjava/util/concurrent/TimeUnit;)D", "", "(DLjava/util/concurrent/TimeUnit;)D", "getDays", "(I)D", "getDays$annotations", "(I)V", "days", "getMinutes", "(J)D", "getMinutes$annotations", "(J)V", "minutes", "getSeconds", "getSeconds$annotations", "seconds", "getMilliseconds", "getMilliseconds$annotations", "milliseconds", "getMicroseconds", "getMicroseconds$annotations", "microseconds", "getNanoseconds", "getNanoseconds$annotations", "nanoseconds", "getHours", "(D)D", "getHours$annotations", "(D)V", "hours", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class DurationKt {
    public static final TimeUnit access$getStorageUnit$p() {
        return TimeUnit.NANOSECONDS;
    }

    public static final double getDays(int i) {
        return toDuration(i, TimeUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static final double getHours(int i) {
        return toDuration(i, TimeUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static final double getMicroseconds(int i) {
        return toDuration(i, TimeUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static final double getMilliseconds(int i) {
        return toDuration(i, TimeUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static final double getMinutes(int i) {
        return toDuration(i, TimeUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static final double getNanoseconds(int i) {
        return toDuration(i, TimeUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static final double getSeconds(int i) {
        return toDuration(i, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(int i, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return toDuration((double) i, timeUnit);
    }

    public static final double getDays(long j) {
        return toDuration(j, TimeUnit.DAYS);
    }

    public static final double getHours(long j) {
        return toDuration(j, TimeUnit.HOURS);
    }

    public static final double getMicroseconds(long j) {
        return toDuration(j, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(long j) {
        return toDuration(j, TimeUnit.MILLISECONDS);
    }

    public static final double getMinutes(long j) {
        return toDuration(j, TimeUnit.MINUTES);
    }

    public static final double getNanoseconds(long j) {
        return toDuration(j, TimeUnit.NANOSECONDS);
    }

    public static final double getSeconds(long j) {
        return toDuration(j, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return toDuration((double) j, timeUnit);
    }

    public static final double getDays(double d) {
        return toDuration(d, TimeUnit.DAYS);
    }

    public static final double getHours(double d) {
        return toDuration(d, TimeUnit.HOURS);
    }

    public static final double getMicroseconds(double d) {
        return toDuration(d, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(double d) {
        return toDuration(d, TimeUnit.MILLISECONDS);
    }

    public static final double getMinutes(double d) {
        return toDuration(d, TimeUnit.MINUTES);
    }

    public static final double getNanoseconds(double d) {
        return toDuration(d, TimeUnit.NANOSECONDS);
    }

    public static final double getSeconds(double d) {
        return toDuration(d, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(double d, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return Duration.m445constructorimpl(b.convertDurationUnit(d, timeUnit, TimeUnit.NANOSECONDS));
    }
}
