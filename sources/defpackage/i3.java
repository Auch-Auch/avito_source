package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.shop_settings_select.ShopSettingsSelectFragment;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItem;
/* compiled from: java-style lambda group */
/* renamed from: i3  reason: default package */
public final class i3<T> implements Observer<ShopSettingsSelectionItem> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public i3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(ShopSettingsSelectionItem shopSettingsSelectionItem) {
        int i = this.a;
        if (i == 0) {
            ShopSettingsSelectionItem shopSettingsSelectionItem2 = shopSettingsSelectionItem;
            if (shopSettingsSelectionItem2 != null) {
                ShopSettingsSelectFragment.access$openSelect((ShopSettingsSelectFragment) this.b, shopSettingsSelectionItem2);
            }
        } else if (i == 1) {
            ShopSettingsSelectionItem shopSettingsSelectionItem3 = shopSettingsSelectionItem;
            if (shopSettingsSelectionItem3 != null) {
                ShopSettingsSelectFragment.access$chooseSelect((ShopSettingsSelectFragment) this.b, shopSettingsSelectionItem3);
            }
        } else {
            throw null;
        }
    }
}
