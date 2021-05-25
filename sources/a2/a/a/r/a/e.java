package a2.a.a.r.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
public final class e<T> implements Observer<StartActivityEvent> {
    public final /* synthetic */ LegacyCheckoutFragment a;

    public e(LegacyCheckoutFragment legacyCheckoutFragment) {
        this.a = legacyCheckoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(StartActivityEvent startActivityEvent) {
        IntentDataHolder intentDataHolder;
        StartActivityEvent startActivityEvent2 = startActivityEvent;
        if (startActivityEvent2 != null && (intentDataHolder = (IntentDataHolder) startActivityEvent2.getContentIfNotHandled()) != null) {
            this.a.startActivity(intentDataHolder.getIntent());
        }
    }
}
