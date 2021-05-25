package a2.a.a.h3.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class p extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ MyAdvertDetails.VasBundlesBanner b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, MyAdvertDetails.VasBundlesBanner vasBundlesBanner) {
        super(0);
        this.a = myAdvertDetailsPresenterImpl;
        this.b = vasBundlesBanner;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MyAdvertRouter myAdvertRouter;
        DeepLink uri = this.b.getUri();
        if (!(uri == null || (myAdvertRouter = this.a.a) == null)) {
            myAdvertRouter.openDeepLink(uri);
        }
        return Unit.INSTANCE;
    }
}
