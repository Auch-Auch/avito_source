package a2.a.a.e2.z;

import com.avito.android.remote.model.PretendResult;
import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<PretendResult, MultiStateLoading<? super PretendResult>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultiStateLoading<? super PretendResult> apply(PretendResult pretendResult) {
        PretendResult pretendResult2 = pretendResult;
        Intrinsics.checkNotNullParameter(pretendResult2, "result");
        return new MultiStateLoading.Loaded(pretendResult2);
    }
}
