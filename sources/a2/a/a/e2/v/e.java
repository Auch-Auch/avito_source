package a2.a.a.e2.v;

import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<a, MultiStateLoading.Loaded<a>> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultiStateLoading.Loaded<a> apply(a aVar) {
        a aVar2 = aVar;
        Intrinsics.checkNotNullParameter(aVar2, "it");
        return new MultiStateLoading.Loaded<>(aVar2);
    }
}
