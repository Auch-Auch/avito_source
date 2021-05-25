package a2.a.a.q3.f.q0;

import android.app.Dialog;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment;
import java.util.Objects;
public final class c<T> implements Observer<StartActivityEvent> {
    public final /* synthetic */ AppliedServicesDialogFragment a;

    public c(AppliedServicesDialogFragment appliedServicesDialogFragment) {
        this.a = appliedServicesDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(StartActivityEvent startActivityEvent) {
        IntentDataHolder intentDataHolder;
        StartActivityEvent startActivityEvent2 = startActivityEvent;
        if (startActivityEvent2 != null && (intentDataHolder = (IntentDataHolder) startActivityEvent2.getContentIfNotHandled()) != null) {
            Dialog dialog = this.a.getDialog();
            Objects.requireNonNull(dialog, "null cannot be cast to non-null type com.avito.android.lib.design.bottom_sheet.BottomSheetDialog");
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            bottomSheetDialog.setOnCloseListener(new b(this, intentDataHolder));
            bottomSheetDialog.close();
        }
    }
}
