package a2.a.a.k2.a;

import com.avito.android.remote.model.counter.ChangingParametersForButton;
import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
public final class g<T, R> implements Function<ChangingParametersForButton, LoadingState<? super CounterButton>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public g(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super CounterButton> apply(ChangingParametersForButton changingParametersForButton) {
        ChangingParametersForButton changingParametersForButton2 = changingParametersForButton;
        this.a.e = changingParametersForButton2.getCounterButton();
        CounterButton counterButton = changingParametersForButton2.getCounterButton();
        String str = null;
        Boolean enabled = counterButton != null ? counterButton.getEnabled() : null;
        CounterButton counterButton2 = changingParametersForButton2.getCounterButton();
        if (counterButton2 != null) {
            str = counterButton2.getTitle();
        }
        return new LoadingState.Loaded(new CounterButton(enabled, str));
    }
}
