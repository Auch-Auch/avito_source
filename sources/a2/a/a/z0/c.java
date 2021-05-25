package a2.a.a.z0;

import androidx.lifecycle.Observer;
import com.avito.android.hints.HintsDialogFragment;
import kotlin.Unit;
public final class c<T> implements Observer<Unit> {
    public final /* synthetic */ HintsDialogFragment a;

    public c(HintsDialogFragment hintsDialogFragment) {
        this.a = hintsDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            this.a.closeActivity();
        }
    }
}
