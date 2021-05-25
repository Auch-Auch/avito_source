package a2.a.a.f1.i;

import com.avito.android.in_app_calls.workers.CallAvailabilityUpdaterImpl;
import com.avito.android.util.Logs;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class a<V> implements Callable<Object> {
    public final /* synthetic */ CallAvailabilityUpdaterImpl a;
    public final /* synthetic */ String b;

    public a(CallAvailabilityUpdaterImpl callAvailabilityUpdaterImpl, String str) {
        this.a = callAvailabilityUpdaterImpl;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.a.b.register(this.b);
        Logs.debug$default("CallAvailabilityUpdater", "Requested login for calls", null, 4, null);
        return Unit.INSTANCE;
    }
}
