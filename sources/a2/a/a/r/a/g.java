package a2.a.a.r.a;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.basket_legacy.ui.Router;
import com.avito.android.basket_legacy.utils.CloseEvent;
import com.avito.android.vas.list.VasConstants;
public final class g<T> implements Observer<CloseEvent> {
    public final /* synthetic */ LegacyCheckoutFragment a;

    public g(LegacyCheckoutFragment legacyCheckoutFragment) {
        this.a = legacyCheckoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(CloseEvent closeEvent) {
        CloseEvent closeEvent2 = closeEvent;
        if (closeEvent2 != null) {
            if (closeEvent2.getPaymentSucceeded()) {
                Intent intent = new Intent();
                intent.setAction(VasConstants.VAS_PAYMENT_OK_INTENT);
                FragmentActivity activity = this.a.getActivity();
                if (activity != null) {
                    activity.sendBroadcast(intent);
                }
            }
            Router router = this.a.f;
            if (router != null) {
                router.finishFlow(closeEvent2.getEnableAppRater());
            }
        }
    }
}
