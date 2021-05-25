package a7.c.a.a;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.SravniChatActivity;
import ru.sravni.android.bankproduct.presentation.dialogerror.view.ErrorDialogFragment;
public final class f<T> implements Observer<String> {
    public final /* synthetic */ SravniChatActivity a;

    public f(SravniChatActivity sravniChatActivity) {
        this.a = sravniChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        ErrorDialogFragment errorDialogFragment;
        String str2 = str;
        ErrorDialogFragment errorDialogFragment2 = this.a.c;
        if ((errorDialogFragment2 != null ? errorDialogFragment2.getDialog() : null) == null) {
            this.a.c = ErrorDialogFragment.Companion.newInstance(str2);
        }
        ErrorDialogFragment errorDialogFragment3 = this.a.c;
        if (errorDialogFragment3 == null) {
            Intrinsics.throwNpe();
        }
        if (!errorDialogFragment3.isAdded() && (errorDialogFragment = this.a.c) != null) {
            errorDialogFragment.show(this.a.getSupportFragmentManager(), "ErrorDialog");
        }
    }
}
