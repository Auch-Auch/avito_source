package a2.a.a.e3.h;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.region.RegionFragment;
public final class d<T> implements Observer<Boolean> {
    public final /* synthetic */ RegionFragment a;

    public d(RegionFragment regionFragment) {
        this.a = regionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            bool2.booleanValue();
            this.a.a().setLoading(bool2.booleanValue());
            this.a.a().setClickable(!bool2.booleanValue());
            RegionFragment.access$getRecyclerView$p(this.a).removeOnItemTouchListener(this.a.i);
            if (bool2.booleanValue()) {
                RegionFragment.access$getRecyclerView$p(this.a).addOnItemTouchListener(this.a.i);
            }
        }
    }
}
