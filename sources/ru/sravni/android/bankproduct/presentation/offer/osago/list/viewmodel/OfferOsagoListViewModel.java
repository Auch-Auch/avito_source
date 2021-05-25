package ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKScopes;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.ISelectUserAnswer;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoCompanyDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListCompanyDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OsagoCompanyDetailEnum;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.presentation.offer.NullOsagoNavInfoCameError;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.SlidingUpPanelSetupInfo;
import ru.sravni.android.bankproduct.utils.date.DateUtilKt;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItemKt;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum;
import ru.sravni.android.bankproduct.utils.filter.entity.UnknownFilterItemException;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import ru.sravni.android.bankproduct.utils.navigation.entity.OsagoNavOffersInfo;
import ru.sravni.android.bankproduct.utils.product.ProductUtilKt;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B¦\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010G\u001a\u00020D\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010}\u001a\u00020x\u0012\u0006\u00107\u001a\u000202\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010a\u001a\u00020\\\u0012\u0007\u0010\u0001\u001a\u00020~\u0012\u0006\u0010w\u001a\u00020t\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010Q\u001a\u00020N\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010s\u001a\u00020p\u0012\b\u0010¡\u0001\u001a\u00030 \u0001¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\u0016J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b'\u0010\u0013J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u000fJ\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\u000fJ\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u000fJ\u000f\u0010,\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010\u000fJ\u000f\u0010-\u001a\u00020\u0005H\u0014¢\u0006\u0004\b-\u0010\u000fR\u001c\u00101\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b/\u00100R\u001c\u00107\u001a\u0002028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R(\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0017088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010C\u001a\b\u0012\u0004\u0012\u00020\u0003088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010:\u001a\u0004\bB\u0010<R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR(\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010:\u001a\u0004\bR\u0010<R\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010a\u001a\u00020\\8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\"\u0010g\u001a\b\u0012\u0004\u0012\u00020\n088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010:\u001a\u0004\bf\u0010<R\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020l0\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u001c\u0010}\u001a\u00020x8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R \u0010\u0001\u001a\u00020~8\u0016@\u0016X\u0004¢\u0006\u000f\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0003088\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b\f\u0010:\u001a\u0005\b\u0001\u0010<R&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001088\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010:\u001a\u0005\b\u0001\u0010<R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0003088\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b\u001b\u0010:\u001a\u0005\b\u0001\u0010<R\"\u0010\u0001\u001a\u00030\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006¤\u0001"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/OfferOsagoListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoListViewModel;", "", "needSendAnalytic", "", "h", "(Z)V", "", "pollingInterval", "", "pollingID", "e", "(JLjava/lang/String;)V", a2.g.r.g.a, "()V", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "filterItem", "c", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;)V", "errorType", "f", "(Ljava/lang/String;)V", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", VKScopes.OFFERS, "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDisplaySettingsDomain;", "d", "(Ljava/util/List;)Ljava/util/List;", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOffersInfo;", "osagoNavOffersInfo", "initOsagoInfo", "(Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOffersInfo;)V", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;", "osagoDetail", "selectedOsago", "(Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;)V", "description", "clickProlongationInfo", "filterClicked", "applyClicked", "closeClicked", "repeatClick", "onRefresh", "checkDate", "onCleared", "Ljava/lang/String;", "getLoadDescription", "()Ljava/lang/String;", "loadDescription", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", "u", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", "getDescriptionViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", "descriptionViewModel", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "getFilterInfo", "()Landroidx/lifecycle/MutableLiveData;", "filterInfo", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;", "p", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;", "offerOsagoInteractor", "getErrorOccurred", "errorOccurred", "Lru/sravni/android/bankproduct/domain/chat/ISelectUserAnswer;", VKApiConst.Q, "Lru/sravni/android/bankproduct/domain/chat/ISelectUserAnswer;", "chatInteractor", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "z", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "l", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOffersInfo;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "getListOsagoDetail", "listOsagoDetail", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "D", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "resultAnalytic", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "s", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelButtonsController", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "w", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "getListInfoViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "listInfoViewModel", "Lio/reactivex/disposables/Disposable;", "k", "Lio/reactivex/disposables/Disposable;", "subscription", "getTitleInfo", "titleInfo", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", AuthSource.OPEN_CHANNEL_LIST, "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", "offerOsagoInfo", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "n", "Ljava/util/List;", "listFilter", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", ExifInterface.LONGITUDE_EAST, "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousInfo", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "y", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "t", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "getFilterViewModel", "()Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "filterViewModel", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "x", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "getSwitcherListViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "switcherListViewModel", "isWaitingUpdate", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;", "j", "getSelectedFilterType", "selectedFilterType", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "B", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "isWaitingList", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", VKApiConst.VERSION, "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "getBarrelDayViewModel", "()Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "barrelDayViewModel", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "o", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "C", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "offerAnalytic", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "r", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "panelController", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;Lru/sravni/android/bankproduct/domain/chat/ISelectUserAnswer;Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListViewModel extends ViewModel implements IOfferOsagoListViewModel {
    public final IThrowableWrapper A;
    public final IProductNameDictionary B;
    public final IOfferAnalytic C;
    public final IResultAnalytic D;
    public final IPreviousModuleInfo E;
    @NotNull
    public final MutableLiveData<String> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<List<OfferOsagoItemDomain>> g = new MutableLiveData<>();
    @NotNull
    public final String h;
    @NotNull
    public final MutableLiveData<List<FilterItem>> i;
    @NotNull
    public final MutableLiveData<FilterTypeEnum> j;
    public Disposable k;
    public OsagoNavOffersInfo l;
    public OfferOsagoListDomain m;
    public List<OfferFilterInfoDomain> n;
    public final INavigator o;
    public final IOfferOsagoInteractor p;
    public final ISelectUserAnswer q;
    public final ISlidingUpPanelController r;
    public final IPanelButtonsController s;
    @NotNull
    public final IOfferOsagoFilterViewModel t;
    @NotNull
    public final IFilterDescriptionViewModel u;
    @NotNull
    public final IFilterBarrelDayViewModel v;
    @NotNull
    public final IFilterListInfoViewModel w;
    @NotNull
    public final IFilterSwitcherListViewModel x;
    public final IErrorLogger y;
    public final IErrorHandlerWithShow z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterTypeEnum.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            FilterTypeEnum filterTypeEnum = FilterTypeEnum.BARREL_DAY;
            iArr[3] = 1;
            FilterTypeEnum filterTypeEnum2 = FilterTypeEnum.LIST_INFO;
            iArr[4] = 2;
            FilterTypeEnum filterTypeEnum3 = FilterTypeEnum.SWITCHER;
            iArr[5] = 3;
        }
    }

    public static final class a<T> implements Consumer<OfferOsagoListDomain> {
        public final /* synthetic */ OfferOsagoListViewModel a;

        public a(OfferOsagoListViewModel offerOsagoListViewModel) {
            this.a = offerOsagoListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferOsagoListDomain offerOsagoListDomain) {
            OfferOsagoListDomain offerOsagoListDomain2 = offerOsagoListDomain;
            this.a.isWaitingList().setValue(Boolean.FALSE);
            OfferOsagoListViewModel offerOsagoListViewModel = this.a;
            Intrinsics.checkExpressionValueIsNotNull(offerOsagoListDomain2, "offerOsagoListDomain");
            OfferOsagoListViewModel.access$setValueFromOfferOsagoInfo(offerOsagoListViewModel, offerOsagoListDomain2, true);
            this.a.s.setPanelClickedActions(this.a);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferOsagoListViewModel a;

        public b(OfferOsagoListViewModel offerOsagoListViewModel) {
            this.a = offerOsagoListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.f(BaseAnalyticKt.ANALYTIC_FAIL_SERVER);
            this.a.y.logError(MessagePriority.ERROR, this.a.A.wrap(th));
            this.a.getErrorOccurred().setValue(Boolean.TRUE);
        }
    }

    public static final class c<T, R> implements Function<T, ObservableSource<? extends R>> {
        public final /* synthetic */ OfferOsagoListViewModel a;
        public final /* synthetic */ String b;

        public c(OfferOsagoListViewModel offerOsagoListViewModel, String str) {
            this.a = offerOsagoListViewModel;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Long) obj, "it");
            return this.a.p.getPollingListCompany(this.b);
        }
    }

    public static final class d<T> implements Consumer<OfferOsagoListCompanyDomain> {
        public final /* synthetic */ OfferOsagoListViewModel a;

        public d(OfferOsagoListViewModel offerOsagoListViewModel) {
            this.a = offerOsagoListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferOsagoListCompanyDomain offerOsagoListCompanyDomain) {
            OfferOsagoListCompanyDomain offerOsagoListCompanyDomain2 = offerOsagoListCompanyDomain;
            OfferOsagoListViewModel offerOsagoListViewModel = this.a;
            this.a.getListOsagoDetail().setValue(OfferOsagoListViewModel.access$getSortListItem(this.a, OfferOsagoListViewModel.access$getUpdateListItem(offerOsagoListViewModel, offerOsagoListViewModel.getListOsagoDetail().getValue(), offerOsagoListCompanyDomain2.getListCompany())));
            String pollingStatus = offerOsagoListCompanyDomain2.getPollingStatus();
            int hashCode = pollingStatus.hashCode();
            if (hashCode != -1411655086) {
                if (hashCode != -673660814) {
                    if (hashCode == 96784904 && pollingStatus.equals("error")) {
                        this.a.g();
                        this.a.y.logError(MessagePriority.ERROR, this.a.A.wrap(new OsagoPollingStatusError()));
                    }
                } else if (pollingStatus.equals("finished")) {
                    OfferOsagoListViewModel.access$checkCompleteOsagoCompanyDetail(this.a);
                }
            } else if (pollingStatus.equals("inprogress")) {
                this.a.e(offerOsagoListCompanyDomain2.getPollingInterval(), offerOsagoListCompanyDomain2.getPollingID());
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferOsagoListViewModel a;

        public e(OfferOsagoListViewModel offerOsagoListViewModel) {
            this.a = offerOsagoListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.g();
            this.a.y.logError(MessagePriority.ERROR, this.a.A.wrap(th));
        }
    }

    public static final class f<T> implements Consumer<OfferOsagoListDomain> {
        public final /* synthetic */ OfferOsagoListViewModel a;
        public final /* synthetic */ boolean b;

        public f(OfferOsagoListViewModel offerOsagoListViewModel, boolean z) {
            this.a = offerOsagoListViewModel;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferOsagoListDomain offerOsagoListDomain) {
            OfferOsagoListDomain offerOsagoListDomain2 = offerOsagoListDomain;
            this.a.isWaitingUpdate().setValue(Boolean.FALSE);
            OfferOsagoListViewModel offerOsagoListViewModel = this.a;
            Intrinsics.checkExpressionValueIsNotNull(offerOsagoListDomain2, "offerOsagoListDomain");
            OfferOsagoListViewModel.access$setValueFromOfferOsagoInfo(offerOsagoListViewModel, offerOsagoListDomain2, this.b);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferOsagoListViewModel a;

        public g(OfferOsagoListViewModel offerOsagoListViewModel, boolean z) {
            this.a = offerOsagoListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.isWaitingUpdate().setValue(Boolean.FALSE);
            this.a.z.handleError(this.a.A.wrap(th));
        }
    }

    public OfferOsagoListViewModel(@NotNull INavigator iNavigator, @NotNull IOfferOsagoInteractor iOfferOsagoInteractor, @NotNull ISelectUserAnswer iSelectUserAnswer, @NotNull ISlidingUpPanelController iSlidingUpPanelController, @NotNull IPanelButtonsController iPanelButtonsController, @NotNull IOfferOsagoFilterViewModel iOfferOsagoFilterViewModel, @NotNull IFilterDescriptionViewModel iFilterDescriptionViewModel, @NotNull IFilterBarrelDayViewModel iFilterBarrelDayViewModel, @NotNull IFilterListInfoViewModel iFilterListInfoViewModel, @NotNull IFilterSwitcherListViewModel iFilterSwitcherListViewModel, @NotNull IErrorLogger iErrorLogger, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IOfferAnalytic iOfferAnalytic, @NotNull IResultAnalytic iResultAnalytic, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IResourceProvider iResourceProvider) {
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
        this.o = iNavigator;
        this.p = iOfferOsagoInteractor;
        this.q = iSelectUserAnswer;
        this.r = iSlidingUpPanelController;
        this.s = iPanelButtonsController;
        this.t = iOfferOsagoFilterViewModel;
        this.u = iFilterDescriptionViewModel;
        this.v = iFilterBarrelDayViewModel;
        this.w = iFilterListInfoViewModel;
        this.x = iFilterSwitcherListViewModel;
        this.y = iErrorLogger;
        this.z = iErrorHandlerWithShow;
        this.A = iThrowableWrapper;
        this.B = iProductNameDictionary;
        this.C = iOfferAnalytic;
        this.D = iResultAnalytic;
        this.E = iPreviousModuleInfo;
        this.h = iResourceProvider.getString(R.string.find_best_offers);
        this.i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.n = CollectionsKt__CollectionsKt.emptyList();
    }

    public static final void access$checkCompleteOsagoCompanyDetail(OfferOsagoListViewModel offerOsagoListViewModel) {
        List<OfferOsagoItemDomain> value = offerOsagoListViewModel.getListOsagoDetail().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "listOsagoDetail.value ?: listOf()");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = value.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t2 = next;
            if (t2.getOfferDomain() == null || t2.getOfferDomain().getStatus() == OsagoCompanyDetailEnum.OSAGO_SUCCESS) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            offerOsagoListViewModel.g();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x005c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List access$getSortListItem(ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel r6, java.util.List r7) {
        /*
            java.util.Objects.requireNonNull(r6)
            r6 = 1
            r0 = 0
            if (r7 == 0) goto L_0x002e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r7.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()
            r4 = r3
            ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain r4 = (ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain) r4
            ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum r4 = r4.getOfferOsagoItemEnum()
            ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum r5 = ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum.ELEMENT
            if (r4 != r5) goto L_0x0027
            r4 = 1
            goto L_0x0028
        L_0x0027:
            r4 = 0
        L_0x0028:
            if (r4 == 0) goto L_0x0010
            r1.add(r3)
            goto L_0x0010
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r7 == 0) goto L_0x0058
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x003a:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r7.next()
            r4 = r3
            ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain r4 = (ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain) r4
            ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum r4 = r4.getOfferOsagoItemEnum()
            ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum r5 = ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum.ELEMENT
            if (r4 == r5) goto L_0x0051
            r4 = 1
            goto L_0x0052
        L_0x0051:
            r4 = 0
        L_0x0052:
            if (r4 == 0) goto L_0x003a
            r2.add(r3)
            goto L_0x003a
        L_0x0058:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x005c:
            if (r1 == 0) goto L_0x0075
            ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel$getSortListItem$$inlined$sortedBy$1 r6 = new ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel$getSortListItem$$inlined$sortedBy$1
            r6.<init>()
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r1, r6)
            if (r6 == 0) goto L_0x0075
            ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel$getSortListItem$$inlined$sortedBy$2 r7 = new ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel$getSortListItem$$inlined$sortedBy$2
            r7.<init>()
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r6, r7)
            if (r6 == 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0079:
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r2, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel.access$getSortListItem(ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel, java.util.List):java.util.List");
    }

    public static final List access$getUpdateListItem(OfferOsagoListViewModel offerOsagoListViewModel, List list, List list2) {
        Object obj;
        OfferOsagoItemDomain offerOsagoItemDomain;
        Objects.requireNonNull(offerOsagoListViewModel);
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            OfferOsagoItemDomain offerOsagoItemDomain2 = (OfferOsagoItemDomain) it.next();
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                String productID = ((OfferOsagoCompanyDetailDomain) obj).getProductID();
                OfferOsagoDetailDomain offerDomain = offerOsagoItemDomain2.getOfferDomain();
                if (Intrinsics.areEqual(productID, offerDomain != null ? offerDomain.getProductID() : null)) {
                    break;
                }
            }
            OfferOsagoCompanyDetailDomain offerOsagoCompanyDetailDomain = (OfferOsagoCompanyDetailDomain) obj;
            if (offerOsagoCompanyDetailDomain != null) {
                OfferOsagoDetailDomain offerDomain2 = offerOsagoItemDomain2.getOfferDomain();
                offerOsagoItemDomain = OfferOsagoItemDomain.copy$default(offerOsagoItemDomain2, null, null, offerDomain2 != null ? OfferOsagoDetailDomain.copy$default(offerDomain2, null, null, false, null, offerOsagoCompanyDetailDomain, offerOsagoCompanyDetailDomain.getStatus(), 15, null) : null, 3, null);
            } else {
                offerOsagoItemDomain = null;
            }
            if (offerOsagoItemDomain != null) {
                offerOsagoItemDomain2 = offerOsagoItemDomain;
            }
            arrayList.add(offerOsagoItemDomain2);
        }
        return arrayList;
    }

    public static final void access$setValueFromOfferOsagoInfo(OfferOsagoListViewModel offerOsagoListViewModel, OfferOsagoListDomain offerOsagoListDomain, boolean z2) {
        String productName;
        String productName2;
        offerOsagoListViewModel.m = offerOsagoListDomain;
        offerOsagoListViewModel.getTitleInfo().setValue(offerOsagoListDomain.getTopHeaderTitle());
        offerOsagoListViewModel.getListOsagoDetail().setValue(offerOsagoListDomain.getListOffers());
        MutableLiveData<List<FilterItem>> filterInfo = offerOsagoListViewModel.getFilterInfo();
        List<OfferFilterDomain> filters = offerOsagoListDomain.getFilters();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(filters, 10));
        Iterator<T> it = filters.iterator();
        while (it.hasNext()) {
            arrayList.add(FilterItemKt.createFilterItem(it.next()));
        }
        filterInfo.setValue(arrayList);
        offerOsagoListViewModel.e(offerOsagoListDomain.getPollingInterval(), offerOsagoListDomain.getPollingID());
        if (z2) {
            List<OfferOsagoDisplaySettingsDomain> d2 = offerOsagoListViewModel.d(offerOsagoListDomain.getListOffers());
            IResultAnalytic iResultAnalytic = offerOsagoListViewModel.D;
            String savedSearchID = offerOsagoListDomain.getSavedSearchID();
            OsagoNavOffersInfo osagoNavOffersInfo = offerOsagoListViewModel.l;
            String str = (osagoNavOffersInfo == null || (productName2 = osagoNavOffersInfo.getProductName()) == null) ? BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR : productName2;
            int size = ((ArrayList) d2).size();
            String previousModuleName = offerOsagoListViewModel.E.getPreviousModuleName();
            OsagoNavOffersInfo osagoNavOffersInfo2 = offerOsagoListViewModel.l;
            iResultAnalytic.sendResultOpenEvent(savedSearchID, str, size, Boolean.FALSE, previousModuleName, osagoNavOffersInfo2 != null ? Boolean.valueOf(osagoNavOffersInfo2.isPush()) : null);
            List<OfferOsagoDisplaySettingsDomain> d3 = offerOsagoListViewModel.d(offerOsagoListDomain.getListOffers());
            ArrayList arrayList2 = (ArrayList) d3;
            if (!arrayList2.isEmpty()) {
                IOfferAnalytic iOfferAnalytic = offerOsagoListViewModel.C;
                String savedSearchID2 = offerOsagoListDomain.getSavedSearchID();
                OsagoNavOffersInfo osagoNavOffersInfo3 = offerOsagoListViewModel.l;
                String str2 = (osagoNavOffersInfo3 == null || (productName = osagoNavOffersInfo3.getProductName()) == null) ? BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR : productName;
                int size2 = arrayList2.size();
                ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(d3, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((OfferOsagoDisplaySettingsDomain) it2.next()).getProductName());
                }
                IOfferAnalytic.DefaultImpls.offerShow$default(iOfferAnalytic, savedSearchID2, str2, size2, CollectionsKt___CollectionsKt.distinct(arrayList3), null, "none", Boolean.FALSE, null, offerOsagoListViewModel.E.getPreviousModuleName(), 144, null);
            }
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions
    public void applyClicked() {
        getFilterViewModel().applyFilters();
        this.n = getFilterViewModel().getFilterToServer();
        h(true);
    }

    public final void c(FilterItem filterItem) {
        SlidingUpPanelSetupInfo slidingUpPanelSetupInfo;
        int ordinal = filterItem.getType().ordinal();
        if (ordinal == 3) {
            this.s.setPanelSetupInfo(new SlidingUpPanelSetupInfo(null, Integer.valueOf(R.string.cancel), Integer.valueOf(R.string.recount), 1, null));
            getBarrelDayViewModel().initFilterBarrelDay(filterItem.getFilterInfo(), getFilterViewModel());
        } else if (ordinal == 4) {
            this.s.setPanelSetupInfo(new SlidingUpPanelSetupInfo(null, null, null, 7, null));
            getListInfoViewModel().initFilterListInfo(filterItem.getFilterInfo());
        } else if (ordinal == 5) {
            if (filterItem.getFilterInfo().getEditable()) {
                List<FilterItem.FilterInfo.DetailFilter> detail = filterItem.getFilterInfo().getDetail();
                if (!(detail == null || detail.isEmpty()) && filterItem.getFilterInfo().getDetail().size() > 1) {
                    slidingUpPanelSetupInfo = new SlidingUpPanelSetupInfo(null, Integer.valueOf(R.string.cancel), Integer.valueOf(R.string.recount), 1, null);
                    this.s.setPanelSetupInfo(slidingUpPanelSetupInfo);
                    getSwitcherListViewModel().initFilterSwitcherList(filterItem.getFilterInfo(), getFilterViewModel());
                }
            }
            slidingUpPanelSetupInfo = new SlidingUpPanelSetupInfo(null, null, null, 7, null);
            this.s.setPanelSetupInfo(slidingUpPanelSetupInfo);
            getSwitcherListViewModel().initFilterSwitcherList(filterItem.getFilterInfo(), getFilterViewModel());
        } else {
            f(BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
            throw new UnknownFilterItemException(filterItem);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    public void checkDate() {
        OfferOsagoListDomain offerOsagoListDomain = this.m;
        if (offerOsagoListDomain != null && DateUtilKt.isInvalidDate(DateUtilKt.serverFormat, offerOsagoListDomain.getRecommendedDate(), 4)) {
            initOsagoInfo(this.l);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.ISelectOfferOsago
    public void clickProlongationInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "description");
        getSelectedFilterType().setValue(FilterTypeEnum.DESCRIPTION);
        this.s.setPanelSetupInfo(new SlidingUpPanelSetupInfo(null, Integer.valueOf(R.string.close), null, 5, null));
        getDescriptionViewModel().initFilterDescription(str);
        this.r.showPanel();
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions
    public void closeClicked() {
    }

    public final List<OfferOsagoDisplaySettingsDomain> d(List<OfferOsagoItemDomain> list) {
        ArrayList<OfferOsagoItemDomain> arrayList = new ArrayList();
        for (T t2 : list) {
            if (t2.getOfferOsagoItemEnum() == OfferOsagoItemEnum.ELEMENT) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (OfferOsagoItemDomain offerOsagoItemDomain : arrayList) {
            OfferOsagoDetailDomain offerDomain = offerOsagoItemDomain.getOfferDomain();
            OfferOsagoDisplaySettingsDomain displaySettings = offerDomain != null ? offerDomain.getDisplaySettings() : null;
            if (displaySettings != null) {
                arrayList2.add(displaySettings);
            }
        }
        return arrayList2;
    }

    public final void e(long j2, String str) {
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        this.k = Observable.timer(j2, TimeUnit.MILLISECONDS).flatMap(new c(this, str)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this));
    }

    public final void f(String str) {
        String str2;
        IResultAnalytic iResultAnalytic = this.D;
        OsagoNavOffersInfo osagoNavOffersInfo = this.l;
        if (osagoNavOffersInfo == null || (str2 = osagoNavOffersInfo.getProductName()) == null) {
            str2 = BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR;
        }
        String previousModuleName = this.E.getPreviousModuleName();
        OsagoNavOffersInfo osagoNavOffersInfo2 = this.l;
        iResultAnalytic.sendResultFailEvent(str, str2, Boolean.FALSE, previousModuleName, osagoNavOffersInfo2 != null ? Boolean.valueOf(osagoNavOffersInfo2.isPush()) : null);
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter
    public void filterClicked(@NotNull FilterItem filterItem) {
        Intrinsics.checkParameterIsNotNull(filterItem, "filterItem");
        getSelectedFilterType().setValue(filterItem.getType());
        this.s.setPanelEnabledAction(false);
        IOfferOsagoFilterViewModel filterViewModel = getFilterViewModel();
        OsagoNavOffersInfo osagoNavOffersInfo = this.l;
        String str = null;
        String productName = osagoNavOffersInfo != null ? osagoNavOffersInfo.getProductName() : null;
        OsagoNavOffersInfo osagoNavOffersInfo2 = this.l;
        if (osagoNavOffersInfo2 != null) {
            str = osagoNavOffersInfo2.getSavedSearchID();
        }
        filterViewModel.initFilterViewModel(str, productName);
        try {
            c(filterItem);
            this.r.showPanel();
        } catch (Throwable th) {
            this.z.handleError(this.A.wrap(th));
        }
    }

    public final void g() {
        List<OfferOsagoItemDomain> value = getListOsagoDetail().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "listOsagoDetail.value ?: listOf()");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(value, 10));
        for (T t2 : value) {
            if (t2.getOfferDomain() != null && t2.getOfferDomain().getCompanyDetail() == null) {
                t2 = OfferOsagoItemDomain.copy$default(t2, null, null, OfferOsagoDetailDomain.copy$default(t2.getOfferDomain(), null, null, false, null, null, OsagoCompanyDetailEnum.OSAGO_ERROR, 31, null), 3, null);
            }
            arrayList.add(t2);
        }
        getListOsagoDetail().setValue(arrayList);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public IFilterBarrelDayViewModel getBarrelDayViewModel() {
        return this.v;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public IFilterDescriptionViewModel getDescriptionViewModel() {
        return this.u;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public MutableLiveData<Boolean> getErrorOccurred() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public IOfferOsagoFilterViewModel getFilterViewModel() {
        return this.t;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public IFilterListInfoViewModel getListInfoViewModel() {
        return this.w;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public String getLoadDescription() {
        return this.h;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public IFilterSwitcherListViewModel getSwitcherListViewModel() {
        return this.x;
    }

    public final void h(boolean z2) {
        String savedSearchID;
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        OfferOsagoListDomain offerOsagoListDomain = this.m;
        if (offerOsagoListDomain != null && (savedSearchID = offerOsagoListDomain.getSavedSearchID()) != null) {
            isWaitingUpdate().setValue(Boolean.TRUE);
            this.k = this.p.getOsagoListCompany(savedSearchID, this.n).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, z2), new g(this, z2));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    public void initOsagoInfo(@Nullable OsagoNavOffersInfo osagoNavOffersInfo) {
        Unit unit;
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        if (osagoNavOffersInfo != null) {
            this.l = osagoNavOffersInfo;
            getErrorOccurred().setValue(Boolean.FALSE);
            isWaitingList().setValue(Boolean.TRUE);
            this.k = this.p.getOsagoListCompany(osagoNavOffersInfo.getSavedSearchID(), this.n).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), new b(this));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.y.logError(MessagePriority.ERROR, this.A.wrap(new NullOsagoNavInfoCameError()));
            getErrorOccurred().setValue(Boolean.TRUE);
            f(BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    public void onRefresh() {
        h(false);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    public void repeatClick() {
        getErrorOccurred().setValue(Boolean.FALSE);
        initOsagoInfo(this.l);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.ISelectOfferOsago
    public void selectedOsago(@NotNull OfferOsagoDetailDomain offerOsagoDetailDomain) {
        Intrinsics.checkParameterIsNotNull(offerOsagoDetailDomain, "osagoDetail");
        OsagoNavOffersInfo osagoNavOffersInfo = this.l;
        if (osagoNavOffersInfo != null) {
            Map<String, String> map = null;
            if (osagoNavOffersInfo.getCardID() != null) {
                ISelectUserAnswer iSelectUserAnswer = this.q;
                Integer cardID = osagoNavOffersInfo.getCardID();
                if (cardID == null) {
                    Intrinsics.throwNpe();
                }
                int intValue = cardID.intValue();
                String conversationID = osagoNavOffersInfo.getConversationID();
                OfferOsagoCompanyDetailDomain companyDetail = offerOsagoDetailDomain.getCompanyDetail();
                if (companyDetail != null) {
                    map = companyDetail.getRequestParams();
                }
                iSelectUserAnswer.setAnswerInfo(new AnswerInfoDomain(intValue, conversationID, offerOsagoDetailDomain.getDisplaySettings().getProductName(), map, null, 16, null));
                this.o.popBackStack(R.id.chatFragment, false);
                return;
            }
            String conversationID2 = osagoNavOffersInfo.getConversationID();
            OfferOsagoCompanyDetailDomain companyDetail2 = offerOsagoDetailDomain.getCompanyDetail();
            if (companyDetail2 != null) {
                map = companyDetail2.getRequestParams();
            }
            INavigator.DefaultImpls.route$default(this.o, R.id.action_offerOsagoListFragment_to_chatFragment, UtilFunctionsKt.toSravniJson(new ChatInfo(((ProductDictionaryInfoDomain) this.B.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getChatName(), conversationID2, ((ProductDictionaryInfoDomain) this.B.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getTitle(), null, map, false, 40, null)), null, 4, null);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter
    @NotNull
    public MutableLiveData<List<FilterItem>> getFilterInfo() {
        return this.i;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public MutableLiveData<List<OfferOsagoItemDomain>> getListOsagoDetail() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter
    @NotNull
    public MutableLiveData<FilterTypeEnum> getSelectedFilterType() {
        return this.j;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public MutableLiveData<String> getTitleInfo() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public MutableLiveData<Boolean> isWaitingList() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel
    @NotNull
    public MutableLiveData<Boolean> isWaitingUpdate() {
        return this.e;
    }
}
