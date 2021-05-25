package ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusNavInfo;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.featuretoggle.config.FeaturesToToggle;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.DataToOpenChat;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoFromChat;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\u00020&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/OfferProductInfoFromChatViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoFromChatViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "detailInfoFromChat", "", "initWithDetailInfo", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;)V", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;", "getOfferProductInfoController", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;", "sendOffer", "()V", "repeatClick", "onCleared", "c", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", g.a, "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "offerProductInteractor", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "getErrorOccurred", "()Landroidx/lifecycle/MutableLiveData;", "errorOccurred", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "subscription", "h", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;", "offerInfoController", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "i", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "", "Ljava/lang/String;", "getLoadDescription", "()Ljava/lang/String;", "loadDescription", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "f", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "dataToOpenChat", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductInfoFromChatViewModel extends ViewModel implements IOfferProductInfoFromChatViewModel {
    @NotNull
    public final String c;
    @NotNull
    public final MutableLiveData<Boolean> d = new MutableLiveData<>();
    public Disposable e;
    public DataToOpenChat f;
    public final IOfferProductInteractor g;
    public final IOfferProductInfoController h;
    public final IFeatureToggleRouterDomain i;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<OfferProductStatusDomain, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(OfferProductStatusDomain offerProductStatusDomain) {
            int i = this.a;
            if (i == 0) {
                OfferProductStatusDomain offerProductStatusDomain2 = offerProductStatusDomain;
                Intrinsics.checkParameterIsNotNull(offerProductStatusDomain2, "statusDomain");
                ((OfferProductInfoFromChatViewModel) this.b).h.openProductStatusFragment(new OfferProductStatusNavInfo(Integer.valueOf(R.id.chatFragment), offerProductStatusDomain2));
                return Unit.INSTANCE;
            } else if (i == 1) {
                OfferProductStatusDomain offerProductStatusDomain3 = offerProductStatusDomain;
                Intrinsics.checkParameterIsNotNull(offerProductStatusDomain3, "statusDomain");
                ((OfferProductInfoFromChatViewModel) this.b).h.openProductStatusFragment(new OfferProductStatusNavInfo(Integer.valueOf(R.id.chatFragment), offerProductStatusDomain3));
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<OfferProductDetailDomain> {
        public final /* synthetic */ OfferProductInfoFromChatViewModel a;

        public b(OfferProductInfoFromChatViewModel offerProductInfoFromChatViewModel) {
            this.a = offerProductInfoFromChatViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferProductDetailDomain offerProductDetailDomain) {
            OfferProductDetailDomain offerProductDetailDomain2 = offerProductDetailDomain;
            this.a.h.setWaitingRetry(false);
            IOfferProductInfoController iOfferProductInfoController = this.a.h;
            Intrinsics.checkExpressionValueIsNotNull(offerProductDetailDomain2, "offerProductDetailDomain");
            iOfferProductInfoController.setValueFromProductInfo(offerProductDetailDomain2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferProductInfoFromChatViewModel a;

        public c(OfferProductInfoFromChatViewModel offerProductInfoFromChatViewModel) {
            this.a = offerProductInfoFromChatViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getErrorOccurred().setValue(Boolean.TRUE);
            this.a.h.setWaitingRetry(true);
            this.a.h.errorLogger(th);
        }
    }

    public OfferProductInfoFromChatViewModel(@NotNull IOfferProductInteractor iOfferProductInteractor, @NotNull IOfferProductInfoController iOfferProductInfoController, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iOfferProductInteractor, "offerProductInteractor");
        Intrinsics.checkParameterIsNotNull(iOfferProductInfoController, "offerInfoController");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.g = iOfferProductInteractor;
        this.h = iOfferProductInfoController;
        this.i = iFeatureToggleRouterDomain;
        this.c = iResourceProvider.getString(R.string.loading_screen_waiting_description_default);
    }

    public final void c() {
        this.h.setWaitingRetry(true);
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        IOfferProductInteractor iOfferProductInteractor = this.g;
        DataToOpenChat dataToOpenChat = this.f;
        if (dataToOpenChat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataToOpenChat");
        }
        this.e = iOfferProductInteractor.getProductDetail(dataToOpenChat.getConversationID()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public MutableLiveData<Boolean> getErrorOccurred() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    @NotNull
    public String getLoadDescription() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoFromChatViewModel
    public void initWithDetailInfo(@NotNull OfferProductDetailInfoFromChat offerProductDetailInfoFromChat) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailInfoFromChat, "detailInfoFromChat");
        this.f = offerProductDetailInfoFromChat.getDataToOpenChat();
        c();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel
    public void repeatClick() {
        getErrorOccurred().setValue(Boolean.FALSE);
        c();
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IClickOfferProduct
    public void sendOffer() {
        if (this.i.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
            this.h.sendRequest(new a(0, this));
        } else {
            this.h.sendRequestLegacy(new a(1, this));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoFromChatViewModel
    @NotNull
    public IOfferProductInfoController getOfferProductInfoController() {
        return this.h;
    }
}
