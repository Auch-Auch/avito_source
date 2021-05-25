package a2.a.a.n2;

import com.avito.android.remote.model.SerpBannerContainer;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.serp.SerpElementResultWithPageParams;
import com.avito.android.serp.adapter.SerpCommercialBannerKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class l<T, R> implements Function<SerpElementResultWithPageParams, ObservableSource<? extends SerpElementResultWithPageParams>> {
    public static final l a = new l();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends SerpElementResultWithPageParams> apply(SerpElementResultWithPageParams serpElementResultWithPageParams) {
        SerpElementResultWithPageParams serpElementResultWithPageParams2 = serpElementResultWithPageParams;
        SerpElementResult serpElementResult = serpElementResultWithPageParams2.getSerpElementResult();
        List<SerpElement> elements = serpElementResult.getElements();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
        for (T t : elements) {
            if (t instanceof SerpBannerContainer) {
                t = (T) SerpCommercialBannerKt.toSerpCommercialBanner(t);
            }
            arrayList.add(t);
        }
        Observable just = Observable.just(new SerpElementResultWithPageParams(serpElementResult.cloneWithNewElements(arrayList), serpElementResultWithPageParams2.getSerpPageParams()));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }
}
