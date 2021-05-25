package a2.a.a.k2.a;

import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.LocationInfo;
import io.reactivex.rxjava3.functions.Consumer;
public final class n<T> implements Consumer<LocationInfo> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public n(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LocationInfo locationInfo) {
        this.a.a = locationInfo;
    }
}
