package a2.a.a.n2.w.c.a;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ AdvertRichJobItemPresenterImpl.d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AdvertRichJobItemPresenterImpl.d dVar) {
        super(1);
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "phoneLink");
        ((AdvertRichItemListener) this.a.c.a.get()).onCallActionClicked(this.a.a.getStringId(), deepLink2, ContactSource.CONTACT_REGULAR);
        return Unit.INSTANCE;
    }
}
