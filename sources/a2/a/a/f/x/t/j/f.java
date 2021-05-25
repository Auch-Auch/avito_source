package a2.a.a.f.x.t.j;

import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment;
import com.avito.android.ui.view.PowerWebViewWrapper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CreditPartnerFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(CreditPartnerFragment creditPartnerFragment) {
        super(0);
        this.a = creditPartnerFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PowerWebViewWrapper powerWebViewWrapper = this.a.n;
        if (powerWebViewWrapper != null) {
            powerWebViewWrapper.reloadPage();
        }
        return Unit.INSTANCE;
    }
}
