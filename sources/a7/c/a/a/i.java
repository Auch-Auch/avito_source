package a7.c.a.a;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.SravniChatActivity;
public final class i<T> implements Observer<Boolean> {
    public final /* synthetic */ SravniChatActivity a;

    public i(SravniChatActivity sravniChatActivity) {
        this.a = sravniChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkExpressionValueIsNotNull(bool2, "it");
        if (bool2.booleanValue()) {
            SravniChatActivity.access$showTokenRefreshDialog(this.a);
        }
    }
}
