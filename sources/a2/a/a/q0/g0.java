package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import io.reactivex.rxjava3.functions.Consumer;
public final class g0<T> implements Consumer<FavoriteAdvertsEvent> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public g0(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(FavoriteAdvertsEvent favoriteAdvertsEvent) {
        FavoriteAdvertsEvent favoriteAdvertsEvent2 = favoriteAdvertsEvent;
        if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.AddedToFavorites) {
            ExtendedProfileViewModelImpl.access$updateFavoriteStatuses(this.a, ((FavoriteAdvertsEvent.AddedToFavorites) favoriteAdvertsEvent2).getIds(), true);
        } else if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.RemovedFromFavorites) {
            ExtendedProfileViewModelImpl.access$updateFavoriteStatuses(this.a, ((FavoriteAdvertsEvent.RemovedFromFavorites) favoriteAdvertsEvent2).getIds(), false);
        } else if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.FavoritesFull) {
            ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
            ExtendedProfileViewModelImpl.access$showSnackbar(extendedProfileViewModelImpl, extendedProfileViewModelImpl.x.getFavoritesFullError());
        }
    }
}
