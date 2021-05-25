package a2.a.a.f;

import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.advert.AdvertDetailsToolbarView;
import io.reactivex.rxjava3.functions.Consumer;
public final class j<T> implements Consumer<Throwable> {
    public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;
    public final /* synthetic */ AdvertDetailsToolbarView b;

    public j(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetailsToolbarView advertDetailsToolbarView) {
        this.a = advertDetailsToolbarPresenterImpl;
        this.b = advertDetailsToolbarView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        AdvertDetailsToolbarPresenterImpl.access$showError(this.a, this.b, th);
    }
}
