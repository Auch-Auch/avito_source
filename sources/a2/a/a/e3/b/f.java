package a2.a.a.e3.b;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.count.TariffCountFragment;
public final class f<T> implements Observer<Boolean> {
    public final /* synthetic */ TariffCountFragment a;

    public f(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            bool2.booleanValue();
            this.a.a().setButtonLoadingState(bool2.booleanValue());
            this.a.b().removeOnItemTouchListener(this.a.h);
            if (bool2.booleanValue()) {
                this.a.b().addOnItemTouchListener(this.a.h);
            }
        }
    }
}
