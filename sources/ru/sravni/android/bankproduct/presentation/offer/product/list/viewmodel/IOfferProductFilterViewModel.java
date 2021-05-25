package ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderUpdate;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointUpdate;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\u0007R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderUpdate;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointUpdate;", "", "savedSearchID", "", "initWithSavedSearchID", "(Ljava/lang/String;)V", "applyFilters", "()V", AnalyticFieldsName.productName, "initProductName", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "getFilterToServer", "()Ljava/util/List;", "filterToServer", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductFilterViewModel extends IFilterSliderUpdate, IFilterSnapPointUpdate {
    void applyFilters();

    @NotNull
    List<OfferFilterInfoDomain> getFilterToServer();

    void initProductName(@Nullable String str);

    void initWithSavedSearchID(@Nullable String str);
}
