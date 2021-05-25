package a2.a.a.q3.f.q0;

import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Predicate<LoadingState<? super AppliedVasResult>> {
    public static final f a = new f();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(LoadingState<? super AppliedVasResult> loadingState) {
        LoadingState<? super AppliedVasResult> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "it");
        return loadingState2 instanceof LoadingState.Loaded;
    }
}
