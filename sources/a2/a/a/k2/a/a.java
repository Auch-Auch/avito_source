package a2.a.a.k2.a;

import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.ParametersTreeWithAdditional;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<LoadingState<? super ParametersTreeWithAdditional>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public a(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super ParametersTreeWithAdditional> loadingState) {
        LoadingState<? super ParametersTreeWithAdditional> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.f = null;
            this.a.c = (ParametersTreeWithAdditional) ((LoadingState.Loaded) loadingState2).getData();
        }
    }
}
