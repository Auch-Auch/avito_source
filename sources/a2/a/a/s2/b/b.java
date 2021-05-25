package a2.a.a.s2.b;

import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<TypedResult<T>, ObservableSource<? extends T>> {
    public static final b a = new b();

    @Override // io.reactivex.rxjava3.functions.Function
    public Object apply(Object obj) {
        TypedResult typedResult = (TypedResult) obj;
        if (typedResult instanceof TypedResult.OfResult) {
            Observable just = Observable.just(((TypedResult.OfResult) typedResult).getResult());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        } else if (typedResult instanceof TypedResult.OfError) {
            TypedResult.OfError ofError = (TypedResult.OfError) typedResult;
            if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                return Observable.error(new IOException(ofError.getError().getMessage()));
            }
            return Observable.error(new RuntimeException(ofError.getError().getMessage()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
