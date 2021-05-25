package com.avito.android.shop_settings;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.ShopSettingsConfirmation;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.android.shop_settings_select.ShopSettingsSelectResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.PublishRelay;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bR \u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040!8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0015R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0015R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001aR\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001a¨\u00060"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsViewModel;", "", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectResult;", "result", "", "handleSelectResult", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectResult;)V", "loadContent", "()V", "", "id", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "handleLocationPickerResult", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "onRetryButtonClick", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/remote/model/ShopSettingsConfirmation;", "getConfirmationChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "confirmationChanges", "getGoToLoginChanges", "goToLoginChanges", "Lcom/avito/android/shop_settings/ShopSettingsSaveButtonData;", "getSaveButtonDataChanges", "saveButtonDataChanges", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getSaveButtonClickRelay", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "saveButtonClickRelay", "", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "getListChanges", "listChanges", "getTitleChanges", "titleChanges", "", "getScrollPositionChanges", "scrollPositionChanges", "getMessageChanges", "messageChanges", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsViewModel {
    @NotNull
    SingleLiveEvent<ShopSettingsConfirmation> getConfirmationChanges();

    @NotNull
    SingleLiveEvent<Unit> getGoToLoginChanges();

    @NotNull
    LiveData<List<ShopSettingsItem>> getListChanges();

    @NotNull
    SingleLiveEvent<String> getMessageChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    PublishRelay<Unit> getSaveButtonClickRelay();

    @NotNull
    LiveData<ShopSettingsSaveButtonData> getSaveButtonDataChanges();

    @NotNull
    SingleLiveEvent<Integer> getScrollPositionChanges();

    @NotNull
    LiveData<String> getTitleChanges();

    void handleLocationPickerResult(@NotNull String str, @NotNull AddressParameter.Value value);

    void handleSelectResult(@NotNull ShopSettingsSelectResult shopSettingsSelectResult);

    void loadContent();

    void onRetryButtonClick();

    @NotNull
    Kundle saveState();
}
