package a2.a.a.h3.a;

import com.avito.android.util.ActionMenu;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Predicate<List<? extends ActionMenu>> {
    public static final l a = new l();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(List<? extends ActionMenu> list) {
        List<? extends ActionMenu> list2 = list;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        return !list2.isEmpty();
    }
}
