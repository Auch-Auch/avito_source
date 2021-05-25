package com.avito.android.tariff.fees_methods.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.tariff.routing.NavigationIcon;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013R\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;", "", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onRetryButtonClick", "()V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/tariff/routing/NavigationIcon;", "getNavigationIconChanges", "()Landroidx/lifecycle/LiveData;", "navigationIconChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getRoutingEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEvents", "getCloseBottomSheetChanges", "closeBottomSheetChanges", "Lcom/avito/android/tariff/fees_methods/viewmodel/HighDemandBottomSheetParams;", "getBottomSheetChanges", "bottomSheetChanges", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenState;", "getProgressChanges", "progressChanges", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface FeeMethodsViewModel {
    @NotNull
    SingleLiveEvent<HighDemandBottomSheetParams> getBottomSheetChanges();

    @NotNull
    SingleLiveEvent<Unit> getCloseBottomSheetChanges();

    @NotNull
    LiveData<NavigationIcon> getNavigationIconChanges();

    @NotNull
    LiveData<LoadingState<FeesScreenState>> getProgressChanges();

    @NotNull
    SingleLiveEvent<DeepLink> getRoutingEvents();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onRetryButtonClick();
}
