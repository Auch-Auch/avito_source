package a2.a.a.e3.e;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
import kotlin.Unit;
public final class e<T> implements Observer<Unit> {
    public final /* synthetic */ FeesMethodsFragment a;

    public e(FeesMethodsFragment feesMethodsFragment) {
        this.a = feesMethodsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        BottomSheetDialog bottomSheetDialog = this.a.f;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.close();
        }
    }
}
