package a2.a.a.e3.d;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.tariff.edit_info.EditInfoFragment;
public final class c<T> implements Observer<Object> {
    public final /* synthetic */ EditInfoFragment a;

    public c(EditInfoFragment editInfoFragment) {
        this.a = editInfoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        BottomSheetDialog bottomSheetDialog;
        if (obj != null && (bottomSheetDialog = this.a.f) != null) {
            bottomSheetDialog.close();
        }
    }
}
