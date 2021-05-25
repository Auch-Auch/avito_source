package a2.j.d.l.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
@CanIgnoreReturnValue
@GwtIncompatible
public abstract class i0 extends h0 implements ScheduledExecutorService {
    public final ScheduledExecutorService b;

    public i0(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.b = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.b;
        Supplier supplier = ((y) this).c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return scheduledExecutorService.schedule(new k(supplier, runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.b;
        Supplier supplier = ((y) this).c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return scheduledExecutorService.scheduleAtFixedRate(new k(supplier, runnable), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.b;
        Supplier supplier = ((y) this).c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return scheduledExecutorService.scheduleWithFixedDelay(new k(supplier, runnable), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.b;
        Supplier supplier = ((y) this).c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return scheduledExecutorService.schedule(new j(supplier, callable), j, timeUnit);
    }
}
