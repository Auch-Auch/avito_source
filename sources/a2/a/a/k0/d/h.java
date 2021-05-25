package a2.a.a.k0.d;

import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewWithRedesignedInputImpl;
import com.avito.android.util.Keyboards;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<String> {
    public final /* synthetic */ DeliveryLocationSuggestViewWithRedesignedInputImpl a;

    public h(DeliveryLocationSuggestViewWithRedesignedInputImpl deliveryLocationSuggestViewWithRedesignedInputImpl) {
        this.a = deliveryLocationSuggestViewWithRedesignedInputImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        Keyboards.hideKeyboard$default(this.a.a, false, 1, null);
        DeliveryLocationSuggestViewModel access$getViewModel$p = DeliveryLocationSuggestViewWithRedesignedInputImpl.access$getViewModel$p(this.a);
        Intrinsics.checkNotNullExpressionValue(str2, "query");
        access$getViewModel$p.searchSuggestions(str2);
    }
}
