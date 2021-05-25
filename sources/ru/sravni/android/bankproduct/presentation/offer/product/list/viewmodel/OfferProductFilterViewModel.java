package ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel;

import a2.g.r.g;
import a7.c.a.a.o.f.b.b.b.a;
import a7.c.a.a.o.f.b.b.b.b;
import a7.c.a.a.o.f.b.b.b.c;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.featuretoggle.config.FeaturesToToggle;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010I\u001a\u00020F¢\u0006\u0004\bL\u0010MJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\tR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R$\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010!R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010!R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020$0#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u001e¨\u0006N"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/OfferProductFilterViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "", "savedSearchID", "", "initWithSavedSearchID", "(Ljava/lang/String;)V", "applyFilters", "()V", "", "sliderValue", "updatedField", "updateFilterSlider", "(Ljava/util/Map;Ljava/lang/String;)V", "snapPointValue", "updateFilterSnapPoint", AnalyticFieldsName.productName, "initProductName", "onCleared", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.OPEN_CHANNEL_LIST, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "k", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "offerProductInteractor", "", "e", "Ljava/util/Map;", "appliedFilterMaps", "c", "Ljava/lang/String;", "Lio/reactivex/subjects/PublishSubject;", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", g.a, "Lio/reactivex/subjects/PublishSubject;", "publishSubject", "i", "lastUpdatedField", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "n", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "l", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "h", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "o", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "resultAnalytic", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "j", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelViewModel", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "p", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "subscription", "getFilterToServer", "()Ljava/util/List;", "filterToServer", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", VKApiConst.Q, "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "d", "filterMaps", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductFilterViewModel extends ViewModel implements IOfferProductFilterViewModel {
    public String c = "";
    public final Map<String, String> d = new LinkedHashMap();
    public final Map<String, String> e = new LinkedHashMap();
    public Disposable f;
    public PublishSubject<List<OfferFilterInfoDomain>> g;
    public String h;
    public String i;
    public final IPanelButtonsController j;
    public final IOfferProductInteractor k;
    public final IErrorLogger l;
    public final IThrowableWrapper m;
    public final IPreviousModuleInfo n;
    public final IResultAnalytic o;
    public final IProductNameDictionary p;
    public final IFeatureToggleRouterDomain q;

    public OfferProductFilterViewModel(@NotNull IPanelButtonsController iPanelButtonsController, @NotNull IOfferProductInteractor iOfferProductInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IResultAnalytic iResultAnalytic, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain) {
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelViewModel");
        Intrinsics.checkParameterIsNotNull(iOfferProductInteractor, "offerProductInteractor");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousModuleInfo");
        Intrinsics.checkParameterIsNotNull(iResultAnalytic, "resultAnalytic");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        this.j = iPanelButtonsController;
        this.k = iOfferProductInteractor;
        this.l = iErrorLogger;
        this.m = iThrowableWrapper;
        this.n = iPreviousModuleInfo;
        this.o = iResultAnalytic;
        this.p = iProductNameDictionary;
        this.q = iFeatureToggleRouterDomain;
    }

    public static final Observable access$getListCount(OfferProductFilterViewModel offerProductFilterViewModel, List list) {
        if (offerProductFilterViewModel.q.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
            return offerProductFilterViewModel.k.getCountOfferProductWithNewParam(offerProductFilterViewModel.c, list);
        }
        return offerProductFilterViewModel.k.getCountOfferProductWithNewParamLegacy(offerProductFilterViewModel.c, list);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductFilterViewModel
    public void applyFilters() {
        this.e.putAll(this.d);
        String str = this.i;
        if (str == null) {
            str = BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR;
        }
        IResultAnalytic iResultAnalytic = this.o;
        String str2 = this.c;
        IProductNameDictionary iProductNameDictionary = this.p;
        String str3 = this.h;
        if (str3 == null) {
            str3 = "";
        }
        iResultAnalytic.sendResultEditEvent(str2, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str3)).getAnalyticProductName(), str, this.n.getPreviousModuleName());
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductFilterViewModel
    @NotNull
    public List<OfferFilterInfoDomain> getFilterToServer() {
        Map<String, String> map = this.d;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new OfferFilterInfoDomain(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductFilterViewModel
    public void initProductName(@Nullable String str) {
        this.h = str;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductFilterViewModel
    public void initWithSavedSearchID(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        this.c = str;
        this.d.clear();
        this.d.putAll(this.e);
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        PublishSubject<List<OfferFilterInfoDomain>> create = PublishSubject.create();
        this.g = create;
        if (create == null) {
            Intrinsics.throwNpe();
        }
        this.f = create.startWith((PublishSubject<List<OfferFilterInfoDomain>>) getFilterToServer()).debounce(500, TimeUnit.MILLISECONDS).distinctUntilChanged().switchMap(new a(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderUpdate
    public void updateFilterSlider(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(map, "sliderValue");
        Intrinsics.checkParameterIsNotNull(str, "updatedField");
        this.d.putAll(map);
        this.i = str;
        PublishSubject<List<OfferFilterInfoDomain>> publishSubject = this.g;
        if (publishSubject != null) {
            publishSubject.onNext(getFilterToServer());
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointUpdate
    public void updateFilterSnapPoint(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(map, "snapPointValue");
        Intrinsics.checkParameterIsNotNull(str, "updatedField");
        this.d.putAll(map);
        this.i = str;
        PublishSubject<List<OfferFilterInfoDomain>> publishSubject = this.g;
        if (publishSubject != null) {
            publishSubject.onNext(getFilterToServer());
        }
    }
}
