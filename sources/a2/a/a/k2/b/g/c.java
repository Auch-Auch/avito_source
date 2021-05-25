package a2.a.a.k2.b.g;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.middleware.LoadMiddleware;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<LoadAction.AppendSerp, ObservableSource<? extends LoadAction>> {
    public final /* synthetic */ LoadMiddleware a;
    public final /* synthetic */ SearchMapState b;

    public c(LoadMiddleware loadMiddleware, SearchMapState searchMapState) {
        this.a = loadMiddleware;
        this.b = searchMapState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LoadAction> apply(LoadAction.AppendSerp appendSerp) {
        LoadAction.AppendSerp appendSerp2 = appendSerp;
        if (appendSerp2.getState() instanceof LoadingState.Loaded) {
            SerpInteractor.Result result = (SerpInteractor.Result) ((LoadingState.Loaded) appendSerp2.getState()).getData();
            SerpDisplayType displayType = this.b.getSerpState().getDisplayType();
            if (displayType == null) {
                displayType = result.getDisplayType();
            }
            Observable just = Observable.just(appendSerp2);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return Observable.merge(just, this.a.c.loadAds(result.getDataSources().getSerpItems(), this.b.getSearchParams(), displayType, result.getKey().getId()).map(b.a));
        }
        Observable just2 = Observable.just(appendSerp2);
        Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(this)");
        return just2;
    }
}
