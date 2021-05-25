package a2.a.a.a1;

import com.avito.android.home.HomeActivity;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Long> {
    public final /* synthetic */ HomeActivity a;

    public a(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Long l) {
        this.a.getUserProfileStatusDataProvider().updateUserFavoritesCounters();
    }
}
