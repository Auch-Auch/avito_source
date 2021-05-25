package a2.a.a.s2.c;

import com.avito.android.remote.model.Category;
import com.avito.android.shop.filter.ShopsFilterInteractorImpl;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<List<? extends Category>, List<? extends Category>> {
    public final /* synthetic */ ShopsFilterInteractorImpl a;

    public b(ShopsFilterInteractorImpl shopsFilterInteractorImpl) {
        this.a = shopsFilterInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends Category> apply(List<? extends Category> list) {
        List<? extends Category> list2 = list;
        ShopsFilterInteractorImpl shopsFilterInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        return ShopsFilterInteractorImpl.access$sortCategories(shopsFilterInteractorImpl, list2);
    }
}
