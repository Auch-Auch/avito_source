package a2.a.a.k2.a;

import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.search.filter.FiltersInteractorImpl;
import java.util.concurrent.Callable;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
public final class j<V> implements Callable<Option<? extends String>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public j(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Option<? extends String> call() {
        CounterButton counterButton = this.a.e;
        return OptionKt.toOption(counterButton != null ? counterButton.getTitle() : null);
    }
}
