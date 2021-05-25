package a2.a.a.h3.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        super(1);
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.a.l(new f(this));
        MyAdvertRouter myAdvertRouter = this.a.a;
        if (myAdvertRouter != null) {
            myAdvertRouter.openDeepLink(deepLink2);
        }
        return Unit.INSTANCE;
    }
}
