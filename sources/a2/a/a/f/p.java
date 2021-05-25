package a2.a.a.f;

import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.advert.AdvertDetailsToolbarRouter;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class p<T> implements Consumer<Unit> {
    public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;

    public p(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl) {
        this.a = advertDetailsToolbarPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        AdvertDetailsToolbarRouter advertDetailsToolbarRouter = this.a.b;
        if (advertDetailsToolbarRouter != null) {
            advertDetailsToolbarRouter.closeScreen();
        }
        this.a.handleBackPressed(true);
    }
}
