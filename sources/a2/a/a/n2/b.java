package a2.a.a.n2;

import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.YandexBannerItem;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.ad.YandexBanner;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import io.reactivex.rxjava3.functions.Function;
public final class b<T, R> implements Function<YandexBanner<? extends NativeGenericAd>, CommercialBanner> {
    public final /* synthetic */ CommercialBannersInteractorImpl a;
    public final /* synthetic */ YandexBannerItem b;
    public final /* synthetic */ int c;
    public final /* synthetic */ CommercialBannersInteractorImpl.a d;

    public b(CommercialBannersInteractorImpl commercialBannersInteractorImpl, YandexBannerItem yandexBannerItem, int i, CommercialBannersInteractorImpl.a aVar) {
        this.a = commercialBannersInteractorImpl;
        this.b = yandexBannerItem;
        this.c = i;
        this.d = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CommercialBanner apply(YandexBanner<? extends NativeGenericAd> yandexBanner) {
        return CommercialBannersInteractorImpl.access$createCommercialBanner(this.a, (String) this.b.getId(), yandexBanner, this.c, this.d);
    }
}
