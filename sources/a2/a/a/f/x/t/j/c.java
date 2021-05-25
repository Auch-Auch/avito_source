package a2.a.a.f.x.t.j;

import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ CreditPartnerFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(CreditPartnerFragment creditPartnerFragment) {
        super(1);
        this.a = creditPartnerFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        CreditPartnerFragment.access$showErrorSnackbar(this.a, bool.booleanValue());
        return Unit.INSTANCE;
    }
}
