package a2.a.a.x.b;

import androidx.lifecycle.Observer;
import com.avito.android.bundles.vas_union.VasUnionFragment;
import com.avito.android.lib.design.button.ButtonsKt;
public final class b<T> implements Observer<String> {
    public final /* synthetic */ VasUnionFragment a;

    public b(VasUnionFragment vasUnionFragment) {
        this.a = vasUnionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        boolean z = true;
        ButtonsKt.bindText(VasUnionFragment.access$getSkipButton$p(this.a), str2, true);
        this.a.a().removeItemDecoration(VasUnionFragment.access$getLastItemDecoration$p(this.a));
        if (!(str2 == null || str2.length() == 0)) {
            z = false;
        }
        if (!z) {
            this.a.a().addItemDecoration(VasUnionFragment.access$getLastItemDecoration$p(this.a));
        }
    }
}
