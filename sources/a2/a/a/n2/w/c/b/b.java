package a2.a.a.n2.w.c.b;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ AdvertXlRichItemPresenterImpl.d a;
    public final /* synthetic */ boolean b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(AdvertXlRichItemPresenterImpl.d dVar, boolean z) {
        super(1);
        this.a = dVar;
        this.b = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "phoneLink");
        ((AdvertRichItemListener) this.a.c.b.get()).onCallActionClicked(this.a.a.getStringId(), deepLink2, AdvertXlRichItemPresenterImpl.access$contactSource(this.a.c, this.b));
        return Unit.INSTANCE;
    }
}
