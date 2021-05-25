package ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel;

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
import ru.sravni.android.bankproduct.domain.chat.ISelectUserAnswer;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\bP\u0010QJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/OfferOsagoListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.OPEN_CHANNEL_LIST, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "r", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "d", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "panelController", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "n", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "i", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "listInfoViewModel", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "p", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "resultAnalytic", "Lru/sravni/android/bankproduct/domain/chat/ISelectUserAnswer;", "c", "Lru/sravni/android/bankproduct/domain/chat/ISelectUserAnswer;", "chatInteractor", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "j", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "switcherListViewModel", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "o", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "offerAnalytic", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "f", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "filterViewModel", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", g.a, "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", "descriptionViewModel", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "h", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "barrelDayViewModel", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "l", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", VKApiConst.Q, "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousInfo", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "k", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;", "offerOsagoInteractor", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "e", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelButtonsController", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;Lru/sravni/android/bankproduct/domain/chat/ISelectUserAnswer;Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListViewModelFactory implements ViewModelProvider.Factory {
    public final INavigator a;
    public final IOfferOsagoInteractor b;
    public final ISelectUserAnswer c;
    public final ISlidingUpPanelController d;
    public final IPanelButtonsController e;
    public final IOfferOsagoFilterViewModel f;
    public final IFilterDescriptionViewModel g;
    public final IFilterBarrelDayViewModel h;
    public final IFilterListInfoViewModel i;
    public final IFilterSwitcherListViewModel j;
    public final IErrorLogger k;
    public final IErrorHandlerWithShow l;
    public final IThrowableWrapper m;
    public final IProductNameDictionary n;
    public final IOfferAnalytic o;
    public final IResultAnalytic p;
    public final IPreviousModuleInfo q;
    public final IResourceProvider r;

    public OfferOsagoListViewModelFactory(@NotNull INavigator iNavigator, @NotNull IOfferOsagoInteractor iOfferOsagoInteractor, @NotNull ISelectUserAnswer iSelectUserAnswer, @NotNull ISlidingUpPanelController iSlidingUpPanelController, @NotNull IPanelButtonsController iPanelButtonsController, @NotNull IOfferOsagoFilterViewModel iOfferOsagoFilterViewModel, @NotNull IFilterDescriptionViewModel iFilterDescriptionViewModel, @NotNull IFilterBarrelDayViewModel iFilterBarrelDayViewModel, @NotNull IFilterListInfoViewModel iFilterListInfoViewModel, @NotNull IFilterSwitcherListViewModel iFilterSwitcherListViewModel, @NotNull IErrorLogger iErrorLogger, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IOfferAnalytic iOfferAnalytic, @NotNull IResultAnalytic iResultAnalytic, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iOfferOsagoInteractor, "offerOsagoInteractor");
        Intrinsics.checkParameterIsNotNull(iSelectUserAnswer, "chatInteractor");
        Intrinsics.checkParameterIsNotNull(iSlidingUpPanelController, "panelController");
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelButtonsController");
        Intrinsics.checkParameterIsNotNull(iOfferOsagoFilterViewModel, "filterViewModel");
        Intrinsics.checkParameterIsNotNull(iFilterDescriptionViewModel, "descriptionViewModel");
        Intrinsics.checkParameterIsNotNull(iFilterBarrelDayViewModel, "barrelDayViewModel");
        Intrinsics.checkParameterIsNotNull(iFilterListInfoViewModel, "listInfoViewModel");
        Intrinsics.checkParameterIsNotNull(iFilterSwitcherListViewModel, "switcherListViewModel");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(iOfferAnalytic, "offerAnalytic");
        Intrinsics.checkParameterIsNotNull(iResultAnalytic, "resultAnalytic");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousInfo");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.a = iNavigator;
        this.b = iOfferOsagoInteractor;
        this.c = iSelectUserAnswer;
        this.d = iSlidingUpPanelController;
        this.e = iPanelButtonsController;
        this.f = iOfferOsagoFilterViewModel;
        this.g = iFilterDescriptionViewModel;
        this.h = iFilterBarrelDayViewModel;
        this.i = iFilterListInfoViewModel;
        this.j = iFilterSwitcherListViewModel;
        this.k = iErrorLogger;
        this.l = iErrorHandlerWithShow;
        this.m = iThrowableWrapper;
        this.n = iProductNameDictionary;
        this.o = iOfferAnalytic;
        this.p = iResultAnalytic;
        this.q = iPreviousModuleInfo;
        this.r = iResourceProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new OfferOsagoListViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
    }
}
