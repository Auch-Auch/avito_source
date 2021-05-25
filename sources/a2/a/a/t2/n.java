package a2.a.a.t2;

import com.avito.android.shop_settings.ShopSettingsSaveButtonData;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class n<T, R> implements Function<Unit, ShopSettingsSaveButtonData> {
    public final /* synthetic */ ShopSettingsSaveButtonData a;

    public n(ShopSettingsSaveButtonData shopSettingsSaveButtonData) {
        this.a = shopSettingsSaveButtonData;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ShopSettingsSaveButtonData apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        this.a.setLoading(true);
        return this.a;
    }
}
