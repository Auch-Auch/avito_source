package a2.a.a.t2;

import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<ShopSettingsAddressItem> {
    public final /* synthetic */ ShopSettingsFragment a;

    public b(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ShopSettingsAddressItem shopSettingsAddressItem) {
        ShopSettingsAddressItem shopSettingsAddressItem2 = shopSettingsAddressItem;
        ShopSettingsFragment shopSettingsFragment = this.a;
        Intrinsics.checkNotNullExpressionValue(shopSettingsAddressItem2, "it");
        ShopSettingsFragment.access$openLocationPicker(shopSettingsFragment, shopSettingsAddressItem2);
    }
}
