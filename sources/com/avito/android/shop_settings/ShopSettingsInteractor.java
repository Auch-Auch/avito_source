package com.avito.android.shop_settings;

import com.avito.android.remote.model.ShopSettings;
import com.avito.android.remote.model.ShopSettingsSave;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/ShopSettings;", "getShopSettings", "()Lio/reactivex/Observable;", "", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "items", "Lcom/avito/android/remote/model/ShopSettingsSave;", "saveShopSettings", "(Ljava/util/List;)Lio/reactivex/Observable;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsInteractor {
    @NotNull
    Observable<LoadingState<ShopSettings>> getShopSettings();

    @NotNull
    Observable<LoadingState<ShopSettingsSave>> saveShopSettings(@NotNull List<? extends ShopSettingsItem> list);
}
