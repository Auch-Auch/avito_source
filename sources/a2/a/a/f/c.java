package a2.a.a.f;

import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import com.avito.android.remote.model.PositionedCommercialCascade;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class c<T, R> implements Function<SerpCommercialBanner, List<? extends PositionedBannerContainer>> {
    public final /* synthetic */ PositionedCommercialCascade a;

    public c(PositionedCommercialCascade positionedCommercialCascade) {
        this.a = positionedCommercialCascade;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends PositionedBannerContainer> apply(SerpCommercialBanner serpCommercialBanner) {
        SerpCommercialBanner serpCommercialBanner2 = serpCommercialBanner;
        String position = this.a.getPosition();
        Intrinsics.checkNotNullExpressionValue(serpCommercialBanner2, "it");
        return d.listOf(new PositionedBannerContainer(position, serpCommercialBanner2));
    }
}
