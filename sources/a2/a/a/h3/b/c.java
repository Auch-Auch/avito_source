package a2.a.a.h3.b;

import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment;
import com.avito.android.user_advert.soa_with_price.events.ItemClosePriceInputEvent;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
public final class c<T> implements Consumer<Pair<? extends Boolean, ? extends String>> {
    public final /* synthetic */ SoaWithPriceSheetDialogFragment a;

    public c(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment) {
        this.a = soaWithPriceSheetDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Pair<? extends Boolean, ? extends String> pair) {
        Pair<? extends Boolean, ? extends String> pair2 = pair;
        boolean booleanValue = ((Boolean) pair2.component1()).booleanValue();
        String str = (String) pair2.component2();
        if (!booleanValue) {
            this.a.getAnalytics().track(new ItemClosePriceInputEvent(SoaWithPriceSheetDialogFragment.access$getAdvertId$p(this.a), str));
        }
    }
}
