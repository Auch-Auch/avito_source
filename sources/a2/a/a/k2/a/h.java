package a2.a.a.k2.a;

import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.search.filter.FiltersInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class h<T> implements Consumer<Throwable> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public h(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        CounterButton counterButton = this.a.e;
        if (counterButton != null) {
            counterButton.setTitle(null);
        }
        CounterButton counterButton2 = this.a.e;
        if (counterButton2 != null) {
            counterButton2.setEnabled(Boolean.TRUE);
        }
    }
}
