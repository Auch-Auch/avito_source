package a2.a.a.a0.a;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.cart.summary.CartSummaryViewModel;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class o<T> implements Consumer<String> {
    public final /* synthetic */ CartSummaryViewModel a;

    public o(CartSummaryViewModel cartSummaryViewModel) {
        this.a = cartSummaryViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        ActivityIntentFactory activityIntentFactory = this.a.H;
        Intrinsics.checkNotNullExpressionValue(str2, "itemId");
        this.a.r.postValue(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory, str2, null, null, null, null, null, false, null, 0, null, null, null, 4094, null));
    }
}
