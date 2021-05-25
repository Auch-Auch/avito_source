package a2.a.a.f.x;

import com.avito.android.FavoriteSeller;
import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
public final class m<T> implements Consumer<Set<? extends FavoriteSeller>> {
    public final /* synthetic */ AdvertDetailsPresenterImpl a;

    public m(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
        this.a = advertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Set<? extends FavoriteSeller> set) {
        Set<? extends FavoriteSeller> set2 = set;
        AdvertDetailsPresenterImpl advertDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(set2, "map");
        AdvertDetailsPresenterImpl.access$updateFavoriteSellersState(advertDetailsPresenterImpl, set2, this.a.z.getSimilars());
    }
}
