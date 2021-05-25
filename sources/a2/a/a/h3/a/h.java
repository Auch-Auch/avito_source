package a2.a.a.h3.a;

import com.avito.android.remote.model.PriceBadge;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import com.avito.android.user_advert.event.IconType;
import com.avito.android.user_advert.event.InformationLinkClickEvent;
import com.avito.android.util.SafeLinkKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function0<Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ MyAdvertDetailsPresenterImpl c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(String str, String str2, MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, PriceBadge priceBadge) {
        super(0);
        this.a = str;
        this.b = str2;
        this.c = myAdvertDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.c.C.track(new InformationLinkClickEvent(this.a, IconType.MARKET_PRICE));
        MyAdvertRouter myAdvertRouter = this.c.a;
        if (myAdvertRouter != null) {
            myAdvertRouter.openUrl(SafeLinkKt.wrapIntoSafeLink(this.b));
        }
        return Unit.INSTANCE;
    }
}
