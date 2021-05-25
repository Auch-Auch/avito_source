package a2.a.a.e2.w;

import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<MultiStateLoading.Loading, MultiStateLoading.Loading> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultiStateLoading.Loading apply(MultiStateLoading.Loading loading) {
        Intrinsics.checkNotNullParameter(loading, "it");
        return MultiStateLoading.Loading.INSTANCE;
    }
}
