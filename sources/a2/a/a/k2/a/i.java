package a2.a.a.k2.a;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<Throwable, LoadingState<? super CounterButton>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public i(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super CounterButton> apply(Throwable th) {
        Throwable th2 = th;
        TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.x;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
    }
}
