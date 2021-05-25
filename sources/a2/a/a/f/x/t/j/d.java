package a2.a.a.f.x.t.j;

import a2.b.a.a.a;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment;
import com.avito.android.design.widget.circular_progress.CircularProgressBar;
import com.avito.android.util.Logs;
import com.avito.android.util.Views;
import com.yatatsu.powerwebview.PowerWebView;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<PowerWebViewStateChangeEvent> {
    public final /* synthetic */ CreditPartnerFragment a;
    public final /* synthetic */ PowerWebView b;
    public final /* synthetic */ String c;

    public d(CreditPartnerFragment creditPartnerFragment, PowerWebView powerWebView, String str) {
        this.a = creditPartnerFragment;
        this.b = powerWebView;
        this.c = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
        PowerWebViewStateChangeEvent powerWebViewStateChangeEvent2 = powerWebViewStateChangeEvent;
        if ((powerWebViewStateChangeEvent2.getState() == PowerWebViewStateChangeEvent.State.PROGRESS || powerWebViewStateChangeEvent2.getState() == PowerWebViewStateChangeEvent.State.STARTED) && powerWebViewStateChangeEvent2.getProgress() < 100) {
            CircularProgressBar circularProgressBar = this.a.l;
            if (circularProgressBar != null) {
                Views.show(circularProgressBar);
            }
            Views.conceal(this.b);
            return;
        }
        if (powerWebViewStateChangeEvent2.getState() == PowerWebViewStateChangeEvent.State.ERROR) {
            String str = this.c;
            StringBuilder L = a.L("HTTP error: code:");
            L.append(powerWebViewStateChangeEvent2.getErrorCode());
            L.append(" message:");
            L.append(powerWebViewStateChangeEvent2.getDescription());
            Logs.error$default(str, L.toString(), null, 4, null);
            CreditPartnerFragment.access$showErrorSnackbar(this.a, powerWebViewStateChangeEvent2.getErrorCode() / 100 == 5);
        } else {
            Views.show(this.b);
        }
        CircularProgressBar circularProgressBar2 = this.a.l;
        if (circularProgressBar2 != null) {
            Views.hide(circularProgressBar2);
        }
    }
}
