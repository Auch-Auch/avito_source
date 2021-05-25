package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.vas_performance.ui.ButtonState;
import com.avito.android.vas_performance.ui.VisualVasFragment;
import kotlin.jvm.internal.Intrinsics;
public final class j0<T> implements Observer<ButtonState> {
    public final /* synthetic */ VisualVasFragment a;

    public j0(VisualVasFragment visualVasFragment) {
        this.a = visualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ButtonState buttonState) {
        ButtonState buttonState2 = buttonState;
        if (buttonState2 != null) {
            Object tag = VisualVasFragment.access$getContinueButton$p(this.a).getTag();
            if (!(tag instanceof Boolean)) {
                tag = null;
            }
            if (!Intrinsics.areEqual((Boolean) tag, Boolean.valueOf(buttonState2.getActive()))) {
                VisualVasFragment.access$updateButtonAppearance(this.a, buttonState2.getActive());
            }
            ButtonsKt.bindText$default(VisualVasFragment.access$getContinueButton$p(this.a), buttonState2.getText(), false, 2, null);
        }
    }
}
