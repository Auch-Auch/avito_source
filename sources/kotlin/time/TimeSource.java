package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/time/TimeSource;", "", "Lkotlin/time/TimeMark;", "markNow", "()Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalTime
public interface TimeSource {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "", "toString", "()Ljava/lang/String;", "Lkotlin/time/TimeMark;", "markNow", "()Lkotlin/time/TimeMark;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Monotonic implements TimeSource {
        @NotNull
        public static final Monotonic INSTANCE = new Monotonic();
        public final /* synthetic */ MonotonicTimeSource a = MonotonicTimeSource.INSTANCE;

        @Override // kotlin.time.TimeSource
        @NotNull
        public TimeMark markNow() {
            return this.a.markNow();
        }

        @NotNull
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }

    @NotNull
    TimeMark markNow();
}
