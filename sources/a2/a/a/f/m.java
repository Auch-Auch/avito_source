package a2.a.a.f;

import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.advert.AdvertDetailsToolbarView;
import com.avito.android.remote.model.AdvertDetails;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class m<T> implements Consumer<Unit> {
    public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;
    public final /* synthetic */ AdvertDetailsToolbarView b;
    public final /* synthetic */ AdvertDetails c;

    public m(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetailsToolbarView advertDetailsToolbarView, AdvertDetails advertDetails) {
        this.a = advertDetailsToolbarPresenterImpl;
        this.b = advertDetailsToolbarView;
        this.c = advertDetails;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.a(this.b, this.c);
    }
}
