package a2.a.a.t2;

import com.avito.android.remote.model.ShopSettings;
import com.avito.android.shop_settings.ShopSettingsViewData;
import com.avito.android.shop_settings.ShopSettingsViewModelImpl;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class p<T, R> implements Function<ShopSettings, ShopSettingsViewData> {
    public final /* synthetic */ ShopSettingsViewModelImpl a;

    public p(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
        this.a = shopSettingsViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ShopSettingsViewData apply(ShopSettings shopSettings) {
        ShopSettings shopSettings2 = shopSettings;
        Intrinsics.checkNotNullParameter(shopSettings2, "it");
        return this.a.v.convert(shopSettings2);
    }
}
