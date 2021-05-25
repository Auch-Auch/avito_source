package a2.a.a.t0;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.util.Throwables;
import io.reactivex.rxjava3.functions.Consumer;
public final class d0<T> implements Consumer<Throwable> {
    public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;
    public final /* synthetic */ String b;

    public d0(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl, String str) {
        this.a = favoriteAdvertsServiceInteractorImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (!Throwables.isNetworkProblem(th2)) {
            Analytics analytics = this.a.g;
            String str = this.b;
            if (str == null) {
                str = "";
            }
            analytics.track(new NonFatalError(str, th2, null, 4, null));
        }
    }
}
