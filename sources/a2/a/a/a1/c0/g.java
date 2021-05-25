package a2.a.a.a1.c0;

import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import com.avito.android.remote.model.Coordinates;
import io.reactivex.rxjava3.functions.Predicate;
public final class g<T> implements Predicate<Coordinates> {
    public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

    public g(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        this.a = defaultSearchLocationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Coordinates coordinates) {
        return this.a.e;
    }
}
