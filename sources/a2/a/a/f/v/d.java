package a2.a.a.f.v;

import com.avito.android.advert.closed.ClosedAdvertPresenterImpl;
import com.avito.android.advert.closed.ClosedAdvertView;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<FavoriteAdvertsEvent> {
    public final /* synthetic */ ClosedAdvertPresenterImpl a;

    public d(ClosedAdvertPresenterImpl closedAdvertPresenterImpl) {
        this.a = closedAdvertPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(FavoriteAdvertsEvent favoriteAdvertsEvent) {
        if (favoriteAdvertsEvent instanceof FavoriteAdvertsEvent.RemovedFromFavorites) {
            ClosedAdvertView closedAdvertView = this.a.b;
            if (closedAdvertView != null) {
                closedAdvertView.showMessage(this.a.h.getRemovedFromFavorites());
            }
            ClosedAdvertView closedAdvertView2 = this.a.b;
            if (closedAdvertView2 != null) {
                closedAdvertView2.setFavoriteVisible(false);
            }
        }
    }
}
