package a2.j.d.l.a;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;
public final class z extends RateLimiter.a {
    public final Stopwatch a = Stopwatch.createStarted();

    @Override // com.google.common.util.concurrent.RateLimiter.a
    public long a() {
        return this.a.elapsed(TimeUnit.MICROSECONDS);
    }

    @Override // com.google.common.util.concurrent.RateLimiter.a
    public void b(long j) {
        if (j > 0) {
            Uninterruptibles.sleepUninterruptibly(j, TimeUnit.MICROSECONDS);
        }
    }
}
