package a2.a.a.k2.a;

import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.search.filter.FiltersInteractorImpl;
import java.util.concurrent.Callable;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
public final class l<V> implements Callable<Option<? extends Location>> {
    public final /* synthetic */ FiltersInteractorImpl a;
    public final /* synthetic */ ParametersTree b;

    public l(FiltersInteractorImpl filtersInteractorImpl, ParametersTree parametersTree) {
        this.a = filtersInteractorImpl;
        this.b = parametersTree;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Option<? extends Location> call() {
        return OptionKt.toOption(FiltersInteractorImpl.access$getLocation(this.a, this.b));
    }
}
