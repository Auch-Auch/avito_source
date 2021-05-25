package a2.a.a.p3.a.a;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment;
public final class d<T> implements Observer<StartActivityEvent> {
    public final /* synthetic */ DiscountDialogFragment a;

    public d(DiscountDialogFragment discountDialogFragment) {
        this.a = discountDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(StartActivityEvent startActivityEvent) {
        IntentDataHolder intentDataHolder;
        BottomSheetDialog bottomSheetDialog;
        StartActivityEvent startActivityEvent2 = startActivityEvent;
        if (startActivityEvent2 != null && (intentDataHolder = (IntentDataHolder) startActivityEvent2.getContentIfNotHandled()) != null && (bottomSheetDialog = this.a.d) != null) {
            bottomSheetDialog.setOnCloseListener(new c(this, intentDataHolder));
            bottomSheetDialog.close();
        }
    }
}
