package a2.a.a.h3.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DeepLink a;
    public final /* synthetic */ MyAdvertDetailsPresenterImpl b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(DeepLink deepLink, MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        super(0);
        this.a = deepLink;
        this.b = myAdvertDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MyAdvertRouter myAdvertRouter = this.b.a;
        if (myAdvertRouter != null) {
            myAdvertRouter.openDeepLink(this.a);
        }
        return Unit.INSTANCE;
    }
}
