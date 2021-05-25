package a2.a.a.o2.a;

import com.avito.android.service.short_task.FingerprintCalculationTask;
import com.avito.android.service.short_task.ShortTask;
import java.util.concurrent.Callable;
public final class a<V> implements Callable<ShortTask.Status> {
    public final /* synthetic */ FingerprintCalculationTask a;

    public a(FingerprintCalculationTask fingerprintCalculationTask) {
        this.a = fingerprintCalculationTask;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public ShortTask.Status call() {
        try {
            return FingerprintCalculationTask.access$fingerprintRoutine(this.a);
        } catch (InterruptedException unused) {
            return ShortTask.Status.FAILED;
        }
    }
}
