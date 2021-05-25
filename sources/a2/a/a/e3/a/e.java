package a2.a.a.e3.a;

import androidx.lifecycle.Observer;
import com.avito.android.remote.model.Action;
import com.avito.android.tariff.change.TariffChangeFragment;
import com.avito.android.util.Views;
public final class e<T> implements Observer<Action> {
    public final /* synthetic */ TariffChangeFragment a;

    public e(TariffChangeFragment tariffChangeFragment) {
        this.a = tariffChangeFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Action action) {
        Action action2 = action;
        if (action2 == null) {
            Views.conceal(TariffChangeFragment.access$getButton$p(this.a));
            return;
        }
        Views.show(TariffChangeFragment.access$getButton$p(this.a));
        TariffChangeFragment.access$getButton$p(this.a).setText(action2.getTitle());
        TariffChangeFragment.access$getButton$p(this.a).setOnClickListener(new d(this, action2));
    }
}
