package a2.a.a.h3.a;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class u<T, R> implements Function<LoadingState<? super SuccessResult>, Unit> {
    public static final u a = new u();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Unit apply(LoadingState<? super SuccessResult> loadingState) {
        return Unit.INSTANCE;
    }
}
