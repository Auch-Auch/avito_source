package a2.a.a.n3;

import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
public final class l<T, R> implements Function<T, LoadingState<? super T>> {
    public static final l a = new l();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return new LoadingState.Loaded(obj);
    }
}
