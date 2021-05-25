package a2.a.a.r.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.MessageEvent;
import kotlin.jvm.functions.Function0;
public final class h<T> implements Observer<MessageEvent> {
    public final /* synthetic */ LegacyCheckoutFragment a;

    public h(LegacyCheckoutFragment legacyCheckoutFragment) {
        this.a = legacyCheckoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(MessageEvent messageEvent) {
        String str;
        MessageEvent messageEvent2 = messageEvent;
        if (messageEvent2 != null && (str = (String) messageEvent2.getContentIfNotHandled()) != null) {
            Views.showSnackBar$default(LegacyCheckoutFragment.access$getRecyclerView$p(this.a), str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
    }
}
