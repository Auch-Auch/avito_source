package a2.a.a.p3.a.a;

import androidx.lifecycle.Observer;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment;
import kotlin.Unit;
public final class e<T> implements Observer<Unit> {
    public final /* synthetic */ DiscountDialogFragment a;

    public e(DiscountDialogFragment discountDialogFragment) {
        this.a = discountDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            DiscountDialogFragment.access$getListener$p(this.a).closeWithError();
        }
    }
}
