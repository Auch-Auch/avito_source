package a2.a.a.e3.f;

import androidx.lifecycle.Observer;
import com.avito.android.remote.model.Action;
import com.avito.android.tariff.info.TariffInfoFragment;
public final class c<T> implements Observer<Action> {
    public final /* synthetic */ TariffInfoFragment a;

    public c(TariffInfoFragment tariffInfoFragment) {
        this.a = tariffInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Action action) {
        Action action2 = action;
        if (action2 != null) {
            TariffInfoFragment.access$getButton$p(this.a).setText(action2.getTitle());
            TariffInfoFragment.access$getButton$p(this.a).setOnClickListener(new b(this, action2));
        }
    }
}
