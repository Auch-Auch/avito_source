package com.avito.android.tariff.edit_info.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR \u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000fR\"\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000f¨\u0006("}, d2 = {"Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;", "", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onRetryButtonClick", "()V", "loadData", "Landroidx/lifecycle/LiveData;", "", "getTitleChanges", "()Landroidx/lifecycle/LiveData;", "titleChanges", "Lcom/avito/android/tariff/edit_info/viewmodel/BottomSheetParams;", "getBottomSheetActionChanges", "bottomSheetActionChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getRoutingEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEvents", "", "Lcom/avito/conveyor_item/Item;", "getListChanges", "listChanges", "getCloseBottomSheetChanges", "closeBottomSheetChanges", "getNextTabActionChanges", "nextTabActionChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "getHeaderChanges", "headerChanges", "getErrorChanges", "errorChanges", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface EditInfoViewModel {
    @NotNull
    LiveData<BottomSheetParams> getBottomSheetActionChanges();

    @NotNull
    LiveData<Object> getCloseBottomSheetChanges();

    @NotNull
    LiveData<String> getErrorChanges();

    @NotNull
    LiveData<List<Item>> getHeaderChanges();

    @NotNull
    LiveData<List<Item>> getListChanges();

    @NotNull
    LiveData<Object> getNextTabActionChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    SingleLiveEvent<DeepLink> getRoutingEvents();

    @NotNull
    LiveData<String> getTitleChanges();

    void loadData();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onRetryButtonClick();
}
