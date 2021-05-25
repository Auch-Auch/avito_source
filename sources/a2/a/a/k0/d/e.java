package a2.a.a.k0.d;

import android.view.KeyEvent;
import android.widget.TextView;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewImpl;
import com.avito.android.util.Keyboards;
import kotlin.jvm.internal.Intrinsics;
public final class e implements TextView.OnEditorActionListener {
    public final /* synthetic */ DeliveryLocationSuggestViewImpl a;

    public e(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl) {
        this.a = deliveryLocationSuggestViewImpl;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(textView, "view");
        Keyboards.hideKeyboard(textView, true);
        textView.removeCallbacks(this.a.f);
        DeliveryLocationSuggestViewImpl.access$getViewModel$p(this.a).searchSuggestions(textView.getText().toString());
        return true;
    }
}
