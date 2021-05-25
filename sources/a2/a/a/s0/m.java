package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class m<T> implements Consumer<List<? extends FavoriteSellersItem>> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    public m(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        this.a = favoriteSellersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends FavoriteSellersItem> list) {
        List<? extends FavoriteSellersItem> list2 = list;
        this.a.m = FavoriteSellersPresenterImpl.VisibleContent.SELLERS_LIST;
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        List list3 = favoriteSellersPresenterImpl.i;
        List list4 = list3 != null ? this.a.o(list3) : null;
        if (list4 == null) {
            list4 = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNullExpressionValue(list2, "items");
        favoriteSellersPresenterImpl.i = CollectionsKt___CollectionsKt.plus((Collection) list4, (Iterable) list2);
        this.a.g();
    }
}
