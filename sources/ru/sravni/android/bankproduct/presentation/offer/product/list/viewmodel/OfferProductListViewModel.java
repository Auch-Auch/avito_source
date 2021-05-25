package ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel;

import a2.g.r.g;
import a7.c.a.a.o.f.b.b.b.f;
import a7.c.a.a.o.f.b.b.b.h;
import a7.c.a.a.o.f.b.b.b.i;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKScopes;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.browser.BrowserAnalyticOpenInfo;
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductListDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusNavInfo;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.featuretoggle.config.FeaturesToToggle;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.presentation.offer.NullOfferProductOrderIDGetStatusError;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailDomainWithLogoInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.DataToOpenChat;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoAnalytic;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoFromList;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.SlidingUpPanelSetupInfo;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItemKt;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum;
import ru.sravni.android.bankproduct.utils.filter.entity.UnknownFilterItemException;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import ru.sravni.android.bankproduct.utils.navigation.entity.ProductNavOffersInfo;
import ru.sravni.android.bankproduct.utils.product.ProductUtilKt;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
import ru.sravni.android.bankproduct.utils.svg.ILogoLoadCallback;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010F\u001a\u00020C\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010s\u001a\u00020p\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010y\u001a\u00020t\u0012\u0006\u0010Q\u001a\u00020L\u0012\u0006\u0010i\u001a\u00020d\u0012\u0007\u0010\u0001\u001a\u00020~\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010`\u001a\u00020]\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\rJ\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\"\u0010\u001fJ\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0019J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u0019J\u000f\u0010)\u001a\u00020\u0007H\u0014¢\u0006\u0004\b)\u0010\u0019R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00103\u001a\u00020.8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R(\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00100\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\"\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u00106\u001a\u0004\b>\u00108R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u00106\u001a\u0004\bK\u00108R\u001c\u0010Q\u001a\u00020L8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010X\u001a\b\u0012\u0004\u0012\u00020.0\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bV\u00106\u001a\u0004\bW\u00108R\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\"\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u00106\u001a\u0004\ba\u00108R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010i\u001a\u00020d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\"\u0010m\u001a\b\u0012\u0004\u0012\u00020j0\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bk\u00106\u001a\u0004\bl\u00108R\u0018\u0010o\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010IR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u001c\u0010y\u001a\u00020t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020z0\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001R$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b\u0012\u00106\u001a\u0005\b\u0001\u00108R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\u00038\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00106\u001a\u0005\b\u0001\u00108R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u00100R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006 \u0001"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/OfferProductListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductListViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "waitingLiveData", "needSendAnalytic", "", "e", "(Landroidx/lifecycle/MutableLiveData;Z)V", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "filterItem", "c", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;)V", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;", VKScopes.OFFERS, "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "d", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;)Ljava/util/List;", "Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "productProductNavOffersInfo", "initOfferProductNavInfo", "(Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;)V", "updateList", "()V", "repeatClick", "onRefresh", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "offerDomain", "clickProduct", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;)V", "filterClicked", "offerProductDetailDomain", "sendOffer", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;", "offerProductActionInfo", "getProductActionClick", "(Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;)V", "applyClicked", "closeClicked", "onCleared", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "x", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelButtonsController", "", "j", "Ljava/lang/String;", "getLoadDescription", "()Ljava/lang/String;", "loadDescription", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailDomainWithLogoInfo;", "i", "Landroidx/lifecycle/MutableLiveData;", "getListOfferProductItem", "()Landroidx/lifecycle/MutableLiveData;", "listOfferProductItem", "f", "getErrorOccurred", "errorOccurred", g.a, "isEmptyListOffer", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "C", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "offerAnalytic", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "t", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lio/reactivex/disposables/Disposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/Disposable;", "subscription", "isWaitingList", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "z", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "getSliderViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "sliderViewModel", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "w", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "panelController", "h", "getTitleInfo", "titleInfo", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "D", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "resultAnalytic", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", ExifInterface.LONGITUDE_EAST, "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "isWaitingUpdate", "n", "Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", "getSnapPointViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", "snapPointViewModel", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;", "l", "getSelectedFilterType", "selectedFilterType", VKApiConst.Q, "productSubscription", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", VKApiConst.VERSION, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "y", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "getFilterViewModel", "()Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;", "filterViewModel", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "p", "Ljava/util/List;", "listFilter", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "B", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousInfo", "isWaitingSend", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "F", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "k", "getFilterInfo", "filterInfo", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "r", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "o", "savedSearchID", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "u", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "G", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "chatInteractor", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "s", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "offerProductInteractor", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductFilterViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListViewModel extends ViewModel implements IOfferProductListViewModel {
    @NotNull
    public final IFilterSnapPointViewModel A;
    public final IPreviousModuleInfoController B;
    public final IOfferAnalytic C;
    public final IResultAnalytic D;
    public final IProductNameDictionary E;
    public final IFeatureToggleRouterDomain F;
    public final IChatInteractor G;
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> h = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<List<OfferProductDetailDomainWithLogoInfo>> i = new MutableLiveData<>();
    @NotNull
    public final String j;
    @NotNull
    public final MutableLiveData<List<FilterItem>> k;
    @NotNull
    public final MutableLiveData<FilterTypeEnum> l;
    public Disposable m;
    public ProductNavOffersInfo n;
    public String o;
    public List<OfferFilterInfoDomain> p;
    public Disposable q;
    public final INavigator r;
    public final IOfferProductInteractor s;
    public final IErrorLogger t;
    public final IErrorHandlerWithShow u;
    public final IThrowableWrapper v;
    public final ISlidingUpPanelController w;
    public final IPanelButtonsController x;
    @NotNull
    public final IOfferProductFilterViewModel y;
    @NotNull
    public final IFilterSliderViewModel z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterTypeEnum.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            FilterTypeEnum filterTypeEnum = FilterTypeEnum.SLIDER;
            iArr[0] = 1;
            FilterTypeEnum filterTypeEnum2 = FilterTypeEnum.SNAP_POINT;
            iArr[1] = 2;
        }
    }

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ OfferProductListViewModel a;

        public a(OfferProductListViewModel offerProductListViewModel) {
            this.a = offerProductListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            OfferProductListViewModel.access$initSavedSearchID(this.a, str);
        }
    }

    public static final class b<T> implements Consumer<OfferProductListDomain> {
        public final /* synthetic */ OfferProductListViewModel a;
        public final /* synthetic */ MutableLiveData b;
        public final /* synthetic */ boolean c;

        public b(OfferProductListViewModel offerProductListViewModel, MutableLiveData mutableLiveData, boolean z) {
            this.a = offerProductListViewModel;
            this.b = mutableLiveData;
            this.c = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferProductListDomain offerProductListDomain) {
            OfferProductListDomain offerProductListDomain2 = offerProductListDomain;
            MutableLiveData mutableLiveData = this.b;
            Boolean bool = Boolean.FALSE;
            mutableLiveData.setValue(bool);
            this.a.isWaitingList().setValue(bool);
            OfferProductListViewModel offerProductListViewModel = this.a;
            Intrinsics.checkExpressionValueIsNotNull(offerProductListDomain2, "offerProductListDomain");
            OfferProductListViewModel.access$setValueFromOfferProductInfoAction(offerProductListViewModel, offerProductListDomain2, this.c);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferProductListViewModel a;
        public final /* synthetic */ MutableLiveData b;
        public final /* synthetic */ boolean c;

        public c(OfferProductListViewModel offerProductListViewModel, MutableLiveData mutableLiveData, boolean z) {
            this.a = offerProductListViewModel;
            this.b = mutableLiveData;
            this.c = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.b.setValue(Boolean.FALSE);
            OfferProductListViewModel.access$uncriticalErrorOnRequestAction(this.a, th, this.c);
        }
    }

    public static final class d<T> implements Consumer<OfferProductListDomain> {
        public final /* synthetic */ OfferProductListViewModel a;

        public d(OfferProductListViewModel offerProductListViewModel) {
            this.a = offerProductListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferProductListDomain offerProductListDomain) {
            OfferProductListDomain offerProductListDomain2 = offerProductListDomain;
            this.a.x.setPanelClickedActions(this.a);
            OfferProductListViewModel offerProductListViewModel = this.a;
            Intrinsics.checkExpressionValueIsNotNull(offerProductListDomain2, "offerProductListDomain");
            OfferProductListViewModel.access$setValueFromOfferProductInfoAction(offerProductListViewModel, offerProductListDomain2, true);
            this.a.isWaitingList().setValue(Boolean.FALSE);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferProductListViewModel a;

        public e(OfferProductListViewModel offerProductListViewModel) {
            this.a = offerProductListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            String str;
            this.a.t.logError(MessagePriority.ERROR, this.a.v.wrap(th));
            this.a.getErrorOccurred().setValue(Boolean.TRUE);
            IResultAnalytic iResultAnalytic = this.a.D;
            IProductNameDictionary iProductNameDictionary = this.a.E;
            ProductNavOffersInfo productNavOffersInfo = this.a.n;
            if (productNavOffersInfo == null || (str = productNavOffersInfo.getProductName()) == null) {
                str = "";
            }
            String analyticProductName = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str)).getAnalyticProductName();
            String previousModuleName = this.a.B.getPreviousModuleName();
            ProductNavOffersInfo productNavOffersInfo2 = this.a.n;
            IResultAnalytic.DefaultImpls.sendResultFailEvent$default(iResultAnalytic, BaseAnalyticKt.ANALYTIC_FAIL_SERVER, analyticProductName, null, previousModuleName, productNavOffersInfo2 != null ? Boolean.valueOf(productNavOffersInfo2.isPush()) : null, 4, null);
        }
    }

    public OfferProductListViewModel(@NotNull INavigator iNavigator, @NotNull IOfferProductInteractor iOfferProductInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ISlidingUpPanelController iSlidingUpPanelController, @NotNull IPanelButtonsController iPanelButtonsController, @NotNull IOfferProductFilterViewModel iOfferProductFilterViewModel, @NotNull IFilterSliderViewModel iFilterSliderViewModel, @NotNull IFilterSnapPointViewModel iFilterSnapPointViewModel, @NotNull IPreviousModuleInfoController iPreviousModuleInfoController, @NotNull IOfferAnalytic iOfferAnalytic, @NotNull IResultAnalytic iResultAnalytic, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain, @NotNull IChatInteractor iChatInteractor, @NotNull IResourceProvider iResourceProvider) {
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
        this.r = iNavigator;
        this.s = iOfferProductInteractor;
        this.t = iErrorLogger;
        this.u = iErrorHandlerWithShow;
        this.v = iThrowableWrapper;
        this.w = iSlidingUpPanelController;
        this.x = iPanelButtonsController;
        this.y = iOfferProductFilterViewModel;
        this.z = iFilterSliderViewModel;
        this.A = iFilterSnapPointViewModel;
        this.B = iPreviousModuleInfoController;
        this.C = iOfferAnalytic;
        this.D = iResultAnalytic;
        this.E = iProductNameDictionary;
        this.F = iFeatureToggleRouterDomain;
        this.G = iChatInteractor;
        this.j = iResourceProvider.getString(R.string.find_best_offers);
        this.k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.p = CollectionsKt__CollectionsKt.emptyList();
        this.q = iOfferProductInteractor.getSavedSearchID().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
    }

    public static final OfferProductStatusNavInfo access$createNavInfo(OfferProductListViewModel offerProductListViewModel, OfferProductStatusDomain offerProductStatusDomain) {
        Objects.requireNonNull(offerProductListViewModel);
        return new OfferProductStatusNavInfo(null, offerProductStatusDomain, 1, null);
    }

    public static final void access$initSavedSearchID(OfferProductListViewModel offerProductListViewModel, String str) {
        offerProductListViewModel.o = str;
    }

    public static final void access$setValueFromOfferProductInfoAction(OfferProductListViewModel offerProductListViewModel, OfferProductListDomain offerProductListDomain, boolean z2) {
        Boolean bool;
        String str;
        String productName;
        OfferProductDetailInfoDomain detailInfo;
        OfferProductDisplaySettingsDomain displaySettings;
        offerProductListViewModel.getTitleInfo().setValue(offerProductListDomain.getTopHeaderTitle());
        offerProductListViewModel.isEmptyListOffer().setValue(Boolean.valueOf(offerProductListDomain.getListOffers().isEmpty()));
        MutableLiveData<List<OfferProductDetailDomainWithLogoInfo>> listOfferProductItem = offerProductListViewModel.getListOfferProductItem();
        List<OfferProductItemDomain> listOffers = offerProductListDomain.getListOffers();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(listOffers, 10));
        Iterator<T> it = listOffers.iterator();
        while (true) {
            bool = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            OfferProductDetailDomain offerDomain = next.getOfferDomain();
            arrayList.add(new OfferProductDetailDomainWithLogoInfo(next, new LogoInfo((offerDomain == null || (detailInfo = offerDomain.getDetailInfo()) == null || (displaySettings = detailInfo.getDisplaySettings()) == null) ? null : displaySettings.getBankLogoUrlSVG(), ILogoLoadCallback.Companion.createDefaultCallback$default(ILogoLoadCallback.Companion, offerProductListViewModel.t, null, 2, null))));
        }
        listOfferProductItem.setValue(arrayList);
        MutableLiveData<List<FilterItem>> filterInfo = offerProductListViewModel.getFilterInfo();
        List<OfferFilterDomain> filters = offerProductListDomain.getFilters();
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(filters, 10));
        Iterator<T> it2 = filters.iterator();
        while (it2.hasNext()) {
            arrayList2.add(FilterItemKt.createFilterItem(it2.next()));
        }
        filterInfo.setValue(arrayList2);
        if (z2) {
            List<OfferProductDisplaySettingsDomain> d2 = offerProductListViewModel.d(offerProductListDomain);
            IResultAnalytic iResultAnalytic = offerProductListViewModel.D;
            String savedSearchID = offerProductListDomain.getSavedSearchID();
            IProductNameDictionary iProductNameDictionary = offerProductListViewModel.E;
            ProductNavOffersInfo productNavOffersInfo = offerProductListViewModel.n;
            String str2 = "";
            if (productNavOffersInfo == null || (str = productNavOffersInfo.getProductName()) == null) {
                str = str2;
            }
            String analyticProductName = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str)).getAnalyticProductName();
            int size = ((ArrayList) d2).size();
            String previousModuleName = offerProductListViewModel.B.getPreviousModuleName();
            ProductNavOffersInfo productNavOffersInfo2 = offerProductListViewModel.n;
            if (productNavOffersInfo2 != null) {
                bool = Boolean.valueOf(productNavOffersInfo2.isPush());
            }
            IResultAnalytic.DefaultImpls.sendResultOpenEvent$default(iResultAnalytic, savedSearchID, analyticProductName, size, null, previousModuleName, bool, 8, null);
            List<OfferProductDisplaySettingsDomain> d3 = offerProductListViewModel.d(offerProductListDomain);
            ArrayList arrayList3 = (ArrayList) d3;
            if (!arrayList3.isEmpty()) {
                IOfferAnalytic iOfferAnalytic = offerProductListViewModel.C;
                String savedSearchID2 = offerProductListDomain.getSavedSearchID();
                IProductNameDictionary iProductNameDictionary2 = offerProductListViewModel.E;
                ProductNavOffersInfo productNavOffersInfo3 = offerProductListViewModel.n;
                if (!(productNavOffersInfo3 == null || (productName = productNavOffersInfo3.getProductName()) == null)) {
                    str2 = productName;
                }
                String analyticProductName2 = ((ProductDictionaryInfoDomain) iProductNameDictionary2.get(str2)).getAnalyticProductName();
                int size2 = arrayList3.size();
                ArrayList arrayList4 = new ArrayList(t6.n.e.collectionSizeOrDefault(d3, 10));
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(((OfferProductDisplaySettingsDomain) it3.next()).getBankName());
                }
                List distinct = CollectionsKt___CollectionsKt.distinct(arrayList4);
                ArrayList arrayList5 = new ArrayList(t6.n.e.collectionSizeOrDefault(d3, 10));
                Iterator it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain = (OfferProductDisplaySettingsDomain) it4.next();
                    arrayList5.add(new Pair(offerProductDisplaySettingsDomain.getBankName(), offerProductDisplaySettingsDomain.getOfferTitle()));
                }
                IOfferAnalytic.DefaultImpls.offerShow$default(iOfferAnalytic, savedSearchID2, analyticProductName2, size2, distinct, arrayList5, null, null, null, offerProductListViewModel.B.getPreviousModuleName(), 224, null);
            }
        }
    }

    public static final void access$uncriticalErrorOnRequestAction(OfferProductListViewModel offerProductListViewModel, Throwable th, boolean z2) {
        String str;
        offerProductListViewModel.isWaitingSend().setValue(Boolean.FALSE);
        offerProductListViewModel.u.handleError(offerProductListViewModel.v.wrap(th));
        if (z2) {
            IResultAnalytic iResultAnalytic = offerProductListViewModel.D;
            IProductNameDictionary iProductNameDictionary = offerProductListViewModel.E;
            ProductNavOffersInfo productNavOffersInfo = offerProductListViewModel.n;
            if (productNavOffersInfo == null || (str = productNavOffersInfo.getProductName()) == null) {
                str = "";
            }
            IResultAnalytic.DefaultImpls.sendResultFailEvent$default(iResultAnalytic, BaseAnalyticKt.ANALYTIC_FAIL_SERVER, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str)).getAnalyticProductName(), null, offerProductListViewModel.B.getPreviousModuleName(), null, 20, null);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions
    public void applyClicked() {
        getFilterViewModel().applyFilters();
        this.p = getFilterViewModel().getFilterToServer();
        e(isWaitingUpdate(), true);
    }

    public final void c(FilterItem filterItem) {
        String str;
        int ordinal = filterItem.getType().ordinal();
        if (ordinal == 0) {
            this.x.setPanelSetupInfo(new SlidingUpPanelSetupInfo(null, Integer.valueOf(R.string.cancel), Integer.valueOf(R.string.show_with_count), 1, null));
            getSliderViewModel().initFilterSlider(filterItem.getFilterInfo(), getFilterViewModel());
        } else if (ordinal != 1) {
            IResultAnalytic iResultAnalytic = this.D;
            IProductNameDictionary iProductNameDictionary = this.E;
            ProductNavOffersInfo productNavOffersInfo = this.n;
            if (productNavOffersInfo == null || (str = productNavOffersInfo.getProductName()) == null) {
                str = "";
            }
            IResultAnalytic.DefaultImpls.sendResultFailEvent$default(iResultAnalytic, BaseAnalyticKt.ANALYTIC_FAIL_MODULE, ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str)).getAnalyticProductName(), null, this.B.getPreviousModuleName(), null, 20, null);
            throw new UnknownFilterItemException(filterItem);
        } else {
            this.x.setPanelSetupInfo(new SlidingUpPanelSetupInfo(null, Integer.valueOf(R.string.cancel), Integer.valueOf(R.string.show_with_count), 1, null));
            getSnapPointViewModel().initFilterSnapPoint(filterItem.getFilterInfo(), getFilterViewModel());
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.ISelectOfferProduct
    public void clickProduct(@NotNull OfferProductDetailDomain offerProductDetailDomain) {
        String productName;
        Intrinsics.checkParameterIsNotNull(offerProductDetailDomain, "offerDomain");
        String str = this.o;
        String str2 = BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR;
        if (str == null) {
            str = str2;
        }
        ProductNavOffersInfo productNavOffersInfo = this.n;
        if (!(productNavOffersInfo == null || (productName = productNavOffersInfo.getProductName()) == null)) {
            str2 = productName;
        }
        OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic = new OfferProductDetailInfoAnalytic(str, str2, offerProductDetailDomain.getDetailInfo().getDisplaySettings().getBankName(), offerProductDetailDomain.getDetailInfo().getDisplaySettings().getOfferTitle());
        INavigator iNavigator = this.r;
        int i2 = R.id.action_offerProductListFragment_to_offerProductInfoFragment;
        List<OfferFilterInfoDomain> list = this.p;
        ProductNavOffersInfo productNavOffersInfo2 = this.n;
        String conversationID = productNavOffersInfo2 != null ? productNavOffersInfo2.getConversationID() : null;
        if (conversationID == null) {
            Intrinsics.throwNpe();
        }
        ProductNavOffersInfo productNavOffersInfo3 = this.n;
        INavigator.DefaultImpls.route$default(iNavigator, i2, UtilFunctionsKt.toSravniJson(new OfferProductDetailInfo(null, new OfferProductDetailInfoFromList(offerProductDetailInfoAnalytic, list, offerProductDetailDomain, new DataToOpenChat(conversationID, productNavOffersInfo3 != null ? productNavOffersInfo3.getCardID() : null)), 1, null)), null, 4, null);
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions
    public void closeClicked() {
    }

    public final List<OfferProductDisplaySettingsDomain> d(OfferProductListDomain offerProductListDomain) {
        OfferProductDetailInfoDomain detailInfo;
        List<OfferProductItemDomain> listOffers = offerProductListDomain.getListOffers();
        ArrayList<OfferProductItemDomain> arrayList = new ArrayList();
        for (T t2 : listOffers) {
            if (t2.getOfferProductItemEnum() == OfferProductItemEnum.ELEMENT) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (OfferProductItemDomain offerProductItemDomain : arrayList) {
            OfferProductDetailDomain offerDomain = offerProductItemDomain.getOfferDomain();
            OfferProductDisplaySettingsDomain displaySettings = (offerDomain == null || (detailInfo = offerDomain.getDetailInfo()) == null) ? null : detailInfo.getDisplaySettings();
            if (displaySettings != null) {
                arrayList2.add(displaySettings);
            }
        }
        return arrayList2;
    }

    public final void e(MutableLiveData<Boolean> mutableLiveData, boolean z2) {
        Observable<OfferProductListDomain> observable;
        Disposable disposable = this.m;
        if (disposable != null) {
            disposable.dispose();
        }
        String str = this.o;
        if (str != null) {
            mutableLiveData.setValue(Boolean.TRUE);
            if (this.F.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
                observable = this.s.getOfferProductList(str, this.p);
            } else {
                observable = this.s.getOfferProductListLegacy(str, this.p);
            }
            this.m = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, mutableLiveData, z2), new c(this, mutableLiveData, z2));
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter
    public void filterClicked(@NotNull FilterItem filterItem) {
        Intrinsics.checkParameterIsNotNull(filterItem, "filterItem");
        getSelectedFilterType().setValue(filterItem.getType());
        this.x.setPanelEnabledAction(false);
        getFilterViewModel().initWithSavedSearchID(this.o);
        try {
            c(filterItem);
            this.w.showPanel();
        } catch (Throwable th) {
            this.u.handleError(this.v.wrap(th));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public MutableLiveData<Boolean> getErrorOccurred() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public IOfferProductFilterViewModel getFilterViewModel() {
        return this.y;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public String getLoadDescription() {
        return this.j;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.IProductActionGetter
    public void getProductActionClick(@NotNull OfferProductActionInfo offerProductActionInfo) {
        Unit unit;
        String str;
        Intrinsics.checkParameterIsNotNull(offerProductActionInfo, "offerProductActionInfo");
        if (!offerProductActionInfo.isMicroCredit() || offerProductActionInfo.getUrl() == null) {
            String orderID = offerProductActionInfo.getOrderID();
            if (orderID != null) {
                isWaitingSend().setValue(Boolean.TRUE);
                Disposable disposable = this.m;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.m = this.s.getProductStatus(orderID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a7.c.a.a.o.f.b.b.b.d(this), new a7.c.a.a.o.f.b.b.b.e(this));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.u.handleError(this.v.wrap(new NullOfferProductOrderIDGetStatusError()));
                return;
            }
            return;
        }
        INavigator iNavigator = this.r;
        String url = offerProductActionInfo.getUrl();
        IProductNameDictionary iProductNameDictionary = this.E;
        ProductNavOffersInfo productNavOffersInfo = this.n;
        if (productNavOffersInfo == null || (str = productNavOffersInfo.getProductName()) == null) {
            str = "";
        }
        INavigator.DefaultImpls.openWebView$default(iNavigator, url, null, new BrowserAnalyticOpenInfo(((ProductDictionaryInfoDomain) iProductNameDictionary.get(str)).getAnalyticProductName(), null, null, null, null, 30, null), 2, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public IFilterSliderViewModel getSliderViewModel() {
        return this.z;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public IFilterSnapPointViewModel getSnapPointViewModel() {
        return this.A;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    public void initOfferProductNavInfo(@Nullable ProductNavOffersInfo productNavOffersInfo) {
        this.n = productNavOffersInfo;
        String str = null;
        this.o = productNavOffersInfo != null ? productNavOffersInfo.getSavedSearchID() : null;
        IOfferProductFilterViewModel filterViewModel = getFilterViewModel();
        if (productNavOffersInfo != null) {
            str = productNavOffersInfo.getProductName();
        }
        filterViewModel.initProductName(str);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.m;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.q;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    public void onRefresh() {
        e(isWaitingUpdate(), false);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    public void repeatClick() {
        getErrorOccurred().setValue(Boolean.FALSE);
        updateList();
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.ISelectOfferProduct
    public void sendOffer(@NotNull OfferProductDetailDomain offerProductDetailDomain) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailDomain, "offerProductDetailDomain");
        if (!this.F.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
            isWaitingSend().setValue(Boolean.TRUE);
            Disposable disposable = this.m;
            if (disposable != null) {
                disposable.dispose();
            }
            this.m = this.s.sendRequestLegacy(offerProductDetailDomain.getRequestParams()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, offerProductDetailDomain), new i(this));
        } else if (offerProductDetailDomain.getExtraInfoRequest()) {
            ProductNavOffersInfo productNavOffersInfo = this.n;
            if ((productNavOffersInfo != null ? productNavOffersInfo.getCardID() : null) != null) {
                ProductNavOffersInfo productNavOffersInfo2 = this.n;
                if (productNavOffersInfo2 == null) {
                    Intrinsics.throwNpe();
                }
                IChatInteractor iChatInteractor = this.G;
                Integer cardID = productNavOffersInfo2.getCardID();
                if (cardID == null) {
                    Intrinsics.throwNpe();
                }
                iChatInteractor.setAnswerInfo(new AnswerInfoDomain(cardID.intValue(), productNavOffersInfo2.getConversationID(), offerProductDetailDomain.getDetailInfo().getDisplaySettings().getOfferTitle(), offerProductDetailDomain.getRequestParamsV2(), null, 16, null));
                this.r.popBackStack(R.id.chatFragment, false);
                return;
            }
            ProductNavOffersInfo productNavOffersInfo3 = this.n;
            if (productNavOffersInfo3 == null) {
                Intrinsics.throwNpe();
            }
            INavigator.DefaultImpls.route$default(this.r, R.id.action_offerProductListFragment_to_chatFragment, UtilFunctionsKt.toSravniJson(new ChatInfo(((ProductDictionaryInfoDomain) this.E.get(ProductUtilKt.getCREDIT_CHAT_NAME())).getChatName(), productNavOffersInfo3.getConversationID(), ((ProductDictionaryInfoDomain) this.E.get(ProductUtilKt.getCREDIT_CHAT_NAME())).getTitle(), null, offerProductDetailDomain.getRequestParamsV2(), false, 40, null)), null, 4, null);
        } else {
            isWaitingSend().setValue(Boolean.TRUE);
            Disposable disposable2 = this.m;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.m = this.s.sendRequest(offerProductDetailDomain.getRequestParamsV2()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, offerProductDetailDomain), new a7.c.a.a.o.f.b.b.b.g(this));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    public void updateList() {
        Unit unit;
        String str;
        Observable<OfferProductListDomain> observable;
        Disposable disposable = this.m;
        if (disposable != null) {
            disposable.dispose();
        }
        String str2 = this.o;
        Boolean bool = null;
        if (str2 != null) {
            getErrorOccurred().setValue(Boolean.FALSE);
            isWaitingList().setValue(Boolean.TRUE);
            if (this.F.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
                observable = this.s.getOfferProductList(str2, this.p);
            } else {
                observable = this.s.getOfferProductListLegacy(str2, this.p);
            }
            this.m = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.t.logError(MessagePriority.ERROR, this.v.wrap(new NullSavedSearchIDForProductListCameError()));
            getErrorOccurred().setValue(Boolean.TRUE);
            IResultAnalytic iResultAnalytic = this.D;
            IProductNameDictionary iProductNameDictionary = this.E;
            ProductNavOffersInfo productNavOffersInfo = this.n;
            if (productNavOffersInfo == null || (str = productNavOffersInfo.getProductName()) == null) {
                str = "";
            }
            String analyticProductName = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str)).getAnalyticProductName();
            String previousModuleName = this.B.getPreviousModuleName();
            ProductNavOffersInfo productNavOffersInfo2 = this.n;
            if (productNavOffersInfo2 != null) {
                bool = Boolean.valueOf(productNavOffersInfo2.isPush());
            }
            IResultAnalytic.DefaultImpls.sendResultFailEvent$default(iResultAnalytic, BaseAnalyticKt.ANALYTIC_FAIL_MODULE, analyticProductName, null, previousModuleName, bool, 4, null);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter
    @NotNull
    public MutableLiveData<List<FilterItem>> getFilterInfo() {
        return this.k;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public MutableLiveData<List<OfferProductDetailDomainWithLogoInfo>> getListOfferProductItem() {
        return this.i;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter
    @NotNull
    public MutableLiveData<FilterTypeEnum> getSelectedFilterType() {
        return this.l;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public MutableLiveData<String> getTitleInfo() {
        return this.h;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public MutableLiveData<Boolean> isEmptyListOffer() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public MutableLiveData<Boolean> isWaitingList() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public MutableLiveData<Boolean> isWaitingSend() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel
    @NotNull
    public MutableLiveData<Boolean> isWaitingUpdate() {
        return this.e;
    }
}
