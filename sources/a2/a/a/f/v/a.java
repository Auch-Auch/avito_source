package a2.a.a.f.v;

import com.avito.android.advert.closed.ClosedAdvertPresenterImpl;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class a<T, R> implements Function<Unit, SingleSource<? extends Unit>> {
    public final /* synthetic */ ClosedAdvertPresenterImpl a;

    public a(ClosedAdvertPresenterImpl closedAdvertPresenterImpl) {
        this.a = closedAdvertPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Unit> apply(Unit unit) {
        return AdvertDetailsFavoriteInteractor.DefaultImpls.removeFromFavorites$default(this.a.e, this.a.d, null, false, 4, null);
    }
}
