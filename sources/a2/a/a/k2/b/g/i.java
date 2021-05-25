package a2.a.a.k2.b.g;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<LoadingState<? super DeepLink>, LoadAction.LoadSavedSearchControlDeeplink> {
    public static final i a = new i();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadAction.LoadSavedSearchControlDeeplink apply(LoadingState<? super DeepLink> loadingState) {
        LoadingState<? super DeepLink> loadingState2 = loadingState;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        return new LoadAction.LoadSavedSearchControlDeeplink(loadingState2);
    }
}
