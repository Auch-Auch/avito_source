package a2.a.a.c2.d;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Observer<String> {
    public final /* synthetic */ PhoneActionFragment a;

    public c(PhoneActionFragment phoneActionFragment) {
        this.a = phoneActionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        Context requireContext = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        new Snackbar(requireContext, str2).setType(SnackbarType.ERROR).setAnchorView(PhoneActionFragment.access$getAnchorView$p(this.a)).setPosition(SnackbarPosition.BELOW_VIEW).show();
    }
}
