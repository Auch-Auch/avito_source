package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.tariff.edit_info.EditInfoFragment;
import kotlin.jvm.functions.Function0;
/* compiled from: java-style lambda group */
/* renamed from: x0  reason: default package */
public final class x0<T> implements Observer<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public x0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(String str) {
        int i = this.a;
        if (i == 0) {
            String str2 = str;
            if (str2 != null) {
                EditInfoFragment.access$getToolbar$p((EditInfoFragment) this.b).setTitle(str2);
            }
        } else if (i == 1) {
            String str3 = str;
            if (str3 != null) {
                SnackbarExtensionsKt.showSnackbar$default((EditInfoFragment) this.b, str3, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, SnackbarType.ERROR, 126, (Object) null);
            }
        } else {
            throw null;
        }
    }
}
