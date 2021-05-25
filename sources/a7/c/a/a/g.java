package a7.c.a.a;

import androidx.lifecycle.Observer;
import ru.sravni.android.bankproduct.SravniChatActivity;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.utils.snackbar.SnackbarData;
public final class g<T> implements Observer<SravniError> {
    public final /* synthetic */ SravniChatActivity a;

    public g(SravniChatActivity sravniChatActivity) {
        this.a = sravniChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(SravniError sravniError) {
        this.a.showBottomSnackbar(new SnackbarData(-1, "Произошла ошибка"));
    }
}
