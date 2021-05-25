package a2.a.a.e3.e;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
import com.avito.android.tariff.fees_methods.viewmodel.HighDemandBottomSheetParams;
public final class d<T> implements Observer<HighDemandBottomSheetParams> {
    public final /* synthetic */ FeesMethodsFragment a;

    public d(FeesMethodsFragment feesMethodsFragment) {
        this.a = feesMethodsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(HighDemandBottomSheetParams highDemandBottomSheetParams) {
        HighDemandBottomSheetParams highDemandBottomSheetParams2 = highDemandBottomSheetParams;
        if (highDemandBottomSheetParams2 != null) {
            FeesMethodsFragment.access$showBottomSheet(this.a, highDemandBottomSheetParams2);
        }
    }
}
