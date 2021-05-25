package a2.a.a.k2.b.f;

import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import io.reactivex.rxjava3.functions.Function;
public final class b<T, R> implements Function<CommercialBanner, SerpCommercialBanner> {
    public final /* synthetic */ SerpCommercialBanner a;

    public b(SerpCommercialBanner serpCommercialBanner) {
        this.a = serpCommercialBanner;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SerpCommercialBanner apply(CommercialBanner commercialBanner) {
        return this.a.copyWithCommercialBanner(commercialBanner);
    }
}
