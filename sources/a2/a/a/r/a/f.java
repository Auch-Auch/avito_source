package a2.a.a.r.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
public final class f<T> implements Observer<StartActivityForResultEvent> {
    public final /* synthetic */ LegacyCheckoutFragment a;

    public f(LegacyCheckoutFragment legacyCheckoutFragment) {
        this.a = legacyCheckoutFragment;
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
