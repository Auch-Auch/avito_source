package a2.a.a.a1;

import com.avito.android.home.HomeInteractorImpl;
import com.avito.android.home.HomePageResult;
import com.avito.android.remote.model.HomeElementResult;
import com.avito.android.remote.model.SerpBannerContainer;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.SerpCommercialBannerKt;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import t6.n.e;
public final class f<T, R> implements Function<HomeElementResult, HomePageResult> {
    public final /* synthetic */ HomeInteractorImpl a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ SerpDisplayType d;

    public f(HomeInteractorImpl homeInteractorImpl, int i, int i2, SerpDisplayType serpDisplayType) {
        this.a = homeInteractorImpl;
        this.b = i;
        this.c = i2;
        this.d = serpDisplayType;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public HomePageResult apply(HomeElementResult homeElementResult) {
        HomeElementResult homeElementResult2 = homeElementResult;
        this.a.r.trackAdvertsLoaded(this.b);
        List<SerpElement> elements = homeElementResult2.getElements();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
        for (T t : elements) {
            if (t instanceof SerpBannerContainer) {
                t = (T) SerpCommercialBannerKt.toSerpCommercialBanner(t);
            }
            arrayList.add(t);
        }
        return HomeInteractorImpl.access$createHomePageResult(this.a, homeElementResult2.cloneWithNewElements(arrayList), this.c, this.d);
    }
}
