package a7.c.a.a;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.SravniChatActivity;
import ru.sravni.android.bankproduct.utils.snackbar.SnackbarData;
public final class h<T> implements Observer<SnackbarData> {
    public final /* synthetic */ SravniChatActivity a;

    public h(SravniChatActivity sravniChatActivity) {
        this.a = sravniChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(SnackbarData snackbarData) {
        SnackbarData snackbarData2 = snackbarData;
        SravniChatActivity sravniChatActivity = this.a;
        Intrinsics.checkExpressionValueIsNotNull(snackbarData2, "it");
        sravniChatActivity.showBottomSnackbar(snackbarData2);
    }
}
