package a2.a.a.k2.b.g;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.map.PinAdvertsResult;
import com.avito.android.search.map.PinAdverts;
import com.avito.android.search.map.middleware.LoadMiddleware;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class l<T, R> implements Function<LoadingState<? super PinAdvertsResult>, ObservableSource<? extends LoadingState<? super PinAdverts>>> {
    public final /* synthetic */ LoadMiddleware a;
    public final /* synthetic */ List b;

    public l(LoadMiddleware loadMiddleware, List list) {
        this.a = loadMiddleware;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LoadingState<? super PinAdverts>> apply(LoadingState<? super PinAdvertsResult> loadingState) {
        LoadingState<? super PinAdvertsResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            PinAdvertsResult pinAdvertsResult = (PinAdvertsResult) ((LoadingState.Loaded) loadingState2).getData();
            SerpDisplayType displayType = pinAdvertsResult.getDisplayType();
            if (displayType == null || !this.a.d.canSwitchDisplayType()) {
                displayType = SerpDisplayType.List;
            }
            return this.a.b.convert(pinAdvertsResult.getItems(), this.a.d.getColumnsCountForList(), displayType).subscribeOn(this.a.e.computation()).map(new k(this, pinAdvertsResult));
        }
        Objects.requireNonNull(loadingState2, "null cannot be cast to non-null type com.avito.android.util.LoadingState<com.avito.android.search.map.PinAdverts>");
        Observable just = Observable.just(loadingState2);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }
}
