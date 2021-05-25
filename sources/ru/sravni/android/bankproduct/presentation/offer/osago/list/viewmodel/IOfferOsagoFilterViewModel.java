package ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayUpdate;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListUpdate;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayUpdate;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListUpdate;", "", "savedSearchID", AnalyticFieldsName.productName, "", "initFilterViewModel", "(Ljava/lang/String;Ljava/lang/String;)V", "applyFilters", "()V", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "getFilterToServer", "()Ljava/util/List;", "filterToServer", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferOsagoFilterViewModel extends IFilterBarrelDayUpdate, IFilterSwitcherListUpdate {
    void applyFilters();

    @NotNull
    List<OfferFilterInfoDomain> getFilterToServer();

    void initFilterViewModel(@Nullable String str, @Nullable String str2);
}
