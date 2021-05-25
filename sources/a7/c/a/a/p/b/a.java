package a7.c.a.a.p.b;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.repository.token.NullTokenAndErrorInContainerException;
public final class a<T, R> implements Function<T, ObservableSource<? extends R>> {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        DataContainer dataContainer = (DataContainer) obj;
        Intrinsics.checkParameterIsNotNull(dataContainer, "tokenDataContainer");
        if (dataContainer.getValue() != null) {
            return (Observable) this.a.b.invoke(dataContainer.getValue());
        }
        if (dataContainer.getError() != null) {
            Observable error = Observable.error(dataContainer.getError());
            Intrinsics.checkExpressionValueIsNotNull(error, "Observable.error(tokenDataContainer.error)");
            return error;
        }
        Observable error2 = Observable.error(this.a.a.g.wrap(new NullTokenAndErrorInContainerException()));
        Intrinsics.checkExpressionValueIsNotNull(error2, "Observable.error(\n      …                        )");
        return error2;
    }
}
