package a2.a.a.k2.b.g;

import com.avito.android.remote.model.search.map.PinAdvertsResult;
import com.avito.android.search.map.PinAdverts;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.SellerPinItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<List<? extends ViewTypeSerpItem>, LoadingState.Loaded<PinAdverts>> {
    public final /* synthetic */ l a;
    public final /* synthetic */ PinAdvertsResult b;

    public k(l lVar, PinAdvertsResult pinAdvertsResult) {
        this.a = lVar;
        this.b = pinAdvertsResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState.Loaded<PinAdverts> apply(List<? extends ViewTypeSerpItem> list) {
        List<? extends ViewTypeSerpItem> list2 = list;
        Intrinsics.checkNotNullExpressionValue(list2, "advertsList");
        ArrayList arrayList = new ArrayList();
        for (T t : list2) {
            T t2 = t;
            if ((t2 instanceof AdvertItem) || (t2 instanceof SellerPinItem)) {
                arrayList.add(t);
            }
        }
        return new LoadingState.Loaded<>(new PinAdverts(arrayList, this.a.b, this.b.getNextPage()));
    }
}
