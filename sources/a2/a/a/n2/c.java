package a2.a.a.n2;

import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.ad.MyTargetBanner;
import io.reactivex.rxjava3.functions.Function;
public final class c<T, R> implements Function<MyTargetBanner, CommercialBanner> {
    public final /* synthetic */ CommercialBannersInteractorImpl a;
    public final /* synthetic */ MyTargetBannerItem b;
    public final /* synthetic */ int c;
    public final /* synthetic */ CommercialBannersInteractorImpl.a d;

    public c(CommercialBannersInteractorImpl commercialBannersInteractorImpl, MyTargetBannerItem myTargetBannerItem, int i, CommercialBannersInteractorImpl.a aVar) {
        this.a = commercialBannersInteractorImpl;
        this.b = myTargetBannerItem;
        this.c = i;
        this.d = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CommercialBanner apply(MyTargetBanner myTargetBanner) {
        return CommercialBannersInteractorImpl.access$createCommercialBanner(this.a, String.valueOf(this.b.getId().intValue()), myTargetBanner, this.c, this.d);
    }
}
