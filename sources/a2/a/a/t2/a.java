package a2.a.a.t2;

import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<ShopSettingsSelectItem> {
    public final /* synthetic */ ShopSettingsFragment a;

    public a(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ShopSettingsSelectItem shopSettingsSelectItem) {
        ShopSettingsSelectItem shopSettingsSelectItem2 = shopSettingsSelectItem;
        ShopSettingsFragment shopSettingsFragment = this.a;
        Intrinsics.checkNotNullExpressionValue(shopSettingsSelectItem2, "it");
        ShopSettingsFragment.access$openSelect(shopSettingsFragment, shopSettingsSelectItem2);
    }
}
