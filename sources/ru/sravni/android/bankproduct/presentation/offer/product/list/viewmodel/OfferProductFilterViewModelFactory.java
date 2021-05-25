package ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b(\u0010)J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/OfferProductFilterViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "offerProductInteractor", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelViewModel", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "h", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "e", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "d", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "f", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "resultAnalytic", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "c", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", g.a, "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductFilterViewModelFactory implements ViewModelProvider.Factory {
    public final IPanelButtonsController a;
    public final IOfferProductInteractor b;
    public final IErrorLogger c;
    public final IThrowableWrapper d;
    public final IPreviousModuleInfo e;
    public final IResultAnalytic f;
    public final IProductNameDictionary g;
    public final IFeatureToggleRouterDomain h;

    public OfferProductFilterViewModelFactory(@NotNull IPanelButtonsController iPanelButtonsController, @NotNull IOfferProductInteractor iOfferProductInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IResultAnalytic iResultAnalytic, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain) {
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelViewModel");
        Intrinsics.checkParameterIsNotNull(iOfferProductInteractor, "offerProductInteractor");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousModuleInfo");
        Intrinsics.checkParameterIsNotNull(iResultAnalytic, "resultAnalytic");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        this.a = iPanelButtonsController;
        this.b = iOfferProductInteractor;
        this.c = iErrorLogger;
        this.d = iThrowableWrapper;
        this.e = iPreviousModuleInfo;
        this.f = iResultAnalytic;
        this.g = iProductNameDictionary;
        this.h = iFeatureToggleRouterDomain;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new OfferProductFilterViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
