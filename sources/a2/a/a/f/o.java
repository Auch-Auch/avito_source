package a2.a.a.f;

import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.remote.model.AdvertDetails;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class o<T> implements Consumer<Unit> {
    public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;
    public final /* synthetic */ AdvertDetails b;

    public o(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetails advertDetails) {
        this.a = advertDetailsToolbarPresenterImpl;
        this.b = advertDetails;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        AdvertDetailsToolbarPresenterImpl.access$onShareClicked(this.a, this.b);
    }
}
