package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.AdvertId;
import com.avito.android.user_advert.advert.DetailsId;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class q extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        super(0);
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DetailsId detailsId = this.a.n;
        String str = null;
        if (!(detailsId instanceof AdvertId)) {
            detailsId = null;
        }
        AdvertId advertId = (AdvertId) detailsId;
        if (advertId != null) {
            str = advertId.getAdvertId();
        }
        if (str != null) {
            MyAdvertDetailsPresenterImpl.access$notifyVasBundleBannerClosed(this.a, str);
        }
        return Unit.INSTANCE;
    }
}
