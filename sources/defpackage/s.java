package defpackage;

import android.view.MenuItem;
import androidx.lifecycle.Observer;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.util.MenuItemsKt;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
/* compiled from: java-style lambda group */
/* renamed from: s  reason: default package */
public final class s<T> implements Observer<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public s(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(String str) {
        MenuItem menuItem;
        int i = this.a;
        if (i == 0) {
            String str2 = str;
            if (str2 != null) {
                CheckoutFragment.access$getButton$p((CheckoutFragment) this.b).setText(str2);
            }
        } else if (i == 1) {
            String str3 = str;
            if (str3 != null && (menuItem = ((CheckoutFragment) this.b).g) != null) {
                MenuItemsKt.bindTitle(menuItem, str3);
            }
        } else if (i == 2) {
            String str4 = str;
            if (str4 != null) {
                Views.showSnackBar$default(CheckoutFragment.access$getContentView$p((CheckoutFragment) this.b), str4, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
            }
        } else {
            throw null;
        }
    }
}
