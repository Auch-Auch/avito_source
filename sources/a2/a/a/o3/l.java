package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class l<T> implements Consumer<Unit> {
    public final /* synthetic */ ParametersListPresenterImpl a;

    public l(ParametersListPresenterImpl parametersListPresenterImpl) {
        this.a = parametersListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.d.accept(Unit.INSTANCE);
        ParametersListPresenterImpl.access$commitDataChange(this.a, new k(this));
        ParametersListPresenterImpl.access$subscribeToItemEvents(this.a);
    }
}
