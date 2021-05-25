package a2.a.a.f1.i;

import com.avito.android.in_app_calls.workers.CallAvailabilityUpdaterImpl;
import com.avito.android.util.Logs;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class b<V> implements Callable<Object> {
    public final /* synthetic */ CallAvailabilityUpdaterImpl a;

    public b(CallAvailabilityUpdaterImpl callAvailabilityUpdaterImpl) {
        this.a = callAvailabilityUpdaterImpl;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Logs.debug$default("CallAvailabilityUpdater", "Requested logout from calls", null, 4, null);
        this.a.b.unregister();
        return Unit.INSTANCE;
    }
}
