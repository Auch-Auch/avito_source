package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class b<V> implements Callable<Object> {
    public final /* synthetic */ ParametersListPresenterImpl a;
    public final /* synthetic */ Map b;

    public b(ParametersListPresenterImpl parametersListPresenterImpl, Map map) {
        this.a = parametersListPresenterImpl;
        this.b = map;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        ParametersListPresenterImpl.access$commitDataChange(this.a, new a(this));
        return Unit.INSTANCE;
    }
}
