package a2.a.a.f.x.t.j;

import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<Unit> {
    public final /* synthetic */ CreditPartnerFragment a;

    public b(CreditPartnerFragment creditPartnerFragment) {
        this.a = creditPartnerFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.finish();
    }
}
