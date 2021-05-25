package ru.sravni.android.bankproduct.domain.dashboard;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.dashboard.entity.ChatProgressDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.DraftDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.HelloMessageInfo;
import ru.sravni.android.bankproduct.domain.dashboard.entity.OfferCalculationElementDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.RestoreStorageIntentInfoDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.util.IStartBundleRepository;
import ru.sravni.android.bankproduct.utils.product.IProductUtil;
import ru.sravni.android.bankproduct.utils.product.SravniProductItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b9\u0010:J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R6\u0010!\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001b \u001c*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00060\u00060\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R6\u0010$\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001b \u001c*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00060\u00060\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lru/sravni/android/bankproduct/domain/dashboard/DashBoardInteractor;", "Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardInteractor;", "Lio/reactivex/Observable;", "", "getHelloMessage", "()Lio/reactivex/Observable;", "", "Lru/sravni/android/bankproduct/utils/product/SravniProductItem;", "getListFinanceProduct", "()Ljava/util/List;", "getListInsuranceProduct", "Lru/sravni/android/bankproduct/domain/dashboard/entity/OfferCalculationElementDomain;", "getOfferCalculatedList", "", "getChatProgress", "()V", "nextFaceImage", "getFaceResource", "Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "getRestoreStorageIntentInfo", "()Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "clearRestoredPushInfo", "Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardRepository;", "d", "Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardRepository;", "dashBoardRepository", "Lio/reactivex/subjects/PublishSubject;", "Lru/sravni/android/bankproduct/domain/dashboard/entity/DraftDomain;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lio/reactivex/subjects/PublishSubject;", "getListFinanceDraftChannel", "()Lio/reactivex/subjects/PublishSubject;", "listFinanceDraftChannel", "c", "getListInsuranceDraftChannel", "listInsuranceDraftChannel", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", g.a, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/util/IStartBundleRepository;", "e", "Lru/sravni/android/bankproduct/domain/util/IStartBundleRepository;", "startBundleRepository", "Lio/reactivex/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/Disposable;", "subscription", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "h", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/utils/product/IProductUtil;", "f", "Lru/sravni/android/bankproduct/utils/product/IProductUtil;", "productUtil", "<init>", "(Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardRepository;Lru/sravni/android/bankproduct/domain/util/IStartBundleRepository;Lru/sravni/android/bankproduct/utils/product/IProductUtil;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DashBoardInteractor implements IDashBoardInteractor {
    public Disposable a;
    @NotNull
    public final PublishSubject<List<DraftDomain>> b;
    @NotNull
    public final PublishSubject<List<DraftDomain>> c;
    public final IDashBoardRepository d;
    public final IStartBundleRepository e;
    public final IProductUtil f;
    public final IErrorLogger g;
    public final IThrowableWrapper h;

    public static final class a<T> implements Consumer<ChatProgressDomain> {
        public final /* synthetic */ DashBoardInteractor a;

        public a(DashBoardInteractor dashBoardInteractor) {
            this.a = dashBoardInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChatProgressDomain chatProgressDomain) {
            ChatProgressDomain chatProgressDomain2 = chatProgressDomain;
            this.a.getListFinanceDraftChannel().onNext(chatProgressDomain2.getListFinanceDraft());
            this.a.getListInsuranceDraftChannel().onNext(chatProgressDomain2.getListInsuranceDraft());
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DashBoardInteractor a;

        public b(DashBoardInteractor dashBoardInteractor) {
            this.a = dashBoardInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.g.logError(MessagePriority.WARN, this.a.h.wrap(th));
        }
    }

    public DashBoardInteractor(@NotNull IDashBoardRepository iDashBoardRepository, @NotNull IStartBundleRepository iStartBundleRepository, @NotNull IProductUtil iProductUtil, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iDashBoardRepository, "dashBoardRepository");
        Intrinsics.checkParameterIsNotNull(iStartBundleRepository, "startBundleRepository");
        Intrinsics.checkParameterIsNotNull(iProductUtil, "productUtil");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        this.d = iDashBoardRepository;
        this.e = iStartBundleRepository;
        this.f = iProductUtil;
        this.g = iErrorLogger;
        this.h = iThrowableWrapper;
        PublishSubject<List<DraftDomain>> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<List<DraftDomain>>()");
        this.b = create;
        PublishSubject<List<DraftDomain>> create2 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create2, "PublishSubject.create<List<DraftDomain>>()");
        this.c = create2;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    public void clearRestoredPushInfo() {
        this.e.removeStorageInfo();
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    public void getChatProgress() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = this.d.getChatProgress().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), new b(this));
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @NotNull
    public Observable<Integer> getFaceResource() {
        return this.d.getIconNumChannel();
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @NotNull
    public Observable<Integer> getHelloMessage() {
        T t;
        boolean z;
        List<HelloMessageInfo> listHelloMessages = this.d.getListHelloMessages();
        int hourNow = this.d.getHourNow();
        Iterator<T> it = listHelloMessages.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            if (hourNow < t2.getBefore() || hourNow >= t2.getAfter()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t3 = t;
        if (t3 == null) {
            this.g.logError(MessagePriority.ERROR, this.h.wrap(new HelloMessageNotFound()));
        }
        Observable<Integer> just = Observable.just(Integer.valueOf(t3 != null ? t3.getMessageID() : DashBoardInteractorKt.access$getDEFAULT_MESSAGE$p()));
        Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(helloMes…ageID ?: DEFAULT_MESSAGE)");
        return just;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @NotNull
    public List<SravniProductItem> getListFinanceProduct() {
        return this.f.getListFinanceProduct();
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @NotNull
    public List<SravniProductItem> getListInsuranceProduct() {
        return this.f.getListInsuranceProduct();
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @NotNull
    public Observable<List<OfferCalculationElementDomain>> getOfferCalculatedList() {
        return this.d.getOfferCalculatedList();
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @Nullable
    public RestoreStorageIntentInfoDomain getRestoreStorageIntentInfo() {
        return this.e.getRestoreStorageIntentInfoDomain();
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    public void nextFaceImage() {
        this.d.nextIcon();
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @NotNull
    public PublishSubject<List<DraftDomain>> getListFinanceDraftChannel() {
        return this.b;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardInteractor
    @NotNull
    public PublishSubject<List<DraftDomain>> getListInsuranceDraftChannel() {
        return this.c;
    }
}
