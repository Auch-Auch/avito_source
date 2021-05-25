package a2.a.a.k2.a;

import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class r<T> implements Consumer<Disposable> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public r(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        FiltersInteractorImpl.access$acceptParametersTreeChange(this.a, LoadingState.Loading.INSTANCE);
    }
}
