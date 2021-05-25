package com.avito.android.shop_settings_select;

import androidx.lifecycle.LiveData;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\t\u001a\u00020\u00022\u0019\u0010\b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006¢\u0006\u0002\b\u00070\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR \u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012¨\u0006!"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;", "", "", "onRetryButtonClick", "()V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "Landroidx/lifecycle/LiveData;", "", "Lcom/avito/konveyor/blueprint/Item;", "getListChanges", "()Landroidx/lifecycle/LiveData;", "listChanges", "", "getTitleChanges", "titleChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItem;", "getOpenSelectEvent", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openSelectEvent", "getChooseSelectEvent", "chooseSelectEvent", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsSelectViewModel {
    @NotNull
    SingleLiveEvent<ShopSettingsSelectionItem> getChooseSelectEvent();

    @NotNull
    LiveData<? extends List<Item>> getListChanges();

    @NotNull
    SingleLiveEvent<ShopSettingsSelectionItem> getOpenSelectEvent();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    LiveData<String> getTitleChanges();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onRetryButtonClick();

    @NotNull
    Kundle saveState();
}
