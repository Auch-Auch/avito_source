package a2.a.a.r0;

import com.avito.android.favorite.FavoriteActionSource;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import io.reactivex.rxjava3.functions.Action;
public final class a implements Action {
    public final /* synthetic */ FavoriteAdvertsInteractorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ FavoriteActionSource c;

    public a(FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl, String str, FavoriteActionSource favoriteActionSource) {
        this.a = favoriteAdvertsInteractorImpl;
        this.b = str;
        this.c = favoriteActionSource;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.a.save(this.b, false);
        this.a.c.acceptEvent(new FavoriteAdvertsEvent.AddedToFavorites(this.b, this.c));
        this.a.b.upload();
    }
}
