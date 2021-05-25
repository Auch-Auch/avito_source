package a2.a.a.a1.c0;

import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

    public d(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        this.a = defaultSearchLocationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.l.sendResolveCoordinates(null, th.getMessage());
        this.a.e = false;
    }
}
