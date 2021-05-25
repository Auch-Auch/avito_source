package a2.a.a.h3.a;

import com.avito.android.remote.model.my_advert.AppliedServicesInfo;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ AppliedServicesInfo b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, AppliedServicesInfo appliedServicesInfo) {
        super(0);
        this.a = myAdvertDetailsPresenterImpl;
        this.b = appliedServicesInfo;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MyAdvertRouter myAdvertRouter = this.a.a;
        if (myAdvertRouter != null) {
            myAdvertRouter.openDeepLink(this.b.getUri());
        }
        return Unit.INSTANCE;
    }
}
