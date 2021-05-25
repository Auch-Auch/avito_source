package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import t6.z.a;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000e\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0012"}, d2 = {"Lkotlin/time/TimeMark;", "", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()D", "elapsedNow", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "minus-LRDsOJo", "minus", "", "hasPassedNow", "()Z", "hasNotPassedNow", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalTime
public abstract class TimeMark {
    /* renamed from: elapsedNow-UwyO8pc */
    public abstract double mo439elapsedNowUwyO8pc();

    public final boolean hasNotPassedNow() {
        return Duration.m466isNegativeimpl(mo439elapsedNowUwyO8pc());
    }

    public final boolean hasPassedNow() {
        return !Duration.m466isNegativeimpl(mo439elapsedNowUwyO8pc());
    }

    @NotNull
    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public TimeMark m491minusLRDsOJo(double d) {
        return mo440plusLRDsOJo(Duration.m485unaryMinusUwyO8pc(d));
    }

    @NotNull
    /* renamed from: plus-LRDsOJo */
    public TimeMark mo440plusLRDsOJo(double d) {
        return new a(this, d, null);
    }
}
