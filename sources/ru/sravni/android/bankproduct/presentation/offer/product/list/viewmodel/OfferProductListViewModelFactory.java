package ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\bL\u0010MJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/OfferProductListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "i", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "sliderViewModel", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "h", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "filterViewModel", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", "j", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", "snapPointViewModel", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "l", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "offerAnalytic", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "p", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "chatInteractor", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "d", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "f", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "panelController", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", AuthSource.OPEN_CHANNEL_LIST, "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "resultAnalytic", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "c", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", VKApiConst.Q, "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "n", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "o", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "offerProductInteractor", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "k", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousInfo", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", g.a, "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelButtonsController", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListViewModelFactory implements ViewModelProvider.Factory {
    public final INavigator a;
    public final IOfferProductInteractor b;
    public final IErrorLogger c;
    public final IErrorHandlerWithShow d;
    public final IThrowableWrapper e;
    public final ISlidingUpPanelController f;
    public final IPanelButtonsController g;
    public final IOfferProductFilterViewModel h;
    public final IFilterSliderViewModel i;
    public final IFilterSnapPointViewModel j;
    public final IPreviousModuleInfoController k;
    public final IOfferAnalytic l;
    public final IResultAnalytic m;
    public final IProductNameDictionary n;
    public final IFeatureToggleRouterDomain o;
    public final IChatInteractor p;
    public final IResourceProvider q;

    public OfferProductListViewModelFactory(@NotNull INavigator iNavigator, @NotNull IOfferProductInteractor iOfferProductInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ISlidingUpPanelController iSlidingUpPanelController, @NotNull IPanelButtonsController iPanelButtonsController, @NotNull IOfferProductFilterViewModel iOfferProductFilterViewModel, @NotNull IFilterSliderViewModel iFilterSliderViewModel, @NotNull IFilterSnapPointViewModel iFilterSnapPointViewModel, @NotNull IPreviousModuleInfoController iPreviousModuleInfoController, @NotNull IOfferAnalytic iOfferAnalytic, @NotNull IResultAnalytic iResultAnalytic, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain, @NotNull IChatInteractor iChatInteractor, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iOfferProductInteractor, "offerProductInteractor");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iSlidingUpPanelController, "panelController");
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelButtonsController");
        Intrinsics.checkParameterIsNotNull(iOfferProductFilterViewModel, "filterViewModel");
        Intrinsics.checkParameterIsNotNull(iFilterSliderViewModel, "sliderViewModel");
        Intrinsics.checkParameterIsNotNull(iFilterSnapPointViewModel, "snapPointViewModel");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfoController, "previousInfo");
        Intrinsics.checkParameterIsNotNull(iOfferAnalytic, "offerAnalytic");
        Intrinsics.checkParameterIsNotNull(iResultAnalytic, "resultAnalytic");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        Intrinsics.checkParameterIsNotNull(iChatInteractor, "chatInteractor");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.a = iNavigator;
        this.b = iOfferProductInteractor;
        this.c = iErrorLogger;
        this.d = iErrorHandlerWithShow;
        this.e = iThrowableWrapper;
        this.f = iSlidingUpPanelController;
        this.g = iPanelButtonsController;
        this.h = iOfferProductFilterViewModel;
        this.i = iFilterSliderViewModel;
        this.j = iFilterSnapPointViewModel;
        this.k = iPreviousModuleInfoController;
        this.l = iOfferAnalytic;
        this.m = iResultAnalytic;
        this.n = iProductNameDictionary;
        this.o = iFeatureToggleRouterDomain;
        this.p = iChatInteractor;
        this.q = iResourceProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new OfferProductListViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
    }
}
