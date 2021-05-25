package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
/* compiled from: java-style lambda group */
/* renamed from: v  reason: default package */
public final class v<T> implements Observer<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public v(int i, Object obj) {
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
                ShopSettingsFragment.access$getToolbarTitleView$p((ShopSettingsFragment) this.b).setText(str2);
            }
        } else if (i == 1) {
            String str3 = str;
            if (str3 != null) {
                Views.showSnackBar$default(ShopSettingsFragment.access$getContentView$p((ShopSettingsFragment) this.b), str3, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
            }
        } else {
            throw null;
        }
    }
}
