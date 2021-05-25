package a2.a.a.f.v;

import com.avito.android.advert.closed.ClosedAdvertView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<Unit> {
    public final /* synthetic */ ClosedAdvertView a;

    public b(ClosedAdvertView closedAdvertView) {
        this.a = closedAdvertView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.setFavoriteVisible(false);
    }
}
