package a7.c.a.a.o.d.b;

import androidx.lifecycle.Observer;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.dialogerror.view.ErrorDialogFragment;
public final class a<T> implements Observer<Integer> {
    public final /* synthetic */ ErrorDialogFragment a;

    public a(ErrorDialogFragment errorDialogFragment) {
        this.a = errorDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        int i = R.id.ok_click_dialog;
        if (num2 != null && num2.intValue() == i) {
            this.a.dismiss();
        } else {
            this.a.dismiss();
        }
    }
}
