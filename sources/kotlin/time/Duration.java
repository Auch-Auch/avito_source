package kotlin.time;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.v.e;
import t6.z.b;
import t6.z.c;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b&\b@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0000\u0012\u0006\u0010c\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\bu\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0000H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007J\u001e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u000eJ\u001e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001b\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007J\r\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u0016J\u001b\u0010 \u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0001\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!2u\u0010*\u001aq\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u00000\"H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b+\u0010,J\u0001\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!2`\u0010*\u001a\\\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u00000.H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b+\u0010/Js\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b+\u00101J^\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!26\u0010*\u001a2\u0012\u0013\u0012\u001103¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u000002H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b+\u00104J\u0019\u0010:\u001a\u00020\u00102\n\u00107\u001a\u000605j\u0002`6¢\u0006\u0004\b8\u00109J\u0019\u0010=\u001a\u0002032\n\u00107\u001a\u000605j\u0002`6¢\u0006\u0004\b;\u0010<J\u0019\u0010@\u001a\u00020\u000b2\n\u00107\u001a\u000605j\u0002`6¢\u0006\u0004\b>\u0010?J\r\u0010C\u001a\u000203¢\u0006\u0004\bA\u0010BJ\r\u0010E\u001a\u000203¢\u0006\u0004\bD\u0010BJ\u000f\u0010I\u001a\u00020FH\u0016¢\u0006\u0004\bG\u0010HJ#\u0010I\u001a\u00020F2\n\u00107\u001a\u000605j\u0002`62\b\b\u0002\u0010J\u001a\u00020\u000b¢\u0006\u0004\bG\u0010KJ\r\u0010M\u001a\u00020F¢\u0006\u0004\bL\u0010HJ\u0010\u0010P\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bN\u0010OJ\u001a\u0010T\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010QHÖ\u0003¢\u0006\u0004\bR\u0010SR\u0013\u0010V\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bU\u0010\u0003R\u0013\u0010X\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010\u0003R\u0013\u0010Z\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bY\u0010\u0003R\u0013\u0010\\\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b[\u0010\u0003R\u0013\u0010^\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b]\u0010\u0003R\u0013\u0010`\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b_\u0010\u0003R\u0016\u0010c\u001a\u00020\u00108\u0000@\u0000X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0019\u0010e\u001a\u00020\u00008F@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bd\u0010\u0003R\u001c\u0010i\u001a\u00020\u000b8@@\u0001X\u0004¢\u0006\f\u0012\u0004\bg\u0010h\u001a\u0004\bf\u0010OR\u001c\u0010l\u001a\u00020\u000b8@@\u0001X\u0004¢\u0006\f\u0012\u0004\bk\u0010h\u001a\u0004\bj\u0010OR\u001c\u0010o\u001a\u00020\u000b8@@\u0001X\u0004¢\u0006\f\u0012\u0004\bn\u0010h\u001a\u0004\bm\u0010OR\u001c\u0010r\u001a\u00020\u000b8@@\u0001X\u0004¢\u0006\f\u0012\u0004\bq\u0010h\u001a\u0004\bp\u0010OR\u0013\u0010t\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bs\u0010\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b20\u0001¨\u0006w"}, d2 = {"Lkotlin/time/Duration;", "", "unaryMinus-UwyO8pc", "(D)D", "unaryMinus", "other", "plus-LRDsOJo", "(DD)D", "plus", "minus-LRDsOJo", "minus", "", "scale", "times-UwyO8pc", "(DI)D", "times", "", "div-UwyO8pc", "div", "div-LRDsOJo", "", "isNegative-impl", "(D)Z", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "compareTo-LRDsOJo", "(DD)I", "compareTo", "T", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toDouble", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLong", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toInt", "toLongNanoseconds-impl", "(D)J", "toLongNanoseconds", "toLongMilliseconds-impl", "toLongMilliseconds", "", "toString-impl", "(D)Ljava/lang/String;", "toString", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "toIsoString-impl", "toIsoString", "hashCode-impl", "(D)I", "hashCode", "", "equals-impl", "(DLjava/lang/Object;)Z", "equals", "getInHours-impl", "inHours", "getInNanoseconds-impl", "inNanoseconds", "getInMinutes-impl", "inMinutes", "getInSeconds-impl", "inSeconds", "getInMilliseconds-impl", "inMilliseconds", "getInMicroseconds-impl", "inMicroseconds", AuthSource.SEND_ABUSE, "D", "value", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "()V", "nanosecondsComponent", "getHoursComponent-impl", "getHoursComponent$annotations", "hoursComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getInDays-impl", "inDays", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalTime
public final class Duration implements Comparable<Duration> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final double b = m445constructorimpl(0.0d);
    public static final double c = m445constructorimpl(Double.POSITIVE_INFINITY);
    public final double a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u000b\u001a\u00020\n8\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u00020\n8\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "", "value", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "(DLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)D", "Lkotlin/time/Duration;", "INFINITE", "D", "getINFINITE-UwyO8pc", "()D", "ZERO", "getZERO-UwyO8pc", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public final double convert(double d, @NotNull TimeUnit timeUnit, @NotNull TimeUnit timeUnit2) {
            Intrinsics.checkNotNullParameter(timeUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(timeUnit2, "targetUnit");
            return b.convertDurationUnit(d, timeUnit, timeUnit2);
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final double m488getINFINITEUwyO8pc() {
            return Duration.c;
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final double m489getZEROUwyO8pc() {
            return Duration.b;
        }

        public Companion(j jVar) {
        }
    }

    public /* synthetic */ Duration(double d) {
        this.a = d;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m443boximpl(double d) {
        return new Duration(d);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static double m445constructorimpl(double d) {
        return d;
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m446divLRDsOJo(double d, double d2) {
        return d / d2;
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final double m448divUwyO8pc(double d, int i) {
        return m445constructorimpl(d / ((double) i));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m449equalsimpl(double d, Object obj) {
        return (obj instanceof Duration) && Double.compare(d, ((Duration) obj).m487unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m450equalsimpl0(double d, double d2) {
        return Double.compare(d, d2) == 0;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final double m451getAbsoluteValueUwyO8pc(double d) {
        return m466isNegativeimpl(d) ? m485unaryMinusUwyO8pc(d) : d;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m452getHoursComponentimpl(double d) {
        return (int) (m454getInHoursimpl(d) % ((double) 24));
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m453getInDaysimpl(double d) {
        return m476toDoubleimpl(d, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m454getInHoursimpl(double d) {
        return m476toDoubleimpl(d, TimeUnit.HOURS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m455getInMicrosecondsimpl(double d) {
        return m476toDoubleimpl(d, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m456getInMillisecondsimpl(double d) {
        return m476toDoubleimpl(d, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m457getInMinutesimpl(double d) {
        return m476toDoubleimpl(d, TimeUnit.MINUTES);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m458getInNanosecondsimpl(double d) {
        return m476toDoubleimpl(d, TimeUnit.NANOSECONDS);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m459getInSecondsimpl(double d) {
        return m476toDoubleimpl(d, TimeUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m460getMinutesComponentimpl(double d) {
        return (int) (m457getInMinutesimpl(d) % ((double) 60));
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m461getNanosecondsComponentimpl(double d) {
        return (int) (m458getInNanosecondsimpl(d) % 1.0E9d);
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m462getSecondsComponentimpl(double d) {
        return (int) (m459getInSecondsimpl(d) % ((double) 60));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m463hashCodeimpl(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m464isFiniteimpl(double d) {
        return !Double.isInfinite(d) && !Double.isNaN(d);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m465isInfiniteimpl(double d) {
        return Double.isInfinite(d);
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m466isNegativeimpl(double d) {
        return d < ((double) 0);
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m467isPositiveimpl(double d) {
        return d > ((double) 0);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final double m468minusLRDsOJo(double d, double d2) {
        return m445constructorimpl(d - d2);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final double m469plusLRDsOJo(double d, double d2) {
        return m445constructorimpl(d + d2);
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final double m471timesUwyO8pc(double d, int i) {
        return m445constructorimpl(d * ((double) i));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m475toComponentsimpl(double d, @NotNull Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, "action");
        return (T) function5.invoke(Integer.valueOf((int) m453getInDaysimpl(d)), Integer.valueOf(m452getHoursComponentimpl(d)), Integer.valueOf(m460getMinutesComponentimpl(d)), Integer.valueOf(m462getSecondsComponentimpl(d)), Integer.valueOf(m461getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m476toDoubleimpl(double d, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return b.convertDurationUnit(d, DurationKt.access$getStorageUnit$p(), timeUnit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m477toIntimpl(double d, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return (int) m476toDoubleimpl(d, timeUnit);
    }

    @NotNull
    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m478toIsoStringimpl(double d) {
        StringBuilder sb = new StringBuilder();
        if (m466isNegativeimpl(d)) {
            sb.append('-');
        }
        sb.append("PT");
        double r7 = m451getAbsoluteValueUwyO8pc(d);
        int r1 = (int) m454getInHoursimpl(r7);
        int r2 = m460getMinutesComponentimpl(r7);
        int r3 = m462getSecondsComponentimpl(r7);
        int r72 = m461getNanosecondsComponentimpl(r7);
        boolean z = true;
        boolean z2 = r1 != 0;
        boolean z3 = (r3 == 0 && r72 == 0) ? false : true;
        if (r2 == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(r1);
            sb.append('H');
        }
        if (z) {
            sb.append(r2);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(r3);
            if (r72 != 0) {
                sb.append(FormatterType.defaultDecimalSeparator);
                String padStart = StringsKt__StringsKt.padStart(String.valueOf(r72), 9, '0');
                if (r72 % 1000000 == 0) {
                    sb.append((CharSequence) padStart, 0, 3);
                    Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                } else if (r72 % 1000 == 0) {
                    sb.append((CharSequence) padStart, 0, 6);
                    Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                } else {
                    sb.append(padStart);
                }
            }
            sb.append('S');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m479toLongimpl(double d, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return (long) m476toDoubleimpl(d, timeUnit);
    }

    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m480toLongMillisecondsimpl(double d) {
        return m479toLongimpl(d, TimeUnit.MILLISECONDS);
    }

    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m481toLongNanosecondsimpl(double d) {
        return m479toLongimpl(d, TimeUnit.NANOSECONDS);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    @org.jetbrains.annotations.NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m482toStringimpl(double r9) {
        /*
            boolean r0 = m465isInfiniteimpl(r9)
            if (r0 == 0) goto L_0x000c
            java.lang.String r9 = java.lang.String.valueOf(r9)
            goto L_0x00d5
        L_0x000c:
            r0 = 0
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0016
            java.lang.String r9 = "0s"
            goto L_0x00d5
        L_0x0016:
            double r0 = m451getAbsoluteValueUwyO8pc(r9)
            double r0 = m458getInNanosecondsimpl(r0)
            r2 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x002e
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
        L_0x002b:
            r1 = 0
            r2 = 1
            goto L_0x0090
        L_0x002e:
            double r2 = (double) r5
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0038
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1 = 7
        L_0x0036:
            r2 = 0
            goto L_0x0090
        L_0x0038:
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0045
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
        L_0x0043:
            r1 = 0
            goto L_0x0036
        L_0x0045:
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0051
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MICROSECONDS
            goto L_0x0043
        L_0x0051:
            r2 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x005d
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            goto L_0x0043
        L_0x005d:
            r2 = 4786511204640096256(0x426d1a94a2000000, double:1.0E12)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0069
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            goto L_0x0043
        L_0x0069:
            r2 = 4813020802404319232(0x42cb48eb57e00000, double:6.0E13)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0075
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MINUTES
            goto L_0x0043
        L_0x0075:
            r2 = 4839562400168542208(0x4329945ca2620000, double:3.6E15)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0081
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.HOURS
            goto L_0x0043
        L_0x0081:
            r2 = 4920018990336211136(0x44476b344f2a78c0, double:8.64E20)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x008d
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L_0x0043
        L_0x008d:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L_0x002b
        L_0x0090:
            double r9 = m476toDoubleimpl(r9, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            if (r2 == 0) goto L_0x00a0
            java.lang.String r9 = kotlin.time.FormatToDecimalsKt.formatScientific(r9)
            goto L_0x00c7
        L_0x00a0:
            if (r1 <= 0) goto L_0x00a7
            java.lang.String r9 = kotlin.time.FormatToDecimalsKt.formatUpToDecimals(r9, r1)
            goto L_0x00c7
        L_0x00a7:
            double r1 = java.lang.Math.abs(r9)
            double r6 = (double) r5
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b2
            r4 = 3
            goto L_0x00c3
        L_0x00b2:
            r6 = 10
            double r6 = (double) r6
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x00bb
            r4 = 2
            goto L_0x00c3
        L_0x00bb:
            r6 = 100
            double r6 = (double) r6
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x00c3
            r4 = 1
        L_0x00c3:
            java.lang.String r9 = kotlin.time.FormatToDecimalsKt.formatToExactDecimals(r9, r4)
        L_0x00c7:
            r3.append(r9)
            java.lang.String r9 = t6.z.c.shortName(r0)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
        L_0x00d5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.Duration.m482toStringimpl(double):java.lang.String");
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m484toStringimpl$default(double d, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m483toStringimpl(d, timeUnit, i);
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final double m485unaryMinusUwyO8pc(double d) {
        return m445constructorimpl(-d);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m486compareToLRDsOJo(duration.m487unboximpl());
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m486compareToLRDsOJo(double d) {
        return m444compareToLRDsOJo(this.a, d);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return m449equalsimpl(this.a, obj);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m463hashCodeimpl(this.a);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return m482toStringimpl(this.a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ double m487unboximpl() {
        return this.a;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m444compareToLRDsOJo(double d, double d2) {
        return Double.compare(d, d2);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final double m447divUwyO8pc(double d, double d2) {
        return m445constructorimpl(d / d2);
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final double m470timesUwyO8pc(double d, double d2) {
        return m445constructorimpl(d * d2);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m474toComponentsimpl(double d, @NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, "action");
        return (T) function4.invoke(Integer.valueOf((int) m454getInHoursimpl(d)), Integer.valueOf(m460getMinutesComponentimpl(d)), Integer.valueOf(m462getSecondsComponentimpl(d)), Integer.valueOf(m461getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m473toComponentsimpl(double d, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, "action");
        return (T) function3.invoke(Integer.valueOf((int) m457getInMinutesimpl(d)), Integer.valueOf(m462getSecondsComponentimpl(d)), Integer.valueOf(m461getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m472toComponentsimpl(double d, @NotNull Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return (T) function2.invoke(Long.valueOf((long) m459getInSecondsimpl(d)), Integer.valueOf(m461getNanosecondsComponentimpl(d)));
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m483toStringimpl(double d, @NotNull TimeUnit timeUnit, int i) {
        String str;
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a.M2("decimals must be not negative, but was ", i).toString());
        } else if (m465isInfiniteimpl(d)) {
            return String.valueOf(d);
        } else {
            double r62 = m476toDoubleimpl(d, timeUnit);
            StringBuilder sb = new StringBuilder();
            if (Math.abs(r62) < 1.0E14d) {
                str = FormatToDecimalsKt.formatToExactDecimals(r62, e.coerceAtMost(i, 12));
            } else {
                str = FormatToDecimalsKt.formatScientific(r62);
            }
            sb.append(str);
            sb.append(c.shortName(timeUnit));
            return sb.toString();
        }
    }
}
