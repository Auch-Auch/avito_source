package a2.a.a.t3;

import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.viewed_items.ViewedItemsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<FavoriteAdvertsEvent> {
    public final /* synthetic */ ViewedItemsPresenterImpl a;

    public d(ViewedItemsPresenterImpl viewedItemsPresenterImpl) {
        this.a = viewedItemsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(FavoriteAdvertsEvent favoriteAdvertsEvent) {
        FavoriteAdvertsEvent favoriteAdvertsEvent2 = favoriteAdvertsEvent;
        if (!(favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.FavoritesFull)) {
            if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.RemovedFromFavorites) {
                ViewedItemsPresenterImpl.access$changeAdvertsFavorite(this.a, ((FavoriteAdvertsEvent.RemovedFromFavorites) favoriteAdvertsEvent2).getIds(), false);
            } else if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.AddedToFavorites) {
                ViewedItemsPresenterImpl.access$changeAdvertsFavorite(this.a, ((FavoriteAdvertsEvent.AddedToFavorites) favoriteAdvertsEvent2).getIds(), true);
            }
        }
    }
}
