package a2.a.a.k3;

import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.user_favorites.UserFavoritesInteractorImpl;
import io.reactivex.rxjava3.functions.Function;
public final class b<T, R> implements Function<SavedSearchesCounter, String> {
    public final /* synthetic */ UserFavoritesInteractorImpl a;

    public b(UserFavoritesInteractorImpl userFavoritesInteractorImpl) {
        this.a = userFavoritesInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public String apply(SavedSearchesCounter savedSearchesCounter) {
        return UserFavoritesInteractorImpl.access$toCounterString(this.a, savedSearchesCounter.getUnreadCount());
    }
}
