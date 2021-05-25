package a2.a.a.b0;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<DeepLink> {
    public final /* synthetic */ CartFabView a;

    public b(CartFabView cartFabView) {
        this.a = cartFabView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        CartFabView cartFabView = this.a;
        Context context = cartFabView.getFab().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "fab.context");
        Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
        CartFabView.access$openDeepLink(cartFabView, context, deepLink2);
    }
}
