package a2.a.a.t0;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class h<T> implements Consumer<List<? extends String>> {
    public final /* synthetic */ FavoriteAdvertsListInteractorImpl.r a;

    public h(FavoriteAdvertsListInteractorImpl.r rVar) {
        this.a = rVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends String> list) {
        FavoriteAdvertsListInteractorImpl.access$wipeLocalAdverts(this.a.a);
    }
}
