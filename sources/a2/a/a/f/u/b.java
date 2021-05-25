package a2.a.a.f.u;

import com.avito.android.advert.badge_details.BadgeDetailsPresenter;
import com.avito.android.advert.badge_details.BadgeDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ BadgeDetailsPresenterImpl a;

    public b(BadgeDetailsPresenterImpl badgeDetailsPresenterImpl) {
        this.a = badgeDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        BadgeDetailsPresenter.Router router = this.a.d;
        if (router != null) {
            router.closeWithError(this.a.k.getErrorText());
        }
    }
}
