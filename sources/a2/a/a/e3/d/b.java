package a2.a.a.e3.d;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.edit_info.EditInfoFragment;
import com.avito.android.tariff.edit_info.viewmodel.BottomSheetParams;
public final class b<T> implements Observer<BottomSheetParams> {
    public final /* synthetic */ EditInfoFragment a;

    public b(EditInfoFragment editInfoFragment) {
        this.a = editInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(BottomSheetParams bottomSheetParams) {
        BottomSheetParams bottomSheetParams2 = bottomSheetParams;
        if (bottomSheetParams2 != null) {
            EditInfoFragment.access$showBottomSheet(this.a, bottomSheetParams2);
        }
    }
}
