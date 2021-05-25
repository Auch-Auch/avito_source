package a2.a.a.f;

import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.advert.AdvertDetailsToolbarView;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.remote.model.AdvertDetails;
import io.reactivex.rxjava3.functions.Consumer;
public final class k<T> implements Consumer<FavoriteAdvertsEvent> {
    public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;
    public final /* synthetic */ AdvertDetailsToolbarView b;
    public final /* synthetic */ AdvertDetails c;

    public k(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetailsToolbarView advertDetailsToolbarView, AdvertDetails advertDetails) {
        this.a = advertDetailsToolbarPresenterImpl;
        this.b = advertDetailsToolbarView;
        this.c = advertDetails;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(FavoriteAdvertsEvent favoriteAdvertsEvent) {
        FavoriteAdvertsEvent favoriteAdvertsEvent2 = favoriteAdvertsEvent;
        if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.AddedToFavorites) {
            if (!this.c.isFavorite()) {
                this.c.setFavorite(true);
                this.b.showMessage(this.a.k.getAddedToFavorites());
            }
        } else if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.RemovedFromFavorites) {
            this.c.setFavorite(false);
            this.b.showMessage(this.a.k.getRemovedFromFavorites());
        } else if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.FavoritesFull) {
            this.b.showMessage(this.a.k.getFavoritesFull());
            this.a.a(this.b, this.c);
        }
    }
}
