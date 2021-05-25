package com.avito.android.tariff.count.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\nR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0019R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0014R\"\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0019¨\u0006+"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;", "", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onRetryButtonClick", "()V", "onSelectButtonClick", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "onViewCreated", "onDestroyView", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getRoutingEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEvents", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "", "Lcom/avito/conveyor_item/Item;", "getListChanges", "listChanges", "Lcom/avito/android/tariff/count/viewmodel/PricePanelState;", "getPricePanelStateChanges", "pricePanelStateChanges", "", "getMessageEvents", "messageEvents", "Lcom/avito/android/tariff/count/viewmodel/Price;", "getPriceChanges", "priceChanges", "", "getLoadingEvents", "loadingEvents", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffCountViewModel {
    @NotNull
    LiveData<List<Item>> getListChanges();

    @NotNull
    LiveData<Boolean> getLoadingEvents();

    @NotNull
    SingleLiveEvent<String> getMessageEvents();

    @NotNull
    LiveData<LoadingState<Price>> getPriceChanges();

    @NotNull
    LiveData<PricePanelState> getPricePanelStateChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    SingleLiveEvent<DeepLink> getRoutingEvents();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onDestroyView();

    void onRetryButtonClick();

    void onSelectButtonClick();

    void onViewCreated();

    @NotNull
    Kundle saveState();
}
