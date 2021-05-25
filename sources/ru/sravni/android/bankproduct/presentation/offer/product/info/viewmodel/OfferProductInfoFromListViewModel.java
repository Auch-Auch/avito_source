package ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusNavInfo;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.featuretoggle.config.FeaturesToToggle;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.presentation.offer.NullOfferProductOrderIDGetStatusError;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.DataToOpenChat;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoFromList;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010$\u001a\u00020\b\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/OfferProductInfoFromListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoFromListViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", "offerProductDetailInfoFromList", "", "initWithDetailInfo", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;)V", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;", "getOfferProductInfoController", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;", "sendOffer", "()V", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;", "offerProductActionInfo", "getProductActionClick", "(Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;)V", "onCleared", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "statusDomain", "c", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;)V", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "subscription", "", "e", "Ljava/lang/String;", AnalyticFieldsName.productName, "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "d", "Ljava/util/List;", "listFilter", "i", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;", "offerInfoController", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "f", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "offerInfoForDomain", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "j", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "h", "Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;", "offerProductInteractor", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "k", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", g.a, "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "dataToOpenChat", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/product/IOfferProductInteractor;Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoController;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductInfoFromListViewModel extends ViewModel implements IOfferProductInfoFromListViewModel {
    public Disposable c;
    public List<OfferFilterInfoDomain> d = CollectionsKt__CollectionsKt.emptyList();
    public String e;
    public OfferProductDetailDomain f;
    public DataToOpenChat g;
    public final IOfferProductInteractor h;
    public final IOfferProductInfoController i;
    public final IFeatureToggleRouterDomain j;
    public final IProductNameDictionary k;

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
                ((OfferProductInfoFromListViewModel) this.b).c(offerProductStatusDomain2);
                ((OfferProductInfoFromListViewModel) this.b).i.sendOfferAnalytic(offerProductStatusDomain2);
                return Unit.INSTANCE;
            } else if (i == 1) {
                OfferProductStatusDomain offerProductStatusDomain3 = offerProductStatusDomain;
                Intrinsics.checkParameterIsNotNull(offerProductStatusDomain3, "statusDomain");
                ((OfferProductInfoFromListViewModel) this.b).c(offerProductStatusDomain3);
                ((OfferProductInfoFromListViewModel) this.b).i.sendOfferAnalytic(offerProductStatusDomain3);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<OfferProductDetailDomain> {
        public final /* synthetic */ OfferProductInfoFromListViewModel a;
        public final /* synthetic */ OfferProductStatusDomain b;

        public b(OfferProductInfoFromListViewModel offerProductInfoFromListViewModel, OfferProductStatusDomain offerProductStatusDomain) {
            this.a = offerProductInfoFromListViewModel;
            this.b = offerProductStatusDomain;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OfferProductDetailDomain offerProductDetailDomain) {
            OfferProductDetailDomain offerProductDetailDomain2 = offerProductDetailDomain;
            if (offerProductDetailDomain2 != null) {
                this.a.i.setValueFromProductInfo(offerProductDetailDomain2);
                this.a.i.openProductStatusFragment(new OfferProductStatusNavInfo(null, this.b, 1, null));
                return;
            }
            this.a.i.errorServer(new NullOfferProductDetailInfoForUpdateError());
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ OfferProductInfoFromListViewModel a;

        public c(OfferProductInfoFromListViewModel offerProductInfoFromListViewModel) {
            this.a = offerProductInfoFromListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.i.errorServer(th);
        }
    }

    public OfferProductInfoFromListViewModel(@NotNull IOfferProductInteractor iOfferProductInteractor, @NotNull IOfferProductInfoController iOfferProductInfoController, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain, @NotNull IProductNameDictionary iProductNameDictionary) {
        Intrinsics.checkParameterIsNotNull(iOfferProductInteractor, "offerProductInteractor");
        Intrinsics.checkParameterIsNotNull(iOfferProductInfoController, "offerInfoController");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        this.h = iOfferProductInteractor;
        this.i = iOfferProductInfoController;
        this.j = iFeatureToggleRouterDomain;
        this.k = iProductNameDictionary;
    }

    public static final void access$checkStatus(OfferProductInfoFromListViewModel offerProductInfoFromListViewModel, OfferProductStatusDomain offerProductStatusDomain) {
        OfferProductStatusDomain.OfferStatusElementDomain offerStatusElementDomain;
        boolean z;
        Objects.requireNonNull(offerProductInfoFromListViewModel);
        List<OfferProductStatusDomain.OfferStatusElementDomain> offerStatusElementDomainList = offerProductStatusDomain.getOfferStatusElementDomainList();
        ListIterator<OfferProductStatusDomain.OfferStatusElementDomain> listIterator = offerStatusElementDomainList.listIterator(offerStatusElementDomainList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                offerStatusElementDomain = null;
                break;
            }
            offerStatusElementDomain = listIterator.previous();
            if (offerStatusElementDomain.getStatus() != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        OfferProductStatusDomain.OfferStatusElementDomain offerStatusElementDomain2 = offerStatusElementDomain;
        ProductStatusEnum status = offerStatusElementDomain2 != null ? offerStatusElementDomain2.getStatus() : null;
        OfferProductDetailDomain offerProductDetailDomain = offerProductInfoFromListViewModel.f;
        if (offerProductDetailDomain == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offerInfoForDomain");
        }
        if (status != offerProductDetailDomain.getDetailInfo().getStatus()) {
            offerProductInfoFromListViewModel.c(offerProductStatusDomain);
        } else {
            offerProductInfoFromListViewModel.i.openProductStatusFragment(new OfferProductStatusNavInfo(null, offerProductStatusDomain, 1, null));
        }
    }

    public final void c(OfferProductStatusDomain offerProductStatusDomain) {
        Observable<OfferProductDetailDomain> observable;
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        if (this.j.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
            observable = this.h.updateOfferProduct(offerProductStatusDomain.getProductId(), offerProductStatusDomain.getSavedSearchID(), this.d);
        } else {
            observable = this.h.updateOfferProductLegacy(offerProductStatusDomain.getProductId(), offerProductStatusDomain.getSavedSearchID(), this.d);
        }
        this.c = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, offerProductStatusDomain), new c(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.IProductActionGetter
    public void getProductActionClick(@NotNull OfferProductActionInfo offerProductActionInfo) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(offerProductActionInfo, "offerProductActionInfo");
        if (!offerProductActionInfo.isMicroCredit() || offerProductActionInfo.getUrl() == null) {
            String orderID = offerProductActionInfo.getOrderID();
            this.i.setWaitingSend(true);
            if (orderID != null) {
                Disposable disposable = this.c;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.c = this.h.getProductStatus(orderID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a7.c.a.a.o.f.b.a.b.a(this), new a7.c.a.a.o.f.b.a.b.b(this));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.i.errorServer(new NullOfferProductOrderIDGetStatusError());
                return;
            }
            return;
        }
        IOfferProductInfoController iOfferProductInfoController = this.i;
        String url = offerProductActionInfo.getUrl();
        String str = this.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.productName);
        }
        iOfferProductInfoController.openWebView(url, str);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoFromListViewModel
    public void initWithDetailInfo(@NotNull OfferProductDetailInfoFromList offerProductDetailInfoFromList) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailInfoFromList, "offerProductDetailInfoFromList");
        this.d = offerProductDetailInfoFromList.getListFilter();
        this.e = offerProductDetailInfoFromList.getAnalyticInfo().getProductName();
        this.f = offerProductDetailInfoFromList.getOfferInfoForDomain();
        this.g = offerProductDetailInfoFromList.getDataToOpenChat();
        this.i.setAnalyticInfo(offerProductDetailInfoFromList.getAnalyticInfo());
        this.i.setValueFromProductInfo(offerProductDetailInfoFromList.getOfferInfoForDomain());
        this.i.openOfferAnalytic();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IClickOfferProduct
    public void sendOffer() {
        if (this.j.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
            OfferProductDetailDomain offerProductDetailDomain = this.f;
            if (offerProductDetailDomain == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerInfoForDomain");
            }
            if (offerProductDetailDomain.getExtraInfoRequest()) {
                DataToOpenChat dataToOpenChat = this.g;
                if (dataToOpenChat == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataToOpenChat");
                }
                if (dataToOpenChat.getCardID() != null) {
                    DataToOpenChat dataToOpenChat2 = this.g;
                    if (dataToOpenChat2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataToOpenChat");
                    }
                    Integer cardID = dataToOpenChat2.getCardID();
                    if (cardID == null) {
                        Intrinsics.throwNpe();
                    }
                    int intValue = cardID.intValue();
                    DataToOpenChat dataToOpenChat3 = this.g;
                    if (dataToOpenChat3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataToOpenChat");
                    }
                    String conversationID = dataToOpenChat3.getConversationID();
                    OfferProductDetailDomain offerProductDetailDomain2 = this.f;
                    if (offerProductDetailDomain2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("offerInfoForDomain");
                    }
                    Map<String, String> requestParamsV2 = offerProductDetailDomain2.getRequestParamsV2();
                    OfferProductDetailDomain offerProductDetailDomain3 = this.f;
                    if (offerProductDetailDomain3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("offerInfoForDomain");
                    }
                    this.i.setAnswerInfo(new AnswerInfoDomain(intValue, conversationID, offerProductDetailDomain3.getDetailInfo().getDisplaySettings().getOfferTitle(), requestParamsV2, null, 16, null));
                    return;
                }
                String str = this.e;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.productName);
                }
                DataToOpenChat dataToOpenChat4 = this.g;
                if (dataToOpenChat4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataToOpenChat");
                }
                String conversationID2 = dataToOpenChat4.getConversationID();
                IProductNameDictionary iProductNameDictionary = this.k;
                String str2 = this.e;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.productName);
                }
                String title = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(str2)).getTitle();
                OfferProductDetailDomain offerProductDetailDomain4 = this.f;
                if (offerProductDetailDomain4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offerInfoForDomain");
                }
                this.i.restoreChat(new ChatInfo(str, conversationID2, title, null, offerProductDetailDomain4.getRequestParamsV2(), false, 40, null));
                return;
            }
            this.i.sendRequest(new a(0, this));
            return;
        }
        this.i.sendRequestLegacy(new a(1, this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoFromListViewModel
    @NotNull
    public IOfferProductInfoController getOfferProductInfoController() {
        return this.i;
    }
}
