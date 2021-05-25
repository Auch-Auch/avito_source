package a2.a.a.n2.w.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ AdvertXlItemPresenterImpl.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AdvertXlItemPresenterImpl.c cVar) {
        super(1);
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "phoneLink");
        ((AdvertXlItemListener) this.a.c.c.get()).onCallActionClicked(this.a.a, deepLink2);
        return Unit.INSTANCE;
    }
}
