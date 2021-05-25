package a2.a.a.a0.a;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.avito.android.cart.summary.CartSummaryFragment;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<DeepLink> {
    public final /* synthetic */ CartSummaryFragment a;

    public b(CartSummaryFragment cartSummaryFragment) {
        this.a = cartSummaryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "link");
        Intent intent = this.a.getDeepLinkIntentFactory().getIntent(deepLink2);
        if (intent != null) {
            this.a.startActivity(intent);
        }
    }
}
