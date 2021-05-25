package a2.a.a.t2;

import com.avito.android.remote.model.ShopSettingsSave;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
public final class o<T, R> implements Function<LoadingState<? super ShopSettingsSave>, Pair<? extends LoadingState<? super ShopSettingsSave>, ? extends List<? extends ShopSettingsItem>>> {
    public final /* synthetic */ List a;

    public o(List list) {
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends LoadingState<? super ShopSettingsSave>, ? extends List<? extends ShopSettingsItem>> apply(LoadingState<? super ShopSettingsSave> loadingState) {
        LoadingState<? super ShopSettingsSave> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "it");
        return TuplesKt.to(loadingState2, this.a);
    }
}
