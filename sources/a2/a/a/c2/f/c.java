package a2.a.a.c2.f;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Observer<String> {
    public final /* synthetic */ PhonesListFragment a;

    public c(PhonesListFragment phonesListFragment) {
        this.a = phonesListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        Context requireContext = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        new Snackbar(requireContext, str2).show();
    }
}
