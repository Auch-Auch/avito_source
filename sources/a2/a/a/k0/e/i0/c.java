package a2.a.a.k0.e.i0;

import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t6.n.r;
public final class c<T, R> implements Function<Map<String, ? extends String>, LoadingState<? super Map<String, ? extends String>>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super Map<String, ? extends String>> apply(Map<String, ? extends String> map) {
        Map<String, ? extends String> map2 = map;
        Intrinsics.checkNotNullExpressionValue(map2, "it");
        return new LoadingState.Loaded(r.toMap(map2));
    }
}
