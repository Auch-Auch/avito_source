package a2.a.a.q3.f.q0;

import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<LoadingState<? super AppliedVasResult>, AppliedVasResult> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public AppliedVasResult apply(LoadingState<? super AppliedVasResult> loadingState) {
        LoadingState<? super AppliedVasResult> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "it");
        return (AppliedVasResult) ((LoadingState.Loaded) loadingState2).getData();
    }
}
