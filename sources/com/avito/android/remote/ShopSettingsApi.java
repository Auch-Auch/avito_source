package com.avito.android.remote;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.ShopSettings;
import com.avito.android.remote.model.ShopSettingsSave;
import com.avito.android.remote.model.ShopSettingsSelections;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00022\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/ShopSettingsApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ShopSettings;", "getShopSettings", "()Lio/reactivex/rxjava3/core/Observable;", "", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/ShopSettingsSave;", "saveShopSettings", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "context", "id", "Lcom/avito/android/remote/model/ShopSettingsSelections;", "getShopSettingsSelections", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsApi {
    @GET("1/shops/settings")
    @NotNull
    Observable<TypedResult<ShopSettings>> getShopSettings();

    @GET("1/shops/settings/select/{context}")
    @NotNull
    Observable<TypedResult<ShopSettingsSelections>> getShopSettingsSelections(@Path("context") @NotNull String str, @Nullable @Query("id") String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/shops/settings/save")
    Observable<TypedResult<ShopSettingsSave>> saveShopSettings(@FieldMap @NotNull Map<String, String> map);
}
