package ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel;

import a2.g.r.g;
import a7.c.a.a.o.f.a.b.c.d;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.browser.BrowserAnalyticOpenInfo;
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyAlternativeDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.offer.NullOsagoNavInfoCameError;
import ru.sravni.android.bankproduct.presentation.offer.entity.UrlInfo;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import ru.sravni.android.bankproduct.utils.navigation.entity.OsagoNavOrderInfo;
import ru.sravni.android.bankproduct.utils.product.ProductUtilKt;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010g\u001a\u00020d\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010p\u001a\u00020o¢\u0006\u0004\bq\u0010rJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001d\u0010\u000bR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b*\u0010'R\"\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010>\u001a\b\u0012\u0004\u0012\u00020;0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010%\u001a\u0004\b=\u0010'R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0?8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010J\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010U\u001a\b\u0012\u0004\u0012\u00020S0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\bT\u0010'R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00170\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010%\u001a\u0004\b`\u0010'R\u0018\u0010c\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u00109R\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\"\u0010k\u001a\b\u0012\u0004\u0012\u00020h0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010%\u001a\u0004\bj\u0010'R\"\u0010n\u001a\b\u0012\u0004\u0012\u00020l0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\bm\u0010'¨\u0006s"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/OfferOsagoOrderViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/IOfferOsagoOrderViewModel;", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;", "osagoNavOrderInfo", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyAlternativeDomain;", "osagoCompanyAlternativeDomain", "", "e", "(Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyAlternativeDomain;)V", "d", "()V", "", "errorType", "c", "(Ljava/lang/String;)V", "initOsagoInfo", "(Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;)V", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "newCompany", "clickNewCompany", "(Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;)V", "nextQuote", "Lru/sravni/android/bankproduct/presentation/offer/entity/UrlInfo;", "info", "openWebAction", "(Lru/sravni/android/bankproduct/presentation/offer/entity/UrlInfo;)V", "closeAction", "repeatClick", "onCleared", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "t", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "h", "Landroidx/lifecycle/MutableLiveData;", "getOsagoPaymentInfo", "()Landroidx/lifecycle/MutableLiveData;", "osagoPaymentInfo", "", "getErrorOccurred", "errorOccurred", g.a, "getQuote", ShareConstants.WEB_DIALOG_PARAM_QUOTE, "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", VKApiConst.VERSION, "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "x", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousInfo", "Lio/reactivex/disposables/Disposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/Disposable;", "subscriptionQuote", "", "j", "getIconStatus", "iconStatus", "", "o", "Ljava/util/List;", VKApiUserFull.QUOTES, VKApiConst.Q, "Z", "analyticRoute", "k", "Ljava/lang/String;", "getLoadDescription", "()Ljava/lang/String;", "loadDescription", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "u", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;", "s", "Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;", "offerOsagoInteractor", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/OsagoOrderButtonState;", "getOsagoOrderButtonState", "osagoOrderButtonState", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "w", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "offerAnalytic", "p", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;", "n", "I", "positionQuote", "i", "getUrlInfo", "urlInfo", "l", "subscription", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "r", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "f", "getOsagoCompanyOrder", "osagoCompanyOrder", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/OsagoOrderState;", "getOsagoOrderState", "osagoOrderState", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/offer/osago/IOfferOsagoInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoOrderViewModel extends ViewModel implements IOfferOsagoOrderViewModel {
    @NotNull
    public final MutableLiveData<OsagoOrderState> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<OsagoOrderButtonState> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<OsagoCompanyOrderDomain> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<OsagoCompanyOrderInfoDomain> h = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<UrlInfo> i = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> j = new MutableLiveData<>();
    @NotNull
    public final String k;
    public Disposable l;
    public Disposable m;
    public int n;
    public List<String> o;
    public OsagoNavOrderInfo p;
    public boolean q;
    public final INavigator r;
    public final IOfferOsagoInteractor s;
    public final IErrorLogger t;
    public final IThrowableWrapper u;
    public final IProductNameDictionary v;
    public final IOfferAnalytic w;
    public final IPreviousModuleInfoController x;

    public static final class a<T> implements Consumer<Long> {
        public final /* synthetic */ OfferOsagoOrderViewModel a;

        public a(OfferOsagoOrderViewModel offerOsagoOrderViewModel) {
            this.a = offerOsagoOrderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Consumer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(java.lang.Long r4) {
            /*
                r3 = this;
                java.lang.Long r4 = (java.lang.Long) r4
                ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel r4 = r3.a
                androidx.lifecycle.MutableLiveData r4 = r4.getQuote()
                ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel r0 = r3.a
                java.util.List r0 = ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel.access$getQuotes$p(r0)
                ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel r1 = r3.a
                int r2 = ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel.access$getPositionQuote$p(r1)
                int r2 = r2 + 1
                ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel.access$setPositionQuote$p(r1, r2)
                int r1 = ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel.access$getPositionQuote$p(r1)
                ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel r2 = r3.a
                java.util.List r2 = ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel.access$getQuotes$p(r2)
                int r2 = r2.size()
                int r1 = r1 % r2
                java.lang.Object r0 = r0.get(r1)
                r4.setValue(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel.a.accept(java.lang.Object):void");
        }
    }

    public static final class b<T> implements Consumer<OsagoCompanyOrderDomain> {
        public final /* synthetic */ OfferOsagoOrderViewModel a;
        public final /* synthetic */ OsagoNavOrderInfo b;

        public b(OfferOsagoOrderViewModel offerOsagoOrderViewModel, OsagoNavOrderInfo osagoNavOrderInfo) {
            this.a = offerOsagoOrderViewModel;
            this.b = osagoNavOrderInfo;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OsagoCompanyOrderDomain osagoCompanyOrderDomain) {
            OsagoCompanyOrderDomain osagoCompanyOrderDomain2 = osagoCompanyOrderDomain;
            OfferOsagoOrderViewModel offerOsagoOrderViewModel = this.a;
            Intrinsics.checkExpressionValueIsNotNull(osagoCompanyOrderDomain2, "osagoCompanyOrderDomain");
            OfferOsagoOrderViewModel.access$sendOfferOpenEvent(offerOsagoOrderViewModel, osagoCompanyOrderDomain2);
            this.a.getOsagoCompanyOrder().setValue(osagoCompanyOrderDomain2);
            this.a.o = osagoCompanyOrderDomain2.getQuotes();
            this.a.d();
            OfferOsagoOrderViewModel.access$makeOrderOsagoInfo(this.a, osagoCompanyOrderDomain2.getPollingInterval(), osagoCompanyOrderDomain2.getPollingID(), this.b.getSavedSearchID());
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferOsagoOrderViewModel a;

        public c(OfferOsagoOrderViewModel offerOsagoOrderViewModel) {
            this.a = offerOsagoOrderViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.c(BaseAnalyticKt.ANALYTIC_FAIL_SERVER);
            this.a.getErrorOccurred().setValue(Boolean.TRUE);
            this.a.t.logError(MessagePriority.ERROR, this.a.u.wrap(th));
        }
    }

    public OfferOsagoOrderViewModel(@NotNull INavigator iNavigator, @NotNull IOfferOsagoInteractor iOfferOsagoInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IOfferAnalytic iOfferAnalytic, @NotNull IPreviousModuleInfoController iPreviousModuleInfoController, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iOfferOsagoInteractor, "offerOsagoInteractor");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(iOfferAnalytic, "offerAnalytic");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfoController, "previousInfo");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.r = iNavigator;
        this.s = iOfferOsagoInteractor;
        this.t = iErrorLogger;
        this.u = iThrowableWrapper;
        this.v = iProductNameDictionary;
        this.w = iOfferAnalytic;
        this.x = iPreviousModuleInfoController;
        this.k = iResourceProvider.getString(R.string.find_best_offers);
    }

    public static final /* synthetic */ List access$getQuotes$p(OfferOsagoOrderViewModel offerOsagoOrderViewModel) {
        List<String> list = offerOsagoOrderViewModel.o;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VKApiUserFull.QUOTES);
        }
        return list;
    }

    public static final void access$makeOrderOsagoInfo(OfferOsagoOrderViewModel offerOsagoOrderViewModel, long j2, String str, String str2) {
        offerOsagoOrderViewModel.getOsagoOrderState().setValue(OsagoOrderState.POLLING);
        offerOsagoOrderViewModel.getOsagoOrderButtonState().setValue(OsagoOrderButtonState.WAIT);
        Disposable disposable = offerOsagoOrderViewModel.l;
        if (disposable != null) {
            disposable.dispose();
        }
        offerOsagoOrderViewModel.l = Observable.timer(j2, TimeUnit.MILLISECONDS).flatMap(new a7.c.a.a.o.f.a.b.c.a(offerOsagoOrderViewModel, str, str2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a7.c.a.a.o.f.a.b.c.b(offerOsagoOrderViewModel, str2), new a7.c.a.a.o.f.a.b.c.c(offerOsagoOrderViewModel));
    }

    public static final void access$osagoCompanyAnswer(OfferOsagoOrderViewModel offerOsagoOrderViewModel, OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain, int i2, OsagoOrderButtonState osagoOrderButtonState) {
        String title;
        Disposable disposable = offerOsagoOrderViewModel.m;
        if (disposable != null) {
            disposable.dispose();
        }
        boolean z = !osagoCompanyOrderInfoDomain.getListCompany().isEmpty();
        String str = BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR;
        if (z) {
            IOfferAnalytic iOfferAnalytic = offerOsagoOrderViewModel.w;
            OsagoNavOrderInfo osagoNavOrderInfo = offerOsagoOrderViewModel.p;
            if (osagoNavOrderInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("osagoNavOrderInfo");
            }
            String savedSearchID = osagoNavOrderInfo.getSavedSearchID();
            String pollingID = osagoCompanyOrderInfoDomain.getPollingID();
            String analyticProductName = ((ProductDictionaryInfoDomain) offerOsagoOrderViewModel.v.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getAnalyticProductName();
            int size = osagoCompanyOrderInfoDomain.getListCompany().size();
            List<OsagoCompanyOrderInfoDomain.CompanyDomain> listCompany = osagoCompanyOrderInfoDomain.getListCompany();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(listCompany, 10));
            Iterator<T> it = listCompany.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTitle());
            }
            List distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
            String currentModuleName = offerOsagoOrderViewModel.x.getCurrentModuleName();
            IOfferAnalytic.DefaultImpls.offerShow$default(iOfferAnalytic, savedSearchID, analyticProductName, size, distinct, null, pollingID, Boolean.TRUE, null, currentModuleName != null ? currentModuleName : str, 144, null);
        }
        offerOsagoOrderViewModel.getOsagoOrderState().setValue(OsagoOrderState.SUCCESS);
        offerOsagoOrderViewModel.getOsagoOrderButtonState().setValue(osagoOrderButtonState);
        offerOsagoOrderViewModel.getOsagoPaymentInfo().setValue(osagoCompanyOrderInfoDomain);
        MutableLiveData<UrlInfo> urlInfo = offerOsagoOrderViewModel.getUrlInfo();
        String url = osagoCompanyOrderInfoDomain.getUrl();
        OsagoCompanyOrderDomain value = offerOsagoOrderViewModel.getOsagoCompanyOrder().getValue();
        if (!(value == null || (title = value.getTitle()) == null)) {
            str = title;
        }
        urlInfo.setValue(new UrlInfo(url, str, osagoCompanyOrderInfoDomain.getPollingID()));
        offerOsagoOrderViewModel.getIconStatus().setValue(Integer.valueOf(i2));
    }

    public static final void access$sendOfferOpenEvent(OfferOsagoOrderViewModel offerOsagoOrderViewModel, OsagoCompanyOrderDomain osagoCompanyOrderDomain) {
        IOfferAnalytic iOfferAnalytic = offerOsagoOrderViewModel.w;
        OsagoNavOrderInfo osagoNavOrderInfo = offerOsagoOrderViewModel.p;
        if (osagoNavOrderInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("osagoNavOrderInfo");
        }
        IOfferAnalytic.DefaultImpls.offerOpen$default(iOfferAnalytic, osagoNavOrderInfo.getSavedSearchID(), ((ProductDictionaryInfoDomain) offerOsagoOrderViewModel.v.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getAnalyticProductName(), osagoCompanyOrderDomain.getTitle(), null, offerOsagoOrderViewModel.x.getPreviousModuleName(), Boolean.valueOf(offerOsagoOrderViewModel.q), null, 72, null);
    }

    public static final void access$sendOfferSendEvent(OfferOsagoOrderViewModel offerOsagoOrderViewModel, UrlInfo urlInfo) {
        IOfferAnalytic.DefaultImpls.offerSend$default(offerOsagoOrderViewModel.w, urlInfo.getOrderId(), ((ProductDictionaryInfoDomain) offerOsagoOrderViewModel.v.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getAnalyticProductName(), urlInfo.getOrganization(), null, offerOsagoOrderViewModel.x.getPreviousModuleName(), Boolean.valueOf(offerOsagoOrderViewModel.q), null, null, 200, null);
    }

    public final void c(String str) {
        IOfferAnalytic.DefaultImpls.offerFail$default(this.w, str, ((ProductDictionaryInfoDomain) this.v.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getAnalyticProductName(), this.x.getPreviousModuleName(), Boolean.valueOf(this.q), null, 16, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter.IAlternativeCompany
    public void clickNewCompany(@NotNull OsagoCompanyOrderInfoDomain.CompanyDomain companyDomain) {
        Intrinsics.checkParameterIsNotNull(companyDomain, "newCompany");
        this.q = true;
        OsagoNavOrderInfo osagoNavOrderInfo = this.p;
        if (osagoNavOrderInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("osagoNavOrderInfo");
        }
        e(osagoNavOrderInfo, new OsagoCompanyAlternativeDomain(companyDomain));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    public void closeAction() {
        this.r.popBackStack(R.id.chatFragment, false);
    }

    public final void d() {
        Disposable disposable = this.m;
        if (disposable != null) {
            disposable.dispose();
        }
        MutableLiveData<String> quote = getQuote();
        List<String> list = this.o;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VKApiUserFull.QUOTES);
        }
        int i2 = this.n;
        List<String> list2 = this.o;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VKApiUserFull.QUOTES);
        }
        quote.setValue(list.get(i2 % list2.size()));
        this.m = Observable.interval(15, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
    }

    public final void e(OsagoNavOrderInfo osagoNavOrderInfo, OsagoCompanyAlternativeDomain osagoCompanyAlternativeDomain) {
        this.p = osagoNavOrderInfo;
        getOsagoOrderState().setValue(OsagoOrderState.WAIT);
        getOsagoOrderButtonState().setValue(OsagoOrderButtonState.WAIT);
        getErrorOccurred().setValue(Boolean.FALSE);
        Disposable disposable = this.l;
        if (disposable != null) {
            disposable.dispose();
        }
        this.l = this.s.getOsagoOrder(osagoNavOrderInfo.getSavedSearchID(), osagoCompanyAlternativeDomain).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, osagoNavOrderInfo), new c(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public MutableLiveData<Boolean> getErrorOccurred() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public String getLoadDescription() {
        return this.k;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    public void initOsagoInfo(@Nullable OsagoNavOrderInfo osagoNavOrderInfo) {
        if (osagoNavOrderInfo != null) {
            e(osagoNavOrderInfo, null);
            return;
        }
        c(BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        getErrorOccurred().setValue(Boolean.TRUE);
        this.t.logError(MessagePriority.ERROR, this.u.wrap(new NullOsagoNavInfoCameError()));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.ITapQuote
    public void nextQuote() {
        this.n++;
        d();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.l;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.m;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    public void openWebAction(@NotNull UrlInfo urlInfo) {
        Intrinsics.checkParameterIsNotNull(urlInfo, "info");
        this.r.openWebView(urlInfo.getUrl(), new d(this, urlInfo), new BrowserAnalyticOpenInfo(((ProductDictionaryInfoDomain) this.v.get(ProductUtilKt.getOSAGO_CHAT_NAME())).getAnalyticProductName(), urlInfo.getOrganization(), urlInfo.getOrderId(), Boolean.valueOf(this.q), Boolean.FALSE));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    public void repeatClick() {
        OsagoNavOrderInfo osagoNavOrderInfo = this.p;
        if (osagoNavOrderInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("osagoNavOrderInfo");
        }
        e(osagoNavOrderInfo, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    @NotNull
    public MutableLiveData<Integer> getIconStatus() {
        return this.j;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    @NotNull
    public MutableLiveData<OsagoCompanyOrderDomain> getOsagoCompanyOrder() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    @NotNull
    public MutableLiveData<OsagoOrderButtonState> getOsagoOrderButtonState() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    @NotNull
    public MutableLiveData<OsagoOrderState> getOsagoOrderState() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    @NotNull
    public MutableLiveData<OsagoCompanyOrderInfoDomain> getOsagoPaymentInfo() {
        return this.h;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    @NotNull
    public MutableLiveData<String> getQuote() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel
    @NotNull
    public MutableLiveData<UrlInfo> getUrlInfo() {
        return this.i;
    }
}
