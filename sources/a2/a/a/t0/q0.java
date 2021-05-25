package a2.a.a.t0;

import android.net.Uri;
import com.avito.android.favorites.FavoritesListPresenterImpl;
import com.avito.android.favorites.FavoritesLoadingModel;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class q0<T> implements Consumer<LoadingState<? super FavoritesLoadingModel>> {
    public final /* synthetic */ FavoritesListPresenterImpl a;
    public final /* synthetic */ Uri b;

    public q0(FavoritesListPresenterImpl favoritesListPresenterImpl, Uri uri) {
        this.a = favoritesListPresenterImpl;
        this.b = uri;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super FavoritesLoadingModel> loadingState) {
        LoadingState<? super FavoritesLoadingModel> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            FavoritesListPresenterImpl.access$handleLoadingNextSuccess(this.a, (LoadingState.Loaded) loadingState2);
        } else if (loadingState2 instanceof LoadingState.Error) {
            FavoritesListPresenterImpl.access$handleLoadingNextError(this.a, (LoadingState.Error) loadingState2, this.b);
        }
    }
}
