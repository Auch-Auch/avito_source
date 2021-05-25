package ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailDomainWithLogoInfo;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions;
import ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel;
import ru.sravni.android.bankproduct.utils.navigation.entity.ProductNavOffersInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u0016\u0010&\u001a\u00020#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductListViewModel;", "Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;", "Lru/sravni/android/bankproduct/presentation/offer/IOfferRetryErrorViewModel;", "Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "productProductNavOffersInfo", "", "initOfferProductNavInfo", "(Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;)V", "updateList", "()V", "onRefresh", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "getFilterViewModel", "()Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "filterViewModel", "Landroidx/lifecycle/LiveData;", "", "getTitleInfo", "()Landroidx/lifecycle/LiveData;", "titleInfo", "", "isWaitingUpdate", "isWaitingSend", "isEmptyListOffer", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "getSliderViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "sliderViewModel", "isWaitingList", "", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailDomainWithLogoInfo;", "getListOfferProductItem", "listOfferProductItem", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", "getSnapPointViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", "snapPointViewModel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductListViewModel extends ISelectFilter, ISelectOfferProduct, IPanelButtonActions, IOfferRetryErrorViewModel {
    @NotNull
    IOfferProductFilterViewModel getFilterViewModel();

    @NotNull
    LiveData<List<OfferProductDetailDomainWithLogoInfo>> getListOfferProductItem();

    @NotNull
    IFilterSliderViewModel getSliderViewModel();

    @NotNull
    IFilterSnapPointViewModel getSnapPointViewModel();

    @NotNull
    LiveData<String> getTitleInfo();

    void initOfferProductNavInfo(@Nullable ProductNavOffersInfo productNavOffersInfo);

    @NotNull
    LiveData<Boolean> isEmptyListOffer();

    @NotNull
    LiveData<Boolean> isWaitingList();

    @NotNull
    LiveData<Boolean> isWaitingSend();

    @NotNull
    LiveData<Boolean> isWaitingUpdate();

    void onRefresh();

    void updateList();
}
