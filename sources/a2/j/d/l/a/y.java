package a2.j.d.l.a;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
public final class y extends i0 {
    public final /* synthetic */ Supplier c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
        super(scheduledExecutorService);
        this.c = supplier;
    }

    @Override // a2.j.d.l.a.h0
    public <T> Callable<T> a(Callable<T> callable) {
        Supplier supplier = this.c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new j(supplier, callable);
    }
}
