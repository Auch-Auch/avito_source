package kotlin.time;

import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001:\u0001\nB\u0013\u0012\n\u0010\u000e\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\u000e\u001a\u00060\bj\u0002`\t8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "", "read", "()D", "Lkotlin/time/TimeMark;", "markNow", "()Lkotlin/time/TimeMark;", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/TimeUnit;", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "unit", "<init>", "(Ljava/util/concurrent/TimeUnit;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalTime
public abstract class AbstractDoubleTimeSource implements TimeSource {
    @NotNull
    public final TimeUnit a;

    public static final class a extends TimeMark {
        public final double a;
        public final AbstractDoubleTimeSource b;
        public final double c;

        public a(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, double d2, j jVar) {
            this.a = d;
            this.b = abstractDoubleTimeSource;
            this.c = d2;
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
        public double mo439elapsedNowUwyO8pc() {
            return Duration.m468minusLRDsOJo(DurationKt.toDuration(this.b.read() - this.a, this.b.getUnit()), this.c);
        }

        @Override // kotlin.time.TimeMark
        @NotNull
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public TimeMark mo440plusLRDsOJo(double d) {
            return new a(this.a, this.b, Duration.m469plusLRDsOJo(this.c, d), null);
        }
    }

    public AbstractDoubleTimeSource(@NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        this.a = timeUnit;
    }

    @NotNull
    public final TimeUnit getUnit() {
        return this.a;
    }

    @Override // kotlin.time.TimeSource
    @NotNull
    public TimeMark markNow() {
        return new a(read(), this, Duration.Companion.m489getZEROUwyO8pc(), null);
    }

    public abstract double read();
}
