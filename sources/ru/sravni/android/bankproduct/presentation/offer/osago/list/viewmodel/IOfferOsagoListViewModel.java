package ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions;
import ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
import ru.sravni.android.bankproduct.utils.navigation.entity.OsagoNavOffersInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0014R\u0016\u0010)\u001a\u00020&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0014R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0014¨\u0006-"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoListViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/IOfferRetryErrorViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;", "Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOffersInfo;", "osagoNavOffersInfo", "", "initOsagoInfo", "(Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOffersInfo;)V", "onRefresh", "()V", "checkDate", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", "getDescriptionViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", "descriptionViewModel", "Landroidx/lifecycle/LiveData;", "", "getTitleInfo", "()Landroidx/lifecycle/LiveData;", "titleInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "getListInfoViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "listInfoViewModel", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "getFilterViewModel", "()Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "filterViewModel", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "getBarrelDayViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "barrelDayViewModel", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "getListOsagoDetail", "listOsagoDetail", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "getSwitcherListViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "switcherListViewModel", "", "isWaitingUpdate", "isWaitingList", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferOsagoListViewModel extends IOfferRetryErrorViewModel, ISelectOfferOsago, ISelectFilter, IPanelButtonActions {
    void checkDate();

    @NotNull
    IFilterBarrelDayViewModel getBarrelDayViewModel();

    @NotNull
    IFilterDescriptionViewModel getDescriptionViewModel();

    @NotNull
    IOfferOsagoFilterViewModel getFilterViewModel();

    @NotNull
    IFilterListInfoViewModel getListInfoViewModel();

    @NotNull
    LiveData<List<OfferOsagoItemDomain>> getListOsagoDetail();

    @NotNull
    IFilterSwitcherListViewModel getSwitcherListViewModel();

    @NotNull
    LiveData<String> getTitleInfo();

    void initOsagoInfo(@Nullable OsagoNavOffersInfo osagoNavOffersInfo);

    @NotNull
    LiveData<Boolean> isWaitingList();

    @NotNull
    LiveData<Boolean> isWaitingUpdate();

    void onRefresh();
}
