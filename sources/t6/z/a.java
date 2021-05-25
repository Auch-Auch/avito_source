package t6.z;

import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlin.time.TimeMark;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@ExperimentalTime
public final class a extends TimeMark {
    @NotNull
    public final TimeMark a;
    public final double b;

    public a(TimeMark timeMark, double d, j jVar) {
        this.a = timeMark;
        this.b = d;
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public double mo439elapsedNowUwyO8pc() {
        return Duration.m468minusLRDsOJo(this.a.mo439elapsedNowUwyO8pc(), this.b);
    }

    @Override // kotlin.time.TimeMark
    @NotNull
    /* renamed from: plus-LRDsOJo */
    public TimeMark mo440plusLRDsOJo(double d) {
        return new a(this.a, Duration.m469plusLRDsOJo(this.b, d), null);
    }
}
