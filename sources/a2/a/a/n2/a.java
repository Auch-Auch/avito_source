package a2.a.a.n2;

import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.ad.DfpBanner;
import io.reactivex.rxjava3.functions.Function;
public final class a<T, R> implements Function<DfpBanner, CommercialBanner> {
    public final /* synthetic */ CommercialBannersInteractorImpl a;
    public final /* synthetic */ DfpBannerItem b;
    public final /* synthetic */ int c;
    public final /* synthetic */ CommercialBannersInteractorImpl.a d;

    public a(CommercialBannersInteractorImpl commercialBannersInteractorImpl, DfpBannerItem dfpBannerItem, int i, CommercialBannersInteractorImpl.a aVar) {
        this.a = commercialBannersInteractorImpl;
        this.b = dfpBannerItem;
        this.c = i;
        this.d = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CommercialBanner apply(DfpBanner dfpBanner) {
        return CommercialBannersInteractorImpl.access$createCommercialBanner(this.a, this.b.getId(), dfpBanner, this.c, this.d);
    }
}
