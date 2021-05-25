package ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.browser.BrowserAnalyticOpenInfo;
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusNavInfo;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfoKt;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailItemDomainWithLogoInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoAnalytic;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import ru.sravni.android.bankproduct.utils.svg.ILogoLoadCallback;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010\u000b\u001a\u00020J\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010s\u001a\u00020p\u0012\u0006\u00105\u001a\u000202¢\u0006\u0004\bt\u0010uJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0013H\u0016¢\u0006\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR(\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u00108\u001a\u0004\bF\u0010:R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010\u000b\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010d\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bc\u00108\u001a\u0004\bd\u0010:R\"\u0010g\u001a\b\u0012\u0004\u0012\u00020$068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u00108\u001a\u0004\bf\u0010:R\"\u0010k\u001a\b\u0012\u0004\u0012\u00020h068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u00108\u001a\u0004\bj\u0010:R\"\u0010o\u001a\b\u0012\u0004\u0012\u00020l068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bm\u00108\u001a\u0004\bn\u0010:R\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006v"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/OfferProductInfoController;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;", "", "value", "", "setWaitingRetry", "(Z)V", "setWaitingSend", "", OkListener.KEY_EXCEPTION, "errorLogger", "(Ljava/lang/Throwable;)V", "errorServer", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "offerProductDetailDomain", "setValueFromProductInfo", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;)V", "Lkotlin/Function1;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "processResponse", "sendRequestLegacy", "(Lkotlin/jvm/functions/Function1;)V", "sendRequest", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answerInfo", "setAnswerInfo", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "chatInfo", "restoreChat", "(Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;)V", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;", "navInfo", "openProductStatusFragment", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;)V", "", "url", AnalyticFieldsName.productName, "openWebView", "(Ljava/lang/String;Ljava/lang/String;)V", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "analyticInfo", "setAnalyticInfo", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;)V", "openOfferAnalytic", "()V", "offerProductStatusDomain", "sendOfferAnalytic", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;)V", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "t", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "chatInteractor", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "isWaitingRetry", "()Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "offerProductInteractor", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "l", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailItemDomainWithLogoInfo;", "h", "getListOfferProductDetailDomain", "listOfferProductDetailDomain", "j", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "n", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "o", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "p", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lio/reactivex/disposables/Disposable;", "i", "Lio/reactivex/disposables/Disposable;", "subscription", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", VKApiConst.Q, "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "offerAnalytic", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "r", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousModule", "k", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "d", "isWaitingSend", "e", "getTitleInfo", "titleInfo", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "f", "getStatus", "status", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;", g.a, "getOfferProductActionInfo", "offerProductActionInfo", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "s", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductInfoController extends ViewModel implements IOfferProductInfoController {
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<ProductStatusEnum> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<OfferProductActionInfo> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<List<OfferProductDetailItemDomainWithLogoInfo>> h = new MutableLiveData<>();
    public Disposable i;
    public OfferProductDetailDomain j;
    public OfferProductDetailInfoAnalytic k;
    public final INavigator l;
    public final IOfferProductInteractor m;
    public final IErrorLogger n;
    public final IErrorHandlerWithShow o;
    public final IThrowableWrapper p;
    public final IOfferAnalytic q;
    public final IPreviousModuleInfoController r;
    public final IProductNameDictionary s;
    public final IChatInteractor t;

    public static final class a<T> implements Consumer<OfferProductStatusDomain> {
        public final /* synthetic */ Function1 a;

        public a(OfferProductInfoController offerProductInfoController, Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferProductStatusDomain offerProductStatusDomain) {
            OfferProductStatusDomain offerProductStatusDomain2 = offerProductStatusDomain;
            Function1 function1 = this.a;
            Intrinsics.checkExpressionValueIsNotNull(offerProductStatusDomain2, "offerProductStatusDomain");
            function1.invoke(offerProductStatusDomain2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferProductInfoController a;
        public final /* synthetic */ Function1 b;

        public b(OfferProductInfoController offerProductInfoController, Function1 function1) {
            this.a = offerProductInfoController;
            this.b = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.errorServer(th);
        }
    }

    public static final class c<T> implements Consumer<OfferProductStatusDomain> {
        public final /* synthetic */ Function1 a;

        public c(OfferProductInfoController offerProductInfoController, Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferProductStatusDomain offerProductStatusDomain) {
            OfferProductStatusDomain offerProductStatusDomain2 = offerProductStatusDomain;
            Function1 function1 = this.a;
            Intrinsics.checkExpressionValueIsNotNull(offerProductStatusDomain2, "offerProductStatusDomain");
            function1.invoke(offerProductStatusDomain2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferProductInfoController a;
        public final /* synthetic */ Function1 b;

        public d(OfferProductInfoController offerProductInfoController, Function1 function1) {
            this.a = offerProductInfoController;
            this.b = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.errorServer(th);
        }
    }

    public OfferProductInfoController(@NotNull INavigator iNavigator, @NotNull IOfferProductInteractor iOfferProductInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IOfferAnalytic iOfferAnalytic, @NotNull IPreviousModuleInfoController iPreviousModuleInfoController, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IChatInteractor iChatInteractor) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iOfferProductInteractor, "offerProductInteractor");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iOfferAnalytic, "offerAnalytic");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfoController, "previousModule");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(iChatInteractor, "chatInteractor");
        this.l = iNavigator;
        this.m = iOfferProductInteractor;
        this.n = iErrorLogger;
        this.o = iErrorHandlerWithShow;
        this.p = iThrowableWrapper;
        this.q = iOfferAnalytic;
        this.r = iPreviousModuleInfoController;
        this.s = iProductNameDictionary;
        this.t = iChatInteractor;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void errorLogger(@Nullable Throwable th) {
        this.n.logError(MessagePriority.ERROR, this.p.wrap(th));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void errorServer(@Nullable Throwable th) {
        setWaitingSend(false);
        this.o.handleError(this.p.wrap(th));
        OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic = this.k;
        if (offerProductDetailInfoAnalytic != null) {
            IOfferAnalytic.DefaultImpls.offerFail$default(this.q, BaseAnalyticKt.ANALYTIC_FAIL_SERVER, ((ProductDictionaryInfoDomain) this.s.get(offerProductDetailInfoAnalytic.getProductName())).getAnalyticProductName(), this.r.getPreviousModuleName(), null, null, 24, null);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void openOfferAnalytic() {
        OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic = this.k;
        if (offerProductDetailInfoAnalytic != null) {
            IOfferAnalytic.DefaultImpls.offerOpen$default(this.q, offerProductDetailInfoAnalytic.getSavedSearchID(), ((ProductDictionaryInfoDomain) this.s.get(offerProductDetailInfoAnalytic.getProductName())).getAnalyticProductName(), offerProductDetailInfoAnalytic.getOrganizationName(), offerProductDetailInfoAnalytic.getOfferName(), this.r.getPreviousModuleName(), null, null, 96, null);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void openProductStatusFragment(@NotNull OfferProductStatusNavInfo offerProductStatusNavInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductStatusNavInfo, "navInfo");
        setWaitingSend(false);
        INavigator.DefaultImpls.route$default(this.l, R.id.action_offerProductInfoFragment_to_offerProductStatusFragment, UtilFunctionsKt.toSravniJson(offerProductStatusNavInfo), null, 4, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void openWebView(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        INavigator.DefaultImpls.openWebView$default(this.l, str, null, new BrowserAnalyticOpenInfo(((ProductDictionaryInfoDomain) this.s.get(str2)).getAnalyticProductName(), null, null, null, null, 30, null), 2, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void restoreChat(@NotNull ChatInfo chatInfo) {
        Intrinsics.checkParameterIsNotNull(chatInfo, "chatInfo");
        INavigator.DefaultImpls.route$default(this.l, R.id.action_offerProductInfoFragment_to_chatFragment, UtilFunctionsKt.toSravniJson(chatInfo), null, 4, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void sendOfferAnalytic(@NotNull OfferProductStatusDomain offerProductStatusDomain) {
        Intrinsics.checkParameterIsNotNull(offerProductStatusDomain, "offerProductStatusDomain");
        OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic = this.k;
        if (offerProductDetailInfoAnalytic != null) {
            IOfferAnalytic iOfferAnalytic = this.q;
            String orderID = offerProductStatusDomain.getOrderID();
            if (orderID == null) {
                orderID = BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR;
            }
            IOfferAnalytic.DefaultImpls.offerSend$default(iOfferAnalytic, orderID, ((ProductDictionaryInfoDomain) this.s.get(offerProductDetailInfoAnalytic.getProductName())).getAnalyticProductName(), offerProductDetailInfoAnalytic.getOrganizationName(), offerProductDetailInfoAnalytic.getOfferName(), this.r.getPreviousModuleName(), null, null, this.r.getCurrentModuleName(), 96, null);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void sendRequest(@NotNull Function1<? super OfferProductStatusDomain, Unit> function1) {
        Map<String, String> requestParamsV2;
        Intrinsics.checkParameterIsNotNull(function1, "processResponse");
        setWaitingSend(true);
        OfferProductDetailDomain offerProductDetailDomain = this.j;
        if (offerProductDetailDomain != null && (requestParamsV2 = offerProductDetailDomain.getRequestParamsV2()) != null) {
            Disposable disposable = this.i;
            if (disposable != null) {
                disposable.dispose();
            }
            this.i = this.m.sendRequest(requestParamsV2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, function1), new b(this, function1));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void sendRequestLegacy(@NotNull Function1<? super OfferProductStatusDomain, Unit> function1) {
        String requestParams;
        Intrinsics.checkParameterIsNotNull(function1, "processResponse");
        setWaitingSend(true);
        OfferProductDetailDomain offerProductDetailDomain = this.j;
        if (offerProductDetailDomain != null && (requestParams = offerProductDetailDomain.getRequestParams()) != null) {
            Disposable disposable = this.i;
            if (disposable != null) {
                disposable.dispose();
            }
            this.i = this.m.sendRequestLegacy(requestParams).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, function1), new d(this, function1));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void setAnalyticInfo(@NotNull OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailInfoAnalytic, "analyticInfo");
        this.k = offerProductDetailInfoAnalytic;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void setAnswerInfo(@NotNull AnswerInfoDomain answerInfoDomain) {
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answerInfo");
        this.t.setAnswerInfo(answerInfoDomain);
        this.l.popBackStack(R.id.chatFragment, false);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void setValueFromProductInfo(@NotNull OfferProductDetailDomain offerProductDetailDomain) {
        OfferProductDisplaySettingsDomain displaySettings;
        Intrinsics.checkParameterIsNotNull(offerProductDetailDomain, "offerProductDetailDomain");
        this.j = offerProductDetailDomain;
        getTitleInfo().setValue(offerProductDetailDomain.getDetailInfo().getDisplaySettings().getDetailTitle());
        getStatus().setValue(offerProductDetailDomain.getDetailInfo().getStatus());
        getOfferProductActionInfo().setValue(OfferProductActionInfoKt.createOfferProductStatusInfo(offerProductDetailDomain));
        MutableLiveData<List<OfferProductDetailItemDomainWithLogoInfo>> listOfferProductDetailDomain = getListOfferProductDetailDomain();
        List<OfferProductDetailItemDomain> detailParams = offerProductDetailDomain.getDetailParams();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(detailParams, 10));
        for (T t2 : detailParams) {
            OfferProductDetailInfoDomain detailInfo = t2.getDetailInfo();
            arrayList.add(new OfferProductDetailItemDomainWithLogoInfo(t2, new LogoInfo((detailInfo == null || (displaySettings = detailInfo.getDisplaySettings()) == null) ? null : displaySettings.getBankLogoUrlSVG(), ILogoLoadCallback.Companion.createDefaultCallback$default(ILogoLoadCallback.Companion, this.n, null, 2, null))));
        }
        listOfferProductDetailDomain.setValue(arrayList);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void setWaitingRetry(boolean z) {
        isWaitingRetry().setValue(Boolean.valueOf(z));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForViewModel
    public void setWaitingSend(boolean z) {
        isWaitingSend().setValue(Boolean.valueOf(z));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout
    @NotNull
    public MutableLiveData<List<OfferProductDetailItemDomainWithLogoInfo>> getListOfferProductDetailDomain() {
        return this.h;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout
    @NotNull
    public MutableLiveData<OfferProductActionInfo> getOfferProductActionInfo() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout
    @NotNull
    public MutableLiveData<ProductStatusEnum> getStatus() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout
    @NotNull
    public MutableLiveData<String> getTitleInfo() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout
    @NotNull
    public MutableLiveData<Boolean> isWaitingRetry() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout
    @NotNull
    public MutableLiveData<Boolean> isWaitingSend() {
        return this.d;
    }
}
