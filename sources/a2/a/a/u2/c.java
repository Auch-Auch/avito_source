package a2.a.a.u2;

import androidx.lifecycle.Observer;
import com.avito.android.shop_settings_select.ShopSettingsSelectFragment;
public final class c<T> implements Observer<String> {
    public final /* synthetic */ ShopSettingsSelectFragment a;

    public c(ShopSettingsSelectFragment shopSettingsSelectFragment) {
        this.a = shopSettingsSelectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            ShopSettingsSelectFragment.access$getToolbarTitleView$p(this.a).setText(str2);
        }
    }
}
