package a2.a.a.r.b.a;

import com.avito.conveyor_item.Item;
import io.reactivex.functions.BiFunction;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class b<T1, T2, R> implements BiFunction<List<? extends Item>, List<? extends Item>, List<? extends Item>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiFunction
    public List<? extends Item> apply(List<? extends Item> list, List<? extends Item> list2) {
        List<? extends Item> list3 = list;
        List<? extends Item> list4 = list2;
        Intrinsics.checkNotNullParameter(list3, "fees");
        Intrinsics.checkNotNullParameter(list4, "vas");
        return CollectionsKt___CollectionsKt.plus((Collection) list3, (Iterable) list4);
    }
}
