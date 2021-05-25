package a2.a.a.f;

import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.remote.model.AdvertDetails;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
public final class h<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
    public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;
    public final /* synthetic */ AdvertDetails b;
    public final /* synthetic */ String c;

    public h(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetails advertDetails, String str) {
        this.a = advertDetailsToolbarPresenterImpl;
        this.b = advertDetails;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Boolean> apply(Boolean bool) {
        return this.a.g.toggleFavoriteStatus(this.b, this.c).map(new g(bool));
    }
}
