package a2.a.a.n2;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.serp.SerpPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class p extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ SerpPresenterImpl a;
    public final /* synthetic */ AsyncPhoneItem b;
    public final /* synthetic */ ContactSource c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(SerpPresenterImpl serpPresenterImpl, AsyncPhoneItem asyncPhoneItem, ContactSource contactSource) {
        super(1);
        this.a = serpPresenterImpl;
        this.b = asyncPhoneItem;
        this.c = contactSource;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "loadedLink");
        this.a.p(this.b.getStringId(), deepLink2, this.c);
        return Unit.INSTANCE;
    }
}
