package a2.a.a.e2.r;

import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<Map<String, ? extends String>, Iterable<? extends Map.Entry<? extends String, ? extends String>>> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Iterable<? extends Map.Entry<? extends String, ? extends String>> apply(Map<String, ? extends String> map) {
        Map<String, ? extends String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "it");
        return map2.entrySet();
    }
}
