package a2.a.a.c;

import com.avito.android.ab_tests.AbTestsReloadTask;
import com.avito.android.remote.model.ab_tests.AbTestsConfigResponse;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class a<V> implements Callable<Object> {
    public final /* synthetic */ AbTestsReloadTask.a a;
    public final /* synthetic */ AbTestsConfigResponse b;

    public a(AbTestsReloadTask.a aVar, AbTestsConfigResponse abTestsConfigResponse) {
        this.a = aVar;
        this.b = abTestsConfigResponse;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.a.a.c.store(this.b);
        return Unit.INSTANCE;
    }
}
