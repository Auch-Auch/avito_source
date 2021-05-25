package a2.a.a.f.x;

import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class i<T> implements Consumer<Throwable> {
    public final /* synthetic */ AdvertDetailsPresenterImpl a;

    public i(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
        this.a = advertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.S.trackComplementaryLoadError();
    }
}
