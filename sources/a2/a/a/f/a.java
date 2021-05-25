package a2.a.a.f;

import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t6.n.e;
public final class a extends Lambda implements Function1<List<? extends List<? extends PositionedBannerContainer>>, List<? extends PositionedBannerContainer>> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public List<? extends PositionedBannerContainer> invoke(List<? extends List<? extends PositionedBannerContainer>> list) {
        List<? extends List<? extends PositionedBannerContainer>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        return e.flatten(list2);
    }
}
