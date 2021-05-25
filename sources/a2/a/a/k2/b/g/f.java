package a2.a.a.k2.b.g;

import com.avito.android.search.map.action.LoadAction;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<ViewTypeSerpItem, LoadAction.LoadAd> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadAction.LoadAd apply(ViewTypeSerpItem viewTypeSerpItem) {
        ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
        Intrinsics.checkNotNullExpressionValue(viewTypeSerpItem2, "ad");
        return new LoadAction.LoadAd(viewTypeSerpItem2);
    }
}
