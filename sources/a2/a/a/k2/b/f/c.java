package a2.a.a.k2.b.f;

import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpCommercialBannerKt;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Throwable, SerpCommercialBanner> {
    public final /* synthetic */ SerpCommercialBanner a;

    public c(SerpCommercialBanner serpCommercialBanner) {
        this.a = serpCommercialBanner;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SerpCommercialBanner apply(Throwable th) {
        SerpCommercialBanner serpCommercialBanner = this.a;
        Intrinsics.checkNotNullExpressionValue(serpCommercialBanner, "banner");
        return SerpCommercialBannerKt.toEmptyBanner(serpCommercialBanner);
    }
}
