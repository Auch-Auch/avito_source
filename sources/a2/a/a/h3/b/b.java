package a2.a.a.h3.b;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.user_advert.soa_with_price.EnterPriceDetails;
import com.avito.android.user_advert.soa_with_price.PriceSheetDialogViewImpl;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<EnterPriceDetails> {
    public final /* synthetic */ SoaWithPriceSheetDialogFragment a;
    public final /* synthetic */ PriceSheetDialogViewImpl b;

    public b(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, PriceSheetDialogViewImpl priceSheetDialogViewImpl) {
        this.a = soaWithPriceSheetDialogFragment;
        this.b = priceSheetDialogViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(EnterPriceDetails enterPriceDetails) {
        EnterPriceDetails enterPriceDetails2 = enterPriceDetails;
        PriceSheetDialogViewImpl priceSheetDialogViewImpl = this.b;
        AttributedTextFormatter attributedTextFormatter = this.a.getAttributedTextFormatter();
        Context requireContext = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        priceSheetDialogViewImpl.setMessage(attributedTextFormatter.format(requireContext, enterPriceDetails2.getMessage()));
        this.b.setInputText(enterPriceDetails2.getPrice());
    }
}
