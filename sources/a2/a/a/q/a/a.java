package a2.a.a.q.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
public final class a<T> implements Observer<StartActivityForResultEvent> {
    public final /* synthetic */ CheckoutFragment a;

    public a(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(StartActivityForResultEvent startActivityForResultEvent) {
        IntentForResultDataHolder intentForResultDataHolder;
        StartActivityForResultEvent startActivityForResultEvent2 = startActivityForResultEvent;
        if (startActivityForResultEvent2 != null && (intentForResultDataHolder = (IntentForResultDataHolder) startActivityForResultEvent2.getContentIfNotHandled()) != null) {
            this.a.startActivityForResult(intentForResultDataHolder.getIntent(), intentForResultDataHolder.getRequestCode());
        }
    }
}
