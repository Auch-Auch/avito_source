package a2.a.a.s0.h0.a;

import com.avito.android.FavoriteSeller;
import io.reactivex.rxjava3.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import t6.n.q;
import t6.v.e;
public final class g<T, R> implements Function<Set<? extends FavoriteSeller>, Map<String, ? extends FavoriteSeller>> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Map<String, ? extends FavoriteSeller> apply(Set<? extends FavoriteSeller> set) {
        Set<? extends FavoriteSeller> set2 = set;
        Intrinsics.checkNotNullExpressionValue(set2, "it");
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(set2, 10)), 16));
        for (T t : set2) {
            linkedHashMap.put(t.getUserKey(), t);
        }
        return linkedHashMap;
    }
}
