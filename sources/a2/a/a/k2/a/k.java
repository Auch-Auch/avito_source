package a2.a.a.k2.a;

import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
public final class k<T, R> implements Function<String, LoadingState<? super CounterButton>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public k(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super CounterButton> apply(String str) {
        CounterButton counterButton = this.a.e;
        String str2 = null;
        Boolean enabled = counterButton != null ? counterButton.getEnabled() : null;
        CounterButton counterButton2 = this.a.e;
        if (counterButton2 != null) {
            str2 = counterButton2.getTitle();
        }
        return new LoadingState.Loaded(new CounterButton(enabled, str2));
    }
}
