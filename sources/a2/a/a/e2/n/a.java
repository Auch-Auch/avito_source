package a2.a.a.e2.n;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Pair<? extends List<? extends Item>, ? extends List<? extends Item>>, List<ParameterElement.Select>> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<ParameterElement.Select> apply(Pair<? extends List<? extends Item>, ? extends List<? extends Item>> pair) {
        String str;
        T t;
        Pair<? extends List<? extends Item>, ? extends List<? extends Item>> pair2 = pair;
        Intrinsics.checkNotNullParameter(pair2, "it");
        List list = (List) pair2.getFirst();
        List list2 = (List) pair2.getSecond();
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(list2, "now");
        for (T t2 : list2) {
            Objects.requireNonNull(t2, "null cannot be cast to non-null type com.avito.android.category_parameters.ParameterElement.Select");
            T t3 = t2;
            Intrinsics.checkNotNullExpressionValue(list, "was");
            Iterator<T> it = list.iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getStringId(), t2.getStringId())) {
                    break;
                }
            }
            T t4 = t;
            String value = t3.getValue();
            if (t4 != null) {
                str = t4.getValue();
            }
            if (!Intrinsics.areEqual(value, str)) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }
}
