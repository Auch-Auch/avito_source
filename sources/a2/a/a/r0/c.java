package a2.a.a.r0;

import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.legacy_mvp.ErrorMessageView;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<FavoriteAdvertsEvent> {
    public final /* synthetic */ FavoriteAdvertsPresenterImpl a;

    public c(FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl) {
        this.a = favoriteAdvertsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(FavoriteAdvertsEvent favoriteAdvertsEvent) {
        FavoriteAdvertsEvent favoriteAdvertsEvent2 = favoriteAdvertsEvent;
        if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.FavoritesFull) {
            ErrorMessageView errorMessageView = this.a.d;
            if (errorMessageView != null) {
                errorMessageView.showError(this.a.h.getFavoritesFullError());
            }
        } else if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.RemovedFromFavorites) {
            FavoriteAdvertsPresenterImpl.access$changeAdvertsFavorite(this.a, ((FavoriteAdvertsEvent.RemovedFromFavorites) favoriteAdvertsEvent2).getIds(), false);
        } else if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.AddedToFavorites) {
            FavoriteAdvertsPresenterImpl.access$changeAdvertsFavorite(this.a, ((FavoriteAdvertsEvent.AddedToFavorites) favoriteAdvertsEvent2).getIds(), true);
        }
    }
}
